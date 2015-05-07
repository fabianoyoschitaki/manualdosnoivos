package br.com.manualdosnoivos.listener;

import java.net.UnknownHostException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.com.manualdosnoivos.mongo.MongoDBUtil;

import com.mongodb.MongoClient;

/**
 * Listener que inicializa com a aplicação para iniciar conexão com MongoDB
 * 
 * @author fabiano
 *
 */
@WebListener
public class MongoDBContextListener implements ServletContextListener {
 
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        MongoDBUtil.destroy();
        System.out.println("MongoClient closed successfully");
    }
 
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        MongoDBUtil.initialize();
		MongoClient mongo = MongoDBUtil.getMongo();
		System.out.println("MongoClient initialized successfully");
		sce.getServletContext().setAttribute("MONGO_CLIENT", mongo);
    }
 
}
