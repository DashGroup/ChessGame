public class Rook extends Pieces
{
    //check if the command is correct to move up down or right left
    public boolean followsBasicRules(int[] command){
        boolean check = false;
        if(command[1]==position[1]){
            check = isNotBlockedByAnotherPieceUpOrDown(command);
        }
        else if(command[0]==position[0]){
            check = isNotBlockedByAnotherPieceRightOrLeft(command);
        }
        return check;
    }
    private int calculateUnitIndex(int[] command, int i){
        if(command[i]<position[i]){
            return -1;
        }
        else{
            return 1;
        }
    }
    private boolean isNotBlockedByAnotherPieceUpOrDown(int[] command){//No block ==> true
        boolean check = false;
        int addIndex = calculateUnitIndex(command,0);
        check = checkBlockedHelperUpOrDown(command,addIndex);
        return check;
    }
    private boolean isNotBlockedByAnotherPieceRightOrLeft(int[] command){
        boolean check = false;
        int addIndex = calculateUnitIndex(command,1);
        check = checkBlockedHelperRightOrLeft(command,addIndex);
        return check;
    }
    private boolean isEnemy(int[] command){
        return Board.getBoard()[command[0]][command[1]]!=null&&!Board.getBoard()[command[0]][command[1]].color.equals(color);
    }
    //return true if no blocked or when tested to the end index to check if the blocked one is with different color
    private boolean checkBlockedHelperUpOrDown(int[] command, int addIndex){
        boolean checkForReturn = true;
        boolean check = true;
        int index = position[0]+addIndex;   
        while(check){
            if(Board.getBoard()[index][command[1]]!=null){
                checkForReturn = false;
                check = false;
            }
            if(index==command[0]){
                check = false;
                if(isEnemy(command)){
                    checkForReturn = true;
                }
            }
            index+=addIndex;
        }
        return checkForReturn;
    }
    private boolean checkBlockedHelperRightOrLeft(int[] command, int addIndex){
        boolean checkForReturn = true;
        boolean check = true;
        int index = position[1]+addIndex;        
        while(check){
            if(Board.getBoard()[command[0]][index]!=null){
                checkForReturn = false;
                check = false;
            }
            if(index==command[1]){
                check = false;
                if(isEnemy(command)){
                    checkForReturn = true;
                }    
            }
            index+=addIndex;
        }
        return checkForReturn;
    }
    //no exceptionalRules for rook
    public boolean followsExceptionalRules(int[] command){
        return false;
    }
    public void setProperty(String input,String name,Pieces piece,String color){
        position=convertor(input);
        this.name=name;
        Board.getBoard()[position[0]][position[1]]=piece;
        this.color=color;
        this.stayTurn=1;
    }
}
