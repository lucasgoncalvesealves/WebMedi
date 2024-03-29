package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.EspecialidadeBean;

public class IncluirEspecialidadeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomEsp = request.getParameter("nomEspInc");
		EspecialidadeBean espBean = new EspecialidadeBean();
		String msgRet = espBean.incluirEspecialidade(nomEsp);
		request.setAttribute("msgRet", msgRet);
		RequestDispatcher view = request.getRequestDispatcher("jsp/adm-especialidades.jsp");
		view.forward(request, response);
	}
}
