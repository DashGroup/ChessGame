public class Game
{
    private Player pWhite;
    private Player pBlack;
    private Board board;
    private String turn;
    Game(){
        board = new Board();
        String white = "White";
        String black = "Black";
        pWhite = new Player(white);
        pBlack = new Player(black);
        turn = PieceGroup.getTurn();
    }
    public Player checkTurn(){
        if(turn.equals("white")){
            return pWhite;
        }
        else{
            return pBlack;
        }
    }
    public void run(String command)throws CheckmateException{
        try{
            board.run(command);
            turn = PieceGroup.getTurn();
        }
        catch(CheckmateException e){
            throw e;
        }
    }
    public String toString(){
        String str = board.toString();
        return str;
    }
}
