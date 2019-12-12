import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Fixes a computer
 * 2019-12-06
 * Author: Elliot Duchek
 */
public class day2 {
    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new File("./input/inputday2"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert in != null;
        String input = in.nextLine();
        String[] inArray = input.split(",");
        int [] inInt = new int[inArray.length];
        int [] inIntSave = new int[inArray.length];
        for (int i = 0; i < inArray.length; i++) {
            inInt[i] = Integer.parseInt(inArray[i]);
            inIntSave[i] = Integer.parseInt(inArray[i]);
        }

        System.out.println("The length of the array is " + inInt.length);

        //inInt[1] = 12;
        //inInt[2] = 2;
        int sum, prod, noun, output;
        int verb = 0;

        for (int k = 0; k <= 99; k++) {
            noun = k;

            if (k == 99) {
                verb++;
                k = 0;
                if (verb == 99) {
                    break;
                }
            }

            inInt[1] = noun;
            inInt[2] = verb;

            for (int i = 0; i < inInt.length; i+=4) {
                if (inInt[i] == 1) {
                    sum = inInt[inInt[(i+1)]] + inInt[inInt[(i+2)]];
                    inInt[inInt[(i+3)]] = sum;
                } else if (inInt[i] == 2) {
                    prod = inInt[inInt[(i+1)]] * inInt[inInt[(i+2)]];
                    inInt[inInt[(i+3)]] = prod;
                } else if (inInt[i] == 99) {
                    output = inInt[0];
                    if (output == 19690720) {
                        System.out.println("The input that produced the right output is noun: " + noun + " and verb: " + verb);
                    }
                    break;
                } else {
                    System.out.println("Something went wrong, i = " + i + " and inInt = " + inInt[i]);
                }
            }
            System.arraycopy(inIntSave, 0, inInt, 0, inIntSave.length);
        }
    }
}
