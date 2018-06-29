package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import bean.MarcasBean;
import connection.ConnectionFactory;


public class MarcasDao {
	
	


		//Atributos para obter a conexao
		private Connection conexao;

		//Construtor
		public MarcasDao() {
			//maneiras de se obter uma conexao
			//ConnectionFactory cf = new ConnectionFactory();
			//this.conexao = cf.obterConexao();

			this.conexao = new ConnectionFactory().obterConexao();
		}


		//Metodo para cadastrar um curso
		public void cadastrarMarcas(MarcasBean cb) {

			//Comando SQL
			String sql = "INSERT INTO marca(nomeMarca) VALUES (?)";
	         
			
			//Tentar realizar o comando SQL
			try {

				//Enviando os parametros e executando
				PreparedStatement pstmt = this.conexao.prepareStatement(sql);
				pstmt.setString(1, cb.getNomeMarca());
				
			
				pstmt.execute();


				//Fechar a conexão
				pstmt.close();

			} catch (Exception e) {

				//caso haja falhas
				JOptionPane.showMessageDialog(null, "Falha ao inserir dados");


			}


		}

		//Metodo para selecionar um curso
		public DefaultTableModel listarMarcas() {

			//Criando defaulttablemodel
			DefaultTableModel modelo = new DefaultTableModel();

			//Definir as colunas do DefaultTableModel
			modelo.addColumn("Código");
			modelo.addColumn("Nome Marca");

			//COMANDO SQL
			String sql = "SELECT * FROM marca";

			//Tentar realizar o comando SQL
			try {
				//Conectar e selecionar o comando SQL
				Statement stmt = conexao.createStatement();

				//Executando comando SQL e obtendo dados
				ResultSet rs = stmt.executeQuery(sql);

				//Listando cursos
				while(rs.next()) {
					modelo.addRow(new Object[]{
							rs.getInt("idMarca"),
							rs.getString("nomeMarca"),
							
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

		public void ExcluirMarcas(MarcasBean cb) {

			//Comando SQL
			String sql = "DELETE FROM marca WHERE nomeMarca = ? ";

			//Tentar realizar o comando SQL
			try {

				//Enviando os parametros e executando
				PreparedStatement pstmt = this.conexao.prepareStatement(sql);
				pstmt.setString(1, cb.getNomeMarca());
				pstmt.execute();


				//Fechar a conexão
				pstmt.close();

			} catch (Exception e) {

				//caso haja falhas
				JOptionPane.showMessageDialog(null, "Falha ao excluir dados");


			}


		}
		public void AlterarMarcas(MarcasBean cb) {

			//Comando SQL
			String sql = "UPDATE marca SET nomeMarca = ? WHERE idMarca = ? ";
			
			//Tentar realizar o comando SQL
			try {

				//Enviando os parametros e executando
				PreparedStatement pstmt = this.conexao.prepareStatement(sql);	
				pstmt.setString(1, cb.getNomeMarca());
				pstmt.setInt(2, cb.getIdMarca());
				pstmt.execute();


				//Fechar a conexão
				pstmt.close();

			} catch (Exception e) {

				//caso haja falhas
				JOptionPane.showMessageDialog(null, "Falha ao alterar dados");


			}

		}
	}



