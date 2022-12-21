package assets;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import client.*;
import wera.*;

import display.*;

public class Table extends JPanel{
	int width, height;
	Racket Player;
	Racket Player2;
	PlayerFrame Fenetre;
	int IdPlayer;
	Socket clientSocket;
	Ball PongBall;

	//Server Interaction
	ReadFromServer RFServer;
	WriteToServer WTServer;

	int Owner = 0;

	PanelString pS;

	static boolean Play = false;

	//Connection to server
	public void connectToServer(){
		try {
			setClientSocket(new Socket("localhost", 3133));
			DataInputStream in = new DataInputStream(getClientSocket().getInputStream());
			DataOutputStream out = new DataOutputStream(getClientSocket().getOutputStream());
			
			setIdPlayer(in.readInt());
			
			System.out.println("Ianao ny mpilalao laharana : "+getIdPlayer());

			if(getIdPlayer() == 1){
				System.out.println("Endraso ny sasany");
			}

			setRFServer(new ReadFromServer(in, this));
			setWTServer(new WriteToServer(out, this));

			getRFServer().waitMsgStart();

		} catch (Exception e){e.printStackTrace();}
	}

	//SetUp the field and instanciate the player
	public void paint(Graphics g){
	//Painting the green field
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, getwidth(), getheight());

		getpS().paintString(g);
		
		getPongBall().paintBall(g);
		if(getPongBall().getXBall() == 0){
			if(getOwner()==1){
				getPlayer().setScore(getPlayer().getScore() + 1);
				getPongBall().setYBall(1);
				getPongBall().setXBall(1);
			}
			else if(getOwner()==2){
				getPlayer2().setScore(getPlayer2().getScore() + 1);
				getPongBall().setYBall(1);
				getPongBall().setXBall(1);
			}
		}

		// System.out.print(getPongBall().getXBall());
		// System.out.println(getOwner());
		
		Graphics2D g2D = (Graphics2D)g;
		getPlayer().drawRacket(g2D);
		getPlayer2().drawRacket(g2D);

		
		//Painting the Player (racket);

		repaint();

	}

	//Create Player Racket
	public void CreateRacket(){
		connectToServer();
		if(getIdPlayer() == 1){
			setPlayer(new Racket(0, 200, 30, Color.BLUE));
			setPlayer2(new Racket(570,200, 30, Color.RED));
		}
		else{
			setPlayer2(new Racket(570, 200, 30, Color.RED));
			setPlayer(new Racket(0, 200, 30, Color.BLUE));
		}
	}

	//Create Ball
	public void CreateBall(){
		setPongBall(new Ball(this));

		Ball.setxBallVelocity(0);
		Ball.setyBallVelocity(0);
	}
	
	//Constructor
	public Table(PlayerFrame P){
		setFenetre(P);
		setpS(new PanelString(this));
		setwidth(getFenetre().getwidth());
		setheight(getFenetre().getheight());
		CreateBall();
		CreateRacket();
	}

	//Getters
	public int getwidth(){return width;}

	public int getheight(){return height;}

	public PlayerFrame getFenetre(){return Fenetre;}

	public Racket getPlayer(){return Player;}

	public Racket getPlayer2(){return Player2;}

	public int getIdPlayer(){return IdPlayer;}

	public Socket getClientSocket(){return clientSocket;}

	public ReadFromServer getRFServer(){return RFServer;}

	public WriteToServer getWTServer(){return WTServer;}

	public Ball getPongBall(){return PongBall;}

	public static boolean getPlay(){return Table.Play;}

	public int getOwner(){return Owner;}

	public PanelString getpS(){return pS;}

	//Setters
	public void setwidth(int W){width = W;}

	public void setheight(int H){height = H;}

	public void setFenetre(PlayerFrame Pf){Fenetre = Pf;}

	public void setPlayer(Racket P){Player = P;}

	public void setPlayer2(Racket player2){Player2 = player2;}

	public void setIdPlayer(int idPlayer){IdPlayer = idPlayer;}

	public void setClientSocket(Socket clientSocket){this.clientSocket = clientSocket;}

	public void setRFServer(ReadFromServer rFServer){RFServer = rFServer;}

	public void setWTServer(WriteToServer wTServer){WTServer = wTServer;}

	public void setPongBall(Ball pongBall){PongBall = pongBall;}

	public static void setPlay(boolean play){Table.Play = play;}

	public void setOwner(int o){Owner = o;}

	public void setpS(PanelString PS){pS = PS;}
}