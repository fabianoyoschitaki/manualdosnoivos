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
 * Connection URL:
 * mongodb://$OPENSHIFT_MONGODB_DB_HOST:$OPENSHIFT_MONGODB_DB_PORT/ Database
 * Name: manualdosnoivos Password: MWxQNVpaUjAw Username: admin
 *
 * 
 * @author fabiano
 *
 */
public class MongoDBTest {

	private static final String DATABASE = "manualdosnoivos";
	private static final String USER = "admin";
	private static final String PASSWORD = "MWxQNVpaUjAw";
	private static final String CONNECTION_URL = "mongodb://$OPENSHIFT_MONGODB_DB_HOST:$OPENSHIFT_MONGODB_DB_PORT/";

	private static MongoCredential credential = MongoCredential
			.createCredential(USER, DATABASE, PASSWORD.toCharArray());

	public static String getCasamentos() {
		StringBuffer retorno = new StringBuffer();
		try {
			retorno.append("MongoClient...");
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			retorno.append("\nMongoClient generated");
			DB db = mongoClient.getDB(DATABASE);
			retorno.append("\nConnect to database successfully");
			
			DBCollection casamento = db.getCollection("casamentos");
			retorno.append("\nCollection created successfully");
			casamento.save(new BasicDBObject("nome", "bla bla bla"));
			retorno.append("\nok");
			mongoClient.close();
		} catch (Exception e) {
			retorno.append("\n" + e.getClass().getName() + ": " + e.getMessage());
		}
		return retorno.toString();
	}

}
