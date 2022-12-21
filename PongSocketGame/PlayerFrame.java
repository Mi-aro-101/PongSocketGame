package display;

import javax.swing.*;
import assets.*;
import mpihaino.*;

public class PlayerFrame extends JFrame{
	int width, height;

//Assets
	Table field;

//for Action Listener, quand on maintient le bouton
	int interval = 10;
	Timer animationTimer;

	//Displaying the Frame to the screen
	public void Display(){
		setTitle("Player "+getField().getIdPlayer());
		setResizable(false);
		setSize(getwidth(), getheight());

		add(getField());
		setUpAnimation();
		setUpKeyListener();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	//Animation timer, quand on maintient le bouton lorsqu'on est en mouvement
	public void setUpAnimation(){
		ActListener actList = new ActListener(this);
		setanimationTimer(new Timer(getInterval(), actList));
		getanimationTimer().start();
	}

	public void setUpKeyListener(){
		KListener Kl = new KListener(getField());
		setFocusable(true);
		addKeyListener(Kl);
	}

	//Constructor
	public PlayerFrame(int W, int H){
		setwidth(W);
		setheight(H);
		setField(new Table(this));
		System.out.println("Ity ny Table an iray "+getField());
	}

	//Getters
	public int getwidth(){return width;}

	public int getheight(){return height;}

	public Table getField(){return field;}

	public int getInterval(){return interval;}

	public Timer getanimationTimer(){return animationTimer;} 

	//Setters
	public void setwidth(int W){width = W;}

	public void setheight(int H){height = H;}

	public void setField(Table t){field = t;}

	public void setInterval(int I){interval = I;}

	public void setanimationTimer(Timer T){animationTimer = T;}
}