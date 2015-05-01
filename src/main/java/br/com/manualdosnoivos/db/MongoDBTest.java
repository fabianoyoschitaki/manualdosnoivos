package br.com.manualdosnoivos.db;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;

/**
 * Teste mongoDB no openshit
 * 
 * Root User:     admin
 * Root Password: 5c4wst3DGsRv
 * Database Name: manualdosnoivos
 *
 * Connection URL: mongodb://$OPENSHIFT_MONGODB_DB_HOST:$OPENSHIFT_MONGODB_DB_PORT/
 * 
 * @author fabiano
 *
 */
public class MongoDBTest {

	private static final String DATABASE = "manualdosnoivos";
	private static final String USER = "admin";
	private static final String PASSWORD = "5c4wst3DGsRv";
	private static final String OPENSHIFT_MONGODB_DB_URL = "mongodb://admin:5c4wst3DGsRv@127.4.173.130:27017/";

	public static String getCasamentos() {
		StringBuffer retorno = new StringBuffer();
		try {
			retorno.append("MongoClient xD");
			MongoClient mongoClient = new MongoClient("127.4.173.130", 27017);
			retorno.append("\nMongoClient generated");
			DB db = mongoClient.getDB(DATABASE);
			retorno.append("\nConnect to database successfully");
			
			DBCollection casamento = db.getCollection("casamentos");
			retorno.append("\nCollection created successfully");
			//TODO dando pau aqui
			BasicDBObject doc = new BasicDBObject("data", "10/10/2015").
	            append("noivo", "João").
	            append("noiva", "Maria").
	            append("custo", 21000);
			casamento.insert(doc);
			retorno.append("\nok");
			mongoClient.close();
		} catch (Exception e) {
			retorno.append("\n" + e.getClass().getName() + ": " + e.getMessage());
		}
		return retorno.toString();
	}

}
