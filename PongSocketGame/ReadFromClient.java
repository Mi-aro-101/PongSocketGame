package server;

import java.io.DataInputStream;
import assets.*;

public class ReadFromClient implements Runnable{
    int IdPlayer;
    DataInputStream datIn;
    GameServer OurServer;

    //Override
    public void run(){
        try {
            while(true){
                if(getIdPlayer() == 1){
                    getOurServer().setP1X(getDatIn().readDouble());
                    getOurServer().setP1Y(getDatIn().readDouble());
                }
                else if(getIdPlayer() == 2){
                    getOurServer().setP2X((getDatIn().readDouble()));
                    getOurServer().setP2Y(getDatIn().readDouble());
                }

                getOurServer().setxBall(getDatIn().readDouble());
                getOurServer().setyBall(getDatIn().readDouble());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Constructor
    public ReadFromClient(GameServer Gs, int idP, DataInputStream dtIn){
        setIdPlayer(idP);
        setDatIn(dtIn);
        setOurServer(Gs);
        System.out.println("Runnable (Read) created for : "+getIdPlayer());
    }

    //Getters
    public int getIdPlayer(){return IdPlayer;}

    public DataInputStream getDatIn(){return datIn;}

    public GameServer getOurServer(){return OurServer;}

    //Setters
    public void setIdPlayer(int idPlayer){IdPlayer = idPlayer;}

    public void setDatIn(DataInputStream datIn){this.datIn = datIn;}

    public void setOurServer(GameServer ourServer){OurServer = ourServer;}
}
