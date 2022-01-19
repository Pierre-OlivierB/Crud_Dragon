import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class QueryDragon extends MyConnexion{
	public static boolean create(String dragon,int id, String sexe, int longueur, int ecailles, String feu,String amour) {
		boolean flag=false;
		try {
			String query ="INSERT INTO dragons2 (Dragon, DragonID, Sexe, Longueur, NombreEcailles, CracheDuFeu?, ComportementAmoureux) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement declaration= accessDataBase.prepareStatement(query);
			declaration.setString(1, dragon);
			declaration.setInt(1, id);
			declaration.setString(1, sexe);
			declaration.setInt(1, longueur);
			declaration.setInt(1, ecailles);
			declaration.setString(1, feu);
			declaration.setString(1, amour);
			int executeUpdate=declaration.executeUpdate();
			flag=(executeUpdate==1);
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Erreur d'insertion dragon"+e.getMessage());
		}
		return flag;
	}
	public static void readAll() {
		try {
			Statement declaration=accessDataBase.createStatement();
			String query="SELECT * FROM dragons2";
			ResultSet resultat=declaration.executeQuery(query);
			while (resultat.next()) {
				Object[] row =new Object[] {
						resultat.getInt("DragonID"),
						resultat.getString("Dragon"),
						resultat.getString("Sexe"),
						resultat.getString("Longueur"),
						resultat.getString("NombreEcailles"),
						resultat.getString("CracheDuFeu?"),
						resultat.getString("ComportementAmoureux")
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
			String query= "DELETE FROM dragons2 where nom = ?";
			PreparedStatement declaration=accessDataBase.prepareStatement(query);
			declaration.setString(1,nom);
			int executeUpdate=declaration.executeUpdate();
			success=(executeUpdate==1);
	} catch(SQLException e) {
		System.err.println("Erreur suppression dragons2: "+e.getMessage());
	}
	return success;
	}
	public static boolean update(String nom) {
		boolean success=false;
		try {
			String query = "UPDATE dragons2 SET nom=?;";
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
		//update("poivre");
		create("Denver",10,"F",250,2300,"non","proche");
		readAll();
		update(null);
		readAll();
		deleteByNamePrepared("Denver");
		closeConnection();
		}
}
