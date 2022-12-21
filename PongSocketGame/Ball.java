package assets;

import javax.swing.JPanel;

import assets.Table;

import java.awt.*;

import display.*;

public class Ball extends JPanel {
 double XBall, YBall, Radius;
 static double xBallVelocity = 0, yBallVelocity = 0;
 Table Window;

    //Ball Moovement
    public void BallMoov(){
        checkOwner();
        if(getXBall() >= getWindow().getFenetre().getwidth()-70 && getXBall() < getWindow().getFenetre().getwidth()){
            Ball.setxBallVelocity(-1);
        }
        if(getYBall() >= getWindow().getFenetre().getheight()-70 && getYBall() < getWindow().getFenetre().getheight()){
            Ball.setyBallVelocity(-1);
        }
        if(getXBall() == 0){
            Ball.setxBallVelocity(1);
        }
        else if(getYBall() == 0){
            Ball.setyBallVelocity(1);
        }
    }

    public void checkOwner(){
        if(getXBall()>0 && getXBall()<=getWindow().getPlayer().getX()+getWindow().getPlayer().getRadius() && getYBall()>getWindow().getPlayer().getY()-getWindow().getPlayer().getRadius() && getYBall()<getWindow().getPlayer().getY()+getWindow().getPlayer().getRadius()){
            getWindow().setOwner(1);
            Ball.setxBallVelocity(1);
        }
        else if(getXBall()>0 && getXBall()<=getWindow().getPlayer2().getX()+getWindow().getPlayer2().getRadius() && getYBall()>getWindow().getPlayer2().getY()-getWindow().getPlayer2().getRadius() && getYBall()<getWindow().getPlayer2().getY()+getWindow().getPlayer2().getRadius()){
            getWindow().setOwner(2);
            Ball.setxBallVelocity(1);
        }
    }

    public void paintBall(Graphics g){
        g.setColor(Color.WHITE);
        int x = (int)getXBall();
        int y = (int)getYBall();
        BallMoov();
        g.fillOval(x, y, (int)getRadius(), (int)getRadius());
    }

    //Movement
    public void MoveX(){
        setXBall(getXBall()+Ball.getxBallVelocity());
    }

    public void MoveY(){
        setYBall(getYBall()+Ball.getyBallVelocity());
    }

    // Constructor
    public Ball(Table tbl){
        setWindow(tbl);
        setRadius(30);
    }

    //Getters
    public double getXBall(){return XBall;}

    public double getYBall(){return YBall;}

    public Table getWindow(){return Window;}

    public double getRadius(){return Radius;}

    public static double getxBallVelocity(){return xBallVelocity;}

    public static double getyBallVelocity(){return yBallVelocity;}

    //Setters
    public void setXBall(double xBall){XBall = xBall;}

    public void setYBall(double yBall){YBall = yBall;}

    public void setWindow(Table window){Window = window;}

    public void setRadius(double radius){Radius = radius;}

    public static void setxBallVelocity(double XBallVelocity){xBallVelocity = XBallVelocity;}

    public static void setyBallVelocity(double YBallVelocity){yBallVelocity = YBallVelocity;}
}