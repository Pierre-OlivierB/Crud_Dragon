import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyConnexion {
	static Connection accessDataBase=null;
	public static void openConnection() {
		String url="jdbc:mysql://127.0.0.1/dragon";
		String utilisateur="root";
		String motDePasse="";
		try {
			System.out.println("Try to connect");
			accessDataBase=DriverManager.getConnection(url,utilisateur,motDePasse);
			
		} catch (SQLException ex) {
			// TODO: handle exception
			Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE,null,ex);
		}
		
	}
	public static boolean testConnection() {
		boolean flag=false;
		try {
			if (accessDataBase!=null) {
				if (!accessDataBase.isClosed()) {
					System.out.println("Connection au serveur ...OK");
					flag=true;
				}
			}
		}catch (SQLException ex) {
			// TODO: handle exception
			Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null,
					ex);
					}
			return flag;
	}
	public static void closeConnection() {
		if(accessDataBase!=null) {
			try {
				accessDataBase.close();
				System.out.println("Close connection.");
			} catch (SQLException e) {
				// TODO: handle exception
				System.err.println("Erreur fermeture: " + e.getMessage());
			}
		}
	}

}