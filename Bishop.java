public class Bishop extends Pieces
{   
    public boolean rules(){
        return true;
    }
    public boolean specialRules(){
        return true;
    }
    public boolean checkRules(){
        return true;
    }
    public void setProperty(String input,String name,Pieces piece,String color){
        position=convertor(input);
        this.name=name;
        Board.board[position[0]][position[1]]=piece;
        this.color=color;
    }
}
