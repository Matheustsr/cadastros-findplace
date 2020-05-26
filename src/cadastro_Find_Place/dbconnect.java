package cadastro_Find_Place;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class dbconnect {

	Connection conn = null;

	public static Connection java_db() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/findplacedb", "root", "root");

			return conn;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}

	}
}