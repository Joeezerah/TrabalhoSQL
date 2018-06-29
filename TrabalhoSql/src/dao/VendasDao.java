package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import bean.VendasBean;
import connection.ConnectionFactory;

public class VendasDao {
	
	//Atributos para obter a conexao
			private Connection conexao;

			//Construtor
			public VendasDao() {
				//maneiras de se obter uma conexao
				//ConnectionFactory cf = new ConnectionFactory();
				//this.conexao = cf.obterConexao();

				this.conexao = new ConnectionFactory().obterConexao();
			}


			//Metodo para cadastrar um curso
			public void cadastrarVendas(VendasBean cb) {

				//Comando SQL
				String sql = "INSERT INTO pecasvendidas(pecasVendidas,idModelo) VALUES (?,?)";
		         
				
				//Tentar realizar o comando SQL
				try {

					//Enviando os parametros e executando
					PreparedStatement pstmt = this.conexao.prepareStatement(sql);
					pstmt.setInt(1, cb.getQuantidade());
					pstmt.setInt(2, cb.getIdModelo());
					pstmt.execute();


					//Fechar a conexão
					pstmt.close();

				} catch (Exception e) {

					//caso haja falhas
					JOptionPane.showMessageDialog(null, "Falha ao inserir dados");


				}


			}

			//Metodo para selecionar um curso
			public DefaultTableModel listarVendas() {

				//Criando defaulttablemodel
				DefaultTableModel modelo = new DefaultTableModel();

				//Definir as colunas do DefaultTableModel
				modelo.addColumn("Quantidade");
				modelo.addColumn("Id Peças");

				//COMANDO SQL
				String sql = "SELECT * FROM pecasvendidas";

				//Tentar realizar o comando SQL
				try {
					//Conectar e selecionar o comando SQL
					Statement stmt = conexao.createStatement();

					//Executando comando SQL e obtendo dados
					ResultSet rs = stmt.executeQuery(sql);

					//Listando cursos
					while(rs.next()) {
						modelo.addRow(new Object[]{
								rs.getInt("pecasVendidas"),
								rs.getInt("idModelo")
								
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

			public void ExcluirVendas(VendasBean cb) {

				//Comando SQL
				String sql = "DELETE FROM pecasvendidas WHERE pecasVendidas = ? AND idModelo = ? ";

				//Tentar realizar o comando SQL
				try {

					//Enviando os parametros e executando
					PreparedStatement pstmt = this.conexao.prepareStatement(sql);
					pstmt.setInt(1, cb.getQuantidade());
					pstmt.setInt(2, cb.getIdModelo());
					pstmt.execute();


					//Fechar a conexão
					pstmt.close();

				} catch (Exception e) {

					//caso haja falhas
					JOptionPane.showMessageDialog(null, "Falha ao excluir dados");


				}


			}
			public void AlterarVendas(VendasBean cb) {

				//Comando SQL
				String sql = "UPDATE pecasvendidas SET pecasVendidas = ? WHERE idModelo = ? ";
				
				//Tentar realizar o comando SQL
				try {

					//Enviando os parametros e executando
					PreparedStatement pstmt = this.conexao.prepareStatement(sql);	
					pstmt.setInt(1, cb.getQuantidade());
					pstmt.setInt(2, cb.getIdModelo());
					pstmt.execute();


					//Fechar a conexão
					pstmt.close();

				} catch (Exception e) {

					//caso haja falhas
					JOptionPane.showMessageDialog(null, "Falha ao alterar dados");


				}

			}
}
