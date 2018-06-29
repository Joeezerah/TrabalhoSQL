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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarMarcaView extends JFrame {

	private JPanel contentPane;
	private JTextField txtMarca;


	public AlterarMarcaView(int idMarca,String NomeMarca) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeMarca = new JLabel("Nome Marca");
		lblNomeMarca.setBounds(23, 35, 100, 14);
		contentPane.add(lblNomeMarca);
		
		txtMarca = new JTextField(NomeMarca);
		txtMarca.setBounds(115, 32, 194, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		JButton btnAlterarNomeMarca = new JButton("Alterar Nome Marca");
		btnAlterarNomeMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    MarcasBean cb = new MarcasBean();
				cb.setIdMarca(idMarca);
				cb.setNomeMarca(txtMarca.getText());
				MarcasDao cd = new MarcasDao();
				cd.AlterarMarcas(cb);
				dispose();
				MarcasView cv = new MarcasView();
				cv.setVisible(true);
				
				
				//limpar os campos
				
				txtMarca.setText("");
				
				
				//cursos no campo nome curso
				txtMarca.requestFocus();
				
			}
		});
		btnAlterarNomeMarca.setBounds(10, 93, 173, 23);
		contentPane.add(btnAlterarNomeMarca);
		
		JButton btnNewButton = new JButton("Excluir Nome Marca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MarcasBean cb = new MarcasBean();
				cb.setNomeMarca(txtMarca.getText());
				MarcasDao cd = new MarcasDao();
				cd.ExcluirMarcas(cb);
				dispose();
				MarcasView cv = new MarcasView();
				cv.setVisible(true);
				
				
				//limpar os campos
				txtMarca.setText("");
				
				
				//cursos no campo nome curso
				txtMarca.requestFocus();

			}
		});
		btnNewButton.setBounds(10, 121, 173, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MarcasView mv = new MarcasView();
				mv.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 151, 173, 23);
		contentPane.add(btnNewButton_1);
	}
}
