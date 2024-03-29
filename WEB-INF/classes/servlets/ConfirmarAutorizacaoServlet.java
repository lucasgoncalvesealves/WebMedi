package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AutorizacaoBean;
import bean.AutorizacaoNegadaBean;

import java.util.Date;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ConfirmarAutorizacaoServlet extends HttpServlet {
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
		DecimalFormat df = new DecimalFormat("###,##0.00");
		String precoStr = df.format(preco);
		BigDecimal precoBig = new BigDecimal(precoStr.replace(".","").replace(",","."));
		String msgRet = "";
		AutorizacaoBean autorizaBean = new AutorizacaoBean();
		msgRet = autorizaBean.verificarSaldo(numCartao,nomProced,nomClinica,nomAtendente,nomMedico,dataRealiza,horaRealiza,preco);
		if (msgRet == "") {
			msgRet = autorizaBean.solicitarAutorizacao(numCartao,nomProced,nomClinica,nomAtendente,nomMedico,dataRealiza,horaRealiza,preco,"N");
			if (msgRet != "") {
				request.setAttribute("msgRet", msgRet);
			}
			RequestDispatcher view = request.getRequestDispatcher("jsp/ate-autorizacoes.jsp");
			view.forward(request, response);
		}
		else {
			AutorizacaoBean autoriza2Bean = new AutorizacaoBean();
			String msgRetAutoriza2 = autoriza2Bean.verificarContingencia(numCartao,nomProced,nomClinica,nomAtendente,nomMedico,dataRealiza,horaRealiza,precoBig);
			if (msgRetAutoriza2 == "") {
				request.setAttribute("numCartao", numCartao);
				request.setAttribute("nomProced", nomProced);
				request.setAttribute("nomClinica", nomClinica);
				request.setAttribute("nomAtendente", nomAtendente);
				request.setAttribute("nomMedico", nomMedico);
				request.setAttribute("dataRealiza", dataRealiza);
				request.setAttribute("horaRealiza", horaRealiza);
				RequestDispatcher view = request.getRequestDispatcher("jsp/ate-confirma-contingencia.jsp");
				view.forward(request, response);
			}
			else {
				msgRet = msgRet.concat(" " + msgRetAutoriza2);
				AutorizacaoNegadaBean autorizaNegBean = new AutorizacaoNegadaBean();
				String msgRetAutorizaNeg = autorizaNegBean.negarAutorizacao(numCartao,nomProced,nomClinica,nomAtendente,nomMedico,dataRealiza,horaRealiza,preco);
				if (msgRetAutorizaNeg != "") {
					msgRet = msgRet.concat(" " + msgRetAutorizaNeg);
				}
				request.setAttribute("msgRet", msgRet);
				RequestDispatcher view = request.getRequestDispatcher("jsp/ate-autorizacoes.jsp");
				view.forward(request, response);
			}
		}
	}
}
