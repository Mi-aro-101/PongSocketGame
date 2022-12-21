package client;

import java.io.DataOutputStream;

import assets.*;

public class WriteToServer implements Runnable {
    DataOutputStream Datout;
    Table Principal;

    //Override
    public void run(){
        try {
            
            while(true){
                getDatout().writeDouble(getPrincipal().getPlayer().getX());
                getDatout().writeDouble(getPrincipal().getPlayer().getY());

                getDatout().writeDouble(getPrincipal().getPongBall().getXBall()+Ball.getxBallVelocity());
                getDatout().writeDouble(getPrincipal().getPongBall().getYBall()+Ball.getyBallVelocity());
                getDatout().flush();
                try {
                    Thread.sleep(3);
                } catch (InterruptedException ew){ew.printStackTrace();}
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Constructor
    public WriteToServer(DataOutputStream dtout, Table tbl){
        setDatout(dtout);
        setPrincipal(tbl);
        System.out.println("Runnable (write) Server created");
    }

    //Getters
    public DataOutputStream getDatout(){return Datout;}

    public Table getPrincipal(){return Principal;}

    //Setters
    public void setDatout(DataOutputStream datout){Datout = datout;}

    public void setPrincipal(Table principal){Principal = principal;}
}
