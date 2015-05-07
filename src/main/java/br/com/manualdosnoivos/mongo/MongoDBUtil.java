package br.com.manualdosnoivos.mongo;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;

/**
 * MongoClient é thread safe e administra internamente seu próprio pool de conexões. 
 * A melhor prática é criar uma instância e reusá-la, criando-a na inicialização da 
 * aplicação e fechando-a quando for desligada, fazendo com que um ServletContextListener
 * seja uma boa opção para realizar essas tarefas.
 * 
 * @author fabiano
 *
 */
public class MongoDBUtil {
	
	private static MongoClient mongo;
	
	public static void initialize() {
		try {
			// conecta à base
			mongo = new MongoClient(new MongoClientURI(System.getenv(MongoDBConstants.URL_MONGO_DB)));
		} catch (MongoException ex) {
			Logger.getLogger(MongoDBUtil.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static MongoClient getMongo() {
		return mongo;
	}
	
	public static void destroy(){
		try {
			mongo.close();
		} catch (MongoException ex) {
			Logger.getLogger(MongoDBUtil.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}