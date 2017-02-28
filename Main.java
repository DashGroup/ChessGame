import java.util.Scanner;
public class Main
{
    public static void main(){
        System.out.println("FORMAT: GOTO A1,A2 or QUIT only!");
        System.out.println();
        Game game = new Game();
        Scanner in = new Scanner(System.in);
        boolean check = true;
        while(check){
            System.out.println(game);
            Player p = game.checkTurn();
            System.out.println(p.getColor()+" turn ==>");
            String str = in.nextLine();
            if(str.equalsIgnoreCase("quit")){
                break;
            }
            game.main(str);
        }
    }
}
