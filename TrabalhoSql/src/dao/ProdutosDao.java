package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import bean.ProdutosBean;
import connection.ConnectionFactory;

public class ProdutosDao {

	//Atributos para obter a conexao
	private Connection conexao;

	//Construtor
	public ProdutosDao() {
		//maneiras de se obter uma conexao
		//ConnectionFactory cf = new ConnectionFactory();
		//this.conexao = cf.obterConexao();

		this.conexao = new ConnectionFactory().obterConexao();
	}


	//Metodo para cadastrar um curso
	public void cadastrarCurso(ProdutosBean cb) {

		//Comando SQL
		String sql = "INSERT INTO produto(nomeProduto,idMarca, Valor) VALUES (?,?,?)";
         
		
		//Tentar realizar o comando SQL
		try {

			//Enviando os parametros e executando
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setString(1, cb.getNomeProduto());
			pstmt.setInt(2, cb.getIdMarca());
			pstmt.setDouble(3, cb.getValor());
			pstmt.execute();


			//Fechar a conexão
			pstmt.close();

		} catch (Exception e) {

			//caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao inserir dados");


		}


	}

	//Metodo para selecionar um curso
	public DefaultTableModel listarCursos() {

		//Criando defaulttablemodel
		DefaultTableModel modelo = new DefaultTableModel();

		//Definir as colunas do DefaultTableModel
		modelo.addColumn("Código");
		modelo.addColumn("Produto");
		modelo.addColumn("idMarca");
		modelo.addColumn("Valor");

		//COMANDO SQL
		String sql = "SELECT * FROM produto";

		//Tentar realizar o comando SQL
		try {
			//Conectar e selecionar o comando SQL
			Statement stmt = conexao.createStatement();

			//Executando comando SQL e obtendo dados
			ResultSet rs = stmt.executeQuery(sql);

			//Listando cursos
			while(rs.next()) {
				modelo.addRow(new Object[]{
						rs.getInt("idProduto"),
						rs.getString("nomeProduto"),
						rs.getInt("idMarca"),
						rs.getDouble("Valor")
				});

			}

			//Fechar a conexão
			stmt.close();



		} catch (Exception e) {
			//caso haja falhas na seleçao
			JOptionPane.showMessageDialog(null, "Falha ao selecionar os cursos");
		}
		return modelo;
	}

	public void ExcluirCursos(ProdutosBean cb) {

		//Comando SQL
		String sql = "DELETE FROM produto WHERE nomeProduto = ? AND Valor = ? ";

		//Tentar realizar o comando SQL
		try {

			//Enviando os parametros e executando
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setString(1, cb.getNomeProduto());
			pstmt.setDouble(2, cb.getValor());
			pstmt.execute();


			//Fechar a conexão
			pstmt.close();

		} catch (Exception e) {

			//caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao excluir dados");


		}


	}
	public void AlterarCursos(ProdutosBean cb) {

		//Comando SQL
		String sql = "UPDATE produto SET nomeProduto = ? , idMarca = ? , Valor = ?   WHERE idProduto = ? ";
		
		//Tentar realizar o comando SQL
		try {

			//Enviando os parametros e executando
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setString(1, cb.getNomeProduto());
			pstmt.setInt(2, cb.getIdMarca());
			pstmt.setDouble(3, cb.getValor());
			pstmt.setInt(4, cb.getIdProduto());
			pstmt.execute();


			//Fechar a conexão
			pstmt.close();

		} catch (Exception e) {

			//caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao alterar dados");


		}

	}
}
