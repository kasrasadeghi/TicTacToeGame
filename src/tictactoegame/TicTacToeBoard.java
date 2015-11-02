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
    private char[][] board;
    // and we need to keep track of who's turn it is
    private boolean xTurn;
    public TicTacToeBoard( int size )
    {
        reset(size);
    }
    
    // reset - sets up a new board with empty squares and sets the turn to be X's turn
    private void reset( int size )
    {      
        board = new char[size][size];
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board.length; ++j)
                board[i][j] = ' ';
        xTurn = true;
    }
    
    public void reset()
    {
        reset(board.length);
    }
    
    // getSize - returns the size of the board (ie the number of rows which will be the same as the number of columns
    // since the board is square)
    public int getSize() 
    { 
        return board.length;
    }

    // getTurn - returns the current turn 'X' if it's X's turn, 'O' if it's O's turn
    public char getTurn()
    {
        return (xTurn) ? 'X' : 'O';
    }
    
    // getSquare - returns the contents of square (i, j)
    // 'X' ==> X owns the square
    // 'O' ==> O owns the square
    // ' ' ==> the square is empty
    public char getSquare( int i, int j )
    {
        return board[i][j];
    }
    
    // markSquare - marks square (i,j) with the current player's mark and then changes the turn to the
    // other player.  If the square is already occupied or the game is over
    public void markSquare(int i, int j) {
        if (isGameOver()) return;
        if (board[i][j] == ' '){
            board[i][j] = (xTurn) ? 'X' : 'O';
            xTurn = !xTurn;
        }
    }
    
    // rowWinner - 
    // figures out if one player or the other has occupied every square in a row
    // returns 'X' if X owns all the squares in the row, 'O' if O does or ' ' if neither player owns all the squares
    private char rowWinner( int i )
    {
        char xchecker = 'X'; boolean xcheck = true;
        for (int j = 0; j < board.length; ++j) 
            if (board[i][j] != xchecker) xcheck = false;
        char ochecker = 'O'; boolean ocheck = true;
        for (int j = 0; j < board.length; ++j) 
            if (board[i][j] != ochecker) ocheck = false;
        
        return (xcheck)?'X':
               (ocheck)?'O':
                ' ';
    }

    // colWinner -
    // like rowWinner but for a column
    private char colWinner( int j )
    {
        char xchecker = 'X'; boolean xcheck = true;
        for (int i = 0; i < board.length; ++i) 
            if (board[i][j] != xchecker) xcheck = false;
        char ochecker = 'O'; boolean ocheck = true;
        for (int i = 0; i < board.length; ++i) 
            if (board[i][j] != ochecker) ocheck = false;
        
        return (xcheck)?'X':
               (ocheck)?'O':
                ' ';
    }

    // mainDiagonalWinner - like row/colWinner but for the main diagonal (top left to bottom right)
    private char mainDiagonalWinner()
    {
        char xchecker = 'X'; boolean xcheck = true;
        for (int i = 0; i < board.length; ++i) 
            if (board[i][i] != xchecker) xcheck = false;
        char ochecker = 'O'; boolean ocheck = true;
        for (int i = 0; i < board.length; ++i) 
            if (board[i][i] != ochecker) ocheck = false;
        
        return (xcheck)?'X':
               (ocheck)?'O':
                ' ';
    }

    // offDiagonalWinner - like row/colWinner but for the off diagonal (top right to bottom left)
    private char offDiagonalWinner()
    {
        char xchecker = 'X'; boolean xcheck = true;
        for (int i = 0; i < board.length; ++i) 
            if (board[i][board.length - 1 - i] != xchecker) xcheck = false;
        char ochecker = 'O'; boolean ocheck = true;
        for (int i = 0; i < board.length; ++i) 
            if (board[i][board.length - 1 - i] != ochecker) ocheck = false;
        
        return (xcheck)?'X':
               (ocheck)?'O':
                ' ';
    }

    // isBoardFull - returns true if all the squares are occupied
    private boolean isBoardFull()
    {
        for (int i = 0; i < board.length; ++i) 
            for (int j = 0; j < board.length; ++j) 
                if (board[i][j] == ' ') return false;
        return true;
    }
    
    // isGameOver - returns true if either player has won a row, column or one of the diagonals or all 
    // the squares are occupied
    public boolean isGameOver()
    {
        for (int i = 0; i < board.length; ++i){
            if(colWinner(i) == 'X' || colWinner(i) == 'O') return true;
            if(rowWinner(i) == 'X' || rowWinner(i) == 'O') return true;
        }
        if(mainDiagonalWinner() == 'X' || offDiagonalWinner() == 'X') return true;
        if(mainDiagonalWinner() == 'O' || offDiagonalWinner() == 'O') return true;
        if (isBoardFull()) return true;
        return false;
    }

    // getWinner -
    // returns 'X' if X has won, 'O' if O has won or ' ' if the game is a tie (board is full without a winner)
    public char getWinner()
    {
        for (int i = 0; i < board.length; ++i){
            if (colWinner(i) == 'X' || rowWinner(i) == 'X') return 'X';
            if (colWinner(i) == 'O' || rowWinner(i) == 'O') return 'O';
        }
        if(mainDiagonalWinner() == 'X' || offDiagonalWinner() == 'X') return 'X';
        if(mainDiagonalWinner() == 'O' || offDiagonalWinner() == 'O') return 'O';
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
        if (getWinner() == ' ') return "tie";
        for (int i = 0; i < board.length; ++i) {                                                                      if(colWinner(i) == 'X' || colWinner(i) == 'O') return "col " + i;
            if(rowWinner(i) == 'X' || rowWinner(i) == 'O') return "row " + i;
        }
        if(mainDiagonalWinner() != ' ') return "main";
        if(offDiagonalWinner() != ' ') return "off";
        return "nomnom";
    }
}
