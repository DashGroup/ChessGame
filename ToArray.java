
public class ToArray
{
     public String[] toArray(String instruction)//GOTO A2,A3
     {
        String cut[]=new String[2];
        cut[0]=instruction.substring(5,7);   
        cut[1]=instruction.substring(8,10);
        return cut;
     }
}
