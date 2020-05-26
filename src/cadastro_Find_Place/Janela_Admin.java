package cadastro_Find_Place;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Janela_Admin extends JFrame {

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/cadastro_Find_Place/iconeJanela.png")));
	}

	public static void main(String[] args) {
		Janela_Admin admin = new Janela_Admin();
	}

	// Definindo o que vai ser utilizado
	Container c;
	JPanel p1, p2, p3;
	ImageIcon img;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, anexada;
	JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t13;
	JTextArea t12;
	JButton sair, salvar, exibir, anexar;

	// Credenciais do Banco de Dados
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/findplacedb";
	static final String USER = "root";
	static final String PASS = "root";
	String s;

	Janela_Admin() {
		// Criando a Janela
		c = getContentPane();

		// Criando Painel 1
		p1 = new JPanel();
		p1.setBackground(new Color(1, 209, 113));
		p1.setBounds(0, -5, 1200, 85);
		img = new ImageIcon(getClass().getResource("header.jpg"));
		l1 = new JLabel(img);

		// Criando Painel 2
		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBackground(new Color(11, 188, 107));
		p2.setBounds(0, 80, 1200, 40);
		JLabel label1 = new JLabel("Preencha as Informações:");
		label1.setFont(new Font("Arial", Font.BOLD, 20));
		label1.setForeground(Color.white);
		p2.add(label1);
		label1.setBounds(20, -5, 300, 50);

		exibir = new JButton("Listar");
		exibir.setBounds(760, 0, 100, 40);
		exibir.setBackground(new Color(230, 233, 238));
		exibir.setIcon(new ImageIcon(getClass().getResource("/cadastro_Find_Place/menu-5.png")));
		p2.add(exibir);

		salvar = new JButton("Salvar");
		salvar.setBounds(865, 0, 100, 40);
		salvar.setBackground(new Color(230, 233, 238));
		salvar.setIcon(new ImageIcon(getClass().getResource("/cadastro_Find_Place/upload-2.png")));
		p2.add(salvar);

		sair = new JButton("SAIR");
		sair.setBounds(970, 0, 90, 40);
		sair.setBackground(new Color(230, 233, 238));
		sair.setIcon(new ImageIcon(getClass().getResource("/cadastro_Find_Place/logout-1.png")));
		p2.add(sair);

		// Criando Painel 3
		p3 = new JPanel();
		p3.setLayout(null);
		p3.setBackground(new Color(1, 209, 113));
		p3.setBounds(0, 80, 1200, 400);

		l2 = new JLabel("ID:");
		l2.setBounds(20, 160, 80, 30);
		t1 = new JTextField(50);
		t1.setEditable(false);
		t1.setBounds(90, 160, 150, 30);
		t1.setText("Gerado Automaticamente");
		t1.setFont(new Font("Arial", Font.BOLD, 12));

		l3 = new JLabel("Razão Social:");
		l3.setBounds(250, 160, 130, 30);
		t2 = new JTextField(50);
		t2.requestFocus();
		t2.setBounds(350, 160, 150, 30);

		l4 = new JLabel("Nome Fantasia:");
		l4.setBounds(530, 160, 130, 30);
		t3 = new JTextField(50);
		t3.setBounds(630, 160, 150, 30);

		l5 = new JLabel("Endereço:");
		l5.setBounds(20, 220, 80, 30);
		t4 = new JTextField(50);
		t4.setBounds(90, 220, 150, 30);

		l6 = new JLabel("Complemento:");
		l6.setBounds(250, 220, 130, 30);
		t5 = new JTextField(50);
		t5.setBounds(350, 220, 150, 30);

		l7 = new JLabel("Número:");
		l7.setBounds(530, 220, 130, 30);
		t6 = new JTextField(50);
		t6.setBounds(630, 220, 150, 30);

		l8 = new JLabel("Bairro:");
		l8.setBounds(20, 280, 80, 30);
		t7 = new JTextField(50);
		t7.setBounds(90, 280, 150, 30);

		l9 = new JLabel("Telefone:");
		l9.setBounds(250, 280, 130, 30);
		t8 = new JTextField(50);
		t8.setBounds(350, 280, 150, 30);

		l10 = new JLabel("Email:");
		l10.setBounds(530, 280, 130, 30);
		t9 = new JTextField(50);
		t9.setBounds(630, 280, 150, 30);

		l11 = new JLabel("Cidade:");
		l11.setBounds(20, 340, 130, 30);
		t10 = new JTextField(50);
		t10.setBounds(90, 340, 150, 30);

		l12 = new JLabel("Estado (UF):");
		l12.setBounds(250, 340, 130, 30);
		t11 = new JTextField(50);
		t11.setBounds(350, 340, 150, 30);

		l13 = new JLabel("Descrição da Atividade:");
		l13.setBounds(20, 400, 150, 30);
		t12 = new JTextArea(5, 20);
		t12.setBounds(200, 400, 580, 90);

		l14 = new JLabel("CPF/CNPJ:");
		l14.setBounds(530, 340, 130, 30);
		t13 = new JTextField(50);
		t13.setBounds(630, 340, 150, 30);

		// Criando Botão Para Anexar Imagem
		anexar = new JButton("Procurar Imagem");
		anexar.setBounds(820, 420, 200, 40);
		anexar.setIcon(new ImageIcon(getClass().getResource("/cadastro_Find_Place/search.png")));
		p3.add(anexar);

		// Criando um label para exibir a imagem após a inserção
		anexada = new JLabel("Imagem Aqui");
		anexada.setBounds(860, 170, 200, 200);
		anexada.setFont(new Font("Arial", Font.BOLD, 20));
		anexada.setForeground(Color.BLACK);
		p3.add(anexada);

		// Criando metodo para inserção de imagem
		anexar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {

				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image", "jpg", "JPG", "JPEG", "png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {

					File selectedFile = file.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					anexada.setIcon(ResizeImage(path));
					s = path;
				} else if (result == JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "Imagem Não Selecionada");
				}
			}
		});

		// Adicionando os Componentes aos Respectivos Paineis
		p1.add(l1);
		p3.add(l2);
		p3.add(t1);
		p3.add(l3);
		p3.add(t2);
		p3.add(l4);
		p3.add(t3);
		p3.add(l5);
		p3.add(t4);
		p3.add(l6);
		p3.add(t5);
		p3.add(l7);
		p3.add(t6);
		p3.add(l8);
		p3.add(t7);
		p3.add(l9);
		p3.add(t8);
		p3.add(l10);
		p3.add(t9);
		p3.add(l11);
		p3.add(t10);
		p3.add(l12);
		p3.add(t11);
		p3.add(l13);
		p3.add(t12);
		p3.add(l14);
		p3.add(t13);

		// Adicionando os Paineis ao Container
		c.add(p1);
		c.add(p2);
		c.add(p3);

		// Configurando caracteristicas da Janela
		setSize(1070, 550);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setTitle("Tela de Cadastro - FindPlace");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		sair();
		listar();
		salvar();
		setIcon();

	}

	// Função para Redimensionamento da Imagem
	public ImageIcon ResizeImage(String Imagepath) {

		ImageIcon myImage = new ImageIcon(Imagepath);
		Image img = myImage.getImage();
		Image newImage = img.getScaledInstance(anexada.getWidth(), anexada.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon Image = new ImageIcon(newImage);
		return Image;
	}

	// Função De LogOut
	public void sair() {
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Login r = new Tela_Login();
				r.setVisible(true);
				dispose();

			}
		});
	}

	// Função Para Listar
	public void listar() {
		exibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela_Tabela ad = new Janela_Tabela();
				ad.setVisible(true);
				dispose();
			}
		});
	}

	// Função para Salvar o Registro
	public void salvar() {
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;

				String s2 = t2.getText();
				String s3 = t3.getText();
				String s4 = t4.getText();
				String s5 = t5.getText();
				String s6 = t6.getText();
				String s7 = t7.getText();
				String s8 = t8.getText();
				String s9 = t9.getText();
				String s10 = t10.getText();
				String s11 = t11.getText();
				String s12 = t12.getText();
				String s13 = t13.getText();

				// Definindo quais campos nao podem estar vazios no momento do preenchimento
				if (t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("")
						|| t6.getText().equals("") || t7.getText().equals("") || t8.getText().equals("")
						|| t9.getText().equals("") || t10.getText().equals("") || t11.getText().equals("")
						|| t12.getText().equals("") || t13.getText().equals("")) {

					JOptionPane.showMessageDialog(salvar, "Todos os campos devem estar preenchidos");
				} else {
					// Se todos os Campos estiverem preenchidos, os Dados Serão Salvos
					try {
						Class.forName("com.mysql.jdbc.Driver");
						conn = DriverManager.getConnection(DB_URL, USER, PASS);
						JOptionPane.showConfirmDialog(null, "Salvar os Dados?", "Salvar", JOptionPane.YES_NO_OPTION);
						PreparedStatement ps = conn.prepareStatement(
								"INSERT INTO informacoes(razaosocial,nomefantasia,endereco,complemento,"
										+ "numero,bairro,telefone,email,cidade," + "estado,descicao,cpf_cnpj,imagem)"
										+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
						InputStream is = new FileInputStream(new File(s));
						ps.setString(1, s2);
						ps.setString(2, s3);
						ps.setString(3, s4);
						ps.setString(4, s5);
						ps.setString(5, s6);
						ps.setString(6, s7);
						ps.setString(7, s8);
						ps.setString(8, s9);
						ps.setString(9, s10);
						ps.setString(10, s11);
						ps.setString(11, s12);
						ps.setString(12, s13);
						ps.setBlob(13, is);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Cadastro Concluido Com Sucesso");
						
						// Setando todos os Campos em Branco após o Cadastro ser Concluido
						t2.setText("");
						t3.setText("");
						t4.setText("");
						t5.setText("");
						t6.setText("");
						t7.setText("");
						t8.setText("");
						t9.setText("");
						t10.setText("");
						t11.setText("");
						t12.setText("");
						t13.setText("");
						

					} catch (SQLException se) {
						se.printStackTrace();

					} catch (Exception ek) {
						ek.printStackTrace();
					} finally {
						try {
							if (stmt != null) {
								conn.close();
							}
						} catch (SQLException se) {
						}
						try {
							if (conn != null) {
								conn.close();
							}
						} catch (SQLException se) {
							se.printStackTrace();
						}
					}
				}
			}
		});
	}
}
