package br.com.manualdosnoivos.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.manualdosnoivos.dao.CategoriaFornecedorDAO;
import br.com.manualdosnoivos.model.CategoriaFornecedor;

@Path("/fornecedores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FornecedoresResource {
	
	@GET
	@Path("/categorias")
	public List<CategoriaFornecedor> getCategorias(){
        CategoriaFornecedorDAO categoriaFornecedorDAO = new CategoriaFornecedorDAO();
		return categoriaFornecedorDAO.readAllCategoriaFornecedor();
	}
}
