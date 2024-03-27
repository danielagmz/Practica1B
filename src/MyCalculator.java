import java.util.InputMismatchException;
import java.util.Scanner;

public class MyCalculator {

    public static void main(final String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        String ANSI_RESET = "\u001B[0m";
        String ANSI_PURPLE= "\u001B[35m";
        int opcio;
        do {
            System.out.println("1. Ennessima potencia d'un nombre");
            System.out.println("2. Divisio d'enters");
            System.out.println("3. Equacio de segon grau");
            System.out.println("0. Acabar");
            System.out.print("Entra una opció (0-3): ");
            opcio = scan.nextInt();
            scan.nextLine();

            try {
                switch (opcio) {
                    case 1:
                        int n;
                        int p;
                        System.out.print("Introdueix la base i l'exponent): ");
                        n= scan.nextInt();
                        p= scan.nextInt();
                        longPower(n,p);
                        scan.nextLine();
                        break;
                    case 2:
                        int x;
                        int y;

                        System.out.print("Introdueix el numerador: ");
                        x= scan.nextInt();
                        System.out.print("Introdueix el denominador: ");
                        y= scan.nextInt();
                        scan.nextLine();
                        divisio(x,y);

                        break;
                    case 3:
                        int a;
                        int b;
                        int c;

                        System.out.println(ANSI_PURPLE+ "Format: ax²+bx+c=0"+ANSI_RESET);
                        System.out.print("Introdueix la a: ");
                        a= scan.nextInt();
                        System.out.print("Introdueix la b: ");
                        b= scan.nextInt();
                        System.out.print("Introdueix la c: ");
                        c= scan.nextInt();
                        calculsegonGrau(a,b,c);
                        break;
                    case 0:

                        break;
                    default:
                        System.out.println("ATENCIÓ!!! \nHa de ser un valor entre 0 i 3");
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }catch (InputMismatchException e2){
                System.out.println(e2);
                scan.nextLine();
            }catch (ArithmeticException e3){
                System.out.println(e3);
            }

            System.out.println();
            Thread.sleep(700);
        } while (opcio != 0);


    }
    public static void longPower(int n,int p){

        if (n > 0 && n <= 10 && p > 0 && p <= 10) {
            System.out.print((int) Math.pow(n,p));
        }else {
            if (n < 0 || p < 0) {
                throw new IllegalArgumentException("Ni n ni p poden ser negatius");
            } else if (n == 0 || p == 0) {
                throw new IllegalArgumentException("Ni n ni p poden ser 0");
            }

        }

    }
    public static void divisio(int x,int y){
        System.out.println(x/y);
    }

    public  static void calculsegonGrau(int a, int b, int c){
        double D=  Math.pow(b, 2) - 4 * a * c;
        double x1 = 0;
        double x2 = 0;
        String excepcion=String.format("El discriminant no pot ser negatiu\n%d²-4*%d*%d= %.1f",b,a,c,D);


        if (a==0){
            throw new IllegalArgumentException("a no pot ser 0");
        }

        if (D>0){
            x1 = (-b + Math.sqrt(D)) / (2 * a);
            x2 = (-b - Math.sqrt(D)) / (2 * a);

            System.out.printf("x1= %f\nx2= %f",x1,x2);

        } else if (D==0) {
            x1= (double) -b /(2*a);

            System.out.printf("x1= %f",x1);

        } else if (D<0) {
            throw new IllegalArgumentException(excepcion);
        }


    }
}

