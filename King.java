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
        //if(followsBasicRules(command) == true) {movementNumCount++;}
        if(movementNumCount == 0 &&  (command[0]-position[0]) == 0 && Math.abs(command[1]-position[1]) == 2&&
        getRook(command[1]).name.substring(1).equals("RK")&&getRook(command[1]).movementNumCount==0){
            check = isBlockOfKing(command);
            if(check){
                Pieces rookN = getRook(command[1]);
                if(rookN!=null){
                    if(rookN.name.equals("WRK")||rookN.name.equals("BRK")){
                        if(rookN.movementNumCount==0){
                            check = true;
                            int position1 = rookN.position[0];
                            int position2 = rookN.position[1];
                            Board.getBoard()[position1][position2] = null;
                            if(position2==7){
                                Board.getBoard()[position1][5]=rookN;
                                rookN.setPosition(position1,5);
                                rookN.movementNumCount++;
                            }
                            else if(position2==0){
                                Board.getBoard()[position1][3]=rookN;
                                rookN.setPosition(position1,3);
                                rookN.movementNumCount++;
                            }
                        }
                    }
                }
                else{
                    check = false;
                }
            }
        }
       
        return check;
    }
    private Pieces getRook(int dividedCommand){
        Pieces forReturn;
        if(dividedCommand==6){
            if(color.equalsIgnoreCase("white")){
                forReturn = Board.getBoard()[7][7];
            }
            else{
                forReturn = Board.getBoard()[0][7];
            }
        }
        else{
            if(color.equalsIgnoreCase("white")){
                forReturn = Board.getBoard()[7][0];
            }
            else{
                forReturn = Board.getBoard()[0][0];
            }
        }
        return forReturn;
    }
    private boolean isBlockOfKing(int[] command){
        int unitColumn = 0;
        boolean checkForReturn=true;
        int column=command[1];
        if(command[1]>position[1]){unitColumn = -1;}
        else if(command[1]<position[1]){unitColumn = 1;}
        for(int i=0;i<Math.abs(position[1]-command[1])-1;i++){
             column = column+unitColumn;
            if(Board.getBoard()[command[0]][column]!=null){
                checkForReturn=false;
                break;
            }
        }
        return checkForReturn;
    }
    public void setProperty(String input,String name,Pieces piece,String color){
        position=convertor(input);
        this.name=name;
        Board.getBoard()[position[0]][position[1]]=piece;
        this.color=color;
        this.stayTurn=1;
    }
}
