package br.com.manualdosnoivos.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_FORM_URLENCODED})
	public CategoriaFornecedor adicionaCategoriaFornecedor(CategoriaFornecedor c){
		return new CategoriaFornecedorDAO().createCategoriaFornecedor(c);
	}
}
