public class Board
{
    private PieceGroup white;
    private PieceGroup black;
    private String[][] board;
    private final int length = 8;
    private static int time;
    Board(){
        System.out.println("FORMAT"+"GOTO 'A1,A2' "+"OR"+" 'QUIT' ONLY");
        white = new PieceGroup("white");
        black = new PieceGroup("black");
        board = new String[length][length];
        int num = 1;
        time=1;
        for(int i = 0;i<length;i++){
            if(i<=1){
                String[] arr = black.getArrName();
                int count = i*length;
                for(int k = 0;k<length;k++){
                    board[i][k] = arr[count];
                    count++;
                }
                count = 0;
            }
            else if(i>1&&i<6){
                for(int k = 0;k<length;k++){
                    board[i][k]="   ";
                }
            }
            else{
                String[] arr = white.getArrName();
                int count = num*length;
                for(int k = 0;k<length;k++){
                    board[i][k]=arr[count];
                    count++;
                } 
                num--;
                count=0;
            }        
        }
    }
    private int convertThirdToNum(String order){
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
    private int convertSecondToNum(String order){
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
    private int convertFirstToNum(String order){
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
    private boolean ifOdd(){
        return time%2!=0;
    }
    public void main(String order){     
        if(order.length()!=10){
            return;
        }
        int first = convertSecondToNum(order);
        int second = convertFirstToNum(order);
        int third = convertThirdToNum(order);
        int four = convertFourToNum(order);
        order = first+""+second+third+four;
        if(ifOdd()){
            if(board[third][four]=="   "){
                String str = white.moveOne(order);
                if(!(str.equals("wrong"))){
                    board[third][four] = str;
                    board[first][second] = "   ";
                    time--;      
                }
            }
        }
        else{
            if(board[third][four]=="   "){
                String str = black.moveOne(order);
                if(!(str.equals("wrong"))){
                    board[third][four] = str;
                    board[first][second] = "   ";
                    time++;      
                }
            }
        }
    }
    public int getTime(){
        return time;
    }
    public String toString(){
        String str = "";
        for(int i = 0;i<length;i++){
            for(int k = 0;k<length;k++){
                str+="["+board[i][k]+"]"+"\t";
            }
            str+="\n"+"\n";
        }
        return str;
    }
}
