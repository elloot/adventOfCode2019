import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Finds the closest intersection between cables
 * 2019-12-12
 * Author: Elliot Duchek
 */
public class day3 {
    public static void main(String[] args) {
        ArrayList<Integer> cableAX = new ArrayList<Integer>();
        cableAX.add(0);
        ArrayList<Integer> cableAY = new ArrayList<Integer>();
        cableAY.add(0);

        Scanner in = null;

        try {
            in = new Scanner (new File("./input/inputDay3"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            in = new Scanner(System.in);
        }

        String tempIn = in.nextLine();
        String[] moveA = tempIn.split(",");

        for (int i = 0; i<moveA.length; i++) {
            String tempMove = moveA[i];

            if (tempMove.charAt(0) == 'R') {
                int tempMoveNumber = Integer.parseInt(tempMove.substring(1));
                for (int j = 0; j < tempMoveNumber; j++) {
                    int last = cableAX.get(cableAX.size() - 1);
                    cableAX.add(j+last);
                }
            }
        }


    }
}
