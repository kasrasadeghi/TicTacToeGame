/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import apcscvm.CVMProgram;

/**
 *
 * @author DSTIGANT
 */
public class TicTacToeGame
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
//        launchEmptyOnePlayerGame();
//        launchDummyOnePlayerGame();
//        launchTwoPlayerGame();
        launchDumbAIGame();
        //launchSmartAIGame();
    }
    
    public static void launchEmptyOnePlayerGame()
    {
        TicTacToeView ttvX = new TicTacToeView( 'X' );
        int size = (int)(Math.random() * 5) + 3;
        
        TicTacToeBoard ttb = new TicTacToeBoard( size );
        launchTTTWindow( ttvX, ttb );
    }
    
    public static void launchDummyOnePlayerGame()
    {
        TicTacToeView ttvX = new TicTacToeView( 'X' );
        int size = 3;
        
        TicTacToeBoard ttb = new TicTacToeBoard( size );
        
        ttb.markSquare( 1, 0 );
        ttb.markSquare( 0, 1 );
        ttb.markSquare( 2, 2 );
        ttb.markSquare( 1, 0 );
        
        launchTTTWindow( ttvX, ttb );
    }
    
    // launchTwoPlayerGame
    // launches a two player game
    public static void launchTwoPlayerGame()
    {
        // Create two view objects, one for each player
        TicTacToeView xView = new TicTacToeView('X');
        TicTacToeView yView = new TicTacToeView('O');
       
        // randomly select a size for the board
        TicTacToeBoard board = new TicTacToeBoard((int)(Math.random() * 3 + 3));
       
        // launch two windows which will play the game on the SAME board
        launchTTTWindow(xView, board);
        launchTTTWindow(yView, board);
    }
    
    // launchDumbAIGame()
    // launches a game for one player against a dumb AI
    public static void launchDumbAIGame()
    {
        // Create two view objects, one for the player
        TicTacToeView xView = new TicTacToeView('X');
        
        // one for the AI
       TicTacToeView yView = new TicTacToeDumbAI('O');
       
        // randomly select a size for the board
        TicTacToeBoard board = new TicTacToeBoard((int)(Math.random() * 3 + 3));
       
        // launch two windows which will play the game on the SAME board
        launchTTTWindow(xView, board);
        launchTTTWindow(yView, board);
    }
    
    // launchSmartAIGame()
    public static void launchSmartAIGame()
    {
        // Create two view objects, one for the player
        
        // one for the AI
        
       
        // randomly select a size for the board
        
        // launch two windows which will play the game on the SAME board
        
    }
    
    // launchTTTWindow
    // launches a TTT window for the given player and board
    public static void launchTTTWindow( TicTacToeView playerView, TicTacToeBoard board )
    {
        new CVMProgram( "Tic Tac Toe - " + playerView.getPlayer(), 600, 622, playerView, playerView, board ).start();
    }
    
}
