import java.sql.Statement;
import java.util.Arrays;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class QueryIngredient extends MyConnexion {
	/**
	* Action de lire les tous les ingrèdients
	*/
	/**
	* Création d'un nouvel ingrédient
	* @param ingredient
	* @return // true si insertion réussite
	*/
	public static boolean create(String ingredient) {
		boolean flag = false;
		try {
		//PreparedStatement declaration = accessDataBase.prepareStatement();
		//String query = "INSERT INTO `ingredients`(`nom`) "
		//+ "VALUES ('" + ingredient + "')";
		//int executeUpdate = declaration.executeUpdate(query);
		// = (executeUpdate == 1);
		
		//declaration.setString(1,ingredient);
			String query= "INSERT INTO ingredients (nom) VALUES (?)";
			PreparedStatement declaration=accessDataBase.prepareStatement(query);
			declaration.setString(1,ingredient);
			int executeUpdate=declaration.executeUpdate();
			flag=(executeUpdate==1);
		
		//if (executeUpdate == 1) {
		//System.out.println("insertion ingredient effectué ! ");
		//} else {
		//System.out.println("insertion ingredient non effectue");
				//}
		} catch (Exception e) {
		System.err.println(
		"Erreur d'insertion ingredient: " + e.getMessage()
		);
		}
		return flag;
	}
	public static void readAll() {
	// TODO
		try {
		Statement declaration = accessDataBase.createStatement();
		String query = "SELECT id, nom FROM ingredients;";
		ResultSet resultat = declaration.executeQuery(query);
		/* Récupération des données */
		while (resultat.next()) {
		Object[] row = new Object[]{
		resultat.getInt("id"),
		resultat.getString("nom")
		};
		System.out.println(Arrays.toString(row));
		}
		} catch (Exception e) {
		System.err.println(
		"Erreur d'affichage d'ing: " + e.getMessage()
		);
		}
	}
	
	public static boolean delete(int id) {
		boolean success=false;
		try {
			Statement declaration = accessDataBase.createStatement();
			/*Requête*/
			String query="DELETE FROM`ingredients` WHERE `id`="+id+";";
			/*Exécution d'une requête de lecture*/
			int executeUpdate=declaration.executeUpdate(query);
			success=(executeUpdate==1);
		} catch(SQLException e) {
			System.err.println("Erreur suppression ingredient: "+e.getMessage());
		}
		return success;
	}
	public static boolean deleteByName(String Nom) {
		boolean success =false;
		try {
			Statement declarationStatement = accessDataBase.createStatement();
			String query = "DELETE FROM `ingredients`WHERE `nom`=\""+Nom+"\";";
			int executeUpdate=declarationStatement.executeUpdate(query);
			success= (executeUpdate==1);
		}catch(SQLException e) {
			System.err.println("Erreur supression ingredient: " +e.getMessage());
		}
		return success;
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
			//ResultSet resultat = declaration.executeQuery(query);
			/* Récupération des données */
			//while (resultat.next()) {
			//Object[] row = new Object[]{
			//resultat.getInt(1),
			//resultat.getString("nom")
			
			//System.out.println(Arrays.toString(row));
			//}
			} catch (Exception e) {
			System.err.println(
			"Erreur d'affichage d'ing: " + e.getMessage()
			);
			}
		return success;
	}
	/**
	* Ici on test
	* @param args the command line arguments
	*/
	public static void main(String[] args) {
	openConnection();
	//avant
	readAll();
	//creation
	
	//delete(18);
	//deleteByName("sel\" OR \"\" = \"");
	//après
	update("poivre");
	create("sel");
	readAll();
	closeConnection();
	}
	
}

