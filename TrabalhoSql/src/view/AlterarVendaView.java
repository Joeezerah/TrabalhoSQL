package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.ProdutosBean;
import bean.VendasBean;
import dao.ProdutosDao;
import dao.VendasDao;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarVendaView extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuantidade;
	private JTextField txtModelo;



	
	public AlterarVendaView(int Quantidade ,int idModelo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQuantidade = new JLabel(String.valueOf("Quantidade"));
		lblQuantidade.setBounds(10, 23, 92, 14);
		contentPane.add(lblQuantidade);
		
		txtQuantidade = new JTextField(String.valueOf(Quantidade));
		txtQuantidade.setBounds(111, 20, 147, 20);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblModelo = new JLabel("Id Modelo");
		lblModelo.setBounds(10, 55, 92, 14);
		contentPane.add(lblModelo);
		
		txtModelo = new JTextField(String.valueOf(idModelo));
		txtModelo.setBounds(110, 52, 148, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VendasBean cb = new VendasBean();
				cb.setQuantidade(Integer.parseInt((txtQuantidade.getText())));
				cb.setIdModelo(Integer.parseInt((txtModelo.getText())));
				VendasDao cd = new VendasDao();
				cd.AlterarVendas(cb);
				dispose();
				VendasView vv = new VendasView();
				vv.setVisible(true);
				
				
				//limpar os campos
				
				txtQuantidade.setText("");
				txtModelo.setText("");
				
				//cursos no campo nome curso
				txtQuantidade.requestFocus();
				
			}
		});
		btnAlterar.setBounds(10, 134, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VendasBean cb = new VendasBean();
				cb.setQuantidade(Integer.parseInt((txtQuantidade.getText())));
				cb.setIdModelo(Integer.parseInt((txtModelo.getText())));
				VendasDao cd = new VendasDao();
				cd.ExcluirVendas(cb);
				dispose();
				VendasView vv = new VendasView();
				vv.setVisible(true);
				
				
				//limpar os campos
				
				txtQuantidade.setText("");
				txtModelo.setText("");
				
				//cursos no campo nome curso
				txtQuantidade.requestFocus();
			}
		});
		btnExcluir.setBounds(140, 134, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendasView vv = new VendasView();
				vv.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(268, 134, 89, 23);
		contentPane.add(btnVoltar);
	}

}
