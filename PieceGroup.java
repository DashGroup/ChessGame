import java.util.*;
public class PieceGroup 
{ 
    protected Knight knight1 = new Knight();
    protected Knight knight2 = new Knight();
    protected Queen queen = new Queen();
    protected King king = new King();
    protected Bishop bishop1  = new Bishop();
    protected Bishop bishop2 = new Bishop();
    protected Rook rook1 = new Rook();
    protected Rook rook2 = new Rook();
    protected Pawns pawns1 = new Pawns();
    protected Pawns pawns2 = new Pawns();
    protected Pawns pawns3 = new Pawns();
    protected Pawns pawns4 = new Pawns();
    protected Pawns pawns5 = new Pawns();
    protected Pawns pawns6 = new Pawns();
    protected Pawns pawns7 = new Pawns();
    protected Pawns pawns8 = new Pawns();
    private int count ;
    private static String turn;
    private int lastCount = 1;
    private int coordinationForOnce[] =new int[2];
    private boolean checkTenLengthCommandValidable = true;
    ArrayList<Pieces> piecesToBeCheck = new ArrayList<Pieces>(16);
    PieceGroup(String input){
        if(input.equals ("white")){
            knight1.setProperty("B1","WKT",knight1,"white");
            knight2.setProperty("G1","WKT",knight2,"white");
            queen.setProperty("D1","WQN",queen,"white");
            king.setProperty("E1","WKG",king,"white");
            bishop1.setProperty("C1","WBP",bishop1,"white");
            bishop2.setProperty("F1","WBP",bishop2,"white");
            rook1.setProperty("A1","WRK",rook1,"white");
            rook2.setProperty("H1","WRK",rook2,"white");
            pawns1.setProperty("A2","WPN",pawns1,"white");
            pawns2.setProperty("B2","WPN",pawns2,"white");
            pawns3.setProperty("C2","WPN",pawns3,"white");
            pawns4.setProperty("D2","WPN",pawns4,"white");
            pawns5.setProperty("E2","WPN",pawns5,"white");
            pawns6.setProperty("F2","WPN",pawns6,"white");
            pawns7.setProperty("G2","WPN",pawns7,"white");
            pawns8.setProperty("H2","WPN",pawns8,"white");
        }
        else{
            knight1.setProperty("B8","BKT",knight1,"black");
            knight2.setProperty("G8","BKT",knight2,"black");
            queen.setProperty("D8","BQN",queen,"black");
            king.setProperty("E8","BKG",king,"black");
            bishop1.setProperty("C8","BBP",bishop1,"black");
            bishop2.setProperty("F8","BBP",bishop2,"black");
            rook1.setProperty("A8","BRK",rook1,"black");
            rook2.setProperty("H8","BRK",rook2,"black");
            pawns1.setProperty("A7","BPN",pawns1,"black");
            pawns2.setProperty("B7","BPN",pawns2,"black");
            pawns3.setProperty("C7","BPN",pawns3,"black");
            pawns4.setProperty("D7","BPN",pawns4,"black");
            pawns5.setProperty("E7","BPN",pawns5,"black");
            pawns6.setProperty("F7","BPN",pawns6,"black");
            pawns7.setProperty("G7","BPN",pawns7,"black");
            pawns8.setProperty("H7","BPN",pawns8,"black");
        }
        count=1;
        turn = "white";
    }
    public static String getTurn(){return turn;}
    private Pieces getKing(){
        if(turn == "white"){return Board.getGroup("black").king;}
        else{return Board.getGroup("white").king;}
    }
    private Pieces getKing2(){
        if(turn == "white"){return Board.getGroup("white").king;}
        else{return Board.getGroup("black").king;}
    }
    public void run(String command) throws InvalidMoveException,CheckmateException{
        if(command.length()==10&&checkTenLengthCommandValidable){
            String[] arr=disposeString(command);
            int[] coordination1=rook1.convertor(arr[0]);
            int[] coordination2=rook1.convertor(arr[1]);//coordination
            String colorRequirement="";
            String antiColorRequirement="";
            if(count%2==0){
                colorRequirement="black";  
                antiColorRequirement = "white";
            }
            else{
                colorRequirement="white";
                antiColorRequirement = "black";
            }           
            if(Board.getBoard()[coordination2[0]][coordination2[1]]==null&&
                Board.getBoard()[coordination1[0]][coordination1[1]]!=null&&
                Board.getBoard()[coordination1[0]][coordination1[1]].color.equals(colorRequirement)){
                if(Board.getBoard()[coordination1[0]][coordination1[1]].isAllowedToMove(coordination2)
                &&isCheck(getKing2())==false){
                    Board.getBoard()[coordination1[0]][coordination1[1]].position[0]=coordination2[0];
                    Board.getBoard()[coordination1[0]][coordination1[1]].position[1]=coordination2[1];
                    Board.getBoard()[coordination2[0]][coordination2[1]]=Board.getBoard()[coordination1[0]][coordination1[1]];
                    Board.getBoard()[coordination1[0]][coordination1[1]]=null;
                    if(isCheck(getKing2())==false){
                        count++;
                    }
                    else{
                        Board.getBoard()[coordination1[0]][coordination1[1]]=Board.getBoard()[coordination2[0]][coordination2[1]];
                        Board.getBoard()[coordination2[0]][coordination2[1]]=null;
                        Board.getBoard()[coordination1[0]][coordination1[1]].setPosition(coordination1[0],coordination1[1]);
                    }
                }
                else if(Board.getBoard()[coordination1[0]][coordination1[1]].isAllowedToMove(coordination2)&&isCheck(getKing2())==true){
                    Pieces lastMovingPiece = Board.getBoard()[coordination1[0]][coordination1[1]];
                    Board.getBoard()[coordination2[0]][coordination2[1]]=lastMovingPiece;
                    lastMovingPiece.position[0]=coordination2[0];
                    lastMovingPiece.position[1]=coordination2[1];
                    Board.getBoard()[coordination1[0]][coordination1[1]]=null;
                    if(isCheck(getKing2())==true){
                        Board.getBoard()[coordination2[0]][coordination2[1]]=null;
                        Board.getBoard()[coordination1[0]][coordination1[1]]=lastMovingPiece;
                        lastMovingPiece.position[0]=coordination1[0];
                        lastMovingPiece.position[1]=coordination1[1];
                    }
                    else{
                        count++;
                    }
                }
            }
            else if((Board.getBoard()[coordination2[0]][coordination2[1]]!=null)&&Board.getBoard()[coordination1[0]][coordination1[1]]!=null){
                if(Board.getBoard()[coordination2[0]][coordination2[1]].color.equals(antiColorRequirement)&&
                    Board.getBoard()[coordination1[0]][coordination1[1]].color.equals(colorRequirement)){
                    if(Board.getBoard()[coordination1[0]][coordination1[1]].isAllowedToMove(coordination2)
                    &&isCheck(getKing2())==false){
                        Board.getBoard()[coordination1[0]][coordination1[1]].position[0]=coordination2[0];
                        Board.getBoard()[coordination1[0]][coordination1[1]].position[1]=coordination2[1];
                        Pieces eatenOne = Board.getBoard()[coordination2[0]][coordination2[1]];
                        Board.getBoard()[coordination2[0]][coordination2[1]]=null;
                        Board.getBoard()[coordination2[0]][coordination2[1]]=Board.getBoard()[coordination1[0]][coordination1[1]];
                        Board.getBoard()[coordination1[0]][coordination1[1]]=null;
                        if(isCheck(getKing2())==false){
                            count++;
                        }
                        else{
                            Board.getBoard()[coordination1[0]][coordination1[1]]=Board.getBoard()[coordination2[0]][coordination2[1]];
                            Board.getBoard()[coordination2[0]][coordination2[1]]=eatenOne;
                            Board.getBoard()[coordination1[0]][coordination1[1]].setPosition(coordination1[0],coordination1[1]);
                        }
                    }
                    else if(Board.getBoard()[coordination1[0]][coordination1[1]].isAllowedToMove(coordination2)&&isCheck(getKing2())==true){
                        Pieces lastMovingPiece = Board.getBoard()[coordination1[0]][coordination1[1]];
                        Pieces eatenPiece = Board.getBoard()[coordination2[0]][coordination2[1]];
                        Board.getBoard()[coordination2[0]][coordination2[1]]=lastMovingPiece;
                        lastMovingPiece.position[0]=coordination2[0];
                        lastMovingPiece.position[1]=coordination2[1];
                        Board.getBoard()[coordination1[0]][coordination1[1]]=null;
                        if(isCheck(getKing2())==true){
                            Board.getBoard()[coordination2[0]][coordination2[1]]=eatenPiece;
                            Board.getBoard()[coordination1[0]][coordination1[1]]=lastMovingPiece;
                            lastMovingPiece.position[0]=coordination1[0];
                            lastMovingPiece.position[1]=coordination1[1];
                        }
                        else{count++;}
                    }
                }   
            }
            if(isCheck(getKing())){
                if(isCheckMate(getKing())){
                    System.out.println("End of the Game! "+getKing().color+" has been checkmated by "+getKing2().color);
                    throw new CheckmateException(getKing().color);
                }
                else
                    System.out.println(getKing().color+" king is checked");
            }
            else if(isCheck(getKing2())){
                System.out.println(getKing2().color+" king is checked");
            }
            if(Board.getBoard()[coordination2[0]][coordination2[1]]!=null){
                if(Board.getBoard()[coordination2[0]][coordination2[1]].name.substring(1).equals("PN")&&(coordination2[0]==7||coordination2[0]==0)&&
                Board.getBoard()[coordination2[0]][coordination2[1]].color.equals(colorRequirement)){
                    count--;
                    lastCount--;
                    coordinationForOnce[0]=coordination2[0];
                    coordinationForOnce[1]=coordination2[1];
                    checkTenLengthCommandValidable = false;
                    System.out.println("Please enter the name of the piece that you want the pawn to change to E.g queen");
                }
            }
        }    
        else if(command.length()!=10&&checkTenLengthCommandValidable!=true){
            try{
                Pieces newPiece = getNewPiece(command);
                newPiece.setPosition(coordinationForOnce[0],coordinationForOnce[1]);
                Board.getBoard()[coordinationForOnce[0]][coordinationForOnce[1]] = newPiece;
                coordinationForOnce = new int[2];
                count++;
                checkTenLengthCommandValidable = true;
            }
            catch(WrongNameException e){
                System.out.println("Sorry " + command + " is not a correct name");
            }
        }
        if(count == lastCount){throw new InvalidMoveException(command);}
        else{
            lastCount++;
            addStayTurn();
        }
        if(count%2==0){turn="black";  }
        else{turn="white";}
    }
    private boolean isCheckMate(Pieces king){//return true if is checkmate
        boolean forReturn = false;
        if(checkAroundKing(king)&&checkOtherPieces(king)){forReturn = true;}
        return forReturn;
    }
    private boolean checkAroundKing(Pieces king){//return true if no where can move for the king
        boolean forReturn = false;
        int checkCount=0;
        int horizontalPosition = king.position[1];
        int verticalPosition = king.position[0];
        Pieces potentialEatenOne = null;
        int position1[] = {verticalPosition-1,horizontalPosition};
        int position2[] = {verticalPosition+1,horizontalPosition};
        int position3[] = {verticalPosition,horizontalPosition-1};
        int position4[] = {verticalPosition,horizontalPosition+1};
        int position5[] = {verticalPosition-1,horizontalPosition+1};
        int position6[] = {verticalPosition-1,horizontalPosition-1};
        int position7[] = {verticalPosition+1,horizontalPosition+1};
        int position8[] = {verticalPosition+1,horizontalPosition-1};
        int[] potentialPosition[]={position1,position2,position3,position4,position5,position6,position7,position8};
        for(int i = 0;i<8;i++){
            int position[] = potentialPosition[i];
            if((position[0]>=0&&position[0]<8)&&(position[1]>=0&&position[1]<8)){
                if(Board.getBoard()[position[0]][position[1]]==null||(!Board.getBoard()[position[0]][position[1]].color.equals(king.color))){
                    if(Board.getBoard()[position[0]][position[1]]!=null){
                        if(!Board.getBoard()[position[0]][position[1]].color.equals(king.color)){
                            potentialEatenOne = Board.getBoard()[position[0]][position[1]];
                            Board.getBoard()[position[0]][position[1]]=king;
                            Board.getBoard()[position[0]][position[1]]=null;
                            king.setPosition(position[0],position[1]);
                            if(isCheck(king)){checkCount++;}
                            Board.getBoard()[verticalPosition][horizontalPosition]=king;
                            king.setPosition(verticalPosition,horizontalPosition);
                            Board.getBoard()[position[0]][position[1]]=potentialEatenOne;
                        }
                        else{checkCount++;}
                    }
                    else{
                        Board.getBoard()[position[0]][position[1]]=king;
                        Board.getBoard()[verticalPosition][horizontalPosition]=null;
                        king.setPosition(position[0],position[1]);
                        if(isCheck(king)){checkCount++;}
                        Board.getBoard()[verticalPosition][horizontalPosition]=king;
                        king.setPosition(verticalPosition,horizontalPosition);
                        Board.getBoard()[position[0]][position[1]]=null;
                    }
                }
                else{checkCount++;}
            }   
            else{checkCount++;}
        }
        if(checkCount==8){forReturn = true;}
        return forReturn;
    }
    private boolean checkOtherPieces(Pieces king){//return true if no pieces can save the king
        boolean forReturn = true;
        for(int i =0;i<8;i++){
            for(int k = 0;k<8;k++){
                if(Board.getBoard()[i][k]!=null){
                    if(Board.getBoard()[i][k].color.equals(king.color)&&(!Board.getBoard()[i][k].name.substring(1).equals("KG"))){
                        piecesToBeCheck.add(Board.getBoard()[i][k]);
                    }
                }
            }
        }
        ArrayList fiveKindsPiecesCheck = new ArrayList(piecesToBeCheck.size());
        for(int i = 0;i<piecesToBeCheck.size();i++){
            Pieces toBeCheck = piecesToBeCheck.get(i);
            if(toBeCheck.name.substring(1).equals("PN")){
                fiveKindsPiecesCheck.add(checkPawns(toBeCheck));
            }
            else if(toBeCheck.name.substring(1).equals("QN")){
                fiveKindsPiecesCheck.add(checkQueens(toBeCheck));
            }
            else if(toBeCheck.name.substring(1).equals("KT")){
                fiveKindsPiecesCheck.add(checkKnights(toBeCheck));
            }
            else if(toBeCheck.name.substring(1).equals("RK")){
                fiveKindsPiecesCheck.add(checkRooks(toBeCheck));
            }
            else if(toBeCheck.name.substring(1).equals("BP")){
                fiveKindsPiecesCheck.add(checkBishops(toBeCheck));
            }
        }
        if((fiveKindsPiecesCheck.contains(true))){
            forReturn = false;
        }
        return forReturn;
    }
    private boolean checkPawns(Pieces toBeCheck){//return false if cannot protect the king
        boolean forReturn = true;
        int checkCount = 0;
        int originalPosition[]={toBeCheck.position[0],toBeCheck.position[1]};
        int unitUpDown1=0;
        if(toBeCheck.color.equals("white")){unitUpDown1=-1;}
        else{unitUpDown1 = 1;}
        int[] position1 = {toBeCheck.position[0]+unitUpDown1,toBeCheck.position[1]};
        int[] position2 = {toBeCheck.position[0]+(unitUpDown1*2),toBeCheck.position[1]};
        int[] position3 = {toBeCheck.position[0]+unitUpDown1,toBeCheck.position[1]+1};
        int[] position4 = {toBeCheck.position[0]+unitUpDown1,toBeCheck.position[1]-1};
        int[] potentialPosition[]={position1,position2,position3,position4};
        for(int i =0;i<2;i++){
            int position[] = potentialPosition[i];
            if((position[0]>=0&&position[0]<8)&&(position[1]>=0&&position[1]<8)){
                if(Board.getBoard()[position[0]][position[1]]==null){checkCount = calculateCheckCount(toBeCheck,checkCount,position);}
                else{checkCount++;}
            }
            else{checkCount++;}
            if(toBeCheck.movementNumCount!=0){checkCount++;
                    break;}
        }
        for(int i = 2;i<4;i++){
            int position[] = potentialPosition[i];
            if((position[0]>=0&&position[0]<8)&&(position[1]>=0&&position[1]<8)){
                if(Board.getBoard()[position[0]][position[1]]!=null&&(!Board.getBoard()[position[0]][position[1]].color.equals(toBeCheck.color))){
                    checkCount = calculateCheckCount2(toBeCheck,checkCount,position);
                }
                else{checkCount++;}
            }
            else{checkCount++;}
        }
        if(checkCount==4){forReturn = false;}
        return forReturn;
    }
    private int calculateCheckCount(Pieces toBeCheck,int checkCount,int[] position){
        Board.getBoard()[position[0]][position[1]]=toBeCheck;
        int[] originalPosition = {toBeCheck.position[0],toBeCheck.position[1]};
        toBeCheck.setPosition(position[0],position[1]);
        Board.getBoard()[originalPosition[0]][originalPosition[1]]=null;
        if(isCheck(getKing())){checkCount++;}
        Board.getBoard()[originalPosition[0]][originalPosition[1]]=toBeCheck;
        toBeCheck.setPosition(originalPosition[0],originalPosition[1]);
        Board.getBoard()[position[0]][position[1]]=null;
        return checkCount;
    }
    private int calculateCheckCount2(Pieces toBeCheck,int checkCount,int[] position){
        int[] originalPosition = {toBeCheck.position[0],toBeCheck.position[1]};
        Pieces toBeEaten = Board.getBoard()[position[0]][position[1]];
        Board.getBoard()[position[0]][position[1]]=toBeCheck;
        toBeCheck.setPosition(position[0],position[1]);
        Board.getBoard()[originalPosition[0]][originalPosition[1]]=null;
        if(isCheck(getKing())){checkCount++;}
        Board.getBoard()[originalPosition[0]][originalPosition[1]]=toBeCheck;
        toBeCheck.setPosition(originalPosition[0],originalPosition[1]);
        Board.getBoard()[position[0]][position[1]]=toBeEaten;
        return checkCount;
    }
    private boolean checkKnights(Pieces toBeCheck){//return false if cannot protect the king
        boolean forReturn = true;
        int checkCount=0;
        int originalPosition[] = {toBeCheck.position[0],toBeCheck.position[1]};
        int position1[] = {toBeCheck.position[0]-1,toBeCheck.position[1]+2};
        int position2[] = {toBeCheck.position[0]-2,toBeCheck.position[1]+1};
        int position3[] = {toBeCheck.position[0]-2,toBeCheck.position[1]-1};
        int position4[] = {toBeCheck.position[0]-1,toBeCheck.position[1]-2};
        int position5[] = {toBeCheck.position[0]+1,toBeCheck.position[1]-2};
        int position6[] = {toBeCheck.position[0]+2,toBeCheck.position[1]-1};
        int position7[] = {toBeCheck.position[0]+2,toBeCheck.position[1]+1};
        int position8[] = {toBeCheck.position[0]+1,toBeCheck.position[1]+2};
        int[] potentialPosition[]={position1,position2,position3,position4,position5,position6,position7,position8};
        for(int i = 0;i<8;i++){
            int[] position = potentialPosition[i];
            if((position[0]>=0&&position[0]<8)&&(position[1]>=0&&position[1]<8)){
                if(Board.getBoard()[position[0]][position[1]]==null){checkCount = calculateCheckCount(toBeCheck,checkCount,position);}
                else if(Board.getBoard()[position[0]][position[1]]!=null&&(!Board.getBoard()[position[0]][position[1]].color.equals(toBeCheck.color))){
                    checkCount = calculateCheckCount2(toBeCheck,checkCount,position);
                }
                else if(Board.getBoard()[position[0]][position[1]]!=null&&(Board.getBoard()[position[0]][position[1]].color.equals(toBeCheck.color))){
                    checkCount++;
                }
            }
            else{
                checkCount++;
            }
        }
        if(checkCount==8){
            forReturn = false;
        }
        return forReturn;
    }
    private boolean checkQueens(Pieces toBeCheck){//return false if cannot protect the king
        boolean forReturn = false;
        boolean checkDiagnolly = checkBishops(toBeCheck);
        boolean checkCrossing = checkRooks(toBeCheck);
        if(checkDiagnolly==true||checkCrossing==true){
            forReturn = true;
        }
        return forReturn;
    }
    private boolean determineBooleansForBishopsAndRooks(Pieces toBeCheck,int ver,int hor)throws BlockedException{
        boolean forReturn = false;
        int verticalPosition = toBeCheck.position[0];
        int horizontalPosition=toBeCheck.position[1];
        if(Board.getBoard()[ver][hor]!=null){
            if(!Board.getBoard()[ver][hor].color.equals(toBeCheck.color)){
                Pieces toBeEaten = Board.getBoard()[ver][hor];
                Board.getBoard()[ver][hor] = toBeCheck;
                toBeCheck.setPosition(ver,hor);
                Board.getBoard()[verticalPosition][horizontalPosition]=null;
                if(isCheck(getKing())){forReturn = false;}
                else{forReturn = true;}
                Board.getBoard()[ver][hor] = toBeEaten;
                Board.getBoard()[verticalPosition][horizontalPosition] = toBeCheck;
                toBeCheck.setPosition(verticalPosition,horizontalPosition);
            }
            else{forReturn = false;
            throw new BlockedException();}
        }
        else{
            Board.getBoard()[ver][hor] = toBeCheck;
            toBeCheck.setPosition(ver,hor);
            Board.getBoard()[verticalPosition][horizontalPosition]=null;
            if(isCheck(getKing())){forReturn = false;}
            else{forReturn = true;}
            Board.getBoard()[ver][hor] = null;
            Board.getBoard()[verticalPosition][horizontalPosition] = toBeCheck;
            toBeCheck.setPosition(verticalPosition,horizontalPosition);
        }
        return forReturn;
    }
    private boolean checkBishops(Pieces toBeCheck){//return false if cannot protect the king
        boolean forReturn = false;
        boolean downRight = false;//true if can save the king
        boolean downLeft = false;
        boolean upRight = false;
        boolean upLeft = false;
        int verticalPosition = toBeCheck.position[0];
        int horizontalPosition=toBeCheck.position[1];
        int ver = verticalPosition+1;
        int hor = horizontalPosition+1;
        while(ver<8&&hor<8){//downright
            try{downRight = determineBooleansForBishopsAndRooks(toBeCheck,ver,hor);if(downRight==true){break;}}
            catch(BlockedException e){break;}
            ver++;
            hor++;
        }
        ver = verticalPosition+1;
        hor = horizontalPosition-1;
        while(ver<8&&hor>=0){//downleft
            try{downLeft = determineBooleansForBishopsAndRooks(toBeCheck,ver,hor);if(downLeft==true){break;}}
            catch(BlockedException e){break;}
            ver++;
            hor--;
        }
        ver = verticalPosition-1;
        hor = horizontalPosition-1;
        while(ver>=0&&hor>=0){//upleft
            try{upLeft = determineBooleansForBishopsAndRooks(toBeCheck,ver,hor);if(upLeft==true){break;}}
            catch(BlockedException e){break;}
            ver--;
            hor--;
        }
        ver = verticalPosition-1;
        hor = horizontalPosition+1;
        while(ver>=0&&hor<8){//upright
            try{upRight = determineBooleansForBishopsAndRooks(toBeCheck,ver,hor);if(upRight==true){break;}}
            catch(BlockedException e){break;}
            ver--;
            hor++;
        }
        if(upRight==true||upLeft==true||downRight==true||downLeft==true){
            forReturn = true;
        }
        return forReturn;
    }
    private boolean checkRooks(Pieces toBeCheck){//return false if cannot protect the king
        boolean forReturn = false;
        boolean up = false;//true if can save the king
        boolean down = false;
        boolean left = false;
        boolean right = false;
        int verticalPosition = toBeCheck.position[0];
        int horizontalPosition=toBeCheck.position[1];
        int ver = verticalPosition-1;
        int hor = horizontalPosition;
        while(ver>=0){//up
            try{up = determineBooleansForBishopsAndRooks(toBeCheck,ver,hor);if(up==true){break;}}
            catch(BlockedException e){break;}
            ver--;
        }
        ver=verticalPosition+1;
        while(ver<8){//down
            try{down = determineBooleansForBishopsAndRooks(toBeCheck,ver,hor);if(down==true){break;}}
            catch(BlockedException e){break;}
            ver++;
        }
        ver = verticalPosition;
        hor = horizontalPosition+1;
        while(hor<8){//right
            try{right = determineBooleansForBishopsAndRooks(toBeCheck,ver,hor);if(right==true){break;}}
            catch(BlockedException e){break;}
            hor++;
        }
        hor = horizontalPosition-1;
        while(hor>=0){//left
            try{left = determineBooleansForBishopsAndRooks(toBeCheck,ver,hor);if(left==true){break;}}
            catch(BlockedException e){break;}
            hor--;
        }
        if(right==true||left==true||up==true||down==true){
            forReturn = true;
        }
        return forReturn;
    }
    private boolean isCheck(Pieces king){//return true if is checked by the enemy
        boolean forReturn = false;
        boolean right = checkRight(king);
        boolean left = checkLeft(king);
        boolean up = checkUp(king);
        boolean down = checkDown(king);
        boolean upRight = checkUpRight(king);
        boolean upLeft = checkUpLeft(king);
        boolean downRight = checkDownRight(king);
        boolean downLeft = checkDownLeft(king);
        boolean knightCheck = checkKnight(king);
        if(right||left||up||down||upRight||upLeft||downRight||downLeft||knightCheck){forReturn = true;}
        return forReturn;
    }
    private boolean checkRight(Pieces king){//return true if is checked from right
        int startPoint = king.position[1]+1;
        for(int i =startPoint;i<8;i++){
            if(Board.getBoard()[king.position[0]][i]!=null){
                if(Board.getBoard()[king.position[0]][i].color.equals(king.color)){return false;}
                else{
                    if(Board.getBoard()[king.position[0]][i].name.substring(1).equals("QN")||
                    Board.getBoard()[king.position[0]][i].name.substring(1).equals("RK")){return true;}   
                    else{return false;}
                }
            }
        }
        return false;
    }
    private boolean checkLeft(Pieces king){//return true if is checked from left
        int startPoint = king.position[1]-1;
        for(int i =startPoint;i>=0;i--){
            if(Board.getBoard()[king.position[0]][i]!=null){
                if(Board.getBoard()[king.position[0]][i].color.equals(king.color)){return false;}
                else{
                    if(Board.getBoard()[king.position[0]][i].name.substring(1).equals("QN")||
                    Board.getBoard()[king.position[0]][i].name.substring(1).equals("RK")){return true;}
                    else{return false;}
                }      
            }
        }
        return false;
    }
    private boolean checkUp(Pieces king){//return true if is checked from up
        int startPoint = king.position[0]-1;
        for(int i =startPoint;i>=0;i--){
            if(Board.getBoard()[i][king.position[1]]!=null){
                if(Board.getBoard()[i][king.position[1]].color.equals(king.color)){
                    return false;
                }
                else{
                    if(Board.getBoard()[i][king.position[1]].name.substring(1).equals("QN")||
                    Board.getBoard()[i][king.position[1]].name.substring(1).equals("RK")){return true;}   
                    else{return false;}
                }
            }
        }
        return false;
    }
    private boolean checkDown(Pieces king){//return true if is checked from down
        int startPoint = king.position[0]+1;
        for(int i =startPoint;i<8;i++){
            if(Board.getBoard()[i][king.position[1]]!=null){
                if(Board.getBoard()[i][king.position[1]].color.equals(king.color)){return false;}
                else{
                    if(Board.getBoard()[i][king.position[1]].name.substring(1).equals("QN")||
                    Board.getBoard()[i][king.position[1]].name.substring(1).equals("RK")){return true;}      
                    else{return false;}
                }
            }
        }
        return false;
    }
    private boolean checkUpRight(Pieces king){//return true if is checked from up right
        int verticalPosition = king.position[0]-1;
        int horizontalPosition = king.position[1]+1;
        int numCount = 0;
        for(;horizontalPosition<8&&verticalPosition>=0;horizontalPosition++){
            if(Board.getBoard()[verticalPosition][horizontalPosition]!=null){
                if(Board.getBoard()[verticalPosition][horizontalPosition].name.substring(1).equals("PN")&&
                !Board.getBoard()[verticalPosition][horizontalPosition].color.equals(king.color)&&
                numCount==0){return true;}
                if(Board.getBoard()[verticalPosition][horizontalPosition].color.equals(king.color)){return false;}
                else{
                    if(Board.getBoard()[verticalPosition][horizontalPosition].name.substring(1).equals("QN")||
                    Board.getBoard()[verticalPosition][horizontalPosition].name.substring(1).equals("BP")){return true;}   
                    else{return false;}
                } 
            }
            numCount++;
            verticalPosition--;
        }
        return false;
    }
    private boolean checkDownRight(Pieces king){//return true if is checked from down right
        int verticalPosition = king.position[0]+1;
        int horizontalPosition = king.position[1]+1;
        int numCount = 0;
        for(;horizontalPosition<8&&verticalPosition<8;horizontalPosition++){
            if(Board.getBoard()[verticalPosition][horizontalPosition]!=null){
                if(Board.getBoard()[verticalPosition][horizontalPosition].name.substring(1).equals("PN")&&
                !Board.getBoard()[verticalPosition][horizontalPosition].color.equals(king.color)&&
                numCount==0){return true;}
                if(Board.getBoard()[verticalPosition][horizontalPosition].color.equals(king.color)){return false;}
                else{
                    if(Board.getBoard()[verticalPosition][horizontalPosition].name.substring(1).equals("QN")||
                    Board.getBoard()[verticalPosition][horizontalPosition].name.substring(1).equals("BP")){return true;}   
                    else{return false;}
                } 
            }
            numCount++;
            verticalPosition++;
        }
        return false;
    }
    private boolean checkUpLeft(Pieces king){//return true if is checked from up left
        int verticalPosition = king.position[0]-1;
        int horizontalPosition = king.position[1]-1;
        int numCount = 0;
        for(;horizontalPosition>=0&&verticalPosition>=0;horizontalPosition--){
            if(Board.getBoard()[verticalPosition][horizontalPosition]!=null){
                if(Board.getBoard()[verticalPosition][horizontalPosition].name.substring(1).equals("PN")&&
                !Board.getBoard()[verticalPosition][horizontalPosition].color.equals(king.color)&&
                numCount==0){return true;}
                if(Board.getBoard()[verticalPosition][horizontalPosition].color.equals(king.color)){return false;}
                else{
                    if(Board.getBoard()[verticalPosition][horizontalPosition].name.substring(1).equals("QN")||
                    Board.getBoard()[verticalPosition][horizontalPosition].name.substring(1).equals("BP")){return true;}   
                    else{return false;}
                } 
            }
            numCount++;
            verticalPosition--;
        }
        return false;
    }
    private boolean checkDownLeft(Pieces king){//return true if is checked from down left
        int verticalPosition = king.position[0]+1;
        int horizontalPosition = king.position[1]-1;
        int numCount = 0;
        for(;horizontalPosition>=0&&verticalPosition<8;horizontalPosition--){
            if(Board.getBoard()[verticalPosition][horizontalPosition]!=null){
                if(Board.getBoard()[verticalPosition][horizontalPosition].name.substring(1).equals("PN")&&
                !Board.getBoard()[verticalPosition][horizontalPosition].color.equals(king.color)&&
                numCount==0){return true;}
                if(Board.getBoard()[verticalPosition][horizontalPosition].color.equals(king.color)){return false;}
                else{
                    if(Board.getBoard()[verticalPosition][horizontalPosition].name.substring(1).equals("QN")||
                    Board.getBoard()[verticalPosition][horizontalPosition].name.substring(1).equals("BP")){return true;}  
                    else{return false;}
                } 
            }
            numCount++;
            verticalPosition++;
        }
        return false;
    }
    private boolean checkKnight(Pieces king){//return true if is checked by knight
        int horizontalPosition = king.position[1];
        int verticalPosition = king.position[0];
        int position1[] = {verticalPosition-1,horizontalPosition+2};
        int position2[] = {verticalPosition-2,horizontalPosition+1};
        int position3[] = {verticalPosition-2,horizontalPosition-1};
        int position4[] = {verticalPosition-1,horizontalPosition-2};
        int position5[] = {verticalPosition+1,horizontalPosition-2};
        int position6[] = {verticalPosition+2,horizontalPosition-1};
        int position7[] = {verticalPosition+2,horizontalPosition+1};
        int position8[] = {verticalPosition+1,horizontalPosition+2};
        int[] potentialPosition[]={position1,position2,position3,position4,position5,position6,position7,position8};
        for(int i=0;i<8;i++){
             try{
                 if(Board.getBoard()[potentialPosition[i][0]][potentialPosition[i][1]].name.substring(1).equals("KT")&&
                 !(Board.getBoard()[potentialPosition[i][0]][potentialPosition[i][1]].color.equals(king.color)))
                    return true;
             }
             catch(NullPointerException e ){}
             catch(ArrayIndexOutOfBoundsException e){}
        }
        return false;
    }
    private Pieces getNewPiece(String command)throws WrongNameException{
        boolean check = true;
        Pieces piece = null;
        if(command.equalsIgnoreCase("queen")){
            piece = new Queen();
            if(turn == "black"){piece.name = "BQN";}
            else{piece.name = "WQN";}
        }
        else if(command.equalsIgnoreCase("knight")){
            piece = new Knight();
            if(turn == "black"){piece.name = "BKT";}
            else{piece.name = "WKT";}
        }
        else if(command.equalsIgnoreCase("rook")){
            piece = new Rook();
            if(turn == "black"){piece.name = "BRK";}
            else{piece.name = "WRK";}
        }
        else if(command.equalsIgnoreCase("bishop")){
            piece = new Bishop();
            if(turn == "black"){piece.name = "BBP";}
            else{piece.name = "WBP";}
        }
        else{check = false;}
        if(check = false){throw new WrongNameException(command);}
        else{piece.color = turn;}
        return piece;
    }
    private void addStayTurn(){
        for(int i =0;i<8;i++){
            for(int k = 0;k<8;k++){
                if(Board.getBoard()[i][k]!=null){Board.getBoard()[i][k].setStayTurn();}
            }
        }
    }
    public String[] disposeString(String command){
        String cut[]=new String[2];
        cut[0]=command.substring(5,7);   
        cut[1]=command.substring(8,10);
        return cut;
    }
}
