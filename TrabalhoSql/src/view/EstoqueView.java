package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.EstoquesBean;
import bean.VendasBean;
import dao.EstoquesDao;
import dao.VendasDao;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EstoqueView extends JFrame {

	private JPanel contentPane;
	private JTable tblEstoque;
	private JTextField txtModelo;
	private JTextField txtPecas;

	public EstoqueView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 567, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 124, 486, 178);
		contentPane.add(scrollPane);
		
		scrollPane.setBounds(21, 124, 486, 178);
		contentPane.add(scrollPane);
		
		tblEstoque = new JTable();
		scrollPane.setViewportView(tblEstoque);
		
		
		tblEstoque = new JTable();
		scrollPane.setViewportView(tblEstoque);
		EstoquesDao cd = new EstoquesDao();
	    tblEstoque.setModel(cd.listarEstoques());
		tblEstoque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int IdModelo = Integer.parseInt(String.valueOf((tblEstoque.getValueAt(tblEstoque.getSelectedRow(), 0))));
				int Total = Integer.parseInt(String.valueOf((tblEstoque.getValueAt(tblEstoque.getSelectedRow(), 1))));
				
				 
				AlterarEstoqueView ev = new AlterarEstoqueView(IdModelo, Total);
				ev.setVisible(true);
				dispose();
				
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainView mv = new MainView();
				mv.setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(438, 313, 89, 23);
		contentPane.add(btnSair);
		
		JLabel lblModelo = new JLabel("ID Modelo");
		lblModelo.setBounds(21, 22, 105, 14);
		contentPane.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(128, 19, 133, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total De Pe\u00E7as");
		lblTotal.setBounds(23, 61, 120, 14);
		contentPane.add(lblTotal);
		
		txtPecas = new JTextField();
		txtPecas.setBounds(128, 58, 133, 20);
		contentPane.add(txtPecas);
		txtPecas.setColumns(10);
		
		JButton btnCadastar = new JButton("Cadastrar");
		btnCadastar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Obter dados informado
				//String nomeCurso = txtNomeCurso.getText();
				//double valorCurso = Double.parseDouble(txtValorCurso.getText());
				EstoquesBean cb = new EstoquesBean();
				cb.setIdModelo(Integer.parseInt(txtModelo.getText()));
				cb.setTotal(Integer.parseInt((txtPecas.getText())));
			
				
				//Executar envio dos dados
				EstoquesDao cd = new EstoquesDao();
				cd.cadastrarEstoque(cb);
				
				//limpar os campos
				txtPecas.setText("");
				txtModelo.setText("");
				
				//cursos no campo nome curso
				txtModelo.requestFocus();
			tblEstoque.setModel(cd.listarEstoques());
				
			}
		});
		btnCadastar.setBounds(128, 90, 120, 23);
		contentPane.add(btnCadastar);
	}

}
