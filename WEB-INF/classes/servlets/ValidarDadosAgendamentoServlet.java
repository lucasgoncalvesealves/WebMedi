package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.AgendamentoBean;
import java.util.Date;
import java.math.BigDecimal;
import dao.SolicitacaoDAO;
import model.clsCliente;
import model.clsSolicitacao;
import java.util.*;
import model.clsProcedimento;

public class ValidarDadosAgendamentoServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BigDecimal numCartao = new BigDecimal(0);
		String nomProced = "";
		String msgRet = "";
		Long codSolicita = new Long(0);
		if (request.getParameter("solicitaSel") != null) {
			codSolicita = new Long(request.getParameter("solicitaSel"));
			SolicitacaoDAO solicitaDAO = new SolicitacaoDAO();
			List<clsSolicitacao> lstSolicita = solicitaDAO.buscaPorCod(codSolicita);
			clsSolicitacao solicita = new clsSolicitacao();
			if (!lstSolicita.isEmpty()) {
				solicita = lstSolicita.get(0);
				clsCliente cli = solicita.getTblCliente();
				numCartao = cli.getNroCartao();
				clsProcedimento proced = solicita.getTblProcedimento();
				nomProced = proced.getNome();
			}
			AgendamentoBean agendaBean = new AgendamentoBean();
			msgRet = agendaBean.validarDadosAgendamento(numCartao,nomProced,codSolicita);
		}
		else {
			msgRet = "Nenhuma Solicitação Selecionada.";
		}
		if (msgRet == "") {
			request.setAttribute("numCartao", numCartao);
			request.setAttribute("nomProced", nomProced);
			request.setAttribute("solicitaSel", codSolicita);
			RequestDispatcher view = request.getRequestDispatcher("jsp/ate-confirma-agendamento.jsp");
			view.forward(request, response);
		}
		else {
			request.setAttribute("msgRet", msgRet);
			RequestDispatcher view = request.getRequestDispatcher("jsp/ate-procedimentos.jsp");
			view.forward(request, response);
		}
	}
}
