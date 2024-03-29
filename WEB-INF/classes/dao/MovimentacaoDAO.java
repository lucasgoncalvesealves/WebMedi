package dao;

import java.util.List;
import model.clsMovimentacao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.SQLQuery;

public class MovimentacaoDAO extends GenericDAO<Long, clsMovimentacao> {
	
	public MovimentacaoDAO() {
		this.persistentClass = clsMovimentacao.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<clsMovimentacao> buscaPorCod(Long cod) {
		Criteria c = this.session.createCriteria(clsMovimentacao.class);
		c.add(Restrictions.eq("codMovimentacao", cod));
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<clsMovimentacao> buscaSQL(String strSql) {
		SQLQuery query = (SQLQuery) this.session.createSQLQuery(strSql).addEntity(model.clsMovimentacao.class);
		List<clsMovimentacao> lst = query.list();
		return lst;
	}

}
