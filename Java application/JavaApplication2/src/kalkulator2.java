
import java.util.Scanner;

public class kalkulator2 {





public static void main(String[] args)





{



double x;



double y;



char v;



double r=0;



Scanner in=new Scanner(System.in);



System.out.println("Jepni vleren e x-it");



x=in.nextDouble();



System.out.println("Jepni veprimin");



v=in.next().charAt(0);



System.out.println("Jepni vleren e y-it");



y=in.nextDouble();





switch(v)



{



case'+':



r=x+y;



System.out.println(r);



break;



case'-':



r=x-y;



System.out.println(r);



break;



case'*':



r=x*y;



System.out.println(r);



break;



case'/':



r=x/y;



System.out.println(r);



break;







}



}



}



