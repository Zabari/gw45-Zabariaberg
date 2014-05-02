/*****************************************************************
 * NAME gw45-Zabariaberg (Maria Kollaros, Coby Goldberg, Daniel Zabari)
 * APCS pd #9
 * HW## 35 GridWorld, Part 4
 * 2014-04-30
 *
 * class MedusaCritter
 *
 * BEACUASE:
 * We like mythology and we thought it was really cool that MedusaCritter turns other actors (with some exceptions) to rock when they face each other (or look at each other), just like in myhtology Medusa turned people to stone with one look in the eyes.
 *
 * SPECIFICATIONS:
 *MedusaCritter Specs:
  -MedusaCritter can turn the actor in front of it into a rock by removing it and spawning a rock object    on the location.
   Class MedusaCritter inherits all methods and variables/constants of superclasses Critter and Actor. B    elow are overwritten methods

-processActors(Actor a){//Overwrites processActors() of superclass Critter
    /*If the actorâ€™s direction is the direction of the medusaâ€™s + 180 && the actor is directly in f      ront of the medusa (basically, eye contact and one space away), the actor in front will be removed       and replaced by a rock UNLESS it is a Critter or Rock
}
-ArrayList<Actor> getActors(){//Overwrites getActors() of superclass Critter
    /*Only obtains critter directly in front for processing. Dependent on direction of MedusaCritter exec      uting code. Returns ArrayList consisting of all objects one space ahead
}
 *
 * TEST CASES:
 * Test cases are provided in the runner class.
 *****************************************************************/

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
		
		
	
	
	
	

	
	
	
    
    
