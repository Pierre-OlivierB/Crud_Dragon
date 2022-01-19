
public class Dragon {
	int id;
	String nom;
	String sexe;
	int longueur;
	int nombreEcailles;
	String cracheFeu;
	String comportement;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public int getLongueur() {
		return longueur;
	}
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	public int getNombreEcailles() {
		return nombreEcailles;
	}
	public void setNombreEcailles(int nombreEcailles) {
		this.nombreEcailles = nombreEcailles;
	}
	public String getCracheFeu() {
		return cracheFeu;
	}
	public void setCracheFeu(String cracheFeu) {
		this.cracheFeu = cracheFeu;
	}
	public String getComportement() {
		return comportement;
	}
	public void setComportement(String comportement) {
		this.comportement = comportement;
	}
	@Override
	public String toString() {
		return "Dragon [id=" + id + ", nom=" + nom + ", sexe=" + sexe + ", longueur=" + longueur + ", nombreEcailles="
				+ nombreEcailles + ", cracheFeu=" + cracheFeu + ", comportement=" + comportement + "]";
	}
	
	
}
