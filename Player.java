<<<<<<< HEAD
import java.util.*;
public class Player
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
            positions.set(index,second);
            String name = names.get(index);
            return name;
        }   
        return "wrong";
    }
    Player(String input){
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
=======
public class Player
{
    private Knight knight1;
    private Knight knight2;
    private Queen queen;
    private King king;
    private Bishop bishop1;
    private Bishop bishop2;
    private Rook rook1;
    private Rook rook2;
    private Pawns pawns1;
    private Pawns pawns2;
    private Pawns pawns3;
    private Pawns pawns4;
    private Pawns pawns5;
    private Pawns pawns6;
    private Pawns pawns7;
    private Pawns pawns8;
}
>>>>>>> origin/master