public class Bishop extends Pieces
{   
    public boolean rules(int[] command){
        int distanceUpAndDown =  Math.abs(command[0]- position[0]);
        int distanceLeftAndRight =  Math.abs(command[1]- position[1]);
        if(distanceUpAndDown==distanceLeftAndRight){return testBlockOfBishop(command);}
        return false;
    }
    private boolean testBlockOfBishop(int command[])
    {
        int unitRow;
        int unitColumn;
        if(command[0]>position[0]){unitRow=-1;}
        else{unitRow=1;}
        if(command[1]>position[1]){unitColumn=-1;}
        else{unitColumn=1;}
        boolean checkForReturn=true;
        int row=command[0];
        int column=command[1];
        for(int i=0;i<Math.abs(position[0]-command[0])-1;i++){
            row=row+unitRow;
            column=column+unitColumn;
            if(Board.getBoard()[row][column]!=null){
                checkForReturn=false;
                break;
            }
        }
        return checkForReturn;
    }
    public boolean ifAllowedToMove(int[] command){
        boolean check=false;
        if(rules(command)){check=true;}
        if(exceptionalRules(command)){check = true;}
        if(check==true){movementNumCount++;}
         return check;
    }
    public boolean exceptionalRules(int[] command){
        return false;
    }
    public void setProperty(String input,String name,Pieces piece,String color){
        position=convertor(input);
        this.name=name;
        Board.getBoard()[position[0]][position[1]]=piece;
        this.color=color;
    }
}

