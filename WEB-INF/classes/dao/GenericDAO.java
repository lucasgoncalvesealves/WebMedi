package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtils;



public abstract class GenericDAO<PK, T> {
    protected Session session;
    protected Class<T> persistentClass;
    
    public GenericDAO() {
        this.session = HibernateUtils.getInstance();
    }
 
    public void salvar(T entity) {
    	session.persist(entity);
    	this.session.beginTransaction().commit();
    }
 
    public void atualizar(T entity) {
    	session.merge(entity);
    	this.session.beginTransaction().commit();
    }
 
    public void remover(T entity) {
    	session.delete(entity);
    	this.session.beginTransaction().commit();
    }
 
    @SuppressWarnings("unchecked")
	public T buscaPorId(long id) {
    	Criteria c = session.createCriteria(persistentClass);
    	c.add(Restrictions.eq("id", id));
    	
    	return (T) c.uniqueResult();
    }
    
    @SuppressWarnings("unchecked")
	public List<T> listaTodos() {
    	Criteria c = session.createCriteria(persistentClass);
    	c.addOrder(Order.asc("id"));
    	
    	return c.list();
    }
}
