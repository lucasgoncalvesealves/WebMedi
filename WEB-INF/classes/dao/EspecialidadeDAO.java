package dao;

import java.util.List;
import model.clsEspecialidade;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class EspecialidadeDAO extends GenericDAO<Long, clsEspecialidade> {
	
	public EspecialidadeDAO() {
		this.persistentClass = clsEspecialidade.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<clsEspecialidade> buscaPorNome(String nome) {
		Criteria c = this.session.createCriteria(clsEspecialidade.class);
		c.add(Restrictions.like("descricao", nome, MatchMode.ANYWHERE));
		return c.list();
	}
	
}
