public class Knight extends Pieces
{
    public boolean rules(int[] command){
        boolean check = false;
        double displacement = Math.pow(command[0]-position[0],2)+Math.pow(command[1]-position[1],2);
        //check if the square of y displacement plus the square of x displacement is equals 5
        if(displacement==5){check = true;}
        return check;
    }
    public boolean specialRules(int[] command){//no special rules
        boolean check = false;
        return check;
    }
    public boolean ifAllowedToMove(int[] command){//check both rules, if any one could move, then is allowed to move
        boolean check = false;
        if(rules(command)){check = true;}
        if(specialRules(command)){check = true;}
        return check;
    }   
    public void setProperty(String input,String name,Pieces piece,String color){//initializing
        position=convertor(input);
        this.name=name;
        Board.getBoard()[position[0]][position[1]]=piece;
        this.color=color;
    }
}
