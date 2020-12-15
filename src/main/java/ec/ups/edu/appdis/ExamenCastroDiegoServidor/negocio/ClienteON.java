package ec.ups.edu.appdis.ExamenCastroDiegoServidor.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import ec.ups.edu.appdis.ExamenCastroDiegoServidor.dao.ClienteDAO;
import ec.ups.edu.appdis.ExamenCastroDiegoServidor.modelo.Cliente;


@Stateless
public class ClienteON implements  ClienteONRemoto {
	
	@Inject
	private ClienteDAO daoCliente;
	
	public boolean registrarCliente (Cliente cliente) throws Exception
	{
		if (cliente.getCedula().length()!=10) {
			throw new Exception("Cedula incorrecta");
		} 
		try {
			daoCliente.insertJPA(cliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Error al registrar");
		}
		
		return true;	
	}
	
	public List<Cliente> getClientesTipo1(){
		return daoCliente.getClientes();
	}
}
