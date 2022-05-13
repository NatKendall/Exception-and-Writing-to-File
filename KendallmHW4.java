package kendallmhw4;

import java.io.*;
import java.util.*;
import java.io.FileWriter;

/**
 * My words and actions will reflect Academic Integrity. I will not cheat or lie
 * or steal in academic matters. I will promote integrity in the UNCG community.
 * Student’s Signature (Nat) Michelle Kendall Date 3/20/2022
 *
 * @author Kenda
 */
// KendallmHW4
/*
    (Nat) Michelle Kendall
     CSC 230, Sec 03
     3/20/2022
 */
public class KendallmHW4 {

    public static void sortArraysMethod(int a[]) {
        Arrays.sort(a);
    }

    public static void printValuesMethod(int k[]) {
        System.out.print("The array in ascending order is: ");
        for (int i = 0; i < k.length; i++) {
            System.out.print(k[i] + " ");
        }
    }

    public static double averageArrayMethod(int a[]) {
        double sum = 0.0, av;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        av = sum / 50;
        return av;
    }

    public static double StandDev(int b[]) {
        double av = 26.640, stand = 0.0, rstand;
        int i = 50;
        for (int c = 0; c < i; c++) {
            stand = stand + Math.pow((b[c] - av), 2);
        }
        rstand = stand / i;
        double k = Math.sqrt(rstand);
        return k;
    }

    public static void printToFileArray(int ar[]) {
        sortArraysMethod(ar);
        try (FileWriter writer = new FileWriter("GradesOut.txt")) {
            for (int c = 0; c < ar.length; c++) {
                writer.write(ar[c] + " ");
            }
            writer.write("\n");
            writer.write("\n");
            writer.write(String.format("The Average of the Grades is %.3f", averageArrayMethod(ar)));
            writer.write("\n");
            writer.write(String.format("The Standard Deviation of the Grades is %.3f", StandDev(ar)));
            writer.close();
        } catch (IOException e) {
            System.out.println("Not found" + e);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner n = new Scanner(System.in);
        double sum;
        int i = 0;
        int[] ar = new int[50];
        System.out.println();
        System.out.println("KendallMHW4\n"
                + "Michelle Kendall\n"
                + "CSC 230, Sec 03\n");   
        System.out.println("This program loads to an array a list of 50 grades read from a file.\n"
                + "Once the scores have been loaded to the array, provide the user with a menu of options:");
        System.out.println("A. Print the Grades to the Screen sorted in ascending order");
        System.out.println("B. Calculate and print to the screen the average value of the scores");
        System.out.println("C. Calculate and print to the screen the standard deviation of the scores");
        System.out.println("D. Print the grades to a file sorted in ascending order, along with the average value\n"
                + " and standard deviation of the scores");
        System.out.println("E. Quit");
        
        try {
            Scanner sc = new Scanner(new FileReader("gradesIn.txt"));
            sum = 0;
            i = 0;
            while (sc.hasNext()) {
                ar[i] = sc.nextInt();
                sum += ar[i];
                i++;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("not found" + e);
        }

        char ch = 'A';

        do {
            System.out.println();
            System.out.print("******************************************************************\n"
                    + "* Menu: *\n"
                    + "* A - Show Grades in Ascending Order. *\n"
                    + "* B - Calculate and Print Average of Grades *\n"
                    + "* C - Calculate and Print Standard Deviation of Grades *\n"
                    + "* D - Create File with Grades, Average, and Standard Deviation *\n"
                    + "* E - Quit *\n"
                    + "******************************************************************\n");
            System.out.println();
            System.out.print("Enter a letter for your choice on the menu (A, B, C, D, or E): ");
            String input = n.next();
           
            ch = input.charAt(0);
            ch = Character.toUpperCase(ch);
            switch (ch) {
                case 'A':
                    sortArraysMethod(ar);
                    printValuesMethod(ar);
                    break;
                case 'B':
                    System.out.printf("The average of the Grades is %.3f", averageArrayMethod(ar));
                    System.out.println();
                    break;
                case 'C':

                    System.out.printf("The Standard Deviation of the Grades is %.3f", StandDev(ar));
                     System.out.println();
                    break;
                case 'D':
                    printToFileArray(ar);
                    break;
                case 'E':
                    System.out.println("Thanks for using my program!");
                    System.exit(0);
            }

        } while (ch != 'E');
    }

}
