import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;
public class QuickCrab extends CrabCritter{
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
	Location right=getLocationsInDirections(new int[]{Location.RIGHT}).get(0);
	Location left=getLocationsInDirections(new int[]{Location.LEFT}).get(0);
	if (getGrid().get(right) == null&&getGrid().get(right.getAdjacentLocation(Location.RIGHT))==null){
	    locs.add(right.getAdjacentLocation(Location.RIGHT));
		System.out.println(locs);
	}
	if (getGrid().get(left) == null&&getGrid().get(left.getAdjacentLocation(Location.LEFT))==null){
	    locs.add(left.getAdjacentLocation(Location.LEFT));
	    System.out.println(locs);
	}
	else if (locs.size()==0)
	    return super.getMoveLocations();
        return locs;
    }


}
