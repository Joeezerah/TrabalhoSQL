package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.MarcasBean;
import bean.ModeloBean;
import dao.MarcasDao;
import dao.ModeloDao;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PecasView extends JFrame {

	private JPanel contentPane;
	private JTextField txtPecas;
	private JTable tblListarPecas;
	private JButton btnSair;

	public PecasView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 582, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPecas = new JLabel("Cadastrar - Pe\u00E7as");
		lblPecas.setBounds(10, 40, 138, 14);
		contentPane.add(lblPecas);
		
		txtPecas = new JTextField();
		txtPecas.setBounds(133, 37, 250, 20);
		contentPane.add(txtPecas);
		txtPecas.setColumns(10);
		
		JButton btnCadastar = new JButton("Cadastar");
		btnCadastar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModeloBean cb = new ModeloBean();
				cb.setModeloPeca(txtPecas.getText());
				
				//Executar envio dos dados
				ModeloDao cd = new ModeloDao();
				cd.cadastrarModelo(cb);
				
				//limpar os campos
				txtPecas.setText("");
				
				//cursos no campo nome curso
				txtPecas.requestFocus();
				tblListarPecas.setModel(cd.listarModelos());
				

			}
		});
		
		
		
		btnCadastar.setBounds(207, 68, 122, 23);
		contentPane.add(btnCadastar);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(42, 114, 463, 161);
		contentPane.add(scrollPane);
		
		tblListarPecas = new JTable();
		scrollPane.setViewportView(tblListarPecas);
	    ModeloDao cd = new ModeloDao();
		tblListarPecas.setModel(cd.listarModelos());
		
		tblListarPecas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int IdModelo = Integer.parseInt(String.valueOf((tblListarPecas.getValueAt(tblListarPecas.getSelectedRow(), 0))));
				String ModeloPeca = String.valueOf(tblListarPecas.getValueAt(tblListarPecas.getSelectedRow(), 1));
				
				 
				AlterarModeloView b = new AlterarModeloView(IdModelo , ModeloPeca);
				b.setVisible(true);
				dispose();
			  
			    
				
			}
		});
		
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainView mv = new MainView();
				mv.setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(450, 286, 89, 23);
		contentPane.add(btnSair);
		
		
	}

}
