public class OccupantInCol{
    private Object occupant;
    private int cols;

    public OccupantInCol(Object occ, int col){
	occupant = occ;
	cols = col;
    }

    public Object getOccupant(){
	return occupant;
    }
    
    public int getColumn(){
	return cols;
    }

    public void setOccupant(Object occ){
	occupant = occ;
    }

}
