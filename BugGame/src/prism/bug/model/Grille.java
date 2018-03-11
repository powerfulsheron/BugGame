package prism.bug.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import prism.bug.constants.Constants;

public class Grille extends JComponent implements Constants{
	
    private Bug bug;
    private Cerise cerise;
    int CASE_DIM = Constants.CASE_DIM;
    int NB_CASES = Constants.NB_CASES;
	
	public Grille(){
		  initGrille();
		  gameInit();
	}
	
    private void initGrille() {
        addKeyListener(new TAdapter());
        setFocusable(true);	
    }
    
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            bug.keyPressed(e);
            if(bug.getX()==cerise.getX()&&bug.getY()==cerise.getY()) {
            	cerise.setDestroyed(true);
            }
            repaint();
            System.out.println(bug.getX());
            System.out.println(bug.getY());

        }
    }
    
    private void gameInit() {
    	
        Random random = new Random();
        int xBug = random.nextInt(NB_CASES-1)+1;
        int yBug = random.nextInt(NB_CASES-1)+1;
        int xCerise = random.nextInt(NB_CASES-1)+1;
        int yCerise = random.nextInt(NB_CASES-1)+1;

        while(xBug != xCerise && yBug != yCerise) {
	        xBug = random.nextInt(NB_CASES-1)+1;
	        yBug = random.nextInt(NB_CASES-1)+1;
	        xCerise = random.nextInt(NB_CASES-1)+1;
	        yCerise = random.nextInt(NB_CASES-1)+1;
        }
        
        System.out.println(xBug);
        System.out.println(yBug);
        System.out.println(xCerise);
        System.out.println(yCerise);

        bug = new Bug(xBug, yBug);
        cerise = new Cerise(xCerise, yCerise);
        
        
    }
    
    protected void paintComponent(Graphics g) {
    	Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < NB_CASES; i++) 
            for (int j = 0; j < NB_CASES; j++) {
            	Rectangle2D rect = new Rectangle2D.Double((j+1)*CASE_DIM, (i+1)*CASE_DIM, CASE_DIM, CASE_DIM);
            	g2.setColor(Color.white);
            	g2.fill(rect);
            	g2.setColor(Color.black);
            	g2.draw(rect);
            }
        
//        g2.drawImage(bug.getImage(), bug.getX(), bug.getY(),
//        		bug.getWidth(), bug.getHeight(), this);
//        g2.drawImage(cerise.getImage(), cerise.getX(), cerise.getY(),
//        		cerise.getWidth(), cerise.getHeight(), this);
        
        bug.getImageIcon().paintIcon(null, g2, (CASE_DIM*bug.getX())+1, (CASE_DIM*bug.getY())+1);
        
        if(!cerise.isDestroyed()) {
        	cerise.getImageIcon().paintIcon(null, g2, (CASE_DIM*cerise.getX())+1, (CASE_DIM*cerise.getY())+1);
        }
 
    	g2.dispose();
    }
	
}
