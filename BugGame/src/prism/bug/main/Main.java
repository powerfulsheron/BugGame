package prism.bug.main;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import prism.bug.constants.Constants;
import prism.bug.model.Grille;

public class Main extends JFrame implements Constants{
	
	  public Main() {
	        initUI();
	    }
	    
	    private void initUI() {
	        
	        add(new Grille());
	        setTitle("Bug Game");
	        
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setSize(FRAME_WIDTH, FRAME_HEIGTH);
	        setLocationRelativeTo(null);
	        setResizable(false);
	        setVisible(true);
	    }

	    public static void main(String[] args) {
	        
	        EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {                
	                Main game = new Main();
	                game.setVisible(true);                
	            }
	        });
	    }
}