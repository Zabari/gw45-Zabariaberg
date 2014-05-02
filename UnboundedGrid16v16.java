public class UnboundedGrid16v16{
    private Object[][] occupantArray; //Arrays cant store generic type

    public UnboundedGrid16v16(){
	occupantArray[16][16];
    }      

    public int getNumRows(){ 
	return -1; 
    } 

    public int getNumCols(){ 
	return -1; 
    }

    public boolean isValid(Location loc){
	return 0 <= loc.getRow() && 0 <= loc.getCol(); // can't be negative for this one
    }

    public ArrayList<Location> getOccupiedLocations(){
	ArrayList<Location> locs = new ArrayList<Location>();
	// traverse the array. It is square, so use same length both times
	for (int i = 0; i < occupantArray.length; i++){
	    for (int j = 0; j < occupantArray.length; j++){
		Location loc = new Location(r, c);
		if (get(loc) != null){
		    locs.add(loc); // add if it isn't null
		}
	    }
	}
	return locs;
    }

    public E get(Location loc){
	if (!isValid(loc)){
	    throw new IllegalArgumentException("Location " + loc + " is not valid");
	}
	int r = loc.getRow();
	int c = loc.getCol();
	if (r >= occupantArray.length || c >= occupantArray.length){
	    return null; // outside array bounds but positive is simply null
	}
	return (E)occupantArray[r][c]; // cast object to E
    }

    public E put(Location loc, E actor){
	if (loc == null){
	    throw new NullPointerException("loc == null");
	} 
	if (actor == null){ 
	    throw new NullPointerException("actor == null"); 
	}
	int r = loc.getRow();
	int c = loc.getCol();
	// if the location is outside the current bounds
	if (r >= occupantArray.length || c >= occupantArray.length){
	    int s = occupantArray.length;
	    while (r >= s || c >= s){
		s = s*2; // double the side lengths until the location is within them
	    }
	    Object[][] temp = new Object[s][s]; // to be filled with old values
	    for (int i = 0; i < occupantArray.length; i++){
		for (int j = 0; j < occupantArray.length; j++){
		    temp[i][j] = occupantArray[i][j]; // copy the contents of the old array
		}
	    }
	    occupantArray = temp; // overwrite the old array    
	}
	E ret = get(loc); // old object to be returned
	occupantArray[r][c] = actor;
	return ret;
    }

    public E remove(Location loc){
	if (!isValid(loc)){
	    throw new IllegalArgumentException("Location " + loc + " is not valid");
	}
	int r = loc.getRow();
	int c = loc.getCol();
	// if the location is not in the array but not negative
	if (r >= occupantArray.length || c >= occupantArray.length){
	    return null;
	}
	E ret = get(loc); // get the object to be returned
	occupantArray[r][c] = null; // set the location to null
	return ret;
    }

}
