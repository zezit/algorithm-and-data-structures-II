import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 Read three integers and sort them in ascending order. After, print these values in ascending order, a blank line and then the values in the sequence as they were readed.

    Input
    The input contains three integer numbers.

    Output
    Present the output as requested above.

    Input Sample    |	Output Sample
      7 21 -14              -14
                            7
                            21

                            7
                            21
                            -14

      -14 21 7      |       -14
                            7
                            21

                            -14
                            21
                            7
 */
public class Ordenacao {

    public static void main(String[] args) throws IOException {

        /**
         * Escreva a sua solução aqui
         * Code your solution here
         * Escriba su solución aquí
         */
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        String s = myObj.nextLine(); // Read user input

        String[] result = s.split(" ");
        int[] a = new int[3];
        int[] outro = new int[3];

        int b = 0;
        for (String i : result) {
            if(b <= 2){int number = Integer.parseInt(i);
            a[b] = number;
            outro[b] = number;
            b++;}
        }

        Arrays.sort(a);

        for (int k = 0; k < 3; k++) {
            System.out.println(a[k]);
        }

        System.out.println("");

        for (int j = 0; j <3 ; j++) {
            System.out.println(outro[j]);
        }

        myObj.close();

    }
}
