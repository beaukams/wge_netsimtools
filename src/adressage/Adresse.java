package adressage;

public abstract class Adresse {
	private byte mot[];
	private int mask;
	
	/**
	 * 
	 * @param mot: les octets de l'adresse
	 */
	public Adresse(byte [] mot){
		this.mot = mot;
	}
	
	/**
	 * 
	 * @param mot : les octets de l'adresse
	 * @param mask : le masque
	 */
	public Adresse(byte [] mot, int mask){
		this.mot = mot;
		this.mask = mask;
	}
	
	/**
	 * 
	 * @param adresse: adresse donnée sous forme de chaîne
	 */
	public Adresse(String adresse){
		
	}
	
	
	/**
	 * 
	 * @param adresse: adresse donnée sous forme de chaîne
	 */
	public Adresse(String adresse, int mask){
		
	}
	
	/**
	 * 
	 * @return les octets de l'adresse
	 */
	public byte [] getAdresseByte(){
		return this.mot;
	}
	
	/**
	 * 
	 * @return le mask associé
	 */
	public int getMask(){
		return this.mask;
	}
	
	
	public void setAdresseByte(byte [] add){
		this.mot = add;
	}
	public void setAdresseByte(byte add, int index){
		this.mot[index] = add;
	}
	public void setMask(int mask){
		this.mask = mask;
	}
	
	/**
	 * 
	 * @return Nom DNS de l'hote
	 */
	public abstract Adresse getHote();
	
	/**
	 * 
	 * @return Nom de l'hote
	 */
	public abstract Adresse getNom();
	
	/**
	 * 
	 * @return l'adresse Réseau du réseau de l'hôte
	 */
	public abstract Adresse getAdresseReseau();
	
	/**
	 * 
	 * @return l'adresse Broadcast du réseau de l'hôte
	 */
	public abstract Adresse getAdresseBroadcast();
	
	/**
	 * @return l'adresse sous forme de chaîne
	 */
	public abstract String toString();
	
	
	/**
	 * 
	 * @return l'adresse sous forme hexadecimal
	 */
	public abstract String getAdresseHex();
	
	/**
	 * 
	 * @return l'adresse sous forme décimal
	 */
	public abstract String getAdresseDec();
	
	/**
	 * 
	 * @return l'adresse sous forme binaire
	 */
	public abstract String getAdresseBin();
	
	
}
