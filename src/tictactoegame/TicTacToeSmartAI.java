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
public class TicTacToeSmartAI extends TicTacToeDumbAI
{

    public TicTacToeSmartAI(char p) {
        super(p);
    }
    
    // chooseAndExecuteMove
    // chooses a move which will at least draw the game
    @Override
    protected void chooseAndExecuteMove( TicTacToeBoard tttb )
    {
        // if you implement this exercise, remove the following line and replace with your more intelligent code
        super.chooseAndExecuteMove(tttb);
    }
    
    private boolean wouldWinColumn(TicTacToeBoard tttb, int col) {
        return false;
    }
    
    private boolean wouldWinRow(TicTacToeBoard tttb, int row) {
        return false;
    }
    
    private boolean wouldWinOff(TicTacToeBoard tttb, int row) {
        return false;
    }
    
    private boolean wouldWinMain(TicTacToeBoard tttb, int row) {
        return false;
    }
}
