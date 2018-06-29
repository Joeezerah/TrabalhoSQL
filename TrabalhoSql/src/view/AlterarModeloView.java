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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarModeloView extends JFrame {

	private JPanel contentPane;
	private JTextField txtModeloPeca;

	public AlterarModeloView(int IdModelo , String ModeloPeca) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeModelo = new JLabel("Modelo - Pe\u00E7a");
		lblNomeModelo.setBounds(10, 33, 109, 14);
		contentPane.add(lblNomeModelo);
		
		txtModeloPeca = new JTextField(ModeloPeca);
		txtModeloPeca.setBounds(100, 30, 306, 20);
		contentPane.add(txtModeloPeca);
		txtModeloPeca.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar ");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			    ModeloBean cb = new ModeloBean();
				cb.setIdModelo(IdModelo);
				cb.setModeloPeca(txtModeloPeca.getText());
				ModeloDao cd = new ModeloDao();
				cd.AlterarModelos(cb);
				dispose();
				PecasView pv = new PecasView();
				pv.setVisible(true);
				
				
				//limpar os campos
				
				txtModeloPeca.setText("");
				
				
				//cursos no campo nome curso
				txtModeloPeca.requestFocus();
			}
		});
		btnAlterar.setBounds(10, 160, 89, 23);
		contentPane.add(btnAlterar);
		
		 
		
		JButton btnExclui = new JButton("Excluir");
		btnExclui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ModeloBean cb = new ModeloBean();
				cb.setModeloPeca(txtModeloPeca.getText());
				ModeloDao cd = new ModeloDao();
				cd.ExcluirModelos(cb);
				dispose();
				PecasView cv = new PecasView();
				cv.setVisible(true);
				
				
				//limpar os campos
				txtModeloPeca.setText("");
				
				
				//cursos no campo nome curso
				txtModeloPeca.requestFocus();
				
			}
		});
		btnExclui.setBounds(158, 160, 89, 23);
		contentPane.add(btnExclui);
		
		
		
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PecasView pv = new PecasView();
				pv.setVisible(true);
				dispose();
				
			}
		});
		btnVoltar.setBounds(304, 160, 89, 23);
		contentPane.add(btnVoltar);
		
		
	}
}
