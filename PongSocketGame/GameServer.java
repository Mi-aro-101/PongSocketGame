package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import assets.*;

import server.ReadFromClient;

public class GameServer{
    ServerSocket serverSocket;
    int numPlayer;
    int nbrPlayer;

    //For Clients
    Socket P1Socket;
    Socket P2Socket;
    ReadFromClient P1ReadRunnable;
    ReadFromClient P2ReadRunnable;
    WriteToClient P1WriteRunnable;
    WriteToClient P2WriteRunnable;

    //Coordinate to read
    double P1Y, P1X, P2X, P2Y;
    double xBall, yBall;

    //Accepting Connection from client
    public void acceptConnection(){
        try {
            System.out.println("Miandry mpiditra");

            while(getNumPlayer() < getNbrPlayer()){
                Socket clientSocket = getServerSocket().accept();
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                setNumPlayer(getNumPlayer() + 1);
                out.writeInt(getNumPlayer());
                System.out.println("Player : "+getNumPlayer()+" has joined");

                ReadFromClient RFClient = new ReadFromClient(this, getNumPlayer(), in);
                WriteToClient WFClient = new WriteToClient(this, getNumPlayer(), out);

                if(getNumPlayer() == 1){
                    setP1Socket(clientSocket);
                    setP1ReadRunnable(RFClient);
                    setP1WriteRunnable(WFClient);
                }
                else if(getNumPlayer() == 2){
                    setP2Socket(clientSocket);
                    setP2ReadRunnable(RFClient);
                    setP2WriteRunnable(WFClient);
                    getP1WriteRunnable().setMsgStart();
                    getP2WriteRunnable().setMsgStart();

                    Thread read1 = new Thread(getP1ReadRunnable());
                    Thread read2 = new Thread(getP2ReadRunnable());
                    read1.start();
                    read2.start();

                    Thread write1 = new Thread(getP1WriteRunnable());
                    Thread write2 = new Thread(getP2WriteRunnable());
                    write1.start();
                    write2.start();
                }
            }
        } catch (Exception e) {e.printStackTrace();}
    }

    //Constructor
    public GameServer(){
        setNumPlayer(0);
        setNbrPlayer(2);


        setP1X(0);
        setP1Y(200);

        setP2X(570);
        setP2Y(200);

        setxBall(0);
        setyBall(0);

        // Ball.setxBallVelocity(1);
        // Ball.setyBallVelocity(1);
        
        try {
            setServerSocket(new ServerSocket(3133));
        } catch (Exception e) {e.printStackTrace();}
    }

//Getters
    public ServerSocket getServerSocket(){return serverSocket;}

    public int getNumPlayer(){return numPlayer;}

    public int getNbrPlayer(){return nbrPlayer;}

    public Socket getP1Socket(){return P1Socket;}

    public Socket getP2Socket(){return P2Socket;}

    public ReadFromClient getP1ReadRunnable(){return P1ReadRunnable;}

    public ReadFromClient getP2ReadRunnable(){return P2ReadRunnable;}

    public WriteToClient getP1WriteRunnable(){return P1WriteRunnable;}

    public WriteToClient getP2WriteRunnable(){return P2WriteRunnable;}

    public double getP1X(){return P1X;}

    public double getP1Y(){return P1Y;}
    
    public double getP2X(){return P2X;}
    
    public double getP2Y(){return P2Y;}

    public double getxBall(){return xBall;}

    public double getyBall(){return yBall;}

//Setters
    public void setServerSocket(ServerSocket serverSocket){this.serverSocket = serverSocket;}

    public void setNumPlayer(int numPlayer){this.numPlayer = numPlayer;}

    public void setNbrPlayer(int nbrPlayer){this.nbrPlayer = nbrPlayer;}

    public void setP1Socket(Socket p1Socket){P1Socket = p1Socket;}

    public void setP2Socket(Socket p2Socket){P2Socket = p2Socket;}

    public void setP1ReadRunnable(ReadFromClient p1ReadRunnable){P1ReadRunnable = p1ReadRunnable;}

    public void setP2ReadRunnable(ReadFromClient p2ReadRunnable){P2ReadRunnable = p2ReadRunnable;}

    public void setP1WriteRunnable(WriteToClient p1WriteRunnable){P1WriteRunnable = p1WriteRunnable;}

    public void setP2WriteRunnable(WriteToClient p2WriteRunnable){P2WriteRunnable = p2WriteRunnable;}

    public void setP1Y(double p1y){P1Y = p1y;}

    public void setP2Y(double p2y){P2Y = p2y;}

    public void setP1X(double p1x){P1X = p1x;}

    public void setP2X(double p2x){P2X = p2x;}

    public void setxBall(double xBall){this.xBall = xBall;}

    public void setyBall(double yBall){this.yBall = yBall;}
}
