package protocole;

public class IP implements Protocole{
	private int version = 4; //version du protocol: 4 ou 6
	private int ihl = 5; //longueur entete en mots de 32 bits: 5 (par défaut)
	private int tos; //type de service
	private int length; //taille 
	
	public IP(){
		this.setNiveau(3);
		
	}

	public int getNiveau() {
		
		return 0;
	}


	
	public int getNom() {
		
		return 0;
	}

	
	public void setNiveau(int niv) {
		
		
	}


	
	public void setNom(String nom) {
		
		
	}

}
