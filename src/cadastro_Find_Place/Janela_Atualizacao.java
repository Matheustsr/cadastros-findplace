package cadastro_Find_Place;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

public class Janela_Atualizacao extends JFrame {

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

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
		Janela_Atualizacao admin = new Janela_Atualizacao();
	}

	Container c;
	JPanel p1, p2, p3;
	ImageIcon img;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14;
	JTextField barraSearch, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t13;
	JTextArea t12;
	JButton sair, limpar, voltar, anexar, att, apagar;
	JLabel anexada;

	// Credenciais do Banco de Dados
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/findplacedb";
	static final String USER = "root";
	static final String PASS = "root";
	String s;

	Janela_Atualizacao() {
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
		JLabel label1 = new JLabel("Procurar Cliente por ID:");
		label1.setFont(new Font("Arial", Font.BOLD, 20));
		label1.setForeground(Color.white);
		p2.add(label1);
		label1.setBounds(20, -5, 300, 50);

		barraSearch = new JTextField();
		barraSearch.setBounds(250, 5, 100, 30);
		barraSearch.setFont(new Font("Arial", Font.PLAIN, 18));
		p2.add(barraSearch);

		barraSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				barraSearchActionPerformed(evt);
			}

			private void barraSearchActionPerformed(ActionEvent evt) {

			}
		});

		barraSearch.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				barraSearchKeyReleased(evt);
			}

			private void barraSearchKeyReleased(KeyEvent evt) {
				try {

					String sql = "select * from informacoes where id = ?";

					pst = conn.prepareStatement(sql);
					pst.setString(1, barraSearch.getText());
					rs = pst.executeQuery();
					while (rs.next()) {

						t1.setText(rs.getString("id"));
						t2.setText(rs.getString("razaosocial"));
						t3.setText(rs.getString("nomefantasia"));
						t4.setText(rs.getString("endereco"));
						t5.setText(rs.getString("complemento"));
						t6.setText(rs.getString("numero"));
						t7.setText(rs.getString("bairro"));
						t8.setText(rs.getString("telefone"));
						t9.setText(rs.getString("email"));
						t10.setText(rs.getString("cidade"));
						t11.setText(rs.getString("estado"));
						t12.setText(rs.getString("descricao"));
						t13.setText(rs.getString("cpf_cnpj"));
						byte[] img = rs.getBytes("imagem");
						ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage()
								.getScaledInstance(anexada.getWidth(), anexada.getHeight(), Image.SCALE_SMOOTH));
						anexada.setIcon(imageIcon);
					}
				} catch (Exception e) {
				} finally {
					try {
						rs.close();
						pst.close();
					} catch (Exception e) {

					}
				}
			}
		});

		voltar = new JButton("Voltar");
		voltar.setBounds(540, 0, 100, 40);
		voltar.setBackground(new Color(230, 233, 238));
		voltar.setIcon(new ImageIcon(getClass().getResource("/cadastro_Find_Place/reply.png")));
		p2.add(voltar);

		limpar = new JButton("Limpar");
		limpar.setBounds(645, 0, 100, 40);
		limpar.setBackground(new Color(230, 233, 238));
		limpar.setIcon(new ImageIcon(getClass().getResource("/cadastro_Find_Place/erase.png")));
		p2.add(limpar);

		apagar = new JButton("Apagar");
		apagar.setBounds(750, 0, 100, 40);
		apagar.setBackground(new Color(230, 233, 238));
		apagar.setIcon(new ImageIcon(getClass().getResource("/cadastro_Find_Place/delete-2.png")));
		p2.add(apagar);

		att = new JButton("Atualizar");
		att.setBounds(855, 0, 110, 40);
		att.setBackground(new Color(230, 233, 238));
		att.setIcon(new ImageIcon(getClass().getResource("/cadastro_Find_Place/refresh-2.png")));
		p2.add(att);

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
		t1.setBounds(90, 160, 150, 30);
		t1.setEditable(false);

		l3 = new JLabel("Razão Social:");
		l3.setBounds(250, 160, 130, 30);
		t2 = new JTextField(50);
		t2.setRequestFocusEnabled(true);
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

		anexar = new JButton("Procurar Imagem");
		anexar.setBounds(820, 420, 200, 40);
		anexar.setIcon(new ImageIcon(getClass().getResource("/cadastro_Find_Place/search.png")));
		p3.add(anexar);
		anexada = new JLabel("   Imagem Aqui");
		anexada.setBounds(840, 170, 200, 200);
		anexada.setFont(new Font("Arial", Font.BOLD, 20));
		anexada.setForeground(Color.BLACK);
		p3.add(anexada);

		// working on photo chosing
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

		c.add(p1);
		c.add(p2);
		c.add(p3);

		setSize(1070, 550);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setTitle("Tela de Atualização - FindPlace");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setIcon();
		back();
		limpar();
		logout();
		apagar();
		att();

	}

	public PreparedStatement getPst() {
		return pst;
	}

	public void setPst(PreparedStatement pst) {
		this.pst = pst;
	}

	private void limpar() {
		limpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				barraSearch.setText("");
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
				anexada.setIcon(null);
			}
		});

	}

	private void att() {
		att.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if (barraSearch.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Nenhum Cadastro Selecionado");
				} else {
					int k = JOptionPane.showConfirmDialog(null, "Atualizar Cadastro?", "Atualizar",
							JOptionPane.YES_NO_OPTION);
					if (k == 0) {
						try {
							String value0 = t1.getText();
							String value1 = t2.getText();
							String value2 = t3.getText();
							String value3 = t4.getText();
							String value4 = t5.getText();
							String value5 = t6.getText();
							String value6 = t7.getText();
							String value7 = t8.getText();
							String value8 = t9.getText();
							String value9 = t10.getText();
							String value10 = t11.getText();
							String value11 = t12.getText();
							String value12 = t13.getText();

							String sql = "att informacoes set razaosocial='" + value1 + "',nomefantasia='" + value2
									+ "', " + "endereco='" + value3 + "',complemento='" + value4 + "',numero='" + value5
									+ "',bairro='" + value6 + "',telefone= '" + value7 + "', " + "email='" + value8
									+ "',cidade ='" + value9 + "',estado='" + value10 + "',descricao='" + value11
									+ "',cpf_cnpj='" + value12 + "" + "where id='" + value0 + "' ";

							pst = conn.prepareStatement(sql);
							pst.execute();
							JOptionPane.showConfirmDialog(null, "Cadastro Atualizado Com Sucesso");
						} catch (Exception e) {
							JOptionPane.showConfirmDialog(null, e);
						} finally {
							try {
								rs.close();
								pst.close();
							} catch (Exception e) {

							}
						}

					}
				}

			}
		});

	}

	// image choose
	private ImageIcon ResizeImage(String Imagepath) {

		ImageIcon myImage = new ImageIcon(Imagepath);
		Image img = myImage.getImage();
		Image newImage = img.getScaledInstance(anexada.getWidth(), anexada.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon Image = new ImageIcon(newImage);
		return Image;
	}

	// end image choose
	private void logout() {
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Tela_Login s = new Tela_Login();
				s.setVisible(true);
				dispose();
			}
		});
	}

	private void back() {
		voltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				Janela_Tabela b = new Janela_Tabela();
				b.setVisible(true);
				dispose();
			}
		});
	}

	private void apagar() {
		apagar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if (barraSearch.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Nenhum Cadastro Selecionado");
				} else {
					int k = JOptionPane.showConfirmDialog(null, "Apagar Totalmente o Cadastro?", "Apagar",
							JOptionPane.YES_NO_OPTION);
					if (k == 0) {
						String sql = "delete from informacoes where id=? ";
						try {
							pst = conn.prepareStatement(sql);
							pst.setString(1, barraSearch.getText());
							pst.execute();

							JOptionPane.showMessageDialog(null, "Cadastro Excluido Com Sucesso", "Apagar",
									JOptionPane.OK_OPTION);
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
							anexar.setIcon(null);
						} catch (Exception j) {
							JOptionPane.showMessageDialog(null, j);
						} finally {
							try {
								rs.close();
								pst.close();
							} catch (Exception j) {

							}
						}
					}
				}
			}
		});
	}
}
