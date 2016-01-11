/**
 * @author abdoulaye KAMA <abdoulayekama@gmail.com>
 */

package adressage;


import netutils.*;

public class AdresseMac {
	private int octets [] = new int [6];
	
	/**
	 * 
	 * @param dec
	 */
	public AdresseMac(int dec []){
		if(dec.length==6){
			this.octets = dec;
		}
	}
	
	/**
	 * 
	 * @param addr (String): adresse mac sous forme de chaîne de caractères
	 * @param type (String): notation de l'adresse. dec(decimal pointé), hex (hexadecimal), bin(binaire)
	 */
	public AdresseMac(String addr, String type){
		if(type.equals("dec")) this.octets = Format.stringSepToDec(addr, ":");
		else if(type.equals("hex")) this.octets = Format.hexToDec(Format.stringSepToHex(addr, ":"));
		
	}
	
	/**
	 * 
	 * @return l'adresse sous forme hexadecimal
	 */
	
	public int [] getFormatDec(){
		return this.octets;
	}
	
	/**
	 * 
	 * @return l'adresse sous format binaire
	 */
	public int [][] getFormatBin(){
		int [][] bin = new int [this.octets.length][8];
		for(int i=0; i<this.octets.length; i++){
			bin[i] = Format.decToBin(this.octets[i],8);
		}
		return bin;
	}
	
	/**
	 * 
	 * @return l'adresse sous format hexadecimal
	 */
	
	public char [][] getFormatHex(){
		char hex [][] = new char [this.octets.length][2];
		for(int i=0; i<this.octets.length; i++){
			hex[i] = Format.decToHex(this.octets[i]);
		}
		return hex;
	}
	
	/**
	 *  
	 * @return l'adresse sous format chaine de caractère de bits 
	 */
	
	public String getFormatBinString(){
		return Format.toString(Format.decToBin(this.octets,8), ":");
	}
	
	/**
	 * 
	 * @return l'adresse sous format chaine de caractère de bits
	 */
	
	public String getFormatHexString(){
		return Format.toString(Format.decToHex(this.octets,2),":");
	}
	
	/**
	 * 
	 * @param mot 
	 */
	public void setFormatDecimal(int [] mot){
		if(mot.length==6) this.octets = mot;
	}

	public String toString(){
		String res="";
		for(int i=0; i<this.octets.length; i++){
			if(i!=0) res+=":";
			res+=this.octets[this.octets.length-i-1];
		}
		return res;
	}
	
	public static void main(String args []){
		AdresseMac adr = new AdresseMac("04:7d:7b:e6:d7:af","hex");
		System.out.println("adresse hex 04:7d:7b:e6:d7:af");
		System.out.println("adresse hex "+adr.getFormatHexString());
		System.out.println("adresse bin "+adr.getFormatBinString());
		System.out.println("adresse dec "+adr.toString());
	}
}
