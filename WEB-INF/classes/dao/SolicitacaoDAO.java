package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;

import model.clsSolicitacao;

public class SolicitacaoDAO extends GenericDAO<Long, clsSolicitacao> {

	public SolicitacaoDAO() {
		this.persistentClass = clsSolicitacao.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<clsSolicitacao> buscaPorCod(Long cod) {
		Criteria c = this.session.createCriteria(clsSolicitacao.class);
		c.add(Restrictions.eq("codSolicitacao", cod));
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<clsSolicitacao> buscaSQL(String strSql) {
		SQLQuery query = (SQLQuery) this.session.createSQLQuery(strSql).addEntity(model.clsSolicitacao.class);
		List<clsSolicitacao> lst = query.list();
		return lst;
	}
	
}
