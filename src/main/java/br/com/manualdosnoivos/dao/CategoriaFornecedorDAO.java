package br.com.manualdosnoivos.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import br.com.manualdosnoivos.converter.CategoriaFornecedorConverter;
import br.com.manualdosnoivos.model.CategoriaFornecedor;
import br.com.manualdosnoivos.mongo.MongoDBConstants;
import br.com.manualdosnoivos.mongo.MongoDBUtil;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * DAO para categorias de fornecedores
 * 
 * @author fabiano
 */
public class CategoriaFornecedorDAO {
	
	private DBCollection col;
	
	public CategoriaFornecedorDAO () {
        this.col = MongoDBUtil.getMongo().getDB(MongoDBConstants.DATABASE).getCollection(MongoDBConstants.COLLECTION_CATEGORIA_FORNECEDOR);
    }
 
    public CategoriaFornecedor createCategoriaFornecedor(CategoriaFornecedor c) {
        DBObject doc = CategoriaFornecedorConverter.toDBObject(c);
        this.col.insert(doc);
        ObjectId id = (ObjectId) doc.get("_id");
        c.setId(id.toString());
        return c;
    }
 
    public void updateCategoriaFornecedor(CategoriaFornecedor c) {
        DBObject query = BasicDBObjectBuilder.start()
        	.append("_id", new ObjectId(c.getId())).get();
        this.col.update(query, CategoriaFornecedorConverter.toDBObject(c));
    }
 
    public List<CategoriaFornecedor> readAllCategoriaFornecedor() {
        List<CategoriaFornecedor> data = new ArrayList<CategoriaFornecedor>();
        DBCursor cursor = col.find();
        while (cursor.hasNext()) {
            DBObject doc = cursor.next();
            CategoriaFornecedor c = CategoriaFornecedorConverter.toCategoriaFornecedor(doc);
            data.add(c);
        }
        return data;
    }
 
    public void deleteCategoriaFornecedor(String id) {
        DBObject query = BasicDBObjectBuilder.start()
        	.append("_id", new ObjectId(id)).get();
        this.col.remove(query);
    }
 
    public CategoriaFornecedor readPerson(CategoriaFornecedor c) {
        DBObject query = BasicDBObjectBuilder.start()
        	.append("_id", new ObjectId(c.getId())).get();
        DBObject data = this.col.findOne(query);
        return CategoriaFornecedorConverter.toCategoriaFornecedor(data);
    }
}
