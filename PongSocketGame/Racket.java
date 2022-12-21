package assets;

import java.awt.*;
import java.awt.geom.*;

public class Racket{
	double x, y, radius;
	Color color;
	int Score = 0;

//For player Movement
	boolean up, down;

	public void drawRacket(Graphics2D g){
		Rectangle2D.Double rack = new Rectangle2D.Double(getX(), getY(), getRadius()-10, getRadius());
		g.setColor(getcolor());
		g.fill(rack); 
	}

	public void moveX(double n){
		setX(getX() + n);
	}

	public void moveY(double n){
		setY(getY() + n);
	}

	public Racket(double a, double b, double r, Color c){
		setX(a);
		setY(b);
		setRadius(r);
		setcolor(c);
		setUp(false);
		setDown(false);
	}

	//Getters
	public double getX(){return x;}

	public double getY(){return y;}

	public double getRadius(){return radius;}

	public Color getcolor(){return color;}

	public boolean getUp(){return up;}

	public boolean getDown(){return down;}

	public int getScore(){return Score;}

	//Setters
	public void setX(double X){x = X;}

	public void setY(double Y){y = Y;}

	public void setRadius(double R){radius = R;}

	public void setcolor(Color c){color = c;}

	public void setUp(boolean u){up = u;}

	public void setDown(boolean d){down = d;}

	public void setScore(int score){Score = score;}
}