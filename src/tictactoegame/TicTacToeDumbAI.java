/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.awt.event.MouseEvent;

/**
 *
 * @author DSTIGANT
 */
public class TicTacToeDumbAI extends TicTacToeView
{
    private int timer;
    
    public TicTacToeDumbAI(char p)
    {
        super(p);
        timer = 1000;
    }
    
    @Override
    public void handleMouseClick( TicTacToeBoard tttb, int ea, MouseEvent me )
    {
        
    }
    
    @Override
    public void handleTimePassage( TicTacToeBoard tttb, int ea, int dt )
    {
        if ( tttb.getTurn() == getPlayer() )
        {
            timer -= dt;
            if ( timer < 0 )
            {
                timer = 1000;
                chooseAndExecuteMove( tttb );
            }
        }
    }
    
    // chooseAndExecuteMove
    // consumes a TTTB and executes a random move
    protected void chooseAndExecuteMove( TicTacToeBoard tttb )
    {
        int size = tttb.getSize();
        int zeroCount = 0;
        // first, count the number of open squares
        for (int i = 0; i < size; ++i)
            for (int j = 0; j < size; ++j) 
                if (tttb.getSquare(i, j) == ' ') ++zeroCount;
        
        // then choose one of the squares randomly
        // choice indicates which open square to choose
        int choice = (int)(Math.random() * zeroCount); //0, 1... zeroCount-1
        
        // write code which marks the choice-th open square
        // for example, if the board is
        // X.O
        // ..X
        // O..
        // (. indicates an open square)
        // and choice is 3, then you should make the move at the 4th open square reading in row-major order
        // that is, the square at row 2, column 1 so that the board is now
        // X.O
        // ..X
        // OX.
        // Hint: use a nested-for loop to iterate over the squares, 
        // keeping track of how many open squares you have seen.  
        // When you've seen the right number, mark that square
        int choiceCount = 0;
        for (int i = 0; i < size; ++i) 
            for (int j = 0; j < size; ++j) 
                if(tttb.getSquare(i,j) == ' ' && choice == choiceCount++)
                    tttb.markSquare(i, j);
            
    }
    
}
