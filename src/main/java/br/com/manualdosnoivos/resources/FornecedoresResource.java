package br.com.manualdosnoivos.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.manualdosnoivos.dao.CategoriaFornecedorDAO;
import br.com.manualdosnoivos.model.CategoriaFornecedor;

@Path("/fornecedores")
public class FornecedoresResource {
	
	/**
	 * Devolve lista de todas as categorias
	 * 
	 * @return
	 */
	@GET
	@Path("/categorias")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CategoriaFornecedor> getCategoriasFornecedor(){
		return new CategoriaFornecedorDAO().readAllCategoriaFornecedor();
	}
	
	/**
	 * Cria uma nova categoria
	 * 
	 * @param c
	 * @return
	 */
	@POST
	@Path("/categoria")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public CategoriaFornecedor addCategoriaFornecedor(CategoriaFornecedor c){
		return new CategoriaFornecedorDAO().createCategoriaFornecedor(c);
	}
	
	/**
	 * Devolve uma única categoria
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/categoria/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CategoriaFornecedor getCategoriaFornecedor(
		@PathParam("id") String id){
		return new CategoriaFornecedorDAO().readCategoriaFornecedor(id);
	}
	
	/**
	 * Deleta uma categoria
	 * 
	 * @param id
	 */
	@DELETE
	@Path("/categoria/{id}")
	@Produces(MediaType.APPLICATION_JSON) //TODO devolve o que? é pelo ID?
	public void deleteCategoriaFornecedor(@PathParam("id") String id){
		new CategoriaFornecedorDAO().deleteCategoriaFornecedor(id);
	}
	
	/**
	 * Exemplo de criação de categoria pelo form
	 * 
	 * @param id
	 * @param codigo
	 * @param nome
	 * @param descricao
	 * @return
	 */
	@POST
	@Path("/categoriaForm")
	@Produces(MediaType.APPLICATION_JSON)
	public CategoriaFornecedor addCategoriaFornecedorForm(
		@FormParam("id") String id,
		@FormParam("codigo") Integer codigo,
		@FormParam("nome") String nome,
		@FormParam("descricao") String descricao){
		
		CategoriaFornecedor retorno = null;
		if (codigo != null && nome != null && descricao != null){
			CategoriaFornecedor c = new CategoriaFornecedor();
			c.setId(id);
			c.setCodigo(codigo);
			c.setNome(nome);
			c.setDescricao(descricao);
			retorno = new CategoriaFornecedorDAO().createCategoriaFornecedor(c);
		} else {
			retorno = null;
		}
		return retorno;
	}
	
	/**
	 * Exemplo de criação de categoria por query parameters
	 * 
	 * @param id
	 * @param codigo
	 * @param nome
	 * @param descricao
	 * @return
	 */
	@GET
	@Path("/categoriaQuery")
	@Produces(MediaType.APPLICATION_JSON)
	public CategoriaFornecedor addCategoriaFornecedorQueryParameter(
		@QueryParam("id") String id,
		@QueryParam("codigo") Integer codigo,
		@QueryParam("nome") String nome,
		@QueryParam("descricao") String descricao){
		
		CategoriaFornecedor retorno = null;
		if (codigo != null && nome != null && descricao != null){
			CategoriaFornecedor c = new CategoriaFornecedor();
			c.setId(id);
			c.setCodigo(codigo);
			c.setNome(nome);
			c.setDescricao(descricao);
			retorno = new CategoriaFornecedorDAO().createCategoriaFornecedor(c);
		} else {
			retorno = null;
		}
		return retorno;
	}
}
