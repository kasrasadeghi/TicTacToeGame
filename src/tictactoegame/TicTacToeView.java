/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import apcscvm.DefaultControl;
import apcscvm.GraphicsUtilityFunctions;
import apcscvm.View;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DSTIGANT
 */
public class TicTacToeView extends DefaultControl<TicTacToeBoard> implements View<TicTacToeBoard>
{
    // instance variables - we need to store the width and height of the window and which player we are
    int width, height;
    char player;
    
    // constructor - consumes a char which indicates which player this window is going to play for
    public TicTacToeView( char p )
    {
        this.player = p;
    }
    
    // paintX - paints an x in a rectangle with ULC (ULCx, ULCy) and width and height w and h
    private void paintX( Graphics g, int ULCx, int ULCy, int w, int h )
    {
        int [] xs = new int[16];
        int [] ys = new int[16];
        
        double pt = 0.05*Math.sqrt(2);
        xs[0] = (int)(ULCx + pt*w);             ys[0] = (int)(ULCy + pt*h);
        xs[1] = xs[0];                          ys[1] = (int)(ULCy + 2*pt*h);
        xs[2] = (int)(ULCx + (0.5-pt)*w);       ys[2] = (int)(ULCy + 0.5*h);
        xs[3] = xs[0];                          ys[3] = (int)(ULCy + (1-2*pt)*h);
        xs[4] = xs[0];                          ys[4] = (int)(ULCy + (1-pt)*h);
        xs[5] = (int)(ULCx + (2*pt)*w);         ys[5] = ys[4];
        xs[6] = (int)(ULCx + 0.5*w);            ys[6] = (int)(ULCy + (0.5+pt)*h);
        xs[7] = (int)(ULCx + (1-2*pt)*w);       ys[7] = ys[4];
        xs[8] = (int)(ULCx + (1-pt)*w);         ys[8] = ys[4];
        xs[9] = xs[8];                          ys[9] = ys[3];
        xs[10] = (int)(ULCx + (0.5+pt)*w);      ys[10] = ys[2];
        xs[11] = xs[8];                         ys[11] = ys[1];
        xs[12] = xs[8];                         ys[12] = ys[0];
        xs[13] = xs[7];                         ys[13] = ys[0];
        xs[14] = xs[6];                         ys[14] = (int)(ULCy + (0.5-pt)*h);
        xs[15] = xs[5];                         ys[15] = ys[0];
        
        g.setColor( Color.RED );
        g.fillPolygon( xs, ys, 16 );
        g.setColor( Color.BLACK );
        g.drawPolygon( xs, ys, 16 );
    }
    
    // paintO - paints an O in the given rectangle
    private void paintO( Graphics g, int ULCx, int ULCy, int w, int h )
    {
        g.setColor( Color.BLUE );
        g.fillOval( (int)(ULCx + 0.05*w), (int)(ULCy + 0.05*h), (int)(0.9*w), (int)(0.9*h) );
        g.setColor( Color.WHITE );
        g.fillOval( (int)(ULCx + 0.15*w), (int)(ULCy + 0.15*h), (int)(0.7*w), (int)(0.7*h) );
        g.setColor( Color.BLACK );
        g.drawOval( (int)(ULCx + 0.05*w), (int)(ULCy + 0.05*h), (int)(0.9*w), (int)(0.9*h) );
        g.drawOval( (int)(ULCx + 0.15*w), (int)(ULCy + 0.15*h), (int)(0.7*w), (int)(0.7*h) );
    }
    
