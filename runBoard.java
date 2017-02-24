import java.util.Scanner;
public class runBoard
{
    public static void runTest(){
        Board board = new Board();
        Scanner in = new Scanner(System.in);
        boolean check = true;
        board.main();
        while(check){
            System.out.println("movement ==>  ");
            String str = in.nextLine();
            board.main(str);
            if(str.equalsIgnoreCase("quit")){
                check = false;
            }
        }
    }
}
