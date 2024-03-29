package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;

import model.clsAgendamento;

public class AgendamentoDAO extends GenericDAO<Long, clsAgendamento> {

	public AgendamentoDAO() {
		this.persistentClass = clsAgendamento.class;
	}

	@SuppressWarnings("unchecked")
	public List<clsAgendamento> buscaPorCod(Long cod) {
		Criteria c = this.session.createCriteria(clsAgendamento.class);
		c.add(Restrictions.eq("codAgendamento", cod));
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<clsAgendamento> buscaSQL(String strSql) {
		SQLQuery query = (SQLQuery) this.session.createSQLQuery(strSql).addEntity(model.clsAgendamento.class);
		List<clsAgendamento> lst = query.list();
		return lst;
	}
	
}
