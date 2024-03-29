package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;

import model.clsAutorizacao;

public class AutorizacaoDAO extends GenericDAO<Long, clsAutorizacao> {

	public AutorizacaoDAO() {
		this.persistentClass = clsAutorizacao.class;
	}

	@SuppressWarnings("unchecked")
	public List<clsAutorizacao> buscaPorCod(Long cod) {
		Criteria c = this.session.createCriteria(clsAutorizacao.class);
		c.add(Restrictions.eq("codAutorizacao", cod));
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<clsAutorizacao> buscaSQL(String strSql) {
		SQLQuery query = (SQLQuery) this.session.createSQLQuery(strSql).addEntity(model.clsAutorizacao.class);
		List<clsAutorizacao> lst = query.list();
		return lst;
	}
	
}
