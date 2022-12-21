package mpihaino;

import java.awt.event.*;
import java.awt.*;
import assets.*;
import display.PlayerFrame;

public class ActListener implements ActionListener{
	PlayerFrame Principal;

	//Override Method
	public void actionPerformed(ActionEvent e){
		double speed = 3;
		if(getPrincipal().getField().getPlayer().getUp() && getPrincipal().getField().getPlayer().getY() > 0){
			getPrincipal().getField().getPlayer().moveY(-speed);
			getPrincipal().repaint();
		}
		else if(getPrincipal().getField().getPlayer().getDown() && getPrincipal().getField().getPlayer().getY() < 425){
			getPrincipal().getField().getPlayer().moveY(speed);
			getPrincipal().repaint();
		}
	}

	//Constructor
	public ActListener(PlayerFrame P){
		setPrincipal(P);
	}

	//Getters
	public PlayerFrame getPrincipal(){return Principal;}

	//Setters
	public void setPrincipal(PlayerFrame T){Principal = T;}
}