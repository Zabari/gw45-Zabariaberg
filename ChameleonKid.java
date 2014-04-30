import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;

import java.util.ArrayList;
public class ChameleonKid extends ChameleonCritter{

    public void processActors(ArrayList<Actor> actors){
	Actor front=null;
	Actor back=null;
	   front=this.getGrid().get(this.getLocation().getAdjacentLocation(this.getDirection()));
	   back=this.getGrid().get(this.getLocation().getAdjacentLocation((180+this.getDirection())%360));
	if (front!=null)
	    setColor(front.getColor());	    
	else if (back!=null)
	    setColor(back.getColor());
        else{
            // Darkens the chameleon 
            Color c = getColor();
            int red = (int) (c.getRed() * .75);
            int green = (int) (c.getGreen() * .75);
            int blue = (int) (c.getBlue() * .75);
            setColor(new Color(red, green, blue));
        }
    }
}
