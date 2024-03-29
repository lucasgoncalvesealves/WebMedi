package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AutorizacaoBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.math.BigDecimal;

public class ConfirmarCancelamentoServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BigDecimal numCartao = (BigDecimal) session.getAttribute("numCartao");
		String nomProced = (String) session.getAttribute("nomProced");
		Date dataCancela = (Date) session.getAttribute("dataCancela");
		String horaCancela = (String) session.getAttribute("horaCancela");
		Double preco = (Double) session.getAttribute("preco");
		Long solicitaSel = (Long) session.getAttribute("solicitaSel");
		AutorizacaoBean autorizaBean = new AutorizacaoBean();
		String msgRet = autorizaBean.verificarCancelamento(numCartao,nomProced,dataCancela,horaCancela,preco,solicitaSel);
		if (msgRet == "") {
			msgRet = autorizaBean.cancelarAutorizacao(numCartao,nomProced,dataCancela,horaCancela,preco,solicitaSel);
			if (msgRet != "") {
				request.setAttribute("msgRet", msgRet);
			}
		}
		else {
			request.setAttribute("msgRet", msgRet);
		}
		RequestDispatcher view = request.getRequestDispatcher("jsp/ate-autorizacoes.jsp");
		view.forward(request, response);
	}
}
