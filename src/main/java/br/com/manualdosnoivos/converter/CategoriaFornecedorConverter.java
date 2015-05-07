package br.com.manualdosnoivos.converter;

import org.bson.types.ObjectId;

import br.com.manualdosnoivos.model.CategoriaFornecedor;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class CategoriaFornecedorConverter {
	
	// convert CategoriaFornecedor Object to MongoDB DBObject
	// take special note of converting id String to ObjectId
	public static DBObject toDBObject(CategoriaFornecedor categoria) {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
			.append("codigo", categoria.getCodigo())
			.append("nome", categoria.getNome())
			.append("descricao", categoria.getDescricao());
		if (categoria.getId() != null) {
			builder = builder.append("_id", new ObjectId(categoria.getId()));
		}
		return builder.get();
	}

	// convert DBObject Object to CategoriaFornecedor 
	// take special note of converting ObjectId to String
	public static CategoriaFornecedor toCategoriaFornecedor (DBObject doc) {
		CategoriaFornecedor retorno = new CategoriaFornecedor();
		retorno.setCodigo((Short) doc.get("codigo"));
		retorno.setNome((String) doc.get("nome"));
		retorno.setDescricao((String) doc.get("descricao"));
		ObjectId id = (ObjectId) doc.get("_id");
		retorno.setId(id.toString());
		return retorno;
	}
}
