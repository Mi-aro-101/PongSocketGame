package wera;

import javax.swing.*;
import assets.*;
import java.awt.*;

public class PanelString extends JPanel {
	Table Principal;

	//Constructor
	public PanelString(Table table){
		setPrincipal(table);
	}

	public void paintString(Graphics g){
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString("Izaho : "+getPrincipal().getPlayer().getScore(), 170, 50);
		g.drawString("Adve : "+getPrincipal().getPlayer2().getScore(), 370, 50);
	}

	//Getters
	public Table getPrincipal(){return Principal;}

	//Setters
	public void setPrincipal(Table principal){Principal = principal;}
}