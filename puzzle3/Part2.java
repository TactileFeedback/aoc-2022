import java.io.File;
import java.util.Scanner;

public class Part2 {
    public static void Part2(String[] args) {
        try {
            File input = new File("C:\\Users\\Dee\\Desktop\\Advent of Code\\puzzle3\\input.txt");
            Scanner scanner = new Scanner(input);

            int prioritySum = 0;
            char[] backPackOne;
            char[] backPackTwo;
            char[] backPackThree;

            while(scanner.hasNext()) {
                backPackOne = scanner.nextLine().toCharArray();
                backPackTwo = scanner.nextLine().toCharArray();
                backPackThree = scanner.nextLine().toCharArray();
                prioritySum += getBadge(backPackOne, backPackTwo, backPackThree);
            }

            System.out.println(prioritySum);

            scanner.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getBadge(char[] backPackOne, char[] backPackTwo, char[] backPackThree) {
        for(char badgeOne : backPackOne){
            for(char badgeTwo: backPackTwo) {
                for(char badgeThree : backPackThree) {
                    if(badgeOne == badgeTwo && badgeTwo == badgeThree) {
                        return getValue(badgeOne);
                    }
                }
            }
        }

        return 0;
    }

    private static int getValue(char supplyOne) {
        int temp  = (int) supplyOne;
        return temp > 96 ? temp - 96 : temp - 38;
    }
}
