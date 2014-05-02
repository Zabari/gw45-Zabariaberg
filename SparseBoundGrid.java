import info.gridworld.grid.Grid; 
import info.gridworld.grid.AbstractGrid; 
import info.gridworld.grid.Location; 
import java.util.*;
import java.io.*;

public class SparseBoundedGrid<E> extends AbstractGrid<E>{

    private ArrayList<ArrayList> occupantArray; // broad ArrayList containing all elements, which are stored in internal ArrayLists as cols
    private int cols;
    private int rows;

    // constructor
    public SparseBoundedGrid(int r, int c){
	if (r > 0 && c >0){
	    rows = r;
	    cols = c;
	    occupantArray = new ArrayList<ArrayList>(rows);
	    for (int i = 0; i < rows; i++){
		occupantArray.add(OccupantInCol);
	    }
	}
        else if (r <= 0){
	    throw new IllegalArgumentException("rows cannot be <= 0");
	}
	else {
	    throw new IllegalArgumentException("columns cannot be <= 0");
	}
    }

    public int getNumRows(){
	return rows;
    }

    public int getNumCols(){
	return cols;
    }

    public boolean isValid(Location loc){
        int r = loc.getRow();
	int c = loc.getCol();
	return 0 <= r && 0 <= c && r < rows && c < cols;
    }

   public E remove(Location loc){
	if (!isValid(loc)){
	    throw new IllegalArgumentException("Location " + loc + " is not valid");
	}
	int r = loc.getRow();
	int c = loc.getCol();
	ArrayList<OccupantInCol> thisRow = occupantArray.get(r);
	for (OccupantInCol temp : thisRow){
	    if (temp.getCol() == c){
		E ret = get(loc);
		thisRow.remove();
		return ret;
	    }
	}
	return null;
    }

    public E get(Location loc){
	if (!isValid(loc)){
	    throw new IllegalArgumentException("Location " + loc + " is not valid");
	}
	int r = loc.getRow();
	int c = loc.getCol();
	ArrayList<OccupantInCol> thisRow = occupantArray.get(r); // the row to work in
	if (thisRow == null){
	    return null;
	}
	// walk through until at correct column
	for (OccupantInCol temp : thisRow){
	    if (temp.getCol() == c){
		return (E)(temp); // OccupantInCol is not E, must be cast
	    }
	}
    }

    public E put(Location loc, E act){
	if (!isValid(loc)){
	    throw new IllegalArgumentException("Location " + loc + " is not valid");
	}
	int r = loc.getRow();
	int c = loc.getCol();
	if (act == null){ // like in boundedGrid, object added cannot be null
	    throw new NullPointerException("obj == null");
	}
	E ret = this.remove(loc); // remove and return the old object
	ArrayList<OccupantArray> cur = occupantArray.get(r);
	OccupantInCol toAdd = new OccupantInCol(act, c);
	cur.add(toAdd);
	return ret;
    }


    public ArrayList<Location> getOccupiedLocations(){
	ArrayList<Location> locs = new ArrayList<Location>s();
	for (int i = 0; i < rows; i++){
	    ArrayList<OccupantInCol> cur = OccupantArray.get(i);
	    if (cur != null){ // ignore empty rows
		for (OccupantInCol temp : cur){ // only looks at spaces with occupants
		    Location l = new Location(temp.getNumRow(), temp.getNumCol()); // What is that occupant's location?
		    locs.add(l); // add it to the list
		}
	    }
	}
	return locs;
    }

}
