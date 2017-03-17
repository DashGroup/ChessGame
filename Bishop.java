public class Bishop extends Pieces
{   
    //if moving diagonally
    public boolean followsBasicRules(int[] command){
        int distanceUpAndDown =  Math.abs(command[0]- position[0]);
        int distanceLeftAndRight =  Math.abs(command[1]- position[1]);
        if(distanceUpAndDown==distanceLeftAndRight){return isBlocked(command);}
        return false;
    }
    private int calculateUnitRow(int command[]){
        int unitRow;
        if(command[0]>position[0]){
            unitRow=-1;
        }
        else{
            unitRow=1;
        }
        return unitRow;
    }
    private int calculateUnitColumn(int command[]){
        int unitColumn;
        if(command[1]>position[1]){
            unitColumn=-1;
        }
        else{
            unitColumn=1;
        }
        return unitColumn;
    }
    private boolean isBlocked(int command[]){
        int unitRow = calculateUnitRow(command);
        int unitColumn = calculateUnitColumn(command);
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

