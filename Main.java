import java.util.Scanner;
public class Main
{
    public static void run(){
        Game game = new Game();
        Scanner in = new Scanner(System.in);
        System.out.println("Format:   'GOTO A2,A3' or 'QUIT' only!");
        System.out.println();
        boolean check = true;
        while(check){
            System.out.println(game);
            Player p = game.checkTurn();
            System.out.println(p.getColor()+" turn ==>");
            String command = in.nextLine();
            if(command.equalsIgnoreCase("quit")){
                check = false;
            }
            game.run(command);
        }
    }
}