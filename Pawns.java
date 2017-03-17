public class Pawns extends Pieces
{
    // if moving one step forward or eating anyone diagnally
    public boolean followsBasicRules(int[] command){
        boolean check = false;
        if(color.equalsIgnoreCase("white")){
            if(command[1]==position[1]){
                if(Board.getBoard()[command[0]][command[1]]==null){
                    if(command[0]+1==position[0]){check = true;}    
                }
            }
            else if((command[1]+1==position[1])||(command[1]-1==position[1])){
                if(Board.getBoard()[command[0]][command[1]]!=null&&
                Board.getBoard()[command[0]][command[1]].color.equalsIgnoreCase("black")){
                    if(command[0]+1==position[0]){check = true;}
                }
            }
        }
        else if(color.equalsIgnoreCase("black")){
            if(command[1]==position[1]){
               if(Board.getBoard()[command[0]][command[1]]==null){
                    if(command[0]-1==position[0]){check = true;}
               }
            }
            else if((command[1]+1==position[1])||(command[1]-1==position[1])){
                if(Board.getBoard()[command[0]][command[1]]!=null&&
                Board.getBoard()[command[0]][command[1]].color.equalsIgnoreCase("white")){
                    if(command[0]-1==position[0]){check = true;}
                }
            }
        }              
        return check;
    }
    //if not moved before, then check if the command is to ask the piece to move two step forward
    public boolean followsExceptionalRules(int[] command){//the second arr;
        boolean check = false;
        if(color.equalsIgnoreCase("white")){
            if(position[0]==6){
                if(command[1]==position[1]){//first move
                    if(command[0]+2==position[0]&&Board.getBoard()[command[0]+1][command[1]]==null){
                        check = true;
                        
                    }
                }
            }
        }
        else if(color.equalsIgnoreCase("black")){//first move
            if(position[0]==1){
                if(command[1]==position[1]){
                    if(command[0]-2==position[0]&&Board.getBoard()[command[0]-1][command[1]]==null){
                        check = true;
                        
                    }
                }
            }            
        }
        return check;
    }

    public void setProperty(String input,String name,Pieces piece,String color){
        position=convertor(input);
        this.name=name;
        Board.getBoard()[position[0]][position[1]]=piece;
        this.color=color;
    }
}
