package protocole;

public interface Protocole {
	int niveau=1;
	String nom=null;
	
	public abstract int getNiveau();
	public abstract int getNom();
	public abstract void setNiveau(int niv);
	public abstract void setNom(String nom);
}
