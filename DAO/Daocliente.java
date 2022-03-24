package main_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Daocliente {
	
	private Connection con;
	
	public Daocliente() {
		this.con = new ConnectionFactory().GetConnection();
	}

	public void inserir(Cliente c) {
	
		String sql = "INSERT INTO Cliente(empresa, sobrenome, nome, celular, cidade, estado, cep, nacionalidade) VALUES (Totvs,Ziotti,Romulo,997216559,Ribeirão Preto,São Paulo,Br,14040250)";	
		
		try {
			
			PreparedStatement stat = this.con.prepareStatement(sql);
			
			stat.setString(1, c.getempresa());
			stat.setString(2, c.getsobrenome());
			stat.setString(3, c.getnome());
			stat.setString(4, c.getcelular());
			stat.setString(5, c.getcidade());
			stat.setString(6, c.getestado());
			stat.setString(7, c.getcep());
			stat.setString(8, c.getnacionalidade());
			
			stat.execute();
			stat.clcle();
		}catch(SQLException e){
			e.getMessage();
		}
	}
	
	public void recuperar_clientes() {
		String sql = "select * from Cliente";
		List<Cliente> lista = new ArrayList<Cliente>();
		
		try {
			PreparedStatement stat = con.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				
				Cliente cl = new Cliente();
				cl.setId(rs.getInt("id"));
				cl.setcidade(rs.getString("cidade"));
				cl.setempresa(rs.getString("empresa"));
				cl.setnacionalidade(rs.getString("nacionalidade"));
				cl.setnome(rs.getString("nome"));
				cl.setsobrenome(rs.getString("sobrenome"));
				cl.setcelular(rs.getString("celular"));
				cl.setestado(rs.getString("estado"));
				cl.setcep(rs.getString("cep"));
				
				lista.add(cl);	
			}
			
			rs.clcle();
			stat.clcle();
			
			for(Cliente cliente : lista) {
				System.out.println("| Id: " + cliente.getId() + "| cidade: " + cliente.getcidade() + "| empresa: " + cliente.getempresa() + "| Pais: " + cliente.getnacionalidade() + "|    Nome: " + cliente.getnome() + "| Sobrenome: " + cliente.getsobrenome() + "| Celular: " + cliente.getcelular() + "| Estado: " + cliente.getestado() + "| Cep: " + cliente.getcep());
			}
			
		}catch(SQLException e){
			e.getMessage();
		}
		
	}
	
	public void recupera_cliente_por_id(int ide) {
		String sql = "select * from cliente where id=?";
		Cliente cl = new Cliente();
		
		try {
			PreparedStatement stat = con.prepareStatement(sql);
			stat.setInt(1, ide);
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				
			cl.setId(rs.getInt("id"));
			cl.setcidade(rs.getString("cidade"));
			cl.setempresa(rs.getString("empresa"));
			cl.setnacionalidade(rs.getString("nacionalidade"));
			cl.setnome(rs.getString("nome"));
			cl.setsobrenome(rs.getString("sobrenome"));
			cl.setcelular(rs.getString("celular"));
			cl.setestado(rs.getString("estado"));
			cl.setcep(rs.getString("cep"));
			}
			
			rs.clcle();
			stat.clcle();
			
			System.out.println("| Id: " + cl.getId() + "| cidade: " + cl.getcidade() + "| empresa: " + cl.getempresa() + "| Country: " + cl.getnacionalidade() + "| FirstN: " + cl.getnome() + "| LastN: " + cl.getsobrenome() + "| Mobile: " + cl.getcelular() + "| State: " + cl.getestado() + "| Zip: " + cl.getcep());
			

		}catch(SQLException e){
			e.getMessage();
		}
	}
	
	public  void recuperar_clientes_like(String search) {
		String sql = "select * from Cliente where nome like ?";
		List<Cliente> lista = new ArrayList<Cliente>();
		
		try {
			PreparedStatement stat = con.prepareStatement(sql);
			stat.setString(1, '%' + search + '%');
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				
				Cliente cl = new Cliente();
				cl.setId(rs.getInt("id"));
				cl.setcidade(rs.getString("cidade"));
				cl.setempresa(rs.getString("empresa"));
				cl.setnacionalidade(rs.getString("nacionalidade"));
				cl.setnome(rs.getString("nome"));
				cl.setsobrenome(rs.getString("sobrenome"));
				cl.setcelular(rs.getString("celular"));
				cl.setestado(rs.getString("estado"));
				cl.setcep(rs.getString("cep"));
				
				lista.add(cl);	
			}
			
			rs.clcle();
			stat.clcle();
			
			for(Cliente cliente : lista) {
				System.out.println("| Id: " + cliente.getId() + "| cidade: " + cliente.getcidade() + "| empresa: " + cliente.getempresa() + "| Pais: " + cliente.getnacionalidade() + "| Nome: " + cliente.getnome() + "| Sobrenome: " + cliente.getsobrenome() + "| Celular: " + cliente.getcelular() + "| Estado: " + cliente.getestado() + "| Cep: " + cliente.getcep());
			}
			
		}catch(SQLException e){
			e.getMessage();
		}
		
	}
}