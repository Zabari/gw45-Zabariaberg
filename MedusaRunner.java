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
 * provided in the body of the code below one by one.
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains critters. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class MedusaRunner
{
    public static void main(String[] args)
    {//Different TestCases for Medussa Critter
	/*T1-There is a non-rock-non-critter actor on the tile ahead facing the MedusaCritter: act() will remove that actor and replace it with a rock. The MedusaCritter will then move as specified by the Critter class*/
        /*ActorWorld world = new ActorWorld();
        world.add(new Location(4, 2), new Rock());
        world.add(new Location(4, 5), new Rock());
	Flower a = new Flower(Color.BLUE);
	a.setDirection(180);
        world.add(new Location(2, 3), a);
        world.add(new Location(1, 2), new Flower(Color.PINK));
        world.add(new Location(1, 5), new Flower(Color.RED));
        world.add(new Location(7, 2), new Flower(Color.YELLOW));
	world.add(new Location(3, 3), new MedusaCritter());
        world.show();
	*/
	/*The above code tests the first test case by pressing Step once. The grid has been programmed so that MedusaCritter is right below a Flower. A Flower is a non Rock and Critter Actor so it can be turned into a rock. The Critter's Direction is north and the Flower's Direction has been set to south meaning they face one another. By one press on step, the act() method is called which runs through getActors() and processActors() meaning the Flower will be turned into a Rock*/

	/*T2-There is a non-rock-non-critter actor on the tile ahead but not facing the MedusaCritter: act() will not do anything to the actor. The MedusaCritter will then move as specified by the Critter class

	  Test case number 2 is also tested by the code above. After executing the step function once, the user can continue to press step which continously calls act(). At certain points MedusaCritter ends up below the remaining two flowers. However, those flowers have the same direction as MedusaCritter (they don't face MedusaCritter), so they will not be turned to rocks. This is true when executed.*/

	/*T3-There is a non-rock-non-critter actor on the tile to the right but not facing the MedusaCritter: act() will not do anything to the actor. The MedusaCritter will then move as specified by the Critter class. Code to execute this test code is found below:


	ActorWorld world = new ActorWorld();
        world.add(new Location(4, 2), new Rock());
        world.add(new Location(4, 5), new Rock());
        world.add(new Location(3, 4), new Flower(Color.PINK));
	world.add(new Location(3, 3), new MedusaCritter());
        world.show();
	*/
	/*The code above creates a flower to the right of MedusaCritter and the flower and MedusaCritter face the same direction. (They do not face each other). Nothing happens to the flower and MedusaCritter moves like a Critter.*/

	/*T4-There is a rock/critter actor on the tile ahead: act() will not do anything to the actor. The MedusaCritter will then move as specified by the Critter class.*/

	ActorWorld world = new ActorWorld();
        world.add(new Location(4, 2), new Rock());
	MedusaCritter a = new MedusaCritter();
	a.setDirection(180);
        world.add(new Location(2, 3), a);
        world.add(new Location(3, 4), new Flower(Color.PINK));
	world.add(new Location(3, 3), new MedusaCritter());
        world.show();
	/*The code above places a new MedusaCritter directly above MedusaCritter and even sets the direction of the new MedussaCritter to south, meaning it faces old MedusaCritter which faces north. Even though the two face one another old MedusaCritter does not turn the new  MedusaCritter into a rock.*/
    }
}
