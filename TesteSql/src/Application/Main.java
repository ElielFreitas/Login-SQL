package Application;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Pessoa;
import Model.Produto;

public class Main extends JFrame implements ActionListener {

	JLabel icone = new JLabel(new ImageIcon(getClass().getResource("icon.png")));
	JLabel nome = new JLabel("Loja da Pedrin");
	JLabel nomeP = new JLabel("Inicio Loja");
	JLabel iUsuario = new JLabel("Usuário");
	JLabel iSenha = new JLabel("Senha");
	JTextField usuario = new JTextField(5);
	JTextField senha= new JTextField(5);
	JButton bt1 = new JButton("Entrar");
	
	public Main() {
		janelaLogin();
		new Logar().start();
	}
	
	public class Logar extends Thread{
		public void run() {
			try {
				bt1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						try {
	                        	String usu = usuario.getText();
	    						int sen = Integer.parseInt(senha.getText());
	    						 
	    						Connection con = new ConnectionFactory().getConnection();
	    						PreparedStatement smt = con.prepareStatement("SELECT * FROM pessoa WHERE nome = ? AND senha = ?");
	    						
	    							
	    	                        smt.setString(1, usu);
	    	                        smt.setInt(2, sen);
	    	                       
	    	                        ResultSet rs = smt.executeQuery();
	    	                        if (rs.next()) {
	    	                            JOptionPane.showMessageDialog(null, "Bem vindo, " + usu + "!");
	    	                            janelaPrincipal();

	    	                        } else {
	    	                            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
	    	                        }
	    	                        rs.close();
	    	                        smt.close();
	    	                        con.close();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	                        
					}
				});
				}
				catch(Exception e) {
					System.out.println("Erro!! " + e);
				}
		}
	}
	
	public void janelaPrincipal() {
		setTitle("Loja da Analu");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,720);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		nomeP.setBounds(160, 100, 250, 250);
		nomeP.setFont(new Font("Arial Black", Font.BOLD, 20));
		add(nomeP);
	}
	
	public void janelaLogin() {
		setTitle("Loja da Analu");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,720);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		//Configuração da imagem do ícone
		icone.setBounds(140, 0, 50, 50);
		icone.setSize(200, 200);
		//Configuração do texto
		nome.setBounds(160, 100, 250, 250);
		nome.setFont(new Font("Arial Black", Font.BOLD, 20));
		iUsuario.setBounds(80, 170, 250, 250);
		iUsuario.setFont(new Font("Arial Black", Font.BOLD, 20));
		iSenha.setBounds(80, 270, 250, 250);
		iSenha.setFont(new Font("Arial Black", Font.BOLD, 20));
		//Configuração do inputs
		usuario.setBounds(100, 320, 160, 20);
		senha.setBounds(100, 420, 160, 20);
		//Configuração botão
		bt1.setBounds(180, 520, 100, 40);
		bt1.addActionListener(this);
		//Adiconar itens
		add(icone);
		add(nome);
		add(iUsuario);
		add(usuario);
		add(iSenha);
		add(senha);
		add(bt1);
		
	}
	
	public static void main(String[] args) {
		PessoaDao dao = new PessoaDao();
		ProdutoDao daoProduto = new ProdutoDao();
		
		new Main();
		
		for(Pessoa p : dao.listarPesssoas()) {
			System.out.println(p.toString());
		}
		
		for(Produto p : daoProduto.listarProdutos()) {
			System.out.println(p.toString());
		}

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
