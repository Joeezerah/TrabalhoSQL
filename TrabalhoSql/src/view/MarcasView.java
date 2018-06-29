package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.MarcasBean;
import bean.ProdutosBean;
import dao.MarcasDao;
import dao.ProdutosDao;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MarcasView extends JFrame {

	private JPanel contentPane;
	private JTextField txtMarca;
	private JButton btnSair;
	private JTable tblListarMarcas;


	public MarcasView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 590, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMarca = new JLabel("Adcionar - Marca");
		lblMarca.setBounds(21, 38, 118, 14);
		contentPane.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(149, 35, 285, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			MarcasBean cb = new MarcasBean();
			cb.setNomeMarca(txtMarca.getText());
			
			//Executar envio dos dados
			MarcasDao cd = new MarcasDao();
			cd.cadastrarMarcas(cb);
			
			//limpar os campos
			txtMarca.setText("");
			
			//cursos no campo nome curso
			txtMarca.requestFocus();
			tblListarMarcas.setModel(cd.listarMarcas());
			}
		});
		btnCadastrar.setBounds(213, 79, 113, 23);
		contentPane.add(btnCadastrar);
		
		
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainView mv = new MainView();
				mv.setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(445, 317, 89, 23);
		contentPane.add(btnSair);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 142, 463, 164);
		contentPane.add(scrollPane);
		
		tblListarMarcas = new JTable();
		scrollPane.setViewportView(tblListarMarcas);
		MarcasDao cd = new MarcasDao();
		tblListarMarcas.setModel(cd.listarMarcas());
		tblListarMarcas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int IdMarca = Integer.parseInt(String.valueOf((tblListarMarcas.getValueAt(tblListarMarcas.getSelectedRow(), 0))));
				String NomeMarca = String.valueOf(tblListarMarcas.getValueAt(tblListarMarcas.getSelectedRow(), 1));
				
				AlterarMarcaView b = new AlterarMarcaView(IdMarca , NomeMarca);
				b.setVisible(true);
			    dispose();
				
			}
		});

	}
}
