public class Queen extends Pieces
{ 
    public boolean followsBasicRules(int[] command){
        int newPosition1=position[0];
        int newPosition2=position[1];
        int distanceUpAndDown = command[0]- position[0];
        int distanceLeftAndRight = command[1]- position[1];
        Pieces inWay=null;
        if(Math.abs(distanceUpAndDown) == Math.abs(distanceLeftAndRight)){
            int i=0;
            while(i<(Math.abs(distanceUpAndDown)-1)){
               if(distanceUpAndDown>0 && distanceLeftAndRight>0){
                  inWay=Board.getBoard()[++newPosition1][++newPosition2];}
               else if(distanceUpAndDown>0 &&distanceLeftAndRight<0){
                  inWay=Board.getBoard()[++newPosition1][--newPosition2];}
               else if(distanceUpAndDown<0 && distanceLeftAndRight<0){
                  inWay=Board.getBoard()[--newPosition1][--newPosition2];}
               else if(distanceUpAndDown<0 && distanceLeftAndRight>0){
                  inWay=Board.getBoard()[--newPosition1][++newPosition2];}
               if(inWay!=null)
                 return false;
               i++;
            }
            return true;
        }
        else if((distanceUpAndDown==0&& distanceLeftAndRight!=0 )||( 
        distanceLeftAndRight==0 && distanceUpAndDown!=0)){
            int count=0;
            if(distanceUpAndDown!=0)
               count=Math.abs(distanceUpAndDown);
            else 
               count=Math.abs(distanceLeftAndRight);
            int i=0;
            while(i<(Math.abs(count)-1)){
              if(distanceUpAndDown<0 && distanceLeftAndRight==0)
                inWay=Board.getBoard()[--newPosition1][newPosition2]; 
              else if(distanceUpAndDown>0 && distanceLeftAndRight==0)
                inWay=Board.getBoard()[++newPosition1][newPosition2];
              else if(distanceUpAndDown==0 && distanceLeftAndRight>0)
                inWay=Board.getBoard()[newPosition1][++newPosition2];
              else if(distanceUpAndDown==0 && distanceLeftAndRight<0)
                inWay=Board.getBoard()[newPosition1][--newPosition2];
              if(inWay!=null)
                 return false;           
              i++;
            }    
            return true;
        }
        return false;
    }
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
