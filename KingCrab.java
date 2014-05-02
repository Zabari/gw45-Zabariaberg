import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.*;

public class KingCrab extends CrabCritter{

    public void processActors(ArrayList<Actor> actors){
        for (Actor a : actors){
            int direction = this.getLocation().getDirectionToward(a.getLocation());
            Location nextLoc = a.getLocation().getAdjacentLocation(direction);
            if (this.getGrid().isValid(nextLoc)){
                a.moveTo(nextLoc);
	    }
            else{
                a.removeSelfFromGrid();
	    }
        }
    }
}
