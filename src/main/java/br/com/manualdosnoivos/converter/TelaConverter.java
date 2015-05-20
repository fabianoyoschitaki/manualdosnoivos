package br.com.manualdosnoivos.converter;

import org.bson.types.ObjectId;

import br.com.manualdosnoivos.model.CategoriaFornecedor;
import br.com.manualdosnoivos.model.Tela;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class TelaConverter {
	
	// convert Tela Object to MongoDB DBObject
	// take special note of converting id String to ObjectId
	public static DBObject toDBObject(Tela tela) {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
			.append("nome", tela.getNome())
			.append("descricao", tela.getConteudo());
		if (tela.getId() != null) {
			builder = builder.append("_id", new ObjectId(tela.getId()));
		}
		return builder.get();
	}

	// convert DBObject Object to CategoriaFornecedor 
	// take special note of converting ObjectId to String
	public static Tela toTela (DBObject doc) {
		Tela retorno = null;
		if (doc != null){
			retorno = new Tela();
			retorno.setNome((String) doc.get("nome"));
			retorno.setConteudo((String) doc.get("conteudo"));
			ObjectId id = (ObjectId) doc.get("_id");
			retorno.setId(id.toString());
		}
		return retorno;
	}
}
