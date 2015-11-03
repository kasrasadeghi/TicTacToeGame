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
        
        int size = tttb.getSize();
//        System.out.println("player = " + tttb.getTurn());
        int[][] decisions = new int[size][size];
        boolean isX = super.getPlayer() == 'X';
        for (int i = 0; i < size; ++i) 
            for (int j = 0; j < size; ++j)  {
                decisions[i][j] = tttb.testWin(i, j, isX);
//                System.out.println("decision (" + i+ "),(" + j + "): " +decisions[i][j]);
            }
                
        
//        find the winning move
//        System.out.println("decisions grid:");
//        for (int i = 0; i < size; ++i){
//            for (int j = 0; j < size; ++j)
//                System.out.print(decisions[i][j] + "\t");
//            System.out.println("");
//        }
//        System.out.println("");
        int foundMove = 0;
        
        for (int i = 0; i < size; ++i)
            for (int j = 0; j < size; ++j){
                if (decisions[i][j] == 1){
//                    System.out.println("found good decision");
                    foundMove = 1;
                    tttb.markSquare(i, j);
                }
            }
        
        breakcheck:
        if (foundMove != 1) {
            for (int i = 0; i < size; ++i)
                for (int j = 0; j < size; ++j){
                    if (decisions[i][j] == -1){
//                        System.out.println("check2");
                        foundMove = -1;
                        tttb.markSquare(i, j);
                        break breakcheck;
                    }
                }
        }
        if (foundMove == 0)  {
            super.chooseAndExecuteMove(tttb);
//            System.out.println("random move");
        }
//        System.out.println("foundMove = " + foundMove);
    }
}
