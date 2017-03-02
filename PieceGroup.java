import java.util.*;
public class PieceGroup
{
    private Knight knight1 = new Knight();
    private Knight knight2 = new Knight();
    private Queen queen = new Queen();
    private King king = new King();
    private Bishop bishop1  = new Bishop();
    private Bishop bishop2 = new Bishop();
    private Rook rook1 = new Rook();
    private Rook rook2 = new Rook();
    private Pawns pawns1 = new Pawns();
    private Pawns pawns2 = new Pawns();
    private Pawns pawns3 = new Pawns();
    private Pawns pawns4 = new Pawns();
    private Pawns pawns5 = new Pawns();
    private Pawns pawns6 = new Pawns();
    private Pawns pawns7 = new Pawns();
    private Pawns pawns8 = new Pawns();
    private String arrName[] = new String[16];
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<String> positions = new ArrayList<String>();
    private ArrayList<Pieces> pieces = new ArrayList<Pieces>();
    public String[] getArrName(){
        return arrName;
    }
    public void setArrName(int i, String input){
        arrName[i] = input;
    }
    public String moveOne(String position){
        String first = position.substring(0,2);
        String second = position.substring(2);
        int index = positions.indexOf(first);
        if(index!=-1){
            String str = reverseChange(second);
            pieces.get(index).setPosition(str);
            positions.set(index,second);
            String name = names.get(index);
            return name;
        }   
        return "wrong";
    }
    private String reverseChange(String str){
        String str1 = str.substring(0,1);
        String str2 = str.substring(1,2);
        if(str1.equals("7")){str1 = "1";}
        else if(str1.equals("6")){str1 = "2";}
        else if(str1.equals("5")){str1 = "3";}
        else if(str1.equals("4")){str1 = "4";}
        else if(str1.equals("3")){str1 = "5";}
        else if(str1.equals("2")){str1 = "6";}
        else if(str1.equals("1")){str1 = "7";}
        else if(str1.equals("0")){str1 = "8";}
        if(str2.equals("0")){str2 = "A";}
        else if(str2.equals("1")){str2 = "B";}
        else if(str2.equals("2")){str2 = "C";}
        else if(str2.equals("3")){str2 = "D";}
        else if(str2.equals("4")){str2 = "E";}
        else if(str2.equals("5")){str2 = "F";}
        else if(str2.equals("6")){str2 = "G";}
        else if(str2.equals("7")){str2 = "H";}
        return str2+str1;
    }
    PieceGroup(String input){
        if(input.equals ("white")){
            knight1.setPosition("B1");
            setArrName(1,"WKT");
            knight2.setPosition("G1");
            setArrName(6,"WKT");
            queen.setPosition("D1");
            setArrName(3,"WQN");
            king.setPosition("E1");
            setArrName(4,"WKG");
            bishop1.setPosition("C1");
            setArrName(2,"WBP");
            bishop2.setPosition("F1");
            setArrName(5,"WBP");
            rook1.setPosition("A1");
            setArrName(0,"WRK");
            rook2.setPosition("H1");
            setArrName(7,"WRK");
            pawns1.setPosition("A2");
            setArrName(8,"WPN");
            pawns2.setPosition("B2");
            setArrName(9,"WPN");
            pawns3.setPosition("C2");
            setArrName(10,"WPN");
            pawns4.setPosition("D2");
            setArrName(11,"WPN");
            pawns5.setPosition("E2");
            setArrName(12,"WPN");
            pawns6.setPosition("F2");
            setArrName(13,"WPN");
            pawns7.setPosition("G2");
            setArrName(14,"WPN");
            pawns8.setPosition("H2");
            setArrName(15,"WPN");
            names.add("WRK");
            names.add("WKT");
            names.add("WBP");
            names.add("WQN");
            names.add("WKG");
            names.add("WBP");
            names.add("WKT");
            names.add("WRK");
            names.add("WPN");
            names.add("WPN");
            names.add("WPN");
            names.add("WPN");
            names.add("WPN");
            names.add("WPN");
            names.add("WPN");
            names.add("WPN");
            pieces.add(rook1);
            pieces.add(knight1);
            pieces.add(bishop1);
            pieces.add(queen);
            pieces.add(king);
            pieces.add(bishop2);
            pieces.add(knight2);
            pieces.add(rook2);
            pieces.add(pawns1);
            pieces.add(pawns2);
            pieces.add(pawns3);
            pieces.add(pawns4);
            pieces.add(pawns5);
            pieces.add(pawns6);
            pieces.add(pawns7);
            pieces.add(pawns8);
            positions.add("70");
            positions.add("71");
            positions.add("72");
            positions.add("73");
            positions.add("74");
            positions.add("75");
            positions.add("76");
            positions.add("77");
            positions.add("60");
            positions.add("61");
            positions.add("62");
            positions.add("63");
            positions.add("64");
            positions.add("65");
            positions.add("66");
            positions.add("67");
        }
        else{
            knight1.setPosition("B8");
            setArrName(1,"BKT");
            knight2.setPosition("G8");
            setArrName(6,"BKT");
            queen.setPosition("D8");
            setArrName(3,"BQN");
            king.setPosition("E8");
            setArrName(4,"BKG");
            bishop1.setPosition("C8");
            setArrName(2,"BBP");
            bishop2.setPosition("F8");
            setArrName(5,"BBP");
            rook1.setPosition("A8");
            setArrName(0,"BRK");
            rook2.setPosition("H8");
            setArrName(7,"BRK");
            pawns1.setPosition("A7");
            setArrName(8,"BPN");
            pawns2.setPosition("B7");
            setArrName(9,"BPN");
            pawns3.setPosition("C7");
            setArrName(10,"BPN");
            pawns4.setPosition("D7");
            setArrName(11,"BPN");
            pawns5.setPosition("E7");
            setArrName(12,"BPN");
            pawns6.setPosition("F7");
            setArrName(13,"BPN");
            pawns7.setPosition("G7");
            setArrName(14,"BPN");
            pawns8.setPosition("H7");
            setArrName(15,"BPN");
            names.add("BRK");
            names.add("BKT");
            names.add("BBP");
            names.add("BQN");
            names.add("BKG");
            names.add("BBP");
            names.add("BKT");
            names.add("BRK");
            names.add("BPN");
            names.add("BPN");
            names.add("BPN");
            names.add("BPN");
            names.add("BPN");
            names.add("BPN");
            names.add("BPN");
            names.add("BPN");
            pieces.add(rook1);
            pieces.add(knight1);
            pieces.add(bishop1);
            pieces.add(queen);
            pieces.add(king);
            pieces.add(bishop2);
            pieces.add(knight2);
            pieces.add(rook2);
            pieces.add(pawns1);
            pieces.add(pawns2);
            pieces.add(pawns3);
            pieces.add(pawns4);
            pieces.add(pawns5);
            pieces.add(pawns6);
            pieces.add(pawns7);
            pieces.add(pawns8);
            positions.add("00");
            positions.add("01");
            positions.add("02");
            positions.add("03");
            positions.add("04");
            positions.add("05");
            positions.add("06");
            positions.add("07");
            positions.add("10");
            positions.add("11");
            positions.add("12");
            positions.add("13");
            positions.add("14");
            positions.add("15");
            positions.add("16");
            positions.add("17");
        }
    }
}
