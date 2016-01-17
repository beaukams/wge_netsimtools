package netutils;

public class Matrice {
	private int n; //nombre de lignes
	private int m; //nombre de colonnes
	private double Mat [][];
	
	public Matrice(int taille){
		if(taille>=0){
			this.n = taille;
			this.m = taille;
		
			this.Mat = Matrice.getTabMatriceUnite(this.n);
		}
	}
	
	public Matrice(int nbLignes, int nbColonnes){
		if(nbLignes>=0 && nbColonnes>=0){
			this.n = nbLignes;
			this.m = nbColonnes;
		
			this.Mat = Matrice.getTabMatriceUnite(this.n, this.m);
		}
	}
	
	public Matrice(double tab [][]){
		
		//verifier que le tableau est un tableau de tableau de mêmes tailles
		boolean bon=true;
		for(int i=0; i<tab.length; i++)
			if(tab[i].length != tab[0].length)
				bon = false;
		 
		if(bon == true){
			this.n = tab.length;
			this.m = tab[0].length;
			this.Mat = tab;
		}
		
	}
	
	
	
	public static double [][] getTabMatriceUnite(int n, int m){
		if(n>=0 && m>=0){
			double mat [][] = new double [n][m];
			for(int i=0;i<n; i++)
				for(int j=0; j<m; j++)
					mat[i][j] = 1;
			return mat;
		}else return null;
	}
	
	public static double [][] getTabMatriceUnite(int n){
		return Matrice.getTabMatriceUnite(n, n);
	}
	
	public static double [][] getTabMatriceIdentite(int n, int m){
		if(n>=0 && m>=0){
			double mat [][] = new double [n][m];
			for(int i=0;i<n; i++)
				for(int j=0; j<m; j++)
					if(i==0)
						mat[i][j] = 1;
					else 
						mat[i][j] = 0;
			return mat;
		}else return null;
	}
	
	public static double [][] getTabMatriceIdentite(int n){
		return Matrice.getTabMatriceIdentite(n, n);
	}
	
	public static Matrice getMatriceIdentite(int n, int m){
		Matrice mat = new Matrice(n, m);
		mat.setMat(Matrice.getTabMatriceIdentite(n, m));
		return mat;
	}
	
	public static Matrice getMatriceIdentite(int n){
		Matrice mat = new Matrice(n);
		mat.setMat(Matrice.getTabMatriceIdentite(n));
		return mat;
	}
	
	public static Matrice getMatriceUnite(int n, int m){
		Matrice mat = new Matrice(n, m);
		mat.setMat(Matrice.getTabMatriceUnite(n, m));
		return mat;
	}
	
	public static Matrice getMatriceUnite(int n){
		Matrice mat = new Matrice(n);
		mat.setMat(Matrice.getTabMatriceUnite(n));
		return mat;
	}
	
	public void setN(int n){
		if(n>=0)
			this.n = n;
	}
	
	public void setM(int m){
		if(m>=0)
			this.m = m;
	}
	
	public void setMat(double [][] mat){
		this.Mat = mat;
	}
}
