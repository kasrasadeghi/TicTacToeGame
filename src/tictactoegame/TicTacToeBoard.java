/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

/**
 *
 * @author DSTIGANT
 */
public class TicTacToeBoard
{
    // The TTT Board neeads an array to hold the contents of the squares
    
    // and we need to keep track of who's turn it is
    
    public TicTacToeBoard( int size )
    {
        reset(size);
    }
    
    // reset - sets up a new board with empty squares and sets the turn to be X's turn
    private void reset( int size )
    {
        
    }
    
    public void reset()
    {
        
    }
    
    // getSize - returns the size of the board (ie the number of rows which will be the same as the number of columns
    // since the board is square)
    public int getSize() 
    { 
        return 0;
    }

    // getTurn - returns the current turn 'X' if it's X's turn, 'O' if it's O's turn
    public char getTurn()
    {
        return ' ';
    }
    
    // getSquare - returns the contents of square (i, j)
    // 'X' ==> X owns the square
    // 'O' ==> O owns the square
    // ' ' ==> the square is empty
    public char getSquare( int i, int j )
    {
        return ' ';
    }
    
    // markSquare - marks square (i,j) with the current player's mark and then changes the turn to the
    // other player.  If the square is already occupied or the game is over, do nothing
    public void markSquare( int i, int j )
    {
       
    }
    
    // rowWinner - 
    // figures out if one player or the other has occupied every square in a row
    // returns 'X' if X owns all the squares in the row, 'O' if O does or ' ' if neither player owns all the squares
    private char rowWinner( int i )
    {
        return ' ';
    }

    // colWinner -
    // like rowWinner but for a column
    private char colWinner( int i )
    {
        return ' ';
    }

    // mainDiagonalWinner - like row/colWinner but for the main diagonal (top left to bottom right)
    private char mainDiagonalWinner()
    {
        return ' ';
    }

    // offDiagonalWinner - like row/colWinner but for the off diagonal (top right to bottom left)
    private char offDiagonalWinner()
    {
        return ' ';
    }

    // isBoardFull - returns true if all the squares are occupied
    private boolean isBoardFull()
    {
        return false;
    }
    
    // isGameOver - returns true if either player has won a row, column or one of the diagonals or all 
    // the squares are occupied
    public boolean isGameOver()
    {
        return false;
    }

    // getWinner -
    // returns 'X' if X has won, 'O' if O has won or ' ' if the game is a tie (board is full without a winner)
    public char getWinner()
    {
        return ' ';
    }

    // getWinningLine - 
    // returns a string indicating which line was filled by the winner or "tie" if the game is a tie
    // For example, if X wins by completing the middle horizontal line, the result will be "row 1"
    // if the winning line is the right column, the result will be "col 2" etc.
    // If the winning line is one of the diagonals return "main" or "off"
    // If the game is a tie, return "tie"
    public String getWinningLine()
    {
        return "tie";
    }
}
