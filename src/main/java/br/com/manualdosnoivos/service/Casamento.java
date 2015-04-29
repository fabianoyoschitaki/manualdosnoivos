package br.com.manualdosnoivos.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Exemplo WebService SOAP com JAX-WS
 * 
 * http://servidor/Casamento?WSDL
 * 
 * @author fabiano
 *
 */
@WebService
public class Casamento {
	@WebMethod(operationName="listarCasamentos")
	public @WebResult(name="casamento")
	List<String> listarCasamentos (
	 @WebParam(name="data")String data){
		List<String> retorno = new ArrayList<String>();
		retorno.add("Maria e João");
		retorno.add("Pirilampo e Matusalenha");
		return retorno;
	}
}
