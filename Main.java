import java.util.Scanner;
public class Main
{
    public static void main(String[] args){
        Game game = new Game();
        Scanner in = new Scanner(System.in);
        System.out.println("Format:   'GOTO A2,A3' or 'QUIT' or the name of the pawn "+"\n"+ "you want to change only!");
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
            try{game.run(command);}
            catch(CheckmateException e){
                check = false;
            }
        }
    }
}
