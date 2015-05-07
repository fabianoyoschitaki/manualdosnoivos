package br.com.manualdosnoivos.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.manualdosnoivos.dao.CategoriaFornecedorDAO;
import br.com.manualdosnoivos.model.CategoriaFornecedor;

@Path("/fornecedores")
public class FornecedoresResource {
	
	@GET
	@Path("/categorias")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CategoriaFornecedor> getCategoriasFornecedor(){
		return new CategoriaFornecedorDAO().readAllCategoriaFornecedor();
	}
	
	@POST
	@Path("/categoria")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public CategoriaFornecedor adicionaCategoriaFornecedor(CategoriaFornecedor c){
		return new CategoriaFornecedorDAO().createCategoriaFornecedor(c);
	}
	
	/**@GET
	@Path("/categoria/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CategoriaFornecedor deletaCategoriaFornecedor(
		@PathParam(name="id") String id,
		@QueryParam(name="operation") String operacao){
		return new CategoriaFornecedorDAO().createCategoriaFornecedor(c);
	}**/
	
	@DELETE
	@Path("/categoria/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CategoriaFornecedor deletaCategoriaFornecedor(
		@PathParam("id") String id){
		new CategoriaFornecedorDAO().deleteCategoriaFornecedor(id);
	}
	
	@POST
	@Path("/categoriaForm")
	@Produces(MediaType.APPLICATION_JSON)
	public CategoriaFornecedor adicionaCategoriaFornecedor(
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
}
