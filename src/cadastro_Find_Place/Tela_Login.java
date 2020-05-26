package cadastro_Find_Place;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Tela_Login extends JFrame {

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

	public void setIcon() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconeJanela.png")));
	}

	public static void main(String[] args) {
		Tela_Login sis = new Tela_Login();

	}

	// Definindo o que vai ser utilizado
	JFrame f1;
	JPanel p1;
	JLabel l1, l2, l3;
	JTextField t1;
	JPasswordField pass;
	JButton b1, b2;
	ImageIcon img;

	Tela_Login() {

		// Criando Painel 1
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(1, 209, 113));

		img = new ImageIcon(getClass().getResource("logo.png"));

		l1 = new JLabel(img);
		l1.setBounds(0, 0, 215, 360);

		l2 = new JLabel("Usuário:");
		l2.setBounds(230, 85, 90, 40);
		l2.setFont(new Font("Product Sans", Font.BOLD, 20));
		l2.setForeground(Color.white);

		l3 = new JLabel("Senha:");
		l3.setBounds(230, 155, 100, 40);
		l3.setFont(new Font("Product Sans", Font.BOLD, 20));
		l3.setForeground(Color.white);

		t1 = new JTextField(30);
		t1.setBounds(320, 85, 230, 35);

		pass = new JPasswordField(30);
		pass.setBounds(320, 155, 230, 35);

		b2 = new JButton("Logar");
		b2.setBounds(310, 250, 90, 50);
		b2.setBackground(new Color(230, 233, 238));
		b2.setFont(new Font("Product Sans", Font.PLAIN, 12));
		b2.setIcon(new ImageIcon(getClass().getResource("/cadastro_Find_Place/login-1.png")));

		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(t1);
		p1.add(b2);
		p1.add(pass);

		// Configurando caracteristicas da Janela
		add(p1);
		setSize(580, 390);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Tela de Login - FindPlace");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		login();
		setIcon();

	}

	// Função de Login utilizando If e Else
	public void login() {
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = t1.getText();
				@SuppressWarnings("deprecation")
				String senha = pass.getText();
				if (usuario.equals("admin") && senha.equals("admin")) {
					Janela_Admin re = new Janela_Admin();
					re.setVisible(true);
					dispose();
				} else {

					JOptionPane.showMessageDialog(null, "Usuário/Senha Incorreto(s)");
					t1.setText("");
					pass.setText("");
					t1.requestFocus();
				}
			}
		});
	}

}
