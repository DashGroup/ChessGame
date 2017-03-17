public class Knight extends Pieces
{
    // if moving in the knight's perfomance
    public boolean followsBasicRules(int[] command){
        boolean check = false;
        double displacement = Math.pow(command[0]-position[0],2)+Math.pow(command[1]-position[1],2);
        //check if the square of y displacement plus the square of x displacement is equals 5
        if(displacement==5){check = true;}
        return check;
    }
    //no exceptional rules
    public boolean followsExceptionalRules(int[] command){
        boolean check = false;
        return check;
    }

    public void setProperty(String input,String name,Pieces piece,String color){//initializing
        position=convertor(input);
        this.name=name;
        Board.getBoard()[position[0]][position[1]]=piece;
        this.color=color;
    }
}
