package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.ProdutosBean;
import dao.ProdutosDao;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarProdutoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCurso2;
	private JTextField txtValorCurso2;
	private JTextField txtMarca;


	public AlterarProdutoView(int IdProduto , String NomeProduto , int IdMarca, Double ValorProduto) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 393, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeCurso = new JLabel("Nome Produto");
		lblNomeCurso.setBounds(10, 22, 86, 14);
		contentPane.add(lblNomeCurso);
		
		txtNomeCurso2 = new JTextField(NomeProduto);
		txtNomeCurso2.setBounds(89, 19, 145, 20);
		contentPane.add(txtNomeCurso2);
		txtNomeCurso2.setColumns(10);
		
		JLabel lblIDMarca = new JLabel("IDMarca");
		lblIDMarca.setBounds(10, 47, 73, 14);
		contentPane.add(lblIDMarca);
		
		txtMarca = new JTextField(String.valueOf(IdMarca));
		txtMarca.setBounds(89, 44, 145, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblValorCurso = new JLabel("Valor Produto");
		lblValorCurso.setBounds(10, 72, 86, 14);
		contentPane.add(lblValorCurso);
		
		txtValorCurso2 = new JTextField(String.valueOf(ValorProduto));
		txtValorCurso2.setBounds(89, 69, 145, 20);
		contentPane.add(txtValorCurso2);
		txtValorCurso2.setColumns(10);
		
	
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAtualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				ProdutosBean cb = new ProdutosBean();
				cb.setIdProduto(IdProduto);
				cb.setNomeProduto(txtNomeCurso2.getText());
				cb.setIdMarca(Integer.parseInt(txtMarca.getText()));
				cb.setValor(Double.parseDouble(txtValorCurso2.getText()));
				ProdutosDao cd = new ProdutosDao();
				cd.AlterarCursos(cb);
				dispose();
				ProdutoView cv = new ProdutoView();
				cv.setVisible(true);
				
				
				//limpar os campos
				
				txtNomeCurso2.setText("");
				txtValorCurso2.setText("");
				
				//cursos no campo nome curso
				txtNomeCurso2.requestFocus();
				
				
				
			}
		});
		btnAtualizar.setBounds(10, 148, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ProdutosBean cb = new ProdutosBean();
				cb.setNomeProduto(txtNomeCurso2.getText());
				cb.setValor(Double.parseDouble(txtValorCurso2.getText()));
				cb.setIdMarca(Integer.parseInt(txtMarca.getText()));
				ProdutosDao cd = new ProdutosDao();
				cd.ExcluirCursos(cb);
				dispose();
				ProdutoView cv = new ProdutoView();
				cv.setVisible(true);
				
				
				//limpar os campos
				
				txtNomeCurso2.setText("");
				txtValorCurso2.setText("");
				
				//cursos no campo nome curso
				txtNomeCurso2.requestFocus();

			}
		});
		btnExcluir.setBounds(133, 148, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ProdutoView cv = new ProdutoView();
				cv.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(252, 148, 89, 23);
		contentPane.add(btnVoltar);
		

	}
}
