package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AgendamentoBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.math.BigDecimal;

public class ConfirmarAgendamentoServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BigDecimal numCartao = (BigDecimal) session.getAttribute("numCartao");
		String nomProced = (String) session.getAttribute("nomProced");
		String strDataRealiza = request.getParameter("dataRealiza");
		Date dataRealiza = new Date(0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String msgRet = "";
		try {
			dataRealiza = sdf.parse(strDataRealiza);
		}
		catch (ParseException e) {
			msgRet = e.getMessage();
		}
		String horaRealiza = request.getParameter("horaRealiza");
		if (msgRet == "") {
			Double preco = (Double) session.getAttribute("preco");
			Long solicitaSel = (Long) session.getAttribute("solicitaSel");
			AgendamentoBean agendaBean = new AgendamentoBean();
			msgRet = agendaBean.verificarDisponibilidade(numCartao,nomProced,dataRealiza,horaRealiza,preco,solicitaSel);
			if (msgRet == "") {
				msgRet = agendaBean.agendarProcedimento(numCartao,nomProced,dataRealiza,horaRealiza,preco,solicitaSel);
				if (msgRet != "") {
					request.setAttribute("msgRet", msgRet);
				}
			}
			else {
				request.setAttribute("msgRet", msgRet);
			}
		}
		else {
			request.setAttribute("msgRet", msgRet);
		}
		RequestDispatcher view = request.getRequestDispatcher("jsp/ate-procedimentos.jsp");
		view.forward(request, response);
	}
}
