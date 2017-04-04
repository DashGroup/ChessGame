public class Queen extends Pieces
{ 
    public boolean followsBasicRules(int[] command){
        return testBlocks(command);
    }
    public boolean followsExceptionalRules(int[] command){
        return false;
    }
    public boolean testBlocks(int[]command)
    {
        int verticalDistance = command[0]- position[0];
        int horizontalDistance = command[1]- position[1];
        if(Math.abs(verticalDistance) == Math.abs(horizontalDistance)){
            return checkInwayDiagonal(command,verticalDistance,horizontalDistance);
        }
        else if((verticalDistance==0&&horizontalDistance!=0)||(horizontalDistance==0&&verticalDistance!=0))
        {
            return checkInwayVerticalHorizontal(command,verticalDistance,horizontalDistance);
        }
        return false;
    }
    public boolean checkInwayDiagonal(int[]command,int verticalDistance, int horizontalDistance)
    {
            int checkPositionRow=position[0];
            int checkPositionColumn=position[1];
            Pieces inWay=null;
            int i=0;
            while(i<(Math.abs(verticalDistance)-1)){
               if(verticalDistance>0)
                   ++checkPositionRow;
               else
                   --checkPositionRow;
               if(horizontalDistance>0)
                   ++checkPositionColumn;
               else
                   --checkPositionColumn;
               inWay=Board.getBoard()[checkPositionRow][checkPositionColumn];
               if(inWay!=null)
                 return false;
               i++;
            }
            return true;
    }
    public boolean checkInwayVerticalHorizontal(int[]command,int verticalDistance, int horizontalDistance)
    {
            int checkPositionRow=position[0];
            int checkPositionColumn=position[1];
            Pieces inWay=null;
            int count=0;
            if(verticalDistance!=0)
               count=Math.abs(verticalDistance);
            else 
               count=Math.abs(horizontalDistance);
            int i=0;
            while(i<(Math.abs(count)-1)){
              if(verticalDistance>0)
                   ++checkPositionRow;
               else if(verticalDistance<0)
                   --checkPositionRow; 
              if(horizontalDistance>0)
                   ++checkPositionColumn;
               else if(horizontalDistance<0)
                   --checkPositionColumn;
              inWay=Board.getBoard()[checkPositionRow][checkPositionColumn]; 
              if(inWay!=null)
                 return false;           
              i++;
            }    
            return true;
    }
    public void setProperty(String input,String name,Pieces piece,String color){
        position=convertor(input);
        this.name=name;
        Board.getBoard()[position[0]][position[1]]=piece;
        this.color=color;
        this.stayTurn=1;
    }
}
