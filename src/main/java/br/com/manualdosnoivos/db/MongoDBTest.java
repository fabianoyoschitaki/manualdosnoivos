package br.com.manualdosnoivos.db;

import java.util.Arrays;
import java.util.List;

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
	
	//conexão
	private static ServerAddress serverAddress = new ServerAddress(CONNECTION_URL);
	private static List<MongoCredential> credentials = Arrays.asList(MongoCredential
			.createCredential(USER, DATABASE, PASSWORD.toCharArray()));

	public static String getCasamentos() {
		StringBuffer retorno = new StringBuffer();
		try {
			retorno.append("MongoClient..");
			MongoClient mongoClient = 
				new MongoClient(serverAddress, credentials);
			retorno.append("\nMongoClient generated");
			DB db = mongoClient.getDB(DATABASE);
			retorno.append("\nConnect to database successfully");
			
			DBCollection casamento = db.getCollection("casamentos");
			retorno.append("\nCollection created successfully");
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
