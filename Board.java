public class Board
{
    private static PieceGroup white;
    private static PieceGroup black;
    private final int length = 8; 
    private static Pieces[][] board=new Pieces[8][8];
    Board(){
        white = new PieceGroup("white");
        black = new PieceGroup("black");
    }
    public static Pieces[][] getBoard(){
        return board;
    }
    public static PieceGroup getGroup(String color){
        if(color.equals("black"))
        return black;
        else
        return white;
    }
    private boolean check(String command)throws InvalidMoveException{
        boolean check = false;
        if(command.length()==10){
            int first = command.charAt(5);
            int second = command.charAt(6)-48;
            int third = command.charAt(8);
            int forth = command.charAt(9)-48;        
            if(command.substring(0,5).equalsIgnoreCase("GOTO ")){
                if(((first>=65&&first<=72)||(first>=97&&first<=104))&&
                ((third>=65&&third<=72)||(third>=97&&third<=104))&&
                (second<=8)&&
                (forth<=8)){
                    check = true;
                }
            }
        }
        else if(command.equalsIgnoreCase("queen")||command.equalsIgnoreCase("knight")||command.equalsIgnoreCase("rook")||command.equalsIgnoreCase("bishop")){
            check = true;
        }
        if(check == false){
            throw new InvalidMoveException(command);
        }
        return check;
    }
    public void run(String command)throws CheckmateException{
        if(command.equalsIgnoreCase("quit")){
            for(int i = 0;i<length;i++){
                for(int k =0;k<length;k++){
                    board[i][k] = null;
                }
            }           
        }
        else{
            try{
                if(check(command)){
                    white.run(command);
                }
            }catch(InvalidMoveException e){
                System.out.println("Sorry " + command + " is not a valid movement");
            }
            catch(CheckmateException e){
                System.out.println(toString());
                this.run("quit");
                throw e;
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