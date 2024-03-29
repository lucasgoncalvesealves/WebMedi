package dao;

import java.util.List;
import model.clsCliente;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import java.math.BigDecimal;

public class ClienteDAO extends GenericDAO<Long, clsCliente> {
	
	public ClienteDAO() {
		this.persistentClass = clsCliente.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<clsCliente> buscaPorNome(String nome) {
		Criteria c = this.session.createCriteria(clsCliente.class);
		c.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE));
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<clsCliente> buscaPorCartao(BigDecimal nro_cartao) {
		Criteria c = this.session.createCriteria(clsCliente.class);
		c.add(Restrictions.eq("nroCartao", nro_cartao));
		return c.list();
	}

}
