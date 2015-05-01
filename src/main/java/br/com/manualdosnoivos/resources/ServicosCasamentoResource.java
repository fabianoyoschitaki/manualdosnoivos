package br.com.manualdosnoivos.resources;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.manualdosnoivos.common.ServicoCasamento;
import br.com.manualdosnoivos.db.MongoDBTest;

/**
 * Exemplo WebService RESTful com JAX-RS
 * 
 * http://manualdosnoivos-manualdosnoivos.rhcloud.com/rest/servicoscasamento/servicos
 * 
 * @author fabiano
 *
 */
@Path("/servicoscasamento")
@Produces("application/json")
@Consumes("application/json")
public class ServicosCasamentoResource {

	@GET
	@Path("/servicos")
	public Set<ServicoCasamento> getServicosCasamento(){
		Set<ServicoCasamento> retorno = new HashSet<ServicoCasamento>();
		retorno = getServicosCasamentoMock();
		return retorno;
	}
	
	@GET
	@Path("/variables")
	public Map<String, String> getEnvironmentalVariables(){
		return System.getenv();
	}
	
	@GET
	@Path("/variable/{variable}")
	public String getEnvironmentalVariable(@PathParam("variable")String variable){
		return System.getenv(variable);
	}
	
	@GET
	@Path("/mongodb")
	public String getCasamento(){
		return MongoDBTest.getCasamentos();
	}
	
	@GET
	@Path("/servico/{nome}")
	public ServicoCasamento getServicoCasamento(@PathParam("nome")String nome){
		ServicoCasamento retorno = null;
		Set<ServicoCasamento> todosServicos = getServicosCasamento();
		for (ServicoCasamento servicoCasamento : todosServicos) {
			if (nome.equals(servicoCasamento.getNome())){
				retorno = servicoCasamento;
				break;
			}
		}
		return retorno;
	}
	
	private static Set<ServicoCasamento> getServicosCasamentoMock() {
		Set<ServicoCasamento> retorno = new HashSet<ServicoCasamento>();
		retorno.add(new ServicoCasamento("Convites", "Crie convites personalizados para seu casamento!"));
		retorno.add(new ServicoCasamento("Buffet", "Escolha o melhor buffet para sua festa!"));
		retorno.add(new ServicoCasamento("Foto e Vídeo", "Registre o momento mais importante de sua vida!"));
		return retorno;
	}
}
