package prism.bug.model;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import prism.bug.constants.Constants;
import prism.bug.generic.Sprite;

public class Bug extends Sprite implements Constants{

	    private char dir;
	    private ImageIcon imageIcon;

	    public Bug(int x, int y) {

	        this.x = x;
	        this.y = y;
	    	
	        imageIcon = new ImageIcon(getClass().getResource("/img/bug.png"));
	     	               
	        dir = INIT_DIR;

	    }
	    
	    public void keyPressed(KeyEvent e) {

	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_LEFT) {
	            dir = 'L';
	            if(this.x>1) {
	            	this.x-=1;
	            }
	        }

	        if (key == KeyEvent.VK_RIGHT) {
	            dir = 'R';
	            if(this.x<NB_CASES) {
		            this.x +=1;	            
		        }
	        }
	        
	        if (key == KeyEvent.VK_UP) {
	            dir = 'U';
	            if(this.y>1) {
	            	this.y-=1;
	            }
	        }

	        if (key == KeyEvent.VK_DOWN) {
	            dir = 'D';
	            if(this.y<NB_CASES) {
		            this.y +=1;	            
		        }
	        }
	                
	    }

		public char getDir() {
			return dir;
		}

		public void setDir(char dir) {
			this.dir = dir;
		}

		public ImageIcon getImageIcon() {
			return imageIcon;
		}

		public void setImageIcon(ImageIcon imageIcon) {
			this.imageIcon = imageIcon;
		}
	}