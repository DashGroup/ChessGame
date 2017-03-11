public class Board
{
    private PieceGroup white;
    private PieceGroup black;
    private final int length = 8; 
    private static Pieces[][] board=new Pieces[8][8];
    Board(){
        white = new PieceGroup("white");
        black = new PieceGroup("black");
    }
    public static Pieces[][] getBoard(){
        return board;
    }
    private boolean check(String command){
        boolean check = false;
        if(command.length()==10){
            int first = command.charAt(5);
            int second = Integer.valueOf(command.substring(6,7));
            int third = command.charAt(8);
            int forth = Integer.valueOf(command.substring(9,10));        
            if(command.substring(0,4).equalsIgnoreCase("GOTO")){
                if(((first>=65&&first<=72)||(first>=97&&first<=104))&&
                ((third>=65&&third<=72)||(third>=97&&third<=104))&&
                (second<=8)&&
                (forth<=8)){
                    check = true;
                }
            }
        }
        return check;
    }
    public void run(String command){
        if(command.equalsIgnoreCase("quit")){
            for(int i = 0;i<length;i++){
                for(int k =0;k<length;k++){
                    board[i][k] = null;
                }
            }           
        }
        else{
            if(check(command)){
                white.run(command);
            }
        }
    }
    public String toString(){
        String str = "";
        for(int i = 0;i<length;i++){
            for(int k = 0;k<length;k++){
                if(board[i][k]==null){
                    str+="[   ]"+"\t";
                }
                else{
                    str+="["+board[i][k].name+"]"+"\t";
                }
            }
            str+="\n"+"\n";
        }
        return str;
    }
}