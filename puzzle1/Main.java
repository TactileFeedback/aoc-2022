import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void  main(String[] args) {
        try{
            File input = new File("C:\\Users\\Dee\\Desktop\\puzzle1\\input.txt");
            Scanner scanner = new Scanner(input);

            String temp;
            int groupCounter = 0;
            int highCounterOne = 0;
            int highCounterTwo = 0;
            int highCounterThree = 0;
            while(scanner.hasNext()){
                temp = scanner.nextLine();

                if(!temp.isBlank()){
                    groupCounter += Integer.parseInt(temp); 
                } else {
                    if(groupCounter > highCounterOne) {
                        highCounterThree = highCounterTwo;
                        highCounterTwo = highCounterOne;
                        highCounterOne = groupCounter;
                    } else if(groupCounter > highCounterTwo) {
                        highCounterThree = highCounterTwo;
                        highCounterTwo = groupCounter;
                    } else if(groupCounter > highCounterThree) {
                        highCounterThree = groupCounter;
                    }

                    groupCounter = 0;
                }
            }
            System.out.println(highCounterOne);
            System.out.println(highCounterTwo);
            System.out.println(highCounterThree);
            System.out.println(highCounterOne + highCounterTwo + highCounterThree);

            scanner.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

