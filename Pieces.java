public abstract class Pieces 
{
    protected String name;
    protected int[] position= new int[2];
    protected String color;
    protected boolean alive;
    protected boolean ifMove;
    protected int numCount;
    public abstract boolean rules();
    public abstract boolean specialRules();
    public abstract boolean checkRules();
    public boolean ifAlive(){return true;}
    public int[] convertor(String position){
       int[] arr = new int[2];
        if(position.substring(1,2).equalsIgnoreCase("8")){arr[0]=0;}
        else if(position.substring(1,2).equalsIgnoreCase("7")){arr[0]=1;}
        else if(position.substring(1,2).equalsIgnoreCase("6")){arr[0]=2;}
        else if(position.substring(1,2).equalsIgnoreCase("5")){arr[0]=3;}
        else if(position.substring(1,2).equalsIgnoreCase("4")){arr[0]=4;}
        else if(position.substring(1,2).equalsIgnoreCase("3")){arr[0]=5;}
        else if(position.substring(1,2).equalsIgnoreCase("2")){arr[0]=6;}
        else if(position.substring(1,2).equalsIgnoreCase("1")){arr[0]=7;}
                if(position.substring(0,1).equalsIgnoreCase("A")){arr[1]=0;}
        else if(position.substring(0,1).equalsIgnoreCase("B")){arr[1]=1;}
        else if(position.substring(0,1).equalsIgnoreCase("C")){arr[1]=2;}
        else if(position.substring(0,1).equalsIgnoreCase("D")){arr[1]=3;}
        else if(position.substring(0,1).equalsIgnoreCase("E")){arr[1]=4;}
        else if(position.substring(0,1).equalsIgnoreCase("F")){arr[1]=5;}
        else if(position.substring(0,1).equalsIgnoreCase("G")){arr[1]=6;}
        else if( position.substring(0,1).equalsIgnoreCase("H")){arr[1]=7;}
        return arr;
    }

}
