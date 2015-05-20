package br.com.manualdosnoivos.resources;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.manualdosnoivos.dao.TelaDAO;
import br.com.manualdosnoivos.model.Tela;

@Path("/telas")
public class TelasResource {
	
	/**
	 * Devolve uma única tela
	 * 
	 * @param nome
	 * @return
	 */
	@GET
	@Path("/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public Tela getTela(
		@PathParam("nome") String nome){
		return new TelaDAO().readTela(nome);
	}
	
	/**
	 * Deleta uma categoria
	 * 
	 * @param id
	 
	@DELETE
	@Path("/categoria/{id}")
	@Produces(MediaType.APPLICATION_JSON) //TODO devolve o que? é pelo ID?
	public void deleteCategoriaFornecedor(@PathParam("id") String id){
		new CategoriaFornecedorDAO().deleteCategoriaFornecedor(id);
	}*/
	
	/**
	 * Exemplo de criação de tela pelo form
	 * 
	 * @param id
	 * @param codigo
	 * @param nome
	 * @param descricao
	 * @return
	 */
	@POST
	@Path("/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public Tela addTela(
		@FormParam("id") String id,
		@FormParam("nome") String nome,
		@FormParam("conteudo") String conteudo){
		
		Tela retorno = null;
		if (nome != null && conteudo != null){
			Tela t = new Tela();
			t.setId(id);
			t.setNome(nome);
			t.setConteudo(conteudo);
			retorno = new TelaDAO().createTela(t);
		} else {
			retorno = null;
		}
		return retorno;
	}
}
