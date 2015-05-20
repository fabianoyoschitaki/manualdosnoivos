package br.com.manualdosnoivos.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.manualdosnoivos.dao.TelaDAO;
import br.com.manualdosnoivos.model.Tela;

/**
 * Servlet implementation class TelaServlet
 */
public class TelasServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TelasServletController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI().substring(request.getContextPath().length() + 7);
		// Set response content type
		response.setContentType("text/html");

		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		if (path != null){
			Tela tela = new TelaDAO().readTela(path);
			if (tela != null){
				if (!"".equals(tela.getConteudo())){
					out.println(tela.getConteudo());
				} else {
					out.println("<h1> Página [" + path + "] existe, mas não tem conteúdo.</h1>");
				}
			}
		} else {
			out.println("<h1> Página [" + path + "] não existe.</h1>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
