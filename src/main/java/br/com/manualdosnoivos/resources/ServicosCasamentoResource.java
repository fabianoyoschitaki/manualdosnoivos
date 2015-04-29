package br.com.manualdosnoivos.resources;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.manualdosnoivos.common.ServicoCasamento;

/**
 * Exemplo WebService RESTful com JAX-RS
 * 
 * http://servidor/servicoscasamento
 * 
 * @author fabiano
 *
 */
@Path("/servicoscasamento")
public class ServicosCasamentoResource {

	@GET
	@Produces("application/json")
	public Set<ServicoCasamento> getServicosCasamento(){
		Set<ServicoCasamento> retorno = new HashSet<ServicoCasamento>();
		retorno = getServicosCasamentoMock();
		return retorno;
	}

	private Set<ServicoCasamento> getServicosCasamentoMock() {
		Set<ServicoCasamento> retorno = new HashSet<ServicoCasamento>();
		retorno.add(new ServicoCasamento("Convites", "Crie convites personalizados para seu casamento!"));
		retorno.add(new ServicoCasamento("Buffet", "Escolha o melhor buffet para sua festa!"));
		retorno.add(new ServicoCasamento("Foto e Vídeo", "Registre o momento mais importante de sua vida!"));
		return retorno;
	}
}
