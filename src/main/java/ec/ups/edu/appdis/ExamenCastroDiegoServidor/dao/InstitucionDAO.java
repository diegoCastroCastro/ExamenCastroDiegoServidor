package ec.ups.edu.appdis.ExamenCastroDiegoServidor.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import ec.ups.edu.appdis.ExamenCastroDiegoServidor.modelo.Cliente;

@Stateless
public class InstitucionDAO{
	
	private Connection con;
	
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

}
