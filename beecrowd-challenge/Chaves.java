import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner; // Import the Scanner class

/**
Gabriel works as Software Engineer at the Fingerbook Inc. On the last week he had a lot of work to do. 
So he decided to sleep at the FingerBook the whole week. After he finished his job, he decided to leave. 
then he realized he has lost his keys from home, so he decided to come back to pick up the keys.

Gabriel decided to start looking in which office that he was recently, After looking in all of the offices 
that he was in the last two days he hasn’t found the keys yet. So he decided to ask you to help him to search 
for the keys again. So he’ll tell you which ones of the offices that he was in the last week.

Help him to find the keys telling him in which offices is possible to find the keys.

Input
The first line contains two integers Q(1 ≤ Q ≤ 1*103) and E(1 ≤ E ≤ Q) representing respectively the number of 
offices that he was in the last week and the number of offices that he was in the last two days.

The second line contains E integers Si (1 ≤ Si ≤ 1000) containing the Identification number of each office 
that he was in the last two days.

The next line contains Q integers Ci (1 ≤ Ci ≤ 1000) containing the identification number of each one of 
the offices that he was in the last week.

Output
For each office that he was in the last week your program should return “0” in case he has already visited 
that office while looking for the keys. Else your program should return “1” in case he hasn't visited that 
office yet while he was looking for the keys.

Input Sample	
10 5
1 15 5 998 27
1
88
15
88
99
5
100
7
27
998

Output Sample
0
1
0
0
1
0
1
1
0
0
 */
public class Main {

    public static void main(String[] args) throws IOException {

        /**
         * Escreva a sua solução aqui
         * Code your solution here
         * Escriba su solución aquí
         */

        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        String s = myObj.nextLine(); // Read user input

        String[] result = s.split(" ");
        int semana = Integer.parseInt(result[0]);
        int doisDias = Integer.parseInt(result[1]);
        int arraylenght = doisDias;

        s = myObj.nextLine(); // Read user input
        result = s.split(" ");

        int[] idDoisDias = new int[1000];

        for (int i = 0; i < doisDias; i++) {
            idDoisDias[i] = Integer.parseInt(result[i]);
        }

        int read;

        for (int i = 0; i < semana; i++) {
            boolean found = false;
            s = myObj.nextLine(); // Read user input
            read = Integer.parseInt(s);
            for (int j = 0; j < arraylenght; j++) {
                if (idDoisDias[j] == read) {
                    found = true;
                    break;
                }
            }
            if (found) {
                System.out.println(0);
            } else {
                System.out.println(1);
                idDoisDias[arraylenght] = read;
                arraylenght++;
            }
        }
        myObj.close();
    }

}
