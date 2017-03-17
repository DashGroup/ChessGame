public class Bishop extends Pieces
{   
    //if moving diagonally
    public boolean followsBasicRules(int[] command){
        int verticalDistance =  Math.abs(command[0]- position[0]);
        int horizontalDistance =  Math.abs(command[1]- position[1]);
        if(verticalDistance==horizontalDistance){return isBlocked(command);}
        return false;
    }
    private int calculateUnitRowOrColumn(int command[], int i){
        int unit;
        if(command[i]>position[i]){
            unit = -1;
        }
        else{
            unit = 1;
        }
        return unit;
    }
    private boolean isBlocked(int command[]){
        int unitRow = calculateUnitRowOrColumn(command,0);
        int unitColumn = calculateUnitRowOrColumn(command,1);
        boolean checkForReturn=true;
        int row=command[0];
        int column=command[1];
        for(int i = 0;i<Math.abs(position[0]-command[0])-1;i++){
            row=row+unitRow;
            column=column+unitColumn;
            if(Board.getBoard()[row][column]!=null){
                checkForReturn=false;
                break;
            }
        }
        return checkForReturn;
    }
    // no exceptional rules
    public boolean followsExceptionalRules(int[] command){
        return false;
    }
    public void setProperty(String input,String name,Pieces piece,String color){
        position=convertor(input);
        this.name=name;
        Board.getBoard()[position[0]][position[1]]=piece;
        this.color=color;
    }
}

