package prism.bug.model;

import javax.swing.ImageIcon;

import prism.bug.constants.Constants;
import prism.bug.generic.Sprite;

public class Cerise extends Sprite implements Constants{
	
	    private boolean destroyed;
	    private ImageIcon imageIcon;

	    public Cerise(int x, int y) {
	        
	        this.x = x;
	        this.y = y;

	        imageIcon = new ImageIcon(getClass().getResource("/img/cherry.png"));

	        destroyed = false;
	    }

	    public boolean isDestroyed() {
	        
	        return destroyed;
	    }

	    public void setDestroyed(boolean val) {
	        
	        destroyed = val;
	    }

		public ImageIcon getImageIcon() {
			return imageIcon;
		}

		public void setImageIcon(ImageIcon imageIcon) {
			this.imageIcon = imageIcon;
		}
	}
