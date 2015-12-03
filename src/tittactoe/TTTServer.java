package tittactoe;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Nick
 */
public class TTTServer {
    public static void main(String[] args) throws IOException
    {
        final int TOTAL_PLAYERS = 2;
        TTTGame game = new TTTGame(TOTAL_PLAYERS);
        final int SBAP_PORT = 8888;
        ServerSocket server = new ServerSocket(SBAP_PORT);
        System.out.println("Waiting for players to join...");
        
        while(true)
        {
            Socket s = server.accept();
            System.out.println("Player has joined the game!");
            GameService service = new GameService(s,game);
            Thread t = new Thread(service);
            t.start();
        }
    }

}
