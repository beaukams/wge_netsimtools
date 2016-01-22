/**
 * @author abdoulaye KAMA <abdoulayekama@gmail.com>
 */

package netutils;

public class Format {
	
	public static int formatByte(){
		return 0;
	}
	
	/**
	 * 
	 * @param b: type int
	 * @return true si b est un entier compris entre 0 et 255
	 */
	public static boolean isFormatDec(int b){
		if(b<0 || b>255) return false;
		else return true;
	}
	public static boolean isFormatDec(int b []){
		boolean res=true;
		for(int i=0; i<b.length; i++){
			if(Format.isFormatDec(b[i])==false){
				res=false; break;
			}
		}
		return res;
	}
	
	/**
	 * @param b: type int
	 * @return true si b est egale à 0 ou 1
	 */
	public static boolean isFormatBin(int b){
		if(b==0 || b==1) return true;
		else return false;
	}
	
	/**
	 * 
	 * @param b: type char
	 * @return true si b est un chiffre hexadecimal
	 */
	
	public static boolean isFormatHex(char b){
		char tab [] = { 0,1,2,3,4,5,6,7,8,9,'a','b','c','d','e','f'};
		boolean res=false;
		for(int c:tab){
			if(b==c){ res=true; break;}
		}
		return res;
	}
	
	/**
	 * 
	 * @param nb
	 * @return convertit le décimal en binaire et retourne le résultat sous la forme d'un tableau dont les élèments sont 1 et 0
	 */
	public static int [] decToBin(int nb){
		int n = (int) (Math.log(nb)/Math.log(2));
		if(Math.pow(2,n)<=nb && Math.pow(2, n+1)>nb) n++;
		int tab [] = new int [n];
		for(int i=0; i<n; i++){
			tab[i] = nb%2;
			nb/=2;
		}
		return tab;
	}
	
	/**
	 * 
	 * @param dec : nombre decimal
	 * @param n: nombre de bits dans un groupement
	 * @return convertit un nombre decimal en binaire. Le nombre de bits obtenu est un multiple de n
	 */
	public static int [] decToBin(int dec, int n){
		int [] bin = Format.decToBin(dec);
		
		if(bin.length%n!=0){
			int res [] = new int [bin.length - bin.length%n + n];
			for(int i=0; i<res.length; i++){
				if(i<bin.length) res[i] = bin[i];
				else res[i] = 0;
			}
			return res;
		}else return bin;
	}
	
	public static int [][] decToBin(int dec []){
		//determiner la longueur maximal en chiffres binaires
		int max=0, temp=0;
		for(int i=0; i<dec.length; i++){
			temp = Format.decToBin(dec[i]).length;
			if(temp>max){
				max = temp;
			}
		}
		
		int [][] bin = new int [dec.length][max];
		for(int i=0; i<dec.length; i++){
			bin[i] = Format.decToBin(dec[i]);
		}
		return bin;
	}
	
	public static int [][] decToBin(int dec [], int n){
		//determiner la longueur maximal en chiffres binaires
		int max=0, temp=0;
		for(int i=0; i<dec.length; i++){
			temp = Format.decToBin(dec[i],n).length;
			if(temp>max){
				max = temp;
			}
		}
		
		int [][] bin = new int [dec.length][max];
		for(int i=0; i<dec.length; i++){
			bin[i] = Format.decToBin(dec[i], n);
		}
		return bin;
	}
	
	/**
	 * 
	 * @param nb
	 * @return convertit un nombre décimal en nombre hexadecimal et retourne le résultat sous forme de tableau de caractere
	 */
	public static char [] decToHex(int nb){
		
		int n = (int) (Math.log(nb)/Math.log(16));
		if(nb==0) n=1;
		if(Math.pow(16,n)<=nb && Math.pow(16, n+1)>nb) n++;
		int tab [] = new int [n];
		for(int i=0; i<n; i++){
			tab[i] = nb%16;
			nb/=16;
		}
		char [] res = new char [tab.length];
		for(int i=0; i<res.length; i++){
			if(tab[i]==10) res[i]='a';
			else if(tab[i]==11) res[i]='b';
			else if(tab[i]==12) res[i]='c';
			else if(tab[i]==13) res[i]='d';
			else if(tab[i]==14) res[i]='e';
			else if(tab[i]==15) res[i]='f';
			else res[i] = Integer.toString(tab[i]).charAt(0);
			
		}
		return res;
	}
	
	/**
	 * 
	 * @param dec: nombre decimal
	 * @param longueur: nombre de chiffres hexadecimal par mot
	 * @return convertir un nombre decimal en nombre hexadecimal
	 */
	public static char [] decToHex(int dec, int longueur){
		char [] hex = Format.decToHex(dec);
		
		if(hex.length%longueur!=0){
			char res [] = new char [hex.length-hex.length%longueur+longueur];
			for(int i=0; i<res.length; i++){
				if(i<hex.length) res[i] = hex[i];
				else res[i] = '0';
			}
			return res;
		}else return hex;
	}
	
