import java.io.File;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        try {
            File input = new File("C:\\Users\\Dee\\Desktop\\Advent of Code\\puzzle3\\input.txt");
            Scanner scanner = new Scanner(input);

            String backPack = "";
            char[] pocketOne;
            char[] pocketTwo;
            int prioritySum = 0;
            boolean match = false;

            while(scanner.hasNext()) {
                backPack = scanner.nextLine();
                pocketOne = backPack.substring(0, backPack.length() / 2).toCharArray();
                pocketTwo = backPack.substring( backPack.length() / 2).toCharArray();

                for(char supplyOne : pocketOne) {
                    for(char supplyTwo : pocketTwo) {
                        if(supplyOne == supplyTwo) {
                            System.out.println(supplyOne);
                            prioritySum += getValue(supplyOne);
                            match = true;
                            break;
                        }
                    }
                    if(match) {
                        match = false;
                        break;
                    }
                }
            }

            System.out.println(prioritySum);

            scanner.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getValue(char supplyOne) {
        int temp  = (int) supplyOne;
        return temp > 96 ? temp - 96 : temp - 38;
    }
}
