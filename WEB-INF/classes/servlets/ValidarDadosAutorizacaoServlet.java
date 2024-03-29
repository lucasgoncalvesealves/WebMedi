package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AutorizacaoBean;

import java.util.Date;
import java.math.BigDecimal;

public class ValidarDadosAutorizacaoServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BigDecimal numCartao = new BigDecimal(request.getParameter("numCartao"));
		String nomProced = request.getParameter("nomProced");
		String nomClinica = request.getParameter("nomClinica");
		String nomAtendente = request.getParameter("nomAtendente");
		String nomMedico = request.getParameter("nomMedico");
		Date dataRealiza = (Date) session.getAttribute("dataRealiza");
		String horaRealiza = (String) session.getAttribute("horaRealiza");
		AutorizacaoBean autorizaBean = new AutorizacaoBean();
		String msgRet = autorizaBean.validarDadosAutorizacao(numCartao,nomProced,nomClinica,nomAtendente,nomMedico,dataRealiza,horaRealiza);
		if (msgRet == "") {
			request.setAttribute("numCartao", numCartao);
			request.setAttribute("nomProced", nomProced);
			request.setAttribute("nomClinica", nomClinica);
			request.setAttribute("nomAtendente", nomAtendente);
			request.setAttribute("nomMedico", nomMedico);
			request.setAttribute("dataRealiza", dataRealiza);
			request.setAttribute("horaRealiza", horaRealiza);
			RequestDispatcher view = request.getRequestDispatcher("jsp/ate-confirma-autorizacao.jsp");
			view.forward(request, response);
		}
		else {
			request.setAttribute("msgRet", msgRet);
			RequestDispatcher view = request.getRequestDispatcher("jsp/ate-autorizacoes.jsp");
			view.forward(request, response);
		}
	}
}
