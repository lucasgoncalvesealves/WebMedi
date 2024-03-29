package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.AutorizacaoBean;
import java.math.BigDecimal;
import dao.SolicitacaoDAO;
import model.clsCliente;
import model.clsSolicitacao;
import java.util.*;
import model.clsProcedimento;

public class ValidarDadosCancelamentoServlet extends HttpServlet {
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
			AutorizacaoBean autorizaBean = new AutorizacaoBean();
			msgRet = autorizaBean.validarDadosCancelamento(numCartao,nomProced,codSolicita);
		}
		else {
			msgRet = "Nenhuma Autorização Selecionada.";
		}
		if (msgRet == "") {
			request.setAttribute("numCartao", numCartao);
			request.setAttribute("nomProced", nomProced);
			request.setAttribute("solicitaSel", codSolicita);
			RequestDispatcher view = request.getRequestDispatcher("jsp/ate-confirma-cancelamento.jsp");
			view.forward(request, response);
		}
		else {
			request.setAttribute("msgRet", msgRet);
			RequestDispatcher view = request.getRequestDispatcher("jsp/ate-autorizacoes.jsp");
			view.forward(request, response);
		}
	}
}
