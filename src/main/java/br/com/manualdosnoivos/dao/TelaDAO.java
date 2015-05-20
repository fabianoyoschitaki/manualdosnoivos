package br.com.manualdosnoivos.dao;

import org.bson.types.ObjectId;

import br.com.manualdosnoivos.converter.CategoriaFornecedorConverter;
import br.com.manualdosnoivos.converter.TelaConverter;
import br.com.manualdosnoivos.model.CategoriaFornecedor;
import br.com.manualdosnoivos.model.Tela;
import br.com.manualdosnoivos.mongo.MongoDBConstants;
import br.com.manualdosnoivos.mongo.MongoDBUtil;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class TelaDAO {
	private DBCollection col;
	
	public TelaDAO () {
        this.col = MongoDBUtil.getMongo().getDB(MongoDBConstants.DATABASE).getCollection(MongoDBConstants.COLLECTION_TELAS);
    }
 
    public Tela readTela(String nome) {
        DBObject query = BasicDBObjectBuilder.start().append("nome", nome).get();
        DBObject data = this.col.findOne(query);
        return TelaConverter.toTela(data);
    }
    
    public Tela createTela(Tela t) {
        DBObject doc = TelaConverter.toDBObject(t);
        this.col.insert(doc);
        ObjectId id = (ObjectId) doc.get("_id");
        t.setId(id.toString());
        return t;
    }
    
    public Tela updateTela(Tela t) {
        DBObject query = BasicDBObjectBuilder.start()
        	.append("_id", new ObjectId(t.getId())).get();
        this.col.update(query, TelaConverter.toDBObject(t));
        return t;
    }
}
