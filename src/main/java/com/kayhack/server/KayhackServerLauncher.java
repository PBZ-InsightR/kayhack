package com.kayhack.server;


import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;

public class KayhackServerLauncher extends Component {
    private static final int PORT = 8082;


    public KayhackServerLauncher() {
        Server server = new Server(Protocol.HTTP, PORT);
        getServers().add(server);
        getDefaultHost().attachDefault(new KayHackApplication());
        System.out.printf("Server started on port %s.\n", PORT);
    }

    public static void main(String[] args) throws Exception {
        new KayhackServerLauncher().start();
    }
}