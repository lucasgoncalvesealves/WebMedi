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

public class ConfirmarContingenciaServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BigDecimal numCartao = (BigDecimal) session.getAttribute("numCartao");
		String nomProced = (String) session.getAttribute("nomProced");
		String nomClinica = (String) session.getAttribute("nomClinica");
		String nomAtendente = (String) session.getAttribute("nomAtendente");
		String nomMedico = (String) session.getAttribute("nomMedico");
		Date dataRealiza = (Date) session.getAttribute("dataRealiza");
		String horaRealiza = (String) session.getAttribute("horaRealiza");
		Double preco = (Double) session.getAttribute("preco");
		String msgRet = "";
		AutorizacaoBean autorizaBean = new AutorizacaoBean();
		msgRet = autorizaBean.solicitarAutorizacao(numCartao,nomProced,nomClinica,nomAtendente,nomMedico,dataRealiza,horaRealiza,preco,"S");
		if (msgRet != "") {
			request.setAttribute("msgRet", msgRet);
		}
		RequestDispatcher view = request.getRequestDispatcher("jsp/ate-autorizacoes.jsp");
		view.forward(request, response);
	}
}
