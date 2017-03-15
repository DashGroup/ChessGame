public class Rook extends Pieces
{
    public boolean rules(int[] command){//check if the command is correct to move
        boolean check = false;
        if(command[1]==position[1]){check = ifNotBlockedByAnotherPiece(command,0);}
        else if(command[0]==position[0]){check = ifNotBlockedByAnotherPiece(command,1);}
        return check;
    }
    private boolean ifNotBlockedByAnotherPiece(int[] command,int upDownOrRightLeft){//No block ==> true
        boolean check = false;
        int addIndex = 0;
        if(upDownOrRightLeft==0){
            if(command[0]<position[0]){addIndex = -1;}
            else{addIndex = 1;}
            check = checkBlockedHelperUpOrDown(command,addIndex);
        }   
        else if(upDownOrRightLeft==1){
            if(command[1]>position[1]){addIndex = 1;}
            else{addIndex = -1;}
            check = checkBlockedHelperRightOrLeft(command,addIndex);
        }
        return check;
    }
    private boolean checkBlockedHelperUpOrDown(int[] command, int addIndex){
        boolean checkForReturn = true;
        boolean check = true;
        int index = position[0]+addIndex;   
        System.out.println(index);
        while(check){
            if(Board.getBoard()[index][command[1]]!=null){
                checkForReturn = false;
                check = false;
            }
            index+=addIndex;
            if(index==command[0]){check = false;}
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
            index+=addIndex;
            if(index==command[0]){check = false;}
        }
        return checkForReturn;
    }
    public boolean exceptionalRules(int[] command){//no exceptionalRules for rook
        return false;
    }
    public boolean ifAllowedToMove(int[] command){//check both if anyone 
        boolean check = false;
        if(rules(command)==true){check = true;}
        if(exceptionalRules(command)==true){check = true;}
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