	/**
	 * 
	 * @param dec
	 * @return convertit un tableau d'entiers en tableau d'hexadecimaux
	 */
	public static char [][] decToHex(int dec []){
		//determiner la longueur maximal en chiffres hexadecimal
		int max=0, temp=0;
		for(int i=0; i<dec.length; i++){
			temp = Format.decToHex(dec[i]).length;
			if(temp>max){
				max = temp;
			}
		}
		
		char [][] hex = new char [dec.length][max];
		for(int i=0; i<dec.length; i++){
			hex[i] = Format.decToHex(dec[i]);
		}
		return hex;
	}
	
	public static char [][] decToHex(int dec [], int longueur){
		int max=0, temp=0;
		for(int i=0; i<dec.length; i++){
			temp = Format.decToHex(dec[i]).length;
			if(temp>max){
				max = temp;
			}
		}
		
		char [][] hex = new char [dec.length][max];
		for(int i=0; i<dec.length; i++){
			hex[i] = Format.decToHex(dec[i], longueur);
		}
		return hex;
	}
	
	/**
	 * 
	 * @param c
	 * @return équivalence d'un chiffre hexadecimal sous forme décimal
	 */
	public static int hexToDec(char c){
		char tab [] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		int res=0;
		for(int i=0; i<tab.length; i++){
			if(c==tab[i]){ res=i; break;}
		}
		return res;
	}
	
	/**
	 * 
	 * @param c
	 * @return convertit un nombre hexadecimal (sous forme de tableau de caractere) en nombre décimal
	 */
	
	public static int hexToDec(char c []){
		int res=0;
		for(int i=0; i<c.length; i++){
			res+=(int) (Format.hexToDec(c[i])*Math.pow(16, i));
		}
		return res;
	}
	
	/**
	 * 
	 * @param hex
	 * @return convertit un tableau de nombres hexadecimal en tableau de nombres decimal
	 */
	public static int [] hexToDec(char hex [][]){
		int [] dec = new int [hex.length];
		for(int i=0; i<dec.length; i++){
			dec[i] = Format.hexToDec(hex[i]);
		}
		return dec;
	}
	
	/**
	 * 
	 * @param hex
	 * @return convertit un nombre hexadecimal en nombre binaire
	 */
	public static int [] hexToBin(char hex []){
		return Format.decToBin(Format.hexToDec(hex));
	}
	
	/**
	 * 
	 * @param tab
	 * @return convertit un nombre binaire (sous forme de tableau) en nombre décimal
	 */
	public static int binToDec(int tab []){
		int res=0;
		for(int i=0; i<tab.length; i++){
			res+=(int) tab[i]*Math.pow(2, i);
		}
		return res;
	}
	
	/**
	 * 
	 * @param bin
	 * @return convertit un nombre binaire en nombre hexadecimal
	 */
	public static char [] binToHex(int bin []){
		return Format.decToHex(Format.binToDec(bin));
	}
	
	/**
	 * 
	 * @param ch
	 * @return convertis une chaine en nombre décimal
	 */
	public static int stringToDec(String ch){
		int res=0;
		try{
			res=Integer.parseInt(ch);
			return res;
		}catch(Exception e){
			return -1;
		}
	}
	
	public static int [] stringSepToDec(String ch, String regex){
		
		if(ch.contains(regex)){
			
			//les parties sans les separateurs
			String chSep [] = Format.decomposeChaine(ch, regex);
			
			int dec [] = new int [chSep.length];
			
			for(int i=0; i<dec.length; i++){
				dec[i] = Format.stringToDec(chSep[dec.length-i-1]);
				
			}
			return dec;
		}else{
			int dec [] = new int [1];
			
			dec[0]=Format.stringToDec(ch);
			return dec;
		}
	}
	
	/**
	 * 
	 * @param ch
	 * @return convertit une chaine de  caractere (contenant des valeurs binaires ) en nombre binaire, et retourne le résultat sous forme de tableau de bits (0,1)
	 */
	public static int [] stringToBin(String ch){
		if(!ch.contains(".")){
			int bin [] = new int [ch.length()];
			String str = "";
			for(int i=0; i<bin.length; i++){
				str += ch.charAt(bin.length-i-1);
				bin[i] = Integer.parseInt(str);
				str="";
			}
			return bin;
		}else{
			return null;
		}
	}
	
	public static int [][] stringSepToBin(String ch, String regex){
		if(ch.contains(regex)){
			//les parties sans les separateurs
			String chSep [] = Format.decomposeChaine(ch, regex);;
			
			int bin [][] = new int [chSep.length][ch.length()];
			
			for(int i=0; i<bin.length; i++){
				bin[i] = Format.stringToBin(chSep[bin.length-i-1]);
			}
			return bin;
		}else{
			int bin [][] = new int [1][ch.length()];
			
			bin[0]=Format.stringToBin(ch);
			return bin;
		}
	}
	
