import java.util.Scanner;
public class runBoard
{
    public static void runTest(){
        Board board = new Board();
        Scanner in = new Scanner(System.in);
        boolean check = true;
        System.out.println(board);
        while(check){
            int time = board.getTime();
            if(time%2==1){
                System.out.println("WHITE MOVEMENT ==>");
            }
            else{
                System.out.println("BLACK MOVEMENT ==>");
            }
            String str = in.nextLine();
            if(str.equalsIgnoreCase("quit")){
                break;
            }
            board.main(str);
            System.out.println(board);
        }
    }
}
