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
    public static String getTurn(){
        return turn;
    }
    public void run(String command){
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
           if(Board.getBoard()[coordination1[0]][coordination1[1]].isAllowedToMove(coordination2)){
               Board.getBoard()[coordination1[0]][coordination1[1]].position[0]=coordination2[0];
               Board.getBoard()[coordination1[0]][coordination1[1]].position[1]=coordination2[1];
               Board.getBoard()[coordination2[0]][coordination2[1]]=Board.getBoard()[coordination1[0]][coordination1[1]];
               Board.getBoard()[coordination1[0]][coordination1[1]]=null;
               count++;
           }
        }
        else if((Board.getBoard()[coordination2[0]][coordination2[1]]!=null)&&
            Board.getBoard()[coordination2[0]][coordination2[1]].color.equals(antiColorRequirement)&&
            Board.getBoard()[coordination1[0]][coordination1[1]].color.equals(colorRequirement)){
            if(Board.getBoard()[coordination1[0]][coordination1[1]].isAllowedToMove(coordination2)){
                Board.getBoard()[coordination1[0]][coordination1[1]].position[0]=coordination2[0];
                Board.getBoard()[coordination1[0]][coordination1[1]].position[1]=coordination2[1];
                Board.getBoard()[coordination2[0]][coordination2[1]]=null;
                Board.getBoard()[coordination2[0]][coordination2[1]]=null;
                Board.getBoard()[coordination2[0]][coordination2[1]]=Board.getBoard()[coordination1[0]][coordination1[1]];
                Board.getBoard()[coordination1[0]][coordination1[1]]=null;
                count++;
            }
        }
        if(count%2==0){
          turn="black";  
        }
        else{
          turn="white";
        }
    }
    public String[] disposeString(String command)
    {
        String cut[]=new String[2];
        cut[0]=command.substring(5,7);   
        cut[1]=command.substring(8,10);
        return cut;
    }
}
