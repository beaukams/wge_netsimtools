/**
 * @author abdoulaye KAMA <abdoulayekama@gmail.com>
 */
package adressage;

import java.net.*;
import netutils.*;

public class AdresseIpV4{
	private int [] octets = new int [4];
	private int [] mask = new int [4];
	
	/**
	 * Cree une adresse ipv4 sans préciser le mask
	 * @param mots
	 */
	public AdresseIpV4(int [] mots){
		if(Format.isFormatDec(mots)){//si le mot decimal est correcte
			this.octets = mots;
			this.mask = this.getMaskParDefaut();
		}
	}
	
	/**
	 * Cree une adresse ipv4 avec un masque
	 * @param mots: adresse sous forme de tableau de décimal
	 * @param mask: masque de l'adresse 
	 */
	public AdresseIpV4(int [] mots, int [] mask){
		if(Format.isFormatDec(mots)){
			this.octets = mots;
			this.setMask(mask);
		}
	}
	
	public AdresseIpV4(String adr){
		this(Format.stringSepToDec(adr, "."));
	}
	
	public AdresseIpV4(String adr, String mask){
		this(Format.stringSepToDec(adr, "."), Format.stringSepToDec(mask, "."));
	}
	
	public AdresseIpV4(String adr, int cidr){
		this(Format.stringSepToDec(adr, "."), AdresseIpV4.convertCIDRToMask(cidr));
	}
	
	public static AdresseIpV4 agrege(AdresseIpV4 adr []){
		return null;
	}
	
	/**
	 * Donne la classe de l'adresse
	 * @return char:la classe de l'adresse sous forme de caractere
	 */
	public char getClasse(){
		if(this.octets[3]>=0 && this.octets[3]<=127) return 'A';
		else if(this.octets[3]>=128 && this.octets[3]<=191) return 'B';
		else if(this.octets[3]>=192 && this.octets[3]<=223) return 'C';
		else if(this.octets[3]>=224 && this.octets[3]<=239) return 'D';
		else if(this.octets[3]>=240 && this.octets[3]<=255) return 'E';
		else return '0';
	}
	
	public int [] getMask(){
		return this.mask;
	}
	
	/**
	 * Donne le masque par défaut de l'adresse 
	 * @return
	 */
	public int [] getMaskParDefaut(){
		char classe = this.getClasse();
		int mask [] = {0,0,0,0};
		if(classe=='A') mask[3]=255;
		if(classe=='B') {
			mask[3]=255;
			mask[2]=255;
		}else if(classe=='C'){
			mask[3]=255;
			mask[2]=255;
			mask[1]=255;
		}else if(classe=='D'){
			
		}
		
		return mask;
	}

	public int getMaskCIDR(){
		return AdresseIpV4.convertMaskToCIDR(this.mask);
	}
	
	public String getFormatCIDR(){
		return Format.toString(this.octets,".")+"/"+this.getMaskCIDR();
	}

	
	public AdresseIpV4 getAdresseReseau(){
		return null;
	}
	
	public AdresseIpV4 getAdresseBroadcast(){
		return null;
	}
	
	/**
	 * Verifier si le masque est un bon masque
	 * @param mask
	 * @return
	 */
	public static boolean isBonMask(int mask []){
		if(mask.length==4){
			if(mask[3]==255){
				if(mask[2]==255){
					if(mask[1]==255){
						return true;
					}else{
						if(mask[0]==0) return true;
						else return false;
					}
				}else{
					if(mask[1]==0 && mask[0]==0) return true;
					else return false;
				}
			}else{
				if(mask[2]==0 && mask[1]==0 && mask[0]==0) return true;
				else return false;
			}
			
		}else{
			return false;
		}
	}
	
	public boolean isAdresseReseau(){
		return false;
	}
	public boolean isAdresseBrodcast(){
		return false;
	}
	
	/**
	 * <p>Modifie le masque de l'adresse</p>
	 * @param mask
	 */
	public void setMask(int mask []){
		if(Format.isFormatDec(mask)){ //verifier si le mask est correcte
			this.mask = mask;
		}else{
			this.mask = this.getMaskParDefaut();
		}
	}
	
	public static AdresseIpV4 [] segmente(AdresseIpV4 adr){
		return null;
	}
	
	public static AdresseIpV4 [] segmente(String adr){
		return null;
	}
	
	public static int [] convertCIDRToMask(int cidr){ 
		return AdresseIpV4.convertCIDRToMask(cidr, 4, 8); //masque pour une adresse IPV4
	}
	
	
	/**
	 * Convertir un masque CIDR en masque normal
	 * @param cidr
	 * @param lng
	 * @param pas
	 * @return
	 */
	public static int [] convertCIDRToMask(int cidr, int lng, int pas){ 
		if(cidr>lng*pas){
			return null;
		}else{
			int mask [] = new int [lng];
			for(int i=0; i<lng; i++){
				if(i<cidr/pas) mask[lng-1-i] = 255;
				else if(i==cidr/pas) mask[lng-1-i] = (int) (256-Math.pow(2, pas-cidr%pas));
				else mask[lng-1-i]=0;
			}
			return mask;
		}
	}
	
	public static int convertMaskToCIDR(String mask, String regex){
		return AdresseIpV4.convertMaskToCIDR(Format.stringSepToDec(mask, regex));
	}
	
	public static int convertMaskToCIDR(int [] mask){
		if(AdresseIpV4.isBonMask(mask)){
			int res=0;
			for(int i:mask){
				if(i==255) res += 8;
				if(i!=255) res += 8-Format.toString(Format.decToBin(255-i)).length();
			}
			
			return res;
		}else return -1;
	}
	
	
	public static void main(String agrs []){
		AdresseIpV4 adr = new AdresseIpV4("192.168.1.10", "255.255.255.192");
		System.out.println("format CIDR "+Format.toString(AdresseIpV4.convertCIDRToMask(13),"."));
	}
	
}
