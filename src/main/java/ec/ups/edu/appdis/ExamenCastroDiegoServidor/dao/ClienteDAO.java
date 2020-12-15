package ec.ups.edu.appdis.ExamenCastroDiegoServidor.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.ups.edu.appdis.ExamenCastroDiegoServidor.modelo.Cliente;

@Stateless
public class ClienteDAO{
	
	@Inject
	private Connection con;
	
	@Inject
	private EntityManager em;
	
	public boolean insertJPA(Cliente entity) throws SQLException {
		em.persist(entity);
		return true;
	}

	public boolean update(Cliente entity) {
		em.merge(entity);
		return true;
	}

	public Cliente read(int id) {
		Cliente cliente = em.find(Cliente.class, id);
		return cliente;
	}

	public boolean delete(int id) {
		Cliente cliente = em.find(Cliente.class, id);
		em.remove(cliente);
		return true;
	}
	
	public List<Cliente> getClientes(){
		String jpql = "SELECT c FROM c WHERE cedula=?1";
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter(1, 1);
		return q.getResultList();
	}

}
