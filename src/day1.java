import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A thingy that calculates fuel I think
 * 2019-12-05
 * Author: Elliot Duchek
 */
public class day1 {
    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new File("./input/inputDay1"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            in = new Scanner(System.in);
        }

        int fuelSum = 0;
        int mass;

        while (in.hasNextLine()) {
            mass = (Integer.parseInt(in.nextLine())/3)-2;
            fuelSum += mass;
            while (mass/3 > 0) {
                mass = (mass / 3) - 2;
                if (mass != 0) {
                    fuelSum += mass;
                }
            }
        }
        /*mass = (100756/3)-2;
        fuelSum += mass;
        while (mass/3 > 0) {
            mass = (mass / 3) - 2;
            if (mass < 0) {
            } else {
                fuelSum += mass;
            }
        }*/
        System.out.print(fuelSum);
    }
}
