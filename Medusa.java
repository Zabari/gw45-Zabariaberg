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
import java.util.ArrayList;
import java.awt.Color;

/* class BlusterCritter is a subclass of Critter*/

public class Medusa extends Critter{

    public ArrayList<Actor> getActors(){
	int a = getDirection();
	Location b = getLocation();
	Location c = b.getAdjacentLocation(int direction);
	Grid d = getGrid();
	Actor e = d.get(c);
    }
}
	
	

	
	
	
    
    