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
import javax.print.DocFlavor.STRING;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProdutoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCurso;
	private JTextField txtValorCurso;
	private JTable tblListarCursos;
	private JScrollPane scrollPane;
	private JTextField txtMarca;
	private JLabel lblMarca;


	/**
	 * Create the frame.
	 */
	public ProdutoView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 568, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblValorDoProduto = new JLabel("Valor Produto");
		lblValorDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorDoProduto.setBounds(31, 102, 97, 14);
		contentPane.add(lblValorDoProduto);
		
		JLabel lblNomeProduto = new JLabel("Nome do produto");
		lblNomeProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeProduto.setBounds(31, 40, 147, 14);
		contentPane.add(lblNomeProduto);
		
		lblMarca = new JLabel("IDMarca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMarca.setBounds(31, 77, 110, 14);
		contentPane.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(167, 70, 168, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtNomeCurso = new JTextField();
		txtNomeCurso.setBounds(167, 39, 168, 20);
		contentPane.add(txtNomeCurso);
		txtNomeCurso.setColumns(10);
		
		txtValorCurso = new JTextField();
		txtValorCurso.setBounds(167, 101, 166, 20);
		contentPane.add(txtValorCurso);
		txtValorCurso.setColumns(10);
		
		JButton btnCadastrarCurso = new JButton("Cadastrar");
		btnCadastrarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Obter dados informado
				//String nomeCurso = txtNomeCurso.getText();
				//double valorCurso = Double.parseDouble(txtValorCurso.getText());
				ProdutosBean cb = new ProdutosBean();
				cb.setNomeProduto(txtNomeCurso.getText());
				cb.setIdMarca(Integer.parseInt(txtMarca.getText()));
				cb.setValor(Double.parseDouble(txtValorCurso.getText()));
				
				//Executar envio dos dados
				ProdutosDao cd = new ProdutosDao();
				cd.cadastrarCurso(cb);
				
				//limpar os campos
				txtNomeCurso.setText("");
				txtValorCurso.setText("");
				txtMarca.setText("");
				
				//cursos no campo nome curso
				txtNomeCurso.requestFocus();
				tblListarCursos.setModel(cd.listarCursos());
			}
		});
		btnCadastrarCurso.setBounds(148, 147, 128, 23);
		contentPane.add(btnCadastrarCurso);
		
		//Objeto da classe ProdutosDao
		ProdutosDao cd = new ProdutosDao();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 203, 445, 155);
		contentPane.add(scrollPane);
		
		tblListarCursos = new JTable();
		tblListarCursos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int IdProduto = Integer.parseInt(String.valueOf((tblListarCursos.getValueAt(tblListarCursos.getSelectedRow(), 0))));
				String NomeProduto = String.valueOf(tblListarCursos.getValueAt(tblListarCursos.getSelectedRow(), 1));
				int IdMarca = Integer.parseInt(String.valueOf((tblListarCursos.getValueAt(tblListarCursos.getSelectedRow(), 2))));
				Double Valor = Double.parseDouble(String.valueOf((tblListarCursos.getValueAt(tblListarCursos.getSelectedRow(), 3))));
				AlterarProdutoView a = new AlterarProdutoView(IdProduto, NomeProduto,IdMarca ,Valor);
				a.setVisible(true);
			    dispose();
			    
			}
		});
		scrollPane.setViewportView(tblListarCursos);
		tblListarCursos.setModel(cd.listarCursos());
		

	}
}
