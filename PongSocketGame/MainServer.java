package show;

import server.*;

public class MainServer {
    public static void main(String[] args) {
        GameServer Gs = new GameServer();
        Gs.acceptConnection();
    }
}
