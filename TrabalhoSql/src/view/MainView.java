package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MainView extends JFrame {

	private JPanel contentPane;


	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMarca = new JButton("");
		btnMarca.setIcon(new ImageIcon(MainView.class.getResource("/imagem/if_car-front-02_1988880.png")));
		btnMarca.setToolTipText("Marcas");
		btnMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MarcasView mv = new MarcasView();
				mv.setVisible(true);
				dispose();
			}
		});
		btnMarca.setBounds(10, 68, 89, 53);
		contentPane.add(btnMarca);
		
		JButton btnModelo = new JButton("");
		btnModelo.setToolTipText("Pe\u00E7as");
		btnModelo.setIcon(new ImageIcon(MainView.class.getResource("/imagem/if_package_utilities_15685.png")));
		btnModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PecasView pc = new PecasView();
				pc.setVisible(true);
				dispose();
			}
		});
		btnModelo.setBounds(10, 124, 89, 53);
		contentPane.add(btnModelo);
		
		JButton btnProduto = new JButton("");
		btnProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProdutoView cv = new ProdutoView();
				cv.setVisible(true);
			}
		});
		btnProduto.setIcon(new ImageIcon(MainView.class.getResource("/imagem/if_Working_Tools_2_753919.png")));
		btnProduto.setToolTipText("Produtos");
		btnProduto.setBounds(10, 11, 89, 53);
		contentPane.add(btnProduto);
		
		JButton btnVenda = new JButton("");
		btnVenda.setToolTipText("Vendas");
		btnVenda.setIcon(new ImageIcon(MainView.class.getResource("/imagem/if_cart-plus_1608607.png")));
		btnVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendasView vv = new  VendasView();
				vv.setVisible(true);
				dispose();
			}
		});
		btnVenda.setBounds(10, 181, 89, 53);
		contentPane.add(btnVenda);
		
		JButton btnEstoque = new JButton("");
		btnEstoque.setIcon(new ImageIcon(MainView.class.getResource("/imagem/if_warehouse_103222.png")));
		btnEstoque.setToolTipText("Estoque");
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstoqueView ev = new EstoqueView();
				ev.setVisible(true);
				dispose();
			}
		});
		btnEstoque.setBounds(10, 238, 89, 53);
		contentPane.add(btnEstoque);
		
		JButton btnSair = new JButton("");
		btnSair.setToolTipText("Sair");
		btnSair.setIcon(new ImageIcon(MainView.class.getResource("/imagem/if_on-off_42283.png")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(10, 292, 89, 53);
		contentPane.add(btnSair);
	}
}