    // paintWinningMessageAndLine - paints the winning message (X wins!, O wins! Tie!) and paints
    // a green line indicating the winning row/col/diagonal (if one player won)
    private void paintWinningMessageAndLine( TicTacToeBoard tttb, Graphics g, int w, int h )
    {
        String line = tttb.getWinningLine();
        if ( line.startsWith("row") )
        {
            int rn = Integer.parseInt( line.substring(4) );
            g.setColor( Color.GREEN );
            g.fillRect( (int)(0.05*w/tttb.getSize()), 
                    (int)(h/(2.0*tttb.getSize()) - 0.05*h/tttb.getSize() + rn*h/(tttb.getSize())),
                    (int)((1-.1/tttb.getSize())*w),
                    (int)(0.1*h/tttb.getSize()) );
            g.setColor( Color.BLACK );
            g.drawRect( (int)(0.05*w/tttb.getSize()), 
                    (int)(h/(2.0*tttb.getSize()) - 0.05*h/tttb.getSize() + rn*h/(tttb.getSize())),
                    (int)((1-.1/tttb.getSize())*w),
                    (int)(0.1*h/tttb.getSize()) );
        }
        else if ( line.startsWith( "col" ) )
        {
            int cn = Integer.parseInt( line.substring(4) );
            g.setColor( Color.GREEN );
            g.fillRect(
                    (int)(w/(2.0*tttb.getSize()) - 0.05*w/tttb.getSize() + cn*w/(tttb.getSize())),
                    (int)(0.05*h/tttb.getSize()), 
                    (int)(0.1*w/tttb.getSize()),
                    (int)((1-.1/tttb.getSize())*h)
                    );
            g.setColor( Color.BLACK );
            g.drawRect( 
                    (int)(w/(2.0*tttb.getSize()) - 0.05*w/tttb.getSize() + cn*w/(tttb.getSize())),
                    (int)(0.05*h/tttb.getSize()), 
                    (int)(0.1*w/tttb.getSize()),
                    (int)((1-.1/tttb.getSize())*h)
            );
        }
        else if ( line.startsWith( "main" ) )
        {
            double po = 0.05*Math.sqrt(2);
            int [] xs = new int[6];
            int [] ys = new int[6];
            xs[0] = (int)(po*w/tttb.getSize());       ys[0] = (int)(po*h/tttb.getSize());
            xs[1] = xs[0];                              ys[1] = (int)(2*po*h/tttb.getSize());
            xs[2] = (int)((1-2*po/tttb.getSize())*w);    ys[2] = (int)((1-po/tttb.getSize())*h);
            xs[3] = (int)((1-po/tttb.getSize())*w);   ys[3] = ys[2];
            xs[4] = xs[3];                              ys[4] = (int)((1-2*po/tttb.getSize())*h);
            xs[5] = (int)(2*po*w/tttb.getSize());        ys[5] = ys[0];
            g.setColor( Color.GREEN );
            g.fillPolygon( xs, ys, 6 );
            g.setColor( Color.BLACK );
            g.drawPolygon( xs, ys, 6 );
        }
        else if ( line.startsWith( "off" ) )
        {
            double po = 0.05*Math.sqrt(2);
            int [] xs = new int[6];
            int [] ys = new int[6];
            xs[0] = (int)(po*w/tttb.getSize());       ys[0] = (int)((1-2*po/tttb.getSize())*h);
            xs[1] = xs[0];                              ys[1] = (int)((1-po/tttb.getSize())*h);
            xs[2] = (int)(2*po*w/tttb.getSize());        ys[2] = ys[1];
            xs[3] = (int)((1-po/tttb.getSize())*w);   ys[3] = (int)(2*po*h/tttb.getSize());
            xs[4] = xs[3];                              ys[4] = (int)(po*h/tttb.getSize());
            xs[5] = (int)((1-2*po/tttb.getSize())*w);    ys[5] = ys[4];
            g.setColor( Color.GREEN );
            g.fillPolygon( xs, ys, 6 );
            g.setColor( Color.BLACK );
            g.drawPolygon( xs, ys, 6 );
        }
        
        if ( tttb.getWinner() != ' ' )
        {
            g.setColor( Color.WHITE );
            g.fillRect( (int)(0.1*w), (int)(0.4*h), (int)(0.8*w), (int)(0.2*h) );
            g.setColor( Color.BLACK );
            g.drawRect( (int)(0.1*w), (int)(0.4*h), (int)(0.8*w), (int)(0.2*h) );
            GraphicsUtilityFunctions.drawStringWithFontInRectangle(
                    g, tttb.getWinner() + " WINS!",
                    GraphicsUtilityFunctions.getFont( (int)(0.2*h)), (int)(0.3*w), (int)(0.4*h), (int)(0.4*w), (int)(0.2*h));
        }
        else
        {
            g.setColor( Color.WHITE );
            g.fillRect( (int)(0.1*w), (int)(0.4*h), (int)(0.8*w), (int)(0.2*h) );
            g.setColor( Color.BLACK );
            g.drawRect( (int)(0.1*w), (int)(0.4*h), (int)(0.8*w), (int)(0.2*h) );
            GraphicsUtilityFunctions.drawStringWithFontInRectangle(
                    g, "TIE!",
                    GraphicsUtilityFunctions.getFont( (int)(0.2*h)), (int)(0.3*w), (int)(0.4*h), (int)(0.4*w), (int)(0.2*h));

        }
    }
    
    // paint -
    // paints the TTT board
    @Override
    public void paint(TicTacToeBoard tttb, Graphics g, int w, int h)
    {
        // save the width and height in our instance variables so that the mouse clicks
        // can get handled properly
        this.width = w;
        this.height = h;
        
        int size = tttb.getSize();
        int wsize = w/size;
        int hsize = h/size;
        // draw each square
        // if it's occupied, draw the appropriate symbol in that square
        g.setColor(Color.BLACK);
        for (int i = 0; i < size; ++i)
            for (int j = 0; j < size; ++j) {
                g.drawRect(i*wsize, j*hsize, wsize, hsize);
                if(tttb.getSquare(i, j) == 'X') paintX(g,j*wsize, i*hsize, wsize, hsize);
                if(tttb.getSquare(i, j) == 'O') paintO(g,j*wsize, i*hsize, wsize, hsize);
            }
        // if the game is over, display the winning line and message
        if(tttb.isGameOver())
            paintWinningMessageAndLine(tttb, g, w, h);
    
    }
    
    // handleMouseClick
    // figures out which square the player clicked in and makes a move in that square
    @Override
    public void handleMouseClick( TicTacToeBoard tttb, int ea, MouseEvent me )
    {
        // make sure the game isn't over
        System.out.println("handling mouse click");
        
        if (tttb.isGameOver()) {

            tttb.reset();
            return;
        }        
        // make sure it's our turn
        int size = tttb.getSize();
        int wsize = width/size;
        int hsize = height/size;
        if (tttb.getTurn() == player) {
            System.out.println("correct player");
            // use me.getX() and me.getY() to get the screen location of the click
            // turn the location into a row and column (hint: this will be
            // based on size of the board and the width and height of the window
            int col = me.getX()/wsize;
            int row = me.getY()/hsize;
            
            // mark the square
            tttb.markSquare(row, col);
        }
        // if the game is over, start a new one!
        
    }
    
    // getPlayer
    // returns the player for this window.
    public char getPlayer() 
    { 
        return player; 
    }
    
}
