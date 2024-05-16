package Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Pessoa;

public class PessoaDao extends Pessoa{
	
	
	public List<Pessoa> listarPesssoas(){
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		try {
			Connection con = new ConnectionFactory().getConnection();
			PreparedStatement smt = con.prepareStatement("select * from pessoa");
			ResultSet rs = smt.executeQuery();
		
			while(rs.next()) {
				Pessoa p = new Pessoa();
				
				p.setNome(rs.getString("nome"));
				p.setSenha(rs.getInt("senha"));
				
				pessoas.add(p);
			}
			rs.close();
			smt.close();
			con.close();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
		
		return pessoas;
	}
}
