package br.com.manualdosnoivos.mongo;

import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

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

	//private static final String SERVER = "127.4.173.130";
	//private static final int PORT = 27017;
	//private static final String USER = "admin";
	//private static final String PASSWORD = "5c4wst3DGsRv";
	//private static final String OPENSHIFT_MONGODB_DB_URL = "mongodb://admin:5c4wst3DGsRv@127.4.173.130:27017/";
	
	//private static final MongoCredential CREDENTIAL = MongoCredential.createCredential(USER, DATABASE, PASSWORD.toCharArray());
	//private static final ServerAddress SERVER_ADDRESS = new ServerAddress(SERVER, PORT);
	
	private static final String DATABASE = "manualdosnoivos";
	private static final String URL_MONGO_DB = "OPENSHIFT_MONGODB_DB_URL";
	
	public static String getCasamentos() {
		StringBuffer retorno = new StringBuffer();
		try {
			retorno.append("MongoClient xDDDD");
			//MongoClient mongoClient = new MongoClient(SERVER_ADDRESS, Arrays.asList(CREDENTIAL));
			MongoClient mongoClient = new MongoClient(new MongoClientURI(System.getenv(URL_MONGO_DB)));
			retorno.append("\nMongoClient generated");
			DB db = mongoClient.getDB(DATABASE);
			retorno.append("\nConnect to database successfully");
			
			DBCollection casamento = db.getCollection("casamentos");
			retorno.append("\nCollection created successfully");
			BasicDBObject doc = new BasicDBObject("data", "10/10/2016").
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
