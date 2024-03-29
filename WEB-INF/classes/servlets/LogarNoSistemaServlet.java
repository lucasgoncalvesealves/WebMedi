package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UsuarioManager;

public class LogarNoSistemaServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		String quemsou = request.getParameter("quemsou");
		String tela = "";
		String msg = UsuarioManager.logarNoSistema(usuario, senha, quemsou);
		
		//util.Teste.main(null);
		
		HttpSession session = request.getSession();
		session.setAttribute("atribUsuario", usuario);

		if (msg == "") {
			switch (quemsou) {
				case "#0C9":
					tela = "jsp/cliente.jsp";
					break;
				case "#0CC":
					tela = "jsp/atendente.jsp";
					break;
				case "#0CF":
					tela = "jsp/credenciador.jsp";
					break;
				case "#39F":
					tela = "jsp/administrador.jsp";
					break;
				case "#99F":
					tela = "jsp/financeiro.jsp";
					break;
			}		
			RequestDispatcher view = request.getRequestDispatcher(tela);
			view.forward(request, response);
		}
		else {
			request.setAttribute("msgStatus", msg);
			RequestDispatcher view = request.getRequestDispatcher("jsp/index.jsp");
			view.forward(request, response);
		}

	}

}
