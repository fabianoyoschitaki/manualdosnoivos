package br.com.manualdosnoivos.mongo;

public class MongoDBConstants {
	/** nome do banco de dados da aplicação **/
	public static final String DATABASE = "manualdosnoivos";
	
	/** string de conexão com o mongo db, conecta com variável de ambiente fornecida pelo openshift**/
	public static final String URL_MONGO_DB = "OPENSHIFT_MONGODB_DB_URL";
	
	/** base das categorias de fornecedores **/
	public static final String COLLECTION_CATEGORIA_FORNECEDOR = "categoria_fornecedor";
	
	/** base das telas **/
	public static final String COLLECTION_TELAS = "telas";
}
