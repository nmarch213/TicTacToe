package tittactoe;

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Nick
 */
public class GameService implements Runnable
{
    private Socket s;
    private Scanner in;
    private PrintWriter out;
    private TTTGame game;
    
    public GameService(Socket aSocket, TTTGame aGame)
    {
        s = aSocket;
        game = aGame;
    }

    @Override
    public void run() 
    {
        try
        {
            try
            {
                in = new Scanner(s.getInputStream());
                out = new PrintWriter(s.getOutputStream());
                //doService();
            }
            finally
            {
                s.close();
            }
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }
    
    public void checkForInput(Scanner in, PrintWriter out)
    {
        
    }

}
