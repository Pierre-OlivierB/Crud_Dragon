import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

public class QueryDragon extends MyConnexion{
	//static Scanner scan=new Scanner(System.in);
	static Clavier scan=new Clavier(); 
	static Boolean flag=false;
	//create
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
	//read
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
						resultat.getInt("Longueur"),
						resultat.getInt("NombreEcailles"),
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
	//delete
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
	//update nom
	public static boolean updateNom(String newNom, String oldNom) {
		boolean success=false;
		try {
			String query = "UPDATE dragons2 SET Dragon=? WHERE Dragon=?;";
			PreparedStatement declaration=accessDataBase.prepareStatement(query);
			declaration.setString(1,newNom);
			declaration.setString(2,oldNom);
			int executeUpdate=declaration.executeUpdate();
			success=(executeUpdate==1);
			} catch (Exception e) {
			System.err.println(
			"Erreur d'affichage d'ing: " + e.getMessage()
			);
			}
		return success;
	}
	//update taille
	public static boolean updateTaille(String nom, int taille) {
		boolean success=false;
		try {
			String query = "UPDATE dragons2 SET Longueur=? WHERE Dragon=?;";
			PreparedStatement declaration=accessDataBase.prepareStatement(query);
			declaration.setInt(1,taille);
			declaration.setString(2,nom);
			int executeUpdate=declaration.executeUpdate();
			success=(executeUpdate==1);
			} catch (Exception e) {
			System.err.println(
			"Erreur d'affichage d'ing: " + e.getMessage()
			);
			}
		return success;
	}
	//update nmb ecailles
	public static boolean updateEcaille(String nom, int ecailles) {
		boolean success=false;
		try {
			String query = "UPDATE dragons2 SET NombreEcailles=? WHERE Dragon=?;";
			PreparedStatement declaration=accessDataBase.prepareStatement(query);
			declaration.setInt(1,ecailles);
			declaration.setString(2,nom);
			int executeUpdate=declaration.executeUpdate();
			success=(executeUpdate==1);
			} catch (Exception e) {
			System.err.println(
			"Erreur d'affichage d'ing: " + e.getMessage()
			);
			}
		return success;
	}
	//update crache du feu
	public static boolean updateFeu(String nom, String feu) {
		boolean success=false;
		try {
			String query = "UPDATE dragons2 SET CracheDuFeu=? WHERE Dragon=?;";
			PreparedStatement declaration=accessDataBase.prepareStatement(query);
			declaration.setString(1,feu);
			declaration.setString(2,nom);
			int executeUpdate=declaration.executeUpdate();
			success=(executeUpdate==1);
			} catch (Exception e) {
			System.err.println(
			"Erreur d'affichage d'ing: " + e.getMessage()
			);
			}
		return success;
	}
	//update comportement
	public static boolean updateAmour(String nom, String amour) {
		boolean success=false;
		try {
			String query = "UPDATE dragons2 SET ComportementAmoureux=? WHERE Dragon=?;";
			PreparedStatement declaration=accessDataBase.prepareStatement(query);
			declaration.setString(1,amour);
			declaration.setString(2,nom);
			int executeUpdate=declaration.executeUpdate();
			success=(executeUpdate==1);
			} catch (Exception e) {
			System.err.println(
			"Erreur d'affichage d'ing: " + e.getMessage()
			);
			}
		return success;
	}
	//update sexe
	public static boolean updateSexe(String nom, String sexe) {
		boolean success=false;
		try {
			String query = "UPDATE dragons2 SET Sexe=? WHERE Dragon=?;";
			PreparedStatement declaration=accessDataBase.prepareStatement(query);
			declaration.setString(1,sexe);
			declaration.setString(2,nom);
			int executeUpdate=declaration.executeUpdate();
			success=(executeUpdate==1);
			} catch (Exception e) {
			System.err.println(
			"Erreur d'affichage d'ing: " + e.getMessage()
			);
			}
		return success;
	}
	//user choice
	public static void userCreaChoice() {
		System.out.println("Quel est son nom?");
		String repNom=Clavier.lireString();
		System.out.println("Quel est son id?");
		int repId=Clavier.lireInt();
		System.out.println("Quel est son sexe? rep attendue: M ou F(un seul caractère)");
		String repSexe=Clavier.lireString();
		System.out.println("Quel est sa taille?");
		int repTail=Clavier.lireInt();
		System.out.println("Quel est son nombre d'écailles?");
		int repEcail=Clavier.lireInt();
		System.out.println("Crache-t-il du feu? réponse attendue oui/non.");
		String repFeu=Clavier.lireString();
		System.out.println("Quel est son comportement amoureux?");
		String repAmor=Clavier.lireString();
		create(repNom,repId,repSexe,repTail,repEcail,repFeu,repAmor);
	}
	//name choice
	public static void userUpdName() {
		System.out.println("Quel est le nom du dragon que vous voulez moddifier? Réponse attendue: nom du Dragon");
		String repOldNom=Clavier.lireString();
		System.out.println("Quel est le nom du dragon que vous voulez lui donner?");
		String repNewNom=Clavier.lireString();
		updateNom(repNewNom,repOldNom);
	}
	//sexe choice
	public static void userUpdSexe() {
		System.out.println("Quel est le nom du dragon que vous voulez moddifier? Réponse attendue: nom du Dragon");
		String repNom=Clavier.lireString();
		System.out.println("Quel est le sexe choisi? Réponse attendue : M/F");
		String repNewSexe=Clavier.lireString();
		updateSexe(repNom,repNewSexe);
	}
	//taille  choice
	public static void userUpdTaille() {
		System.out.println("Quel est le nom du dragon que vous voulez moddifier? Réponse attendue: nom du Dragon");
		String repNom=Clavier.lireString();
		System.out.println("Quel est la taille choisi?");
		int repNewTaille=Clavier.lireInt();
		updateTaille(repNom,repNewTaille);
	}
	//nmb ecaille choice
	public static void userUpdEcaille() {
		System.out.println("Quel est le nom du dragon que vous voulez moddifier? Réponse attendue: nom du Dragon");
		String repNom=Clavier.lireString();
		System.out.println("Quel est son nombre d'écailles? ");
		int repNewEcaille=Clavier.lireInt();
		updateEcaille(repNom,repNewEcaille);
	}
	//crache du feu choice
	public static void userUpdFeu() {
		System.out.println("Quel est le nom du dragon que vous voulez moddifier? Réponse attendue: nom du Dragon");
		String repNom=Clavier.lireString();
		System.out.println("Ce Dragon crache-t-il du feu? Réponse attendue: oui/non");
		String repNewFeu=Clavier.lireString();
		updateFeu(repNom,repNewFeu);
	}
	//comportement choice
	public static void userUpdAmour() {
		System.out.println("Quel est le nom du dragon que vous voulez moddifier? Réponse attendue: nom du Dragon");
		String repNom=Clavier.lireString();
		System.out.println("Quel est son comportement amoureux?");
		String repNewAmour=Clavier.lireString();
		updateAmour(repNom,repNewAmour);
	}
	//delete choice
	public static void userDelChoice() {
		System.out.println("Quel est le dragon que vous voulez supprimer? Réponse attendue: nom du Dragon");
		String repNom=Clavier.lireString();
		deleteByNamePrepared(repNom);
	}
	//proposition boucle
	public static boolean propBool() {
		flag=true;
		System.out.println("Voulez-vous faire d'autres modifications dans la base de données? Réponse attendue o/n");
		String repboucle=Clavier.lireString();
		if(repboucle.equals("o")) {
			flag=false;
		}
		else if(repboucle.equals("n")) {
			flag=true;
		}
		else {
			System.out.println("La réponse choisi n'est pas bonne, veuillez recommencer.");
			flag=false;
		}
		return flag;
	}
	//proposition choix
	public static void propUpdate() {
		
		do {
			flag=true;
			System.out.println("Que voulez vous modifier? Réponse attendu nom/sexe/taille/ecaille/feu/amour)");
			String repmodif=Clavier.lireString();
			if(repmodif.equals("nom")) {
			userUpdName();
					}
			else if(repmodif.equals("sexe")) {
			userUpdSexe();
			
					}
			else if(repmodif.equals("taille")) {
			userUpdTaille();
					}
			else if(repmodif.equals("ecaille")) {
			userUpdEcaille();
					}
			else if(repmodif.equals("feu")) {
			userUpdFeu();
					}
			else if(repmodif.equals("amour")) {
			userUpdAmour();
			}
			readAll();
			propBool();	
		}while(!flag);
	}
	
	
	public static void main(String[] args) {
		
//		openConnection();
//		readAll();
//		//update("poivre");
//		create("Denver",10,"F",250,2300,"non","proche");
//		readAll();
//		updateNom("DenverA","Denver");
//		readAll();
//		deleteByNamePrepared("DenverA");
//		readAll();	
		openConnection();
		testConnection();
		boolean choix=false;
		do {
		
		choix=true;
		System.out.println("Voulez-vous travailler sur la base de données Dragon? Réponse attendue: o/n");
		String rep=Clavier.lireString();
			if (rep.equals("o")) {
				System.out.println("Voulez-vous créer un dragon? Réponse attendue: o/n");
				String repCrea=Clavier.lireString();
				if (repCrea.equals("o")) {
					userCreaChoice();
					readAll();
				}
				System.out.println("Voulez-vous modifier un dragon? Réponse attendue: o/n");
				String repUpd=Clavier.lireString();
				
				if (repUpd.equals("o")) {
					propUpdate();	
				}
				System.out.println("Voulez-vous supprimer un dragon? Réponse attendue: o/n");
				String repDel=Clavier.lireString();
				if (repDel.equals("o")) {
					userDelChoice();
					readAll();
				}
				System.out.println("Voulez-vous faire d'autres modifications? Réponse attendue: o/n");
				String repBis=Clavier.lireString();
					if(repBis.equals("o")) {
						choix=false;
					}
					else {
						choix=true;			
					}	
			}
			else {
				System.out.println("Êtes-vous sûr de votre choix? Réponse attendue: o/n");
				String repTest=Clavier.lireString();
				if(repTest.equals("n")) {
					choix=false;
				}
			}
		}while(!choix);
		closeConnection();
		System.out.println("Les portes du pénitencier, vont se refermer. Bonne journée.");
		}
}

