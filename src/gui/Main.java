package gui;

import javax.swing.*;


public class Main{
	public Main(String titre){
		super();
	}
	
	public static void main(String rgs []){
		
	}
}

class IHM extends JFrame{
	public IHM(String titre){
		super(titre);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	public  IHM(String titre, int width, int height){
		super(titre);
		this.setSize(width, height);
		this.setVisible(true);
	}
}
