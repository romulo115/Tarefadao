package main_package;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDAO {
	
	public static void main(String[] args) throws SQLException {
	
	Cliente c = new Cliente();
	
	
	c.setempresa("Totbvs");
	c.setsobrenome("Ziotti");
	c.setnome("Romulo");
	c.setcelular("997216559");
	c.setcidade("Ribeirão Preto");
	c.setestado("São Paulo");
	c.setcep("14040250");
	c.setnacionalidade("BR");
	
	Daocliente daoc = new Daocliente();
	
	daoc.recuperar_clientes_like("Ann");
	
	}

}