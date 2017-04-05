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
                isRookOnPosition(command);
            }
        }
        return check;
    }
    private void isRookOnPosition(int[] command){
        Pieces rookN = getRook(command[1]);
        boolean check = false;
        if(rookN!=null){
            if(rookN.name.equals("WRK")||rookN.name.equals("BRK")){rookNmovementNumCount(command);}
        }
    }
    private void rookNmovementNumCount(int[] command){
        Pieces rookN = getRook(command[1]);
        boolean check = false;
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
    private Pieces getRook(int dividedCommand){
        Pieces forReturn;
        if(dividedCommand==6){
            if(color.equalsIgnoreCase("white")){forReturn = Board.getBoard()[7][7];}
            else{forReturn = Board.getBoard()[0][7];}
        }
        else{
            if(color.equalsIgnoreCase("white")){forReturn = Board.getBoard()[7][0];}
            else{forReturn = Board.getBoard()[0][0];}
        }
        return forReturn;
    }
    private boolean isBlockOfKing(int[] command){
        int unitColumn = 0;
        boolean checkForReturn=true;
        int column=position[1];
        int limitMax = 0;
        if(command[1]>position[1]){unitColumn = 1;limitMax = 2;}
        else if(command[1]<position[1]){unitColumn = -1;limitMax = 3;}
        for(int i=0;i<limitMax;i++){
            column = column+unitColumn;
            int checkPosition[] = {command[0],column};
            if(Board.getBoard()[command[0]][column]!=null||isThreatened(checkPosition)){
                checkForReturn=false;
                break;
            }
        }
        return checkForReturn;
    }
    private boolean isThreatened(int checkPosition[]){//return true if is threatened
        boolean forReturn = false;
        boolean checkUpDown = false;
        boolean checkUpDownRight = false;
        boolean checkUpDownLeft = false;
        boolean checkKnight = false;
        int left = checkPosition[1]-1;
        int right = checkPosition[1]+1;
        boolean check = true;
        int[][] positions = new int[4][2];
        if(checkPosition[0]==7){
            int position1[]={checkPosition[0]-1,checkPosition[1]-2};
            int position2[]={checkPosition[0]-2,checkPosition[1]-1};
            int position3[]={checkPosition[0]-1,checkPosition[1]+2};
            int position4[]={checkPosition[0]-2,checkPosition[1]+1};
            positions[0]=position1;
            positions[1]=position2;
            positions[2]=position3;
            positions[3]=position4;
        }
        else{
            check = false;
            int position1[]={checkPosition[0]+1,checkPosition[1]-2};
            int position2[]={checkPosition[0]+2,checkPosition[1]-1};
            int position3[]={checkPosition[0]+1,checkPosition[1]+2};
            int position4[]={checkPosition[0]-2,checkPosition[1]+1};
            positions[0]=position1;
            positions[1]=position2;
            positions[2]=position3;
            positions[3]=position4;
        }
        if(check){
            for(int i = checkPosition[0]-1;i>=0;i--){
                if(Board.getBoard()[i][checkPosition[1]]!=null){
                    if(Board.getBoard()[i][checkPosition[1]].color.equals(this.color)){break;}
                    else{
                        if(Board.getBoard()[i][checkPosition[1]].name.substring(1).equals("RK")||
                        Board.getBoard()[i][checkPosition[1]].name.substring(1).equals("QN")){checkUpDown = true;break;}
                    }
                }
            }
            for(int i = checkPosition[0]-1;i>=0&&right<8;i--){//right
                if(Board.getBoard()[i][right]!=null){
                    if(Board.getBoard()[i][right].color.equals(this.color)){break;}
                    else{
                        if(Board.getBoard()[i][right].name.substring(1).equals("BP")||
                        Board.getBoard()[i][right].name.substring(1).equals("QN")){checkUpDownRight = true;break;}
                        if(Board.getBoard()[i][right].name.substring(1).equals("PN")&&right==checkPosition[1]+1){checkUpDownRight = true;
                            break;}
                    }
                }
                right++;
            }
            for(int i = checkPosition[0]-1;i>=0&&left>=0;i--){
                if(Board.getBoard()[i][left]!=null){
                    if(Board.getBoard()[i][left].color.equals(this.color)){break;}
                    else{
                        if(Board.getBoard()[i][left].name.substring(1).equals("BP")||
                        Board.getBoard()[i][left].name.substring(1).equals("QN")){checkUpDownLeft = true;break;}
                        if(Board.getBoard()[i][left].name.substring(1).equals("PN")&&left==checkPosition[1]-1){checkUpDownLeft = true;
                            break;}
                    }
                }
                left--;
            }
        }
        else{
            for(int i = checkPosition[0]+1;i<8;i++){
                if(Board.getBoard()[i][checkPosition[1]]!=null){
                    if(Board.getBoard()[i][checkPosition[1]].color.equals(this.color)){break;}
                    else{
                        if(Board.getBoard()[i][checkPosition[1]].name.substring(1).equals("RK")||
                        Board.getBoard()[i][checkPosition[1]].name.substring(1).equals("QN")){checkUpDown = true;break;}
                    }
                }
            }
            for(int i = checkPosition[0]+1;i<8&&right<8;i++){//right
                if(Board.getBoard()[i][right]!=null){
                    if(Board.getBoard()[i][right].color.equals(this.color)){break;}
                    else{
                        if(Board.getBoard()[i][right].name.substring(1).equals("BP")||
                        Board.getBoard()[i][right].name.substring(1).equals("QN")){checkUpDownRight = true;break;}
                        if(Board.getBoard()[i][right].name.substring(1).equals("PN")&&right==checkPosition[1]+1){checkUpDownRight = true;
                            break;}
                    }
                }
                right++;
            }
            for(int i = checkPosition[0]+1;i<8&&left>=0;i++){
                if(Board.getBoard()[i][left]!=null){
                    if(Board.getBoard()[i][left].color.equals(this.color)){break;}
                    else{
                        if(Board.getBoard()[i][left].name.substring(1).equals("BP")||
                        Board.getBoard()[i][left].name.substring(1).equals("QN")){checkUpDownLeft = true;break;}
                        if(Board.getBoard()[i][left].name.substring(1).equals("PN")&&left==checkPosition[1]-1){checkUpDownLeft = true;
                            break;}
                    }
                }
                left--;
            }
        }
        for(int i = 0;i<4;i++){
            int position2[] = positions[i];
            if(position2[0]<8&&position2[0]>=0&&position2[1]>=0&&position2[1]<8){
                if(Board.getBoard()[position2[0]][position2[1]]!=null){
                    if(!Board.getBoard()[position2[0]][position2[1]].color.equals(this.color)){
                        if(Board.getBoard()[position2[0]][position2[1]].name.substring(1).equals("KT")){
                            checkKnight=true;break;
                        }
                    }
                }
            }
        }
        if(checkUpDown==true||checkUpDownRight==true||checkUpDownLeft==true||checkKnight==true){
            forReturn = true;
        }
        return forReturn;
    }
    public void setProperty(String input,String name,Pieces piece,String color){
        position=convertor(input);
        this.name=name;
        Board.getBoard()[position[0]][position[1]]=piece;
        this.color=color;
        this.stayTurn=1;
    }
}
