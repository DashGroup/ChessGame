public class Board
{
    private PieceGroup white;
    private PieceGroup black;
    private final int length = 8; 
    public static Pieces[][] board=new Pieces[8][8];
    Board(){
        white = new PieceGroup("white");
        black = new PieceGroup("black");
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
            white.run(command);
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