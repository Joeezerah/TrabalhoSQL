package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.ModeloBean;
import bean.ProdutosBean;
import bean.VendasBean;
import dao.ModeloDao;
import dao.ProdutosDao;
import dao.VendasDao;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VendasView extends JFrame {

	private JPanel contentPane;
	private JTable tblListarVendas;
	private JTextField txtVenda;
	private JTextField txtModelo;


	public VendasView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 581, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(30, 150, 422, 196);
		contentPane.add(scrollPane);
		
		tblListarVendas = new JTable();
		scrollPane.setViewportView(tblListarVendas);
	    VendasDao cd = new VendasDao();
	    tblListarVendas.setModel(cd.listarVendas());
        tblListarVendas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Quantidade = Integer.parseInt(String.valueOf((tblListarVendas.getValueAt(tblListarVendas.getSelectedRow(), 0))));
				int IdModelo = Integer.parseInt(String.valueOf((tblListarVendas.getValueAt(tblListarVendas.getSelectedRow(), 1))));
				
				 
				AlterarVendaView av = new AlterarVendaView(Quantidade, IdModelo);
				av.setVisible(true);
				dispose();
				
			}
		});
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainView mv = new MainView();
				mv.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(462, 323, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNovaVenda = new JLabel("Quantidade Vendida");
		lblNovaVenda.setBounds(30, 22, 127, 14);
		contentPane.add(lblNovaVenda);
		
		txtVenda = new JTextField();
		txtVenda.setBounds(167, 19, 153, 20);
		contentPane.add(txtVenda);
		txtVenda.setColumns(10);
		
		JLabel lblModelo = new JLabel("ID Modelo");
		lblModelo.setHorizontalAlignment(SwingConstants.LEFT);
		lblModelo.setBounds(30, 53, 81, 14);
		contentPane.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(167, 50, 153, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Obter dados informado
				//String nomeCurso = txtNomeCurso.getText();
				//double valorCurso = Double.parseDouble(txtValorCurso.getText());
				VendasBean cb = new VendasBean();
				cb.setQuantidade(Integer.parseInt((txtVenda.getText())));
				cb.setIdModelo(Integer.parseInt(txtModelo.getText()));
			
				
				//Executar envio dos dados
				VendasDao cd = new VendasDao();
				cd.cadastrarVendas(cb);
				
				//limpar os campos
				txtVenda.setText("");
				txtModelo.setText("");
				
				//cursos no campo nome curso
				txtVenda.requestFocus();
			tblListarVendas.setModel(cd.listarVendas());
			}
		});
		btnCadastrar.setBounds(196, 81, 113, 23);
		contentPane.add(btnCadastrar);
	}

}
