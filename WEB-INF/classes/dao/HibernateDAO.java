package dao;

import java.util.List;

import model.Hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class HibernateDAO extends GenericDAO<Long, Hibernate> {
	public HibernateDAO() {
		this.persistentClass = Hibernate.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Hibernate> buscaPorNome(String nome) {
		Criteria c = this.session.createCriteria(Hibernate.class);
		c.add(Restrictions.like("descricao", nome, MatchMode.ANYWHERE));
		return c.list();
	}
}
