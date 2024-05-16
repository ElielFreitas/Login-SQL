package Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Produto;

public class ProdutoDao {
	public List<Produto> listarProdutos(){
		List<Produto> pessoas = new ArrayList<Produto>();
		
		try {
			Connection con = new ConnectionFactory().getConnection();
			PreparedStatement smt = con.prepareStatement("select * from produto");
			ResultSet rs = smt.executeQuery();
		
			while(rs.next()) {
				Produto p = new Produto();
				p.setIdProduto(rs.getInt("idProduto"));
				p.setNome(rs.getString("nome"));
				p.setPreco(rs.getDouble("preco"));
				
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
