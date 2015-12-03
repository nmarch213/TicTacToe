package tittactoe;



/**
 *
 * @author Nick
 */
public class TTTGame {
    
    private int playerTurn;
    private final int numberOfPlayers;
    public char[][] gameBoard = {{'-', '-', '-'},{'-', '-', '-'},{'-', '-', '-'}};
    private boolean winner = false;

    
    public TTTGame(int TOTAL_PLAYERS)
    {
        numberOfPlayers = TOTAL_PLAYERS;
        playerTurn = 1;
    }
    
    public int whoseTurn()
    {       
        return playerTurn;
    }
    
    public void endTurn(int playerID)
    {
        switch (playerID) {
            case 1:
                System.out.println("Player 1's turn is now over.");
                playerTurn = 2;
                break;
            case 2:
                System.out.println("Player 2's turn is now over.");
                playerTurn = 1;
                break;
            default:
                System.out.println("Invalid player number. Try again with either player 1 or 2.");
                break;
        }
    }
    
    public void makeMove(int player, int row, int column)
    {
        if(row < 0 || row > 2)
        {
            System.out.println("Row out of Range. Try Again");
        }
        else if(column < 0 || column > 2)
        {
            System.out.println("Column out of Range. Try Again");
        }
        else if(whoseTurn() != player)
        {
            System.out.println("It is currently not your turn.");
        }
        else
        {
            if(gameBoard[row][column] == '-')
            {
                char symbol = getSymbol(player);               
                gameBoard[row][column] = symbol;
                if(checkWinner())
                {
                    System.out.print("Player " +player + " has won! A new game will begin.");
                }
                checkWinner();
                printBoard();
                endTurn(player);
                
            }
            else
            {
                System.out.println("Space has already been taken! Try again");
            }
        }
    }
    
    public char getSymbol(int player)
    {
        char symbol;
        
        if(player == 1)
        {
            symbol = 'X';
        }
        else
        {
            symbol = 'O';
        }
        
        return symbol;
    }
    
    public boolean checkWinner()
    {
        boolean isWinner = false;
        
         for (int i = 0; i <= 2; i++)
        {
            if ((gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2]) && gameBoard[i][2] != '-') 
                isWinner = true;
        }

         // checks the contents of each column for matching data
         // X
         // X
         // X
        for (int j = 0; j <= 2; j++)
        {
            if ((gameBoard[0][j] == gameBoard[1][j] && gameBoard[1][j] == gameBoard[2][j]) && gameBoard[2][j] != '-') 
                isWinner = true;
        }

        // checks the contents of one diagonal for matching data
        //X
        //  X
        //    X
        if ((gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]) && gameBoard[2][2] != '-') 
                isWinner = true;

        // checks the contents of the other diagonal for matching data
        //      X
        //    X
        //  X
        if ((gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0]) && gameBoard[2][0] != '-') 
                isWinner = true;
        
        return isWinner;
    }
    
    public void printBoard()
    {
        for(int i = 0; i<2; i++)
            System.out.println(gameBoard[0][i]);
        for(int i = 0; i<2; i++)
            System.out.println(gameBoard[1][i]);
        for(int i = 0; i<2; i++)
            System.out.println(gameBoard[2][i]);
        
    }


}
