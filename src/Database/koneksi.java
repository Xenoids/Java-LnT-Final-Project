package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class koneksi {

		public static Connection connect(){
			Connection connection = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bobacool?useLegacyDatetimeCode=false&serverTimezone=UTC","root","test123456");
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return connection;
		}
	

}
