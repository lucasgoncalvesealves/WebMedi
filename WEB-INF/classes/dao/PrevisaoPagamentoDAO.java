package dao;

import java.util.List;
import model.clsPrevisaoPagamento;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.SQLQuery;

public class PrevisaoPagamentoDAO extends GenericDAO<Long, clsPrevisaoPagamento> {
	
	public PrevisaoPagamentoDAO() {
		this.persistentClass = clsPrevisaoPagamento.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<clsPrevisaoPagamento> buscaPorCod(Long cod) {
		Criteria c = this.session.createCriteria(clsPrevisaoPagamento.class);
		c.add(Restrictions.eq("codPrevisaoPagamento", cod));
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<clsPrevisaoPagamento> buscaSQL(String strSql) {
		SQLQuery query = (SQLQuery) this.session.createSQLQuery(strSql).addEntity(model.clsPrevisaoPagamento.class);
		List<clsPrevisaoPagamento> lst = query.list();
		return lst;
	}

}
