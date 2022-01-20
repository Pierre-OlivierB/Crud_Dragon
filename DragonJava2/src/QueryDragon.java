import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

public class QueryDragon extends MyConnexion{
	//static Scanner scan=new Scanner(System.in);
	static Clavier scan=new Clavier(); 
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
		System.out.println("fin requ�te create");
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
						resultat.getInt("Longueur"),
						resultat.getInt("NombreEcailles"),
						resultat.getString("CracheDuFeu"),
						resultat.getString("ComportementAmoureux")
				};
			System.out.println(Arrays.toString(row));
			}
			System.out.println("fin requ�te read");
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
		System.out.println("fin requ�te delete");
	return success;
	}
	public static boolean update(String newNom, String oldNom) {
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
	public static void userCreaChoice() {
		System.out.println("Quel est son nom?");
		String repNom=Clavier.lireString();
		System.out.println("Quel est son id?");
		int repId=Clavier.lireInt();
		System.out.println("Quel est son sexe? rep attendue: M ou F(un seul caract�re)");
		String repSexe=Clavier.lireString();
		System.out.println("Quel est sa taille?");
		int repTail=Clavier.lireInt();
		System.out.println("Quel est son nombre d'�cailles?");
		int repEcail=Clavier.lireInt();
		System.out.println("Crache-t-il du feu? r�ponse attendue oui/non.");
		String repFeu=Clavier.lireString();
		System.out.println("Quel est son comportement amoureux?");
		String repAmor=Clavier.lireString();
		create(repNom,repId,repSexe,repTail,repEcail,repFeu,repAmor);
	}
	public static void userUpdName() {
		System.out.println("Quel est le nom du dragon que vous voulez moddifier? R�ponse attendue: nom du Dragon");
		String repOldNom=Clavier.lireString();
		System.out.println("Quel est le nom du dragon que vous voulez lui donner?");
		String repNewNom=Clavier.lireString();
		update(repNewNom,repOldNom);
	}
	public static void userDelChoice() {
		System.out.println("Quel est le dragon que vous voulez supprimer? R�ponse attendue: nom du Dragon");
		String repNom=Clavier.lireString();
		deleteByNamePrepared(repNom);
	}
	
	
	public static void main(String[] args) {
		
//		openConnection();
//		readAll();
//		//update("poivre");
//		create("Denver",10,"F",250,2300,"non","proche");
//		readAll();
//		update("DenverA","Denver");
//		readAll();
//		deleteByNamePrepared("DenverA");
//		readAll();	
		openConnection();
		boolean choix=false;
		do {
		
		choix=true;
		System.out.println("Voulez-vous travailler sur la base de donn�es Dragon? R�ponse attendue: o/n");
		String rep=Clavier.lireString();
			if (rep.equals("o")) {
				System.out.println("Voulez-vous cr�er un dragon? R�ponse attendue: o/n");
				String repCrea=Clavier.lireString();
				if (repCrea.equals("o")) {
					userCreaChoice();
					readAll();
				}
				System.out.println("Voulez-vous modifier le nom d'un dragon? R�ponse attendue: o/n");
				String repUpd=Clavier.lireString();
				Boolean flag=false;
				if (repUpd.equals("o")) {
					do {
						flag=true;
						System.out.println("Que voulez vous modifier? R�ponse attendu nom/sexe/taille/ecaille/feu/amour)");
						String repmodif=Clavier.lireString();
						if(repmodif.equals("nom")) {
						userUpdName();
								}
						else if(repmodif.equals("sexe")) {
						
						
								}
						else if(repmodif.equals("taille")) {
						
								}
						else if(repmodif.equals("ecaille")) {
	
								}
						else if(repmodif.equals("feu")) {
	
								}
						else if(repmodif.equals("amour")) {
	
					}
					readAll();
					}while(!flag);
					
					
				}
				System.out.println("Voulez-vous supprimer un dragon? R�ponse attendue: o/n");
				String repDel=Clavier.lireString();
				if (repDel.equals("o")) {
					userDelChoice();
					readAll();
				}
				System.out.println("Voulez-vous faire d'autres modifications? R�ponse attendue: o/n");
				String repBis=Clavier.lireString();
					if(repBis.equals("o")) {
						choix=false;
					}
					else {
						choix=true;			
					}	
			}
			else {
				System.out.println("�tes-vous s�r de votre choix? R�ponse attendue: o/n");
				String repTest=Clavier.lireString();
				if(repTest.equals("n")) {
					choix=false;
				}
			}
		}while(!choix);
		closeConnection();
		System.out.println("Les portes du p�nitencier, vont se refermer. Bonne journ�e.");
		}
}

