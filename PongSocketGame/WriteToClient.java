package server;

import java.io.DataOutputStream;

import server.GameServer;
import assets.*;

public class WriteToClient implements Runnable{
    int IdPlayer;
    DataOutputStream DatOut;
    GameServer OurServer;

    //Override
    public void run(){
        try {
            while(true){
                if(getIdPlayer() == 1){
                    getDatOut().writeDouble(getOurServer().getP2X());
                    getDatOut().writeDouble(getOurServer().getP2Y());
                    getDatOut().flush();
                }
                else if(getIdPlayer() == 2){
                    getDatOut().writeDouble(getOurServer().getP1X());
                    getDatOut().writeDouble(getOurServer().getP1Y());
                    getDatOut().flush();
                }

                // if(Table.getPlay() == true){
                    getDatOut().writeDouble(getOurServer().getxBall()+Ball.getxBallVelocity());
                    getDatOut().writeDouble(getOurServer().getyBall()+Ball.getyBallVelocity());
                    getDatOut().flush();
                // }

                try {
                    Thread.sleep(3);
                } catch (InterruptedException ew) {
                    ew.printStackTrace();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setMsgStart(){
        try {
            getDatOut().writeUTF("Atomboy amin'izay");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Constructor
    public WriteToClient(GameServer Gs, int idP, DataOutputStream dtout){
        setIdPlayer(idP);
        setDatOut(dtout);
        setOurServer(Gs);

        System.out.println("Runnable (Write) created for : "+getIdPlayer());
    }

    //Getters
    public int getIdPlayer(){return IdPlayer;}

    public DataOutputStream getDatOut(){return DatOut;}

    public GameServer getOurServer() {return OurServer;}

    //Setters
    public void setIdPlayer(int idPlayer){IdPlayer = idPlayer;}

    public void setDatOut(DataOutputStream DatOut){this.DatOut = DatOut;}

    public void setOurServer(GameServer ourServer){OurServer = ourServer;}
}
