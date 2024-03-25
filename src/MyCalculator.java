import megaLibreria.utilities;

import java.util.Scanner;

public class MyCalculator {

    public static void main(final String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
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
                        scan.nextLine();
                        longPower(n,p);

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 0:

                        break;
                    default:
                        System.out.println("ATENCIÓ!!! \nHa de ser un valor entre 0 i 3");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
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
                throw new NumberFormatException("Ni n ni p poden ser negatius");
            } else if (n == 0 || p == 0) {
                throw new NumberFormatException("Ni n ni p poden ser 0");
            }
        }

    }
}

