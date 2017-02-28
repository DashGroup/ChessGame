public class Board
{
    private PieceGroup white;
    private PieceGroup black;
    private String[][] board;
    private final int length = 8;
    private static int time;
    public PieceGroup getWhite(){
        return this.white;
    }
    public PieceGroup getBlack(){
        return this.black;
    }
    Board(){
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
    private int convertThirdToNum2(String order){
        String str = order.substring(2,3);
        return Integer.valueOf(str);
    }
    private int convertFirstToNum2(String order){
        String str = order.substring(0,1);
        return Integer.valueOf(str);
    }
    private int convertSecondToNum2(String order){
        String str = order.substring(1,2);
        return Integer.valueOf(str);
    }
    private int convertFourToNum2(String order){
        String str = order.substring(3,4);
        return Integer.valueOf(str);
    }
    private boolean ifOdd(){
        return time%2!=0;
    }
    public void run(String order){     
        if(order.length()!=4){
            return;
        }
        int first = convertFirstToNum2(order);
        int second = convertSecondToNum2(order);
        int third = convertThirdToNum2(order);
        int four = convertFourToNum2(order);
        order = ""+first+second+third+four;
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
