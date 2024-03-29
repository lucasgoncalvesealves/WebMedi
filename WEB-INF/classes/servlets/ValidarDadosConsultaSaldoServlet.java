package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.ClienteBean;
import java.math.BigDecimal;

public class ValidarDadosConsultaSaldoServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BigDecimal numCartao = new BigDecimal(request.getParameter("numCartao"));
		BigDecimal numCPF = new BigDecimal(request.getParameter("numCPF"));
		ClienteBean cliBean = new ClienteBean();
		String msgRet = cliBean.validarDadosConsultaSaldo(numCartao,numCPF);
		if (msgRet == "") {
			msgRet = cliBean.consultarSaldo(numCartao,numCPF);
		}
		request.setAttribute("msgRet", msgRet);
		RequestDispatcher view = request.getRequestDispatcher("jsp/ate-saldo.jsp");
		view.forward(request, response);
	}
}
