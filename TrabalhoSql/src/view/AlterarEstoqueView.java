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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarEstoqueView extends JFrame {

	private JPanel contentPane;
	private JTextField txtIDModelo;
	private JTextField txtTotal;

	public AlterarEstoqueView(int IdModelo , int Total) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdModelo = new JLabel("Id Modelo");
		lblIdModelo.setBounds(24, 33, 103, 14);
		contentPane.add(lblIdModelo);
		
		txtIDModelo = new JTextField(String.valueOf(IdModelo));
		txtIDModelo.setBounds(123, 30, 141, 20);
		contentPane.add(txtIDModelo);
		txtIDModelo.setColumns(10);
		
		JLabel lblTotalDePeas = new JLabel("Total De Pe\u00E7as");
		lblTotalDePeas.setBounds(24, 70, 91, 14);
		contentPane.add(lblTotalDePeas);
		
		txtTotal = new JTextField(String.valueOf(Total));
		txtTotal.setBounds(123, 67, 141, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstoquesBean cb = new EstoquesBean();
				cb.setIdModelo(Integer.parseInt((txtIDModelo.getText())));
				cb.setTotal(Integer.parseInt((txtTotal.getText())));
				EstoquesDao ed = new EstoquesDao();
				ed.AlterarEstoque(cb);
				dispose();
				EstoqueView ev = new EstoqueView();
				ev.setVisible(true);
				
				
				//limpar os campos
				
				txtIDModelo.setText("");
				txtTotal.setText("");
				
				//cursos no campo nome curso
				txtIDModelo.requestFocus();
				
			}
		});
		btnAlterar.setBounds(26, 151, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EstoquesBean cb = new EstoquesBean();
				cb.setIdModelo(Integer.parseInt((txtIDModelo.getText())));
				cb.setTotal(Integer.parseInt((txtTotal.getText())));
				EstoquesDao ed = new EstoquesDao();
				ed.ExcluirEstoques(cb);
				dispose();
				EstoqueView ev = new EstoqueView();
				ev.setVisible(true);
				
				//limpar os campos
				
				txtIDModelo.setText("");
				txtTotal.setText("");
				
				//cursos no campo nome curso
				txtIDModelo.requestFocus();
				
			}
		});
		btnExcluir.setBounds(175, 151, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstoqueView ev = new EstoqueView();
				ev.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(302, 151, 89, 23);
		contentPane.add(btnVoltar);
		
		
	}

}
