package adressage;

import netutils.*;

public class AdresseIpV6 {
	
	private int octets [] = new int [16]; 
	private int mask = 64;
	
	private AdresseIpV6(int mots []){
		this.octets = mots;
	}
	private AdresseIpV6(int mots [], int  maskCidr){
		this.octets = mots;
		this.mask = maskCidr;
	}
	
	public AdresseIpV6(char [] mots){
		
		for(int i=0; i<mots.length; i+=4){
			char tab [] = {mots[i],mots[i+1],mots[i+2],mots[i+3]};
			this.octets[i/4] = Format.hexToDec(tab);
		}
	}
	
	public AdresseIpV6(char [] mots, int mask){
		
		for(int i=0; i<mots.length; i+=2){
			char tab [] = {mots[i],mots[i+1]};
			this.octets[i/2] = Format.hexToDec(tab);
		}
	}
	
	public AdresseIpV6(char [][] mots){
		
		this.octets = Format.hexToDec(mots);
	}
	
	public AdresseIpV6(char [][] mots, int maskCidr){
		
		for(int i=0; i<mots.length; i++){
			this.octets[i] = Format.hexToDec(mots[i]);
		}
		this.mask = maskCidr;
	}
	
	public AdresseIpV6(String adr){
		this(Format.stringSepToHex(adr, ":"));
	}
	
	
	
	public AdresseIpV6(String adr, int maskCidr){
		this(Format.stringSepToHex(adr, ":"), maskCidr);
	}
	
	public String analyseAdresseIpV6(String adr){
		return null;
	}
	
	public String getFormatCIDR(){
		return Format.toString(this.octets,":")+"/"+this.mask;
	}
	
	public String getFormeSimplifie(){
		
		if(AdresseIpV6.zeroConsecutifs(this.octets)>1){
			int mots [] = this.octets;
			
			String res = "";
			
			for(int i=0; i<mots.length; i++){
				
				if(i<AdresseIpV6.zeroPremier(mots) || i>AdresseIpV6.zeroDernier(mots)){
					res += Format.toString(Format.decToHex(mots[i]));
					//System.out.println(mots[i]+"--"+zeroConsecutifs(mots)+"---"+AdresseIpV6.zeroPremier(mots)+"--"+AdresseIpV6.zeroDernier(mots));
					if(i != (mots.length-1)){
						res += ":";
					}
				}else if(i>=AdresseIpV6.zeroPremier(mots) && i<=AdresseIpV6.zeroDernier(mots)){
					if(i==AdresseIpV6.zeroPremier(mots)) res += ":";
				}
				
			}
			
			return Format.toString(Format.renverserTableau(Format.stringSepToHex(res, ":")), ":");
			
		}else return Format.toString(Format.decToHex(this.octets),":");
		
		
	}
	
	
	
	/**
	 * Compte le nombre maximal de 0 successifs
	 * @param tab
	 * @return 
	 */
	public static int zeroConsecutifs(int tab []){
		int contZero=0, ancien=0;
		for(int i=0; i<tab.length; i++){
			if(tab[i] == 0){
				contZero++;
			}else if(tab[i]!=0 || i==(tab.length-1)){
				if(contZero>ancien){
					ancien = contZero;
					contZero = 0;
				}
			}
		}
		
		return ancien;
	}
	
	/**
	 * Determine l'index du premier chiffre de la séquence de 0 la plus longue
	 * @param tab
	 * @return
	 */
	public static int zeroPremier(int tab []){
		if(zeroConsecutifs(tab)==0) return -1;
		else{
			int res=-1;
			for(int i=0; i<tab.length; i++){
				if(tab[i] == 0){
					for(int j=i+1; j<i+zeroConsecutifs(tab); j++){ //verifier que i est le premier
						if(tab[j] != 0){
							break;
						}
						if(j == i+zeroConsecutifs(tab)-1) res = i;
					}
				}
			}
			return res;
		}
	}
	
	public static int zeroDernier(int tab []){
		if(zeroConsecutifs(tab) == 0) return -1;
		else{
			return zeroConsecutifs(tab)+zeroPremier(tab)-1;
		}
	}
	
	
	public static void main(String args []){
		AdresseIpV6 ip = new AdresseIpV6("4534:0000:0000:fff4:ff45:0000:0000:78c9");
		System.out.println("adresse 4534:0000:fff4:ff45:0000:0000:0000:78c9 ->\nforme simple "+Format.toString(ip.octets,":"));
		System.out.println("Adresse "+ip.getFormeSimplifie());
	}
	
}
