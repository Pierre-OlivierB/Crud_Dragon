
public class Ingredient {
	int id_ingredient;
	String Nom;
	
	public int getId_ingredient() {
		return id_ingredient;
	}
	public void setId_ingredient(int id_ingredient) {
		this.id_ingredient = id_ingredient;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	
	@Override
	public String toString() {
		return "Ingredient [id_ingredient=" + id_ingredient + ", Nom=" + Nom + "]";
	}
	
	
	
}
