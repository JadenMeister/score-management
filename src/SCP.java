import java.io.*;

public class SCP implements Serializable, Comparable <SCP> {
    private String Id;
    private String Major;
    private double sub1;
    private double sub4;
    private double sub2;
    private double sub3;
    private double sub5;
    private double sub6;
    private double sub7;
    private double sub8;
    private double total;

    private double avg;

    public SCP(String Major, String Id, double sub1, double sub2, double sub3, double sub4,
               double sub5, double sub6, double sub7, double sub8) {
        this.Major = Major;
        this.Id = Id;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.sub4 = sub4;
        this.sub5 = sub5;
        this.sub6 = sub6;
        this.sub7 = sub7;
        this.sub8 = sub8;
        this.total = sub1 + sub2 + sub3 + sub4 + sub5+ sub6 + sub7+ sub8;
        this.avg = total/8;

    }

    public String getMajor() {return Major;}
    public String getId() {return Id;}
    public double getSub1() {return sub1;}
    public double getSub2() {return sub2;}
    public double getSub3() {return sub3;}
    public double getSub4() {return sub4;}
    public double getSub5() {return sub5;}
    public double getSub6() {return sub6;}
    public double getSub7() {return sub7;}
    public double getSub8() {return sub8;}
    public double getTotal() {return total;}
    public double getAvg() {return avg;}

    public int compareTo(SCP o){
        if(getTotal()<o.getTotal()) return -1;
        else if (getTotal()==o.getTotal()) return 0;
        else return 1;
            


    }
     @Override
    public String toString() {
        return Major + "," + Id + "," + sub1 + "," + sub2 + "," + sub3 + "," + sub4 + "," + sub5 +
                "," + sub6 + "," + sub7 + "," + sub8+ "," + total+ "," + avg;
     }


}