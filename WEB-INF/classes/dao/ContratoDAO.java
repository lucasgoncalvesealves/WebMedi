package dao;

import java.util.List;

import model.clsContrato;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;

public class ContratoDAO extends GenericDAO<Long, clsContrato> {
	
	public ContratoDAO() {
		this.persistentClass = clsContrato.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<clsContrato> buscaPorCod(Long cod) {
		Criteria c = this.session.createCriteria(clsContrato.class);
		c.add(Restrictions.eq("codContrato", cod));
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<clsContrato> buscaSQL(String strSql) {
		SQLQuery query = (SQLQuery) this.session.createSQLQuery(strSql).addEntity(model.clsContrato.class);
		List<clsContrato> lst = query.list();
		return lst;
	}

}
