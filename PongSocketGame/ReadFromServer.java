package client;

import java.io.DataInputStream;

import assets.*;
import server.GameServer;

public class ReadFromServer implements Runnable{
    DataInputStream DatIn;
    Table Principal;

    //Override
    public void run(){
        try {
            
            while(true){
                getPrincipal().getPlayer2().setX(getDatIn().readDouble());
                getPrincipal().getPlayer2().setY(getDatIn().readDouble());
                
                getPrincipal().getPongBall().setXBall(getDatIn().readDouble());
                getPrincipal().getPongBall().setYBall(getDatIn().readDouble());
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void waitMsgStart(){
        try {
            String On = getDatIn().readUTF();
            System.out.println("Server : "+On);

            Thread read = new Thread(getPrincipal().getRFServer());
            Thread write = new Thread(getPrincipal().getWTServer());
            read.start();   
            write.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Constructor
    public ReadFromServer(DataInputStream dtin, Table tbl){
        setDatIn(dtin);
        setPrincipal(tbl);
        System.out.println("Runnable (read) Server created");
    }

    //Getter
    public DataInputStream getDatIn(){return DatIn;}

    public Table getPrincipal(){return Principal;}

    //Setter
    public void setDatIn(DataInputStream datIn){DatIn = datIn;}

    public void setPrincipal(Table principal){Principal = principal;}
}
