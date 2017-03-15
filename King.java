public class King extends Pieces
{
    public boolean rules(int[] command){
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
    public boolean exceptionalRules(int[] command){
        boolean check = false;
        return check;
    }
    public boolean ifAllowedToMove(int[] command){
        boolean check = false;
        if(rules(command)){check = true;}
        if(exceptionalRules(command)){check = true;}
        if(check == true){movementNumCount++;}
        return check;
    }
    public void setProperty(String input,String name,Pieces piece,String color){
        position=convertor(input);
        this.name=name;
        Board.getBoard()[position[0]][position[1]]=piece;
        this.color=color;
    }
}
