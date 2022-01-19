import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

public class QueryDragon extends MyConnexion{
	public static boolean create(String dragon,int id, String sexe, int longueur, int ecailles, String feu,String amour) {
		boolean flag=false;
		try {
			String query ="INSERT INTO dragons2 (Dragon, DragonID, Sexe, Longueur, NombreEcailles, CracheDuFeu, ComportementAmoureux) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement declaration= accessDataBase.prepareStatement(query);
			declaration.setString(1, dragon);
			declaration.setInt(2, id);
			declaration.setString(3, sexe);
			declaration.setInt(4, longueur);
			declaration.setInt(5, ecailles);
			declaration.setString(6, feu);
			declaration.setString(7, amour);
			int executeUpdate=declaration.executeUpdate();
			flag=(executeUpdate==1);
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Erreur d'insertion dragon"+e.getMessage());
		}
		System.out.println("fin requête create");
		return flag;
	}
	public static void readAll() {
		try {
			Statement declaration=accessDataBase.createStatement();
			String query="SELECT * FROM dragons2";
			ResultSet resultat=declaration.executeQuery(query);
			while (resultat.next()) {
				Object[] row =new Object[] {
						resultat.getString("Dragon"),
						resultat.getInt("DragonID"),
						resultat.getString("Sexe"),
						resultat.getString("Longueur"),
						resultat.getString("NombreEcailles"),
						resultat.getString("CracheDuFeu"),
						resultat.getString("ComportementAmoureux")
				};
			System.out.println(Arrays.toString(row));
			}
			System.out.println("fin requête read");
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Erreur d'affichage d'ing: " + e.getMessage());
		}
	}
	public static boolean deleteByNamePrepared(String nom) {
		boolean success=false;
		try {
			String query= "DELETE FROM dragons2 where Dragon = ?";
			PreparedStatement declaration=accessDataBase.prepareStatement(query);
			declaration.setString(1,nom);
			int executeUpdate=declaration.executeUpdate();
			success=(executeUpdate==1);
	} catch(SQLException e) {
		System.err.println("Erreur suppression dragons2: "+e.getMessage());
	}
		System.out.println("fin requête delete");
	return success;
	}
	public static boolean update(String nom) {
		boolean success=false;
		try {
			String query = "UPDATE dragons2 SET Dragon=? WHERE Dragon='Denver';";
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
		Scanner scan=new Scanner(System.in);
		
		openConnection();
		readAll();
		//update("poivre");
		create("Denver",10,"F",250,2300,"non","proche");
		readAll();
		update("DenverA");
		readAll();
		deleteByNamePrepared("DenverA");
		readAll();
		closeConnection();
		boolean choix=false;
		do {
		
		choix=true;
		System.out.println("Voulez-vous faire des modifications? Réponse attendue: o/n");
		String rep=scan.nextLine();
			if (rep.equals("o")) {
				System.out.println("Voulez-vous créer un dragon? Réponse attendue: o/n");
				String repCrea=scan.nextLine();
				if (repCrea.equals("o")) {
					System.out.println("Quel est son nom?");
					String repNom=scan.nextLine();
					System.out.println("Quel est son id?");
					int repId=scan.nextInt();
					scan.nextLine();
					System.out.println("Quel est son sexe?");
					String repSexe=scan.nextLine();
					System.out.println("Quel est sa taille?");
					System.out.println("Quel est son nombre d'écailles?");
					System.out.println("Crache-t-il du feu? réponse attendue oui/non.");
					System.out.println("Quel est son nom?");
				}
			}
		}while(!choix);
		System.out.println("Les portes du pénitencier, vont se refermer. Bonne journée.");
		}
}
