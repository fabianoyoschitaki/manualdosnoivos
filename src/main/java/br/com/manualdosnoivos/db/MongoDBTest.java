package br.com.manualdosnoivos.db;

import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

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
		String retorno = "";
		try {
			MongoClient mongoClient = new MongoClient(new ServerAddress(
					CONNECTION_URL), Arrays.asList(credential));
			System.out.println("Mongoclient generated");
			DB db = mongoClient.getDB(DATABASE);
			System.out.println("Connect to database successfully");
			
			DBCollection casamento = db.getCollection("casamentos");
			System.out.println("Collection created successfully");
			casamento.save(new BasicDBObject("nome", "bla bla bla"));
			retorno = "ok";
		} catch (Exception e) {
			retorno = e.getClass().getName() + ": " + e.getMessage();
		}
		return retorno;
	}

}
