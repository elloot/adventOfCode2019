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

        //list for cable a coordinates
        ArrayList<Integer> cableAX = new ArrayList<>();
        cableAX.add(0);
        ArrayList<Integer> cableAY = new ArrayList<>();
        cableAY.add(0);

        int cableBX = 0;
        int cableBY = 0;

        ArrayList<Integer> intersections = new ArrayList<>();

        ArrayList<Integer> distance = new ArrayList<>();
        int shortDistance;

        //list for cable b coordinates
        /*ArrayList<Integer> cableBX = new ArrayList<>();
        cableBX.add(0);
        ArrayList<Integer> cableBY = new ArrayList<>();
        cableBY.add(0);*/


        Scanner in;

        try {
            in = new Scanner(new File("./input/inputDay3"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            in = new Scanner(System.in);
        }

        //reads instructions for cable a to string array
        String tempIn = in.nextLine();
        String[] moveA = tempIn.split(",");

        //reads instructions for cable b to string array
        tempIn = in.nextLine();
        String[] moveB = tempIn.split(",");

        for (int i = 0; i < moveA.length; i++) {
            //stores the current instructions in a variable
            //String tempMoveX = moveA[i];

            //gets the current x and y coordinate of cableA and stores them in variables
            int lastX = cableAX.get(cableAX.size() - 1);
            int lastY = cableAY.get(cableAY.size() - 1);

            //checks which direction to increase cable length and does it
            drawCableA(cableAX, cableAY, moveA, i, lastX, lastY);
        }

        //find intersections between B and A
        for (int i = 0; i< moveB.length; i++) {
            int tempMoveNumber = Integer.parseInt(moveA[i].substring(1));
            switch (moveB[i].charAt(0)) {
                case 'R':
                    for (int j = 0; j < tempMoveNumber; j++) {
                        cableBX++;
                        for (int k = 0; k < cableAX.size(); k++) {
                            if (cableBX == cableAX.get(k) && cableBY == cableAY.get(k)) {
                                intersections.add(cableBX);
                                intersections.add(cableBY);
                                distance.add((Math.abs(cableBX)+Math.abs(cableBY)));
                                shortDistance = Math.abs(cableBX)+Math.abs(cableBY;
                            }
                        }
                    }
                    break;
                case 'L':
                    for (int j = 0; j < tempMoveNumber; j++) {
                        cableBX--;
                        for (int k = 0; k < cableAX.size(); k++) {
                            if (cableBX == cableAX.get(k) && cableBY == cableAY.get(k)) {
                                intersections.add(cableBX);
                                intersections.add(cableBY);
                                distance.add((Math.abs(cableBX)+Math.abs(cableBY)));
                            }
                        }
                    }
                    break;
                case 'U':
                    for (int j = 0; j < tempMoveNumber; j++) {
                        cableBY++;
                        for (int k = 0; k < cableAX.size(); k++) {
                            if (cableBX == cableAX.get(k) && cableBY == cableAY.get(k)) {
                                intersections.add(cableBX);
                                intersections.add(cableBY);
                                distance.add((Math.abs(cableBX)+Math.abs(cableBY)));
                            }
                        }
                    }
                    break;
                case 'D':
                    for (int j = 0; j < tempMoveNumber; j++) {
                        cableBY--;
                        for (int k = 0; k < cableAX.size(); k++) {
                            if (cableBX == cableAX.get(k) && cableBY == cableAY.get(k)) {
                                intersections.add(cableBX);
                                intersections.add(cableBY);
                                distance.add((Math.abs(cableBX)+Math.abs(cableBY)));
                            }
                        }
                    }
                    break;

            }
        }

        for (int i = 0; i < distance.size(); i++) {

        }
        System.out.println(intersections);
    }

    private static void drawCableA(ArrayList<Integer> cableAX, ArrayList<Integer> cableAY, String[] moveA, int i, int lastX, int lastY) {
        switch (moveA[i].charAt(0)) {
            //increases cable x coordinate
            case 'R':
                //stores the number by which to increase the x-coordinate
                int tempMoveNumber = Integer.parseInt(moveA[i].substring(1));
                //increases the x-coordinate by one (starting from the last known x-coordinate) and adds
                //each increment to fully draw the cable
                increaseCableX(cableAX, cableAY, lastX, lastY, tempMoveNumber);
                break;
            case 'L':
                //stores the number by which to decrease the x-coordinate
                tempMoveNumber = Integer.parseInt(moveA[i].substring(1));
                //decreases x
                decreaseCableAX(cableAX, cableAY, lastX, lastY, tempMoveNumber);
                break;
            case 'U':
                //stores the number by which to increase the y-coordinate
                tempMoveNumber = Integer.parseInt(moveA[i].substring(1));
                //increases y
                increaseCableAY(cableAX, cableAY, lastX, lastY, tempMoveNumber);
                break;
            case 'D':
                tempMoveNumber = Integer.parseInt(moveA[i].substring(1));
                //decreases y
                decreaseCableAY(cableAX, cableAY, lastX, lastY, tempMoveNumber);
                break;
        }
    }

    private static void decreaseCableAY(ArrayList<Integer> cableAX, ArrayList<Integer> cableAY, int lastX, int lastY, int tempMoveNumber) {
        for (int j = 0; j < tempMoveNumber; j++) {
            cableAY.add(lastY - j - 1);
            //adds static x
            cableAX.add(lastX);
        }
    }

    private static void increaseCableAY(ArrayList<Integer> cableAX, ArrayList<Integer> cableAY, int lastX, int lastY, int tempMoveNumber) {
        for (int j = 0; j < tempMoveNumber; j++) {
            cableAY.add(lastY + j + 1);
            //adds static x
            cableAX.add(lastX);
        }
    }

    private static void decreaseCableAX(ArrayList<Integer> cableAX, ArrayList<Integer> cableAY, int lastX, int lastY, int tempMoveNumber) {
        for (int j = 0; j < tempMoveNumber; j++) {
            cableAX.add(lastX - j - 1);
            cableAY.add(lastY);
        }
    }

    private static void increaseCableX(ArrayList<Integer> cableAX, ArrayList<Integer> cableAY, int lastX, int lastY, int tempMoveNumber) {
        for (int j = 0; j < tempMoveNumber; j++) {
            cableAX.add(j + lastX + 1);
            //adds static y-coordinate to y-list so each x-coordinate has a corresponding y-coordinate
            cableAY.add(lastY);
        }
    }
}