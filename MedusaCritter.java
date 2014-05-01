/*
* AP(r) Computer Science GridWorld Case Study:
* Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
*
* This code is free software; you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation.
*
* This code is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* @author Chris Nevison
* @author Barbara Cloud Wells
* @author Cay Horstmann
*/


import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Rock;
import java.util.ArrayList;
import java.awt.Color;

/* class BlusterCritter is a subclass of Critter*/

public class MedusaCritter extends Critter{

    public ArrayList<Actor> getActors(){
	int a = getDirection();
	System.out.println(a);
	Location b = getLocation();
	Location c = b.getAdjacentLocation(a);
	Grid<Actor> d = getGrid();
	Actor e = d.get(c);
	ArrayList<Actor> f = new ArrayList<Actor>();
	if (e != null && d.isValid(c)){
	    f.add(e);
	}
	System.out.println(f);
	return f;
	
    }

    public void processActors (ArrayList<Actor> a){
	if( a.size() == 0)
	    return;
	int dir = a.get(0).getDirection();
	System.out.println(dir);
	if (dir == getDirection() + 180){
	    if (!(a.get(0) instanceof Rock) && !(a.get(0) instanceof Critter)){
		Location b = a.get(0).getLocation();
		Rock tom = new Rock();
		tom.putSelfInGrid(getGrid(), b);
	    }
	}
    }
}
		
		
	
	
	
	

	
	
	
    
    
