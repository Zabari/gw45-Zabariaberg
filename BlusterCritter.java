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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.awt.Color;

/* class BlusterCritter is a subclass of Critter*/

public class BlusterCritter extends Critter{

    //courage will store the value of c
    private int courage;
    
    public BlusterCritter(int c){
	super(); // the rest of the constructor besides the assignemnt of c will fuction as the superclass constructor
	courage = c;
    }

    /* getActors() creates an ArrayList of all the Actors that are within 2 rows and 2 columns from the blusterCritter not including itself */

    public ArrayList<Actor> getActors(){
	Location loc = getLocation();
	ArrayList<Actor> actors = new ArrayList<Actor>();

	for(int r = loc.getRow() - 2; r <= loc.getRow() + 2; r++){
	    for(int c = loc.getCol() - 2; c<= loc.getCol() + 2; c++){
		Location tmp = new Location(r,c);
		if(getGrid().isValid(tmp)){
		    Actor x = getGrid().get(tmp);
		    if (x != null && x != this)
			actors.add(x);
		}
	    }
	}
	return actors;
    }

    /* if the size of the ArrayList created in getActors() is less than courage the blusterCritter will get Critter but if the size is greater than or equal to courage the blusterCritter will get darker()*/
    public void processActors(ArrayList<Actor> actors){
	int s = actors.size();
	if (s < courage){
	    brighter();
	}
	else{
	    darker();
	}
    }

    /*helper method to make the color darker */
    public void darker(){
	Color c = getColor();
	int red = (int) (c.getRed() * .75);
	int green = (int) (c.getGreen() * .75);
	int blue = (int) (c.getBlue() * .75);
	setColor(new Color(red, green, blue));
    }

    /* helper method to make the color brighter*/
    public void brighter(){
	Color c = getColor();
	int red = c.getRed();
	int green = c.getGreen();
	int blue = c.getBlue();
	if (red < 255)
	    red = (int) (c.getRed() + 10);
	if (green < 255)
	    green = (int) (c.getGreen() + 10);
	if (blue < 255)
	    blue = (int) (c.getBlue() + 10);
	setColor(new Color(red, green, blue));
    }
}	
		
	    
		
