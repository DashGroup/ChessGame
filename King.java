public class King extends Pieces
{
    // if moving only one step aroung it
    public boolean followsBasicRules(int[] command){
        int distanceUpAndDown =  Math.abs(command[0]- position[0]);//if it is 0, possiblePosition could be up or down
        int distanceLeftAndRight =  Math.abs(command[1]- position[1]);//if it is 0, possiblePosition could be left or right
        if(distanceUpAndDown == 0 && distanceLeftAndRight == 1){
            return true;
        }
        else if(distanceUpAndDown == 1 && distanceLeftAndRight == 0){
            return true;
        }
        else if(distanceUpAndDown == 1 && distanceLeftAndRight == 1){
            return true;
        }
        return false;
    }
    public boolean followsExceptionalRules(int[] command){
        boolean check = false;
        return check;
    }

    public void setProperty(String input,String name,Pieces piece,String color){
        position=convertor(input);
        this.name=name;
        Board.getBoard()[position[0]][position[1]]=piece;
        this.color=color;
    }
}
