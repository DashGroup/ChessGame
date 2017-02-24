<<<<<<< HEAD
public class Board
{
    private Player playerWhite;
    private Player playerBlack;
    private String[][] board;
    private final int length = 8;
    private static int time;
    Board(){
        System.out.println("FORMAT"+" 'A1,A2' "+"OR"+" 'QUIT' ONLY");
        playerWhite = new Player("white");
        playerBlack = new Player("black");
        board = new String[length][length];
        int num = 1;
        time=1;
        for(int i = 0;i<length;i++){
            if(i<=1){
                String[] arr = playerBlack.getArrName();
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
                String[] arr = playerWhite.getArrName();
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
        String str = order.substring(4);
        if(str.equalsIgnoreCase("1")){
            return 7;
        }
        else if(str.equalsIgnoreCase("2")){
            return 6;
        }
        else if(str.equalsIgnoreCase("3")){
            return 5;
        }
        else if(str.equalsIgnoreCase("4")){
            return 4;
        }
        else if(str.equalsIgnoreCase("5")){
            return 3;
        }
        else if(str.equalsIgnoreCase("6")){
            return 2;
        }
        else if(str.equalsIgnoreCase("7")){
            return 1;
        }
        else{
            return 0;
        }
    }
    private int convertSecondToNum(String order){
        String str = order.substring(1,2);
        if(str.equalsIgnoreCase("1")){
            return 7;
        }
        else if(str.equalsIgnoreCase("2")){
            return 6;
        }
        else if(str.equalsIgnoreCase("3")){
            return 5;
        }
        else if(str.equalsIgnoreCase("4")){
            return 4;
        }
        else if(str.equalsIgnoreCase("5")){
            return 3;
        }
        else if(str.equalsIgnoreCase("6")){
            return 2;
        }
        else if(str.equalsIgnoreCase("7")){
            return 1;
        }
        else{
            return 0;
        }
    }
    private int convertFirstToNum(String order){
        String str = order.substring(0,1);
        if(str.equalsIgnoreCase("A")){
            return 0;
        }
        else if(str.equalsIgnoreCase("B")){
            return 1;
        }
        else if(str.equalsIgnoreCase("C")){
            return 2;
        }
        else if(str.equalsIgnoreCase("D")){
            return 3;
        }
        else if(str.equalsIgnoreCase("E")){
            return 4;
        }
        else if(str.equalsIgnoreCase("F")){
            return 5;
        }
        else if(str.equalsIgnoreCase("G")){
            return 6;
        }
        else{
            return 7;
        }
    }
    private int convertFourToNum(String order){
        String str = order.substring(3,4);
        if(str.equalsIgnoreCase("A")){
            return 0;
        }
        else if(str.equalsIgnoreCase("B")){
            return 1;
        }
        else if(str.equalsIgnoreCase("C")){
            return 2;
        }
        else if(str.equalsIgnoreCase("D")){
            return 3;
        }
        else if(str.equalsIgnoreCase("E")){
            return 4;
        }
        else if(str.equalsIgnoreCase("F")){
            return 5;
        }
        else if(str.equalsIgnoreCase("G")){
            return 6;
        }
        else{
            return 7;
        }
    }
    private boolean ifOdd(){
        return time%2!=0;
    }
    public void main(String order){     
        int first = convertSecondToNum(order);
        int second = convertFirstToNum(order);
        int third = convertThirdToNum(order);
        int four = convertFourToNum(order);
        order = first+""+second+third+four;
        if(ifOdd()){
            if(board[third][four]=="   "){
                String str = playerWhite.moveOne(order);
                if(str.equals("wrong")){
                    System.out.println("Wrong movement, white moves");
                }
                else{
                    board[third][four] = str;
                    board[first][second] = "   ";
                    time++;      
                }
            }
        }
        else{
            if(board[third][four]=="   "){
                String str = playerBlack.moveOne(order);
                if(str.equals("wrong")){
                    System.out.println("Wrong movement, black moves");
                }
                else{
                    board[third][four] = str;
                    board[first][second] = "   ";
                    time++;      
                }
            }
        }
        System.out.println(toString());  
    }
    public void main(){
        System.out.println(toString());
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
=======
public class Board
{
    private Player playerWhite;
    private Player playerBlack;
}
>>>>>>> origin/master
