package br.com.manualdosnoivos.resources;

import java.util.List;

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
	 * Devolve lista de todas as telas
	 * 
	 * @return
	 */
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tela> getTelas(){
		return new TelaDAO().readAllTelas();
	}
	/**
	 * Devolve uma única tela
	 * 
	 * @param nome
	 * @return
	 */
	@GET
	@Path("/tela/{nome}")
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
	@Path("/tela")
	@Produces(MediaType.APPLICATION_JSON)
	public Tela addTela(
		@FormParam("nome") String nome,
		@FormParam("senha") String senha,
		@FormParam("conteudo") String conteudo){
		
		Tela retorno = null;
		// se enviou nome da tela e o conteúdo
		if (nome != null && conteudo != null && senha.equals("jordao123")){
			TelaDAO dao = new TelaDAO();
			
			// ve se a tela ja existe no banco
			Tela t = dao.readTela(nome);
			
			// nova tela
			if (t == null){
				t = new Tela();
				t.setNome(nome);
				t.setConteudo(conteudo);
				retorno = dao.createTela(t);
			} 
			// só atualiza
			else {
				t.setConteudo(conteudo);
				retorno = dao.updateTela(t);
			} 
		} 
		return retorno;
	}
}
