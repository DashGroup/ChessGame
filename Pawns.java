public class Pawns extends Pieces
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
    public String getPosition(){
        return position;
    }
    public void setPosition(String input){
        position = input;
    }
}
