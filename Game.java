public class Game
{
    private Player pWhite;
    private Player pBlack;
    private Board board;
    private static int time;
    Game(){
        board = new Board();
        String white = "White";
        String black = "Black";
        pWhite = new Player(white);
        pBlack = new Player(black);
        time = board.getTime();
    }
    public Player checkTurn(){
        if(time%2==1){
            return pWhite;
        }
        else{
            return pBlack;
        }
    }
    public void main(String order){
        order = ""+convertFirstToNum(order)+convertSecondToNum(order)+convertThirdToNum(order)+convertFourToNum(order);
        board.run(order);
        time = board.getTime();
    }
    private int convertThirdToNum(String order){
        if(order.length()!=10)
            return -1;
        String str = order.substring(9);
        if(str.equalsIgnoreCase("1")){return 7;}
        else if(str.equalsIgnoreCase("2")){return 6;}
        else if(str.equalsIgnoreCase("3")){return 5;}
        else if(str.equalsIgnoreCase("4")){return 4;}
        else if(str.equalsIgnoreCase("5")){return 3;}
        else if(str.equalsIgnoreCase("6")){return 2;}
        else if(str.equalsIgnoreCase("7")){return 1;}
        else{return 0;}
    }
    private int convertFirstToNum(String order){
        if(order.length()!=10)
            return -1;
        String str = order.substring(6,7);
        if(str.equalsIgnoreCase("1")){return 7;}
        else if(str.equalsIgnoreCase("2")){return 6;}
        else if(str.equalsIgnoreCase("3")){return 5;}
        else if(str.equalsIgnoreCase("4")){return 4;}
        else if(str.equalsIgnoreCase("5")){return 3;}
        else if(str.equalsIgnoreCase("6")){return 2;}
        else if(str.equalsIgnoreCase("7")){return 1;}
        else{return 0;}
    }
    private int convertSecondToNum(String order){
        if(order.length()!=10)
            return -1;
        String str = order.substring(5,6);
        if(str.equalsIgnoreCase("A")){return 0;}
        else if(str.equalsIgnoreCase("B")){return 1;}
        else if(str.equalsIgnoreCase("C")){return 2;}
        else if(str.equalsIgnoreCase("D")){return 3;}
        else if(str.equalsIgnoreCase("E")){return 4;}
        else if(str.equalsIgnoreCase("F")){return 5;}
        else if(str.equalsIgnoreCase("G")){return 6;}
        else{return 7;}
    }
    private int convertFourToNum(String order){
        if(order.length()!=10)
            return -1;
        String str = order.substring(8,9);
        if(str.equalsIgnoreCase("A")){return 0;}
        else if(str.equalsIgnoreCase("B")){return 1;}
        else if(str.equalsIgnoreCase("C")){return 2;}
        else if(str.equalsIgnoreCase("D")){return 3;}
        else if(str.equalsIgnoreCase("E")){return 4;}
        else if(str.equalsIgnoreCase("F")){return 5;}
        else if(str.equalsIgnoreCase("G")){return 6;}
        else{return 7;}
    }
    public String toString(){
        String str = board.toString();
        return str;
    }
}
