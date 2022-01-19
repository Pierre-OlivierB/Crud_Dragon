import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class QueryDragon extends MyConnexion{
	public static boolean create(String dragon) {
		boolean flag=false;
		try {
			String query ="INSERT INTO dragons2(Dragon) VALUES (?)";
			PreparedStatement declaration= accessDataBase.prepareStatement(query);
			declaration.setString(1, dragon);
			int executeUpdate=declaration.executeUpdate();
			flag=(executeUpdate==1);
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Erreur d'insertion dragon"+e.getMessage());
		}
	}
	public static void readAll() {
		try {
			Statement declaration=accessDataBase.createStatement();
			String query="SELECT DragonID, Dragon FROM dragons2";
			ResultSet resultat=declaration.executeQuery(query);
			while (resultat.next()) {
				Object[] row =new Object[] {
						resultat.getInt("DragonID"),
						resultat.getString("dragons2")
				};
			System.out.println(Arrays.toString(row));
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Erreur d'affichage d'ing: " + e.getMessage());
		}
	}
	public static boolean deleteByNamePrepared(String nom) {
		boolean success=false;
		try {
			String query= "DELETE FROM ingredients where nom = ?";
			PreparedStatement declaration=accessDataBase.prepareStatement(query);
			declaration.setString(1,nom);
			int executeUpdate=declaration.executeUpdate();
			success=(executeUpdate==1);
	} catch(SQLException e) {
		System.err.println("Erreur suppression ingredient: "+e.getMessage());
	}
	return success;
	}
	public static boolean update(String nom) {
		boolean success=false;
		try {
			String query = "UPDATE ingredients SET nom=?;";
			PreparedStatement declaration=accessDataBase.prepareStatement(query);
			declaration.setString(1,nom);
			int executeUpdate=declaration.executeUpdate();
			success=(executeUpdate==1);
			} catch (Exception e) {
			System.err.println(
			"Erreur d'affichage d'ing: " + e.getMessage()
			);
			}
		return success;
	}
	public static void main(String[] args) {
		openConnection();
		readAll();
		update("poivre");
		create("sel");
		readAll();
		closeConnection();
		}
}
