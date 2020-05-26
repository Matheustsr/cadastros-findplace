package cadastro_Find_Place;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Janela_Tabela extends JFrame {

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	// Definindo o que vai ser utilizado
	JButton jButton1, jButton2, jButton3, jButton4;
	JLabel jLabel1;
	JPanel jPanel1, jPanel2;
	JScrollPane jScrollPane1;
	JTable jTable1;
	JTextField jTextField1;
	Label label1, label2;
	Panel panel1;

	// Metodo Para Implementação do Icone FindPlace na Janela
	public static void main1(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					iconeJanela frame = new iconeJanela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void setIcon() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconeJanela.png")));
	}

	// Configurando caracteristicas da Janela
	public Janela_Tabela() {
		initComponents();
		conn = dbconnect.java_db();
		setSize(1200, 690);
		setIcon();
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Listagem de Clientes - FindPlace");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Update_table3();

	}

	// Metodo de busca dos Cadastros do Banco de Dados
	private void Update_table3() {
		try {

			String sql = "select * from informacoes";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			jTable1.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {

			try {
				rs.close();
				pst.close();

			} catch (Exception e) {

			}
		}
	}

	// Iniciando os Componentes
	private void initComponents() {

		panel1 = new Panel();
		label1 = new Label();
		label2 = new Label();
		jButton4 = new JButton();
		jPanel1 = new JPanel();
		jLabel1 = new JLabel();
		jTextField1 = new JTextField();
		jButton1 = new JButton();
		jButton2 = new JButton();
		jButton3 = new JButton();
		jPanel2 = new JPanel();
		jScrollPane1 = new JScrollPane();
		jTable1 = new JTable();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Criando e Customizando o Layout da Janela
		panel1.setBackground(new Color(11, 188, 107));

		label1.setText("label1");

		label2.setText("label2");

		jButton4.setIcon(new ImageIcon(getClass().getResource("/cadastro_Find_Place/header.jpg")));
		jButton4.setBorderPainted(false);
		jButton4.setContentAreaFilled(false);
		jButton4.setDefaultCapable(false);
		jButton4.setFocusPainted(false);
		jButton4.setFocusable(false);
		jButton4.setHideActionText(true);
		jButton4.setRequestFocusEnabled(false);
		jButton4.setRolloverEnabled(false);
		jButton4.setVerifyInputWhenFocusTarget(false);
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		GroupLayout panel1Layout = new GroupLayout(panel1);
		panel1.setLayout(panel1Layout);
		panel1Layout.setHorizontalGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 1212, GroupLayout.PREFERRED_SIZE));
		panel1Layout.setVerticalGroup(
				panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
						panel1Layout.createSequentialGroup().addComponent(jButton4).addGap(0, 0, Short.MAX_VALUE)));

		jPanel1.setBackground(new Color(11, 188, 107));

		jLabel1.setBounds(5, 50, 20, 20);
		jLabel1.setFont(new Font("Arial", 1, 14));
		jLabel1.setText("Procurar Cliente por ID:");
		jLabel1.setForeground(Color.white);

		// Criando os Eventos da Barra de Pesquisa
		jTextField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});
		jTextField1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				jTextField1KeyReleased(evt);
			}
		});

		// Criando os Botões
		jButton1.setBackground(new Color(230, 233, 238));
		jButton1.setFont(new Font("Arial", 1, 12));
		jButton1.setIcon(new ImageIcon(getClass().getResource("/cadastro_Find_Place/reply.png")));
		jButton1.setText("Voltar");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setBackground(new Color(230, 233, 238));
		jButton2.setFont(new Font("Arial", 1, 12));
		jButton2.setIcon(new ImageIcon(getClass().getResource("/cadastro_Find_Place/erase-128.png")));
		jButton2.setText("Limpar");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setBackground(new Color(230, 233, 238));
		jButton3.setFont(new Font("Arial", 1, 12));
		jButton3.setIcon(new ImageIcon(getClass().getResource("/cadastro_Find_Place/person-icon.png")));
		jButton3.setText("Mostrar Detalhes");
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		// Customizando o Group Layout
		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(51, 51, 51)
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(jButton3).addGap(27, 27, 27).addComponent(jButton2).addGap(18, 18, 18)
						.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addGap(53, 53, 53)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(2, 2, 2).addComponent(jButton2,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addGroup(GroupLayout.Alignment.TRAILING,
								jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(jButton3))
						.addComponent(jButton1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));

		jPanel2.setBackground(new Color(11, 188, 107));
		
		// Criando a JTable
		jTable1.setBackground(new Color(204, 255, 204));
		jTable1.setFont(new Font("Arial", 0, 14));
		jTable1.setModel(
				new DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jTable1.setIntercellSpacing(new Dimension(2, 5));
		jScrollPane1.setViewportView(jTable1);

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jScrollPane1));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGap(6, 6, 6)));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(jPanel2, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));

		pack();
	}

	private void jButton4ActionPerformed(ActionEvent evt) {

	}

	private void jButton3ActionPerformed(ActionEvent evt) {

		new Janela_Atualizacao().setVisible(true);
		dispose();

	}

	private void jButton1ActionPerformed(ActionEvent evt) {

		new Janela_Admin();
		dispose();
	}

	private void jTextField1ActionPerformed(ActionEvent evt) {

	}

	private void jTextField1KeyReleased(KeyEvent evt) {

		try {

			String sql = "select* from informacoes where id = ? ";

			pst = conn.prepareStatement(sql);
			pst.setString(1, jTextField1.getText());
			rs = pst.executeQuery();
			jTable1.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {

			try {

				rs.close();
				pst.close();

			} catch (Exception e) {

			}
		}

	}

	private void jButton2ActionPerformed(ActionEvent evt) {

		Update_table3();
		jTextField1.setText("");
	}

	public static void main(String args[]) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Janela_Tabela.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(Janela_Tabela.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(Janela_Tabela.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(Janela_Tabela.class.getName()).log(Level.SEVERE, null, ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Janela_Tabela().setVisible(true);
			}
		});
	}
}