	/**
	 * 
	 * @param ch
	 * @return convertir une chaine hexadecimal en nombre hexadecimal
	 */
	public static char [] stringToHex(String ch){
		if(!ch.contains(".")){
			char hex [] = new char [ch.length()];
			for(int i=0; i<hex.length; i++) hex[i] = ch.charAt(hex.length-i-1);
			return hex;
		}else{
			return null;
		}
	}
	
	public static char [][] stringSepToHex(String ch, String regex){
		if(ch.contains(regex)){
			//les parties sans les separateurs
			String chSep [] = Format.decomposeChaine(ch, regex);;
			
			char bin [][] = new char [chSep.length][chSep[0].length()];
			
			
			for(int i=0; i<bin.length; i++){
				bin[i] = Format.stringToHex(chSep[bin.length-i-1]);
				
			}
			return bin;
		}else{
			char bin [][] = new char [1][ch.length()];
			
			bin[0]=Format.stringToHex(ch);
			return bin;
		}
	}
	
	/**
	 * 
	 * @param c
	 * @return convertit un entier en chaîne
	 */
	
	public static String toString(int c){
		String res="";
		return res+c;
	}
	
	/**
	 * 
	 * @param tab
	 * @return convertit un tableau d'entier en chaîne de caractere
	 */
	public static String toString(int tab []){
		String res="";
		for(int i=0; i<tab.length; i++){
			res+=tab[tab.length-i-1];
		}
		return res;
	}
	
	public static String toString(int tab [], String regex){
		String res="";
		for(int i=0; i<tab.length; i++){
			if(i!=0) res+=regex;
			res+=tab[tab.length-i-1];
		}
		return res;
	}
	
	
	public static String toString(int tab [][], String regex){
		String res="";
		for(int i=0; i<tab.length; i++){
			if(i!=0) res+=regex; 
			res+=Format.toString(tab[tab.length-i-1]);
		}
		return res;
	}
	
	
	/**
	 * 
	 * @param tab
	 * @return convertit un tableau de caractère en chaine de caractere
	 */
	public static String toString(char tab []){
		String res="";
		for(int i=0; i<tab.length; i++){
			res+=tab[tab.length-i-1];
		}
		return res;
	}
	
	public static String toString(char tab [][], String regex){
		String res="";
		for(int i=0; i<tab.length; i++){
			if(i!=0) res+=regex;
			
			res+=Format.toString(tab[tab.length-i-1]);
		}
		return res;
	}

	private static String [] decomposeChaine(String chaine, String regex){
		String ch = chaine+"";
		char caract [] = ch.toCharArray();
		int countRegex = 1;
		for(int i=0; i<ch.length(); i++){
			if(caract[i] == regex.charAt(0)){
				countRegex++;
			}
		}

		String res [] = new String [countRegex];
		for(int i=0; i<countRegex; i++){
			if(i==countRegex-1) res[i]=ch;
			else{
				res[i] = ch.substring(0,ch.indexOf(regex.charAt(0)));
				ch=ch.substring(1+ch.indexOf(regex.charAt(0)),ch.length());
			}
		}
		
		return res;
	}
	
	/**
	 * @param 
	 * @return la même chaine renversée
	 */
	public static String renverserChaine(String chaine){
		String res = "";
		for(int i=0; i<chaine.length(); i++) res += chaine.charAt(chaine.length()-i-1);
		return res;
	}
	
	/**
	 * Renverser un tableau de type int
	 * @param tab
	 * @return renverser un tableau d'entier
	 */
	public static int [] renverserTableau(int tab []){
		int res [] = new int [tab.length];
		for(int i=0; i<res.length; i++) res[i] = tab[res.length-i-1];
		return res;
	}
	
	/**
	 * Renverser un tableau de type char
	 * @param tab
	 * @return renverser un tableau de char
	 */
	public static char [] renverserTableau(char tab []){
		char res [] = new char [tab.length];
		for(int i=0; i<res.length; i++) res[i] = tab[res.length-i-1];
		return res;
	}
	
	public static char [][] renverserTableau(char tab [][]){
		char res [][] = new char [tab.length][tab[0].length];
		for(int i=0; i<res.length; i++) res[i] = tab[res.length-i-1];
		return res;
	}
	
	public static void main(String args []){
		int n=295;
		//System.out.println(Format.toString(Format.decToHex(n)));
		//System.out.println(Format.toString(Format.hexToDec(Format.decToHex(n))));
	/*	String ch = "ab015f";
		String bi = "11010110";
		System.out.println("chaine hex"+ch);
		System.out.println("chaine en hex"+Format.toString(Format.stringToHex(ch)));
		System.out.println("hex en bin"+Format.toString(Format.hexToBin(Format.stringToHex(ch))));
		System.out.println("hex en dec"+Format.toString(Format.hexToDec(Format.stringToHex(ch))));
		System.out.println("chaine bin"+bi);
		System.out.println("chaine en bin"+Format.toString(Format.stringToBin(bi)));
		System.out.println("bin to dec"+Format.toString(Format.binToDec(Format.stringToBin(bi))));*/
		System.out.println(Format.toString(Format.decToHex(2555)));
		System.out.println(Format.toString(Format.decToBin(2555, 8)));
	}
}
