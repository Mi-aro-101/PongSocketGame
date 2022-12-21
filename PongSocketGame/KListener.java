package mpihaino;

import java.awt.event.*;
import java.awt.*;
import assets.*;

public class KListener implements KeyListener {
	Table field;

	//Overrinding method
	public void keyPressed(KeyEvent e){
		if(e.getKeyChar() == 'w'){
			// if(getField().getPlayer().getY() > 0){
				getField().getPlayer().setUp(true);
			// }
		}
		if(e.getKeyChar() == 's'){
			// if(getField().getPlayer().getY() < 425){
				getField().getPlayer().setDown(true);
			// }
		}
			System.out.println(getField().getPlayer().getY());
	}

	public void keyReleased(KeyEvent e){
		if(e.getKeyChar() == 'w'){
			getField().getPlayer().setUp(false);
		}
		if(e.getKeyChar() == 's'){
			getField().getPlayer().setDown(false);
		}
	}

	public void keyTyped(KeyEvent e){
		// if(e.getKeyChar() == 'p'){
		// 	Table.setPlay(true);
		// 	Ball.setxBallVelocity(1);
		// 	Ball.setyBallVelocity(1);
		// }
	}

	//Constructor
	public KListener(Table T){
		setField(T);
	}

	//Getters
	public Table getField(){return field;}

	//Setters
	public void setField(Table T){field = T;}
}