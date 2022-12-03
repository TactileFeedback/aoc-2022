import java.io.File;
import java.util.Scanner;

public class Main {
    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS = 3;
    private static final int WON = 6;
    private static final int DRAW = 3;
    private static final int LOSS = 0;
    
    public static void main(String[] args) {
        try{
            File input = new File("C:\\Users\\Dee\\Desktop\\Advent of Code\\puzzle2\\input.txt");
            Scanner scanner = new Scanner(input);
    
            int totalScore = 0;
            String round = "";

            while(scanner.hasNext()) {
                round = scanner.nextLine();
                totalScore = calculateUltimateRound(totalScore, round);
            }
            System.out.println(totalScore);

            scanner.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int calculateRound(int totalScore, String roundChoices) {
        switch(roundChoices) {
            case "A X": //Elf: Rock       You: Rock 
                return totalScore += DRAW + ROCK;
            case "A Y": //Elf: Rock       You: Paper
                return totalScore += WON + PAPER;
            case "A Z": //Elf: Rock       You: Scissors
                return totalScore += LOSS + SCISSORS;
            case "B X": //Elf: Paper      You: Rock
                return totalScore += LOSS + ROCK;
            case "B Y": //Elf: Paper      You: Paper
                return totalScore += DRAW + PAPER;
            case "B Z": //Elf: Paper      You: Scissors
                return totalScore += WON + SCISSORS; 
            case "C X": //Elf: Scissors   You: Rock
                return totalScore += WON + ROCK;
            case "C Y": //Elf: Scissors   You: Paper
                return totalScore += LOSS + PAPER;
            case "C Z": //Elf: Scissors   You: Scissors
                return totalScore += DRAW + SCISSORS;
            default:
                System.out.println(roundChoices);
                return totalScore;
        }
    }

    public static int calculateUltimateRound(int totalScore, String roundChoices) {
        switch(roundChoices) {
            case "A X": //Elf: Rock       You: Lose 
                return totalScore += LOSS + SCISSORS;
            case "A Y": //Elf: Rock       You: Draw
                return totalScore += DRAW + ROCK;
            case "A Z": //Elf: Rock       You: Win
                return totalScore += WON + PAPER;
            case "B X": //Elf: Paper      You: Lose
                return totalScore += LOSS + ROCK;
            case "B Y": //Elf: Paper      You: Draw
                return totalScore += DRAW + PAPER;
            case "B Z": //Elf: Paper      You: Win
                return totalScore += WON + SCISSORS; 
            case "C X": //Elf: Scissors   You: Lose
                return totalScore += LOSS + PAPER;
            case "C Y": //Elf: Scissors   You: Draw
                return totalScore += DRAW + SCISSORS;
            case "C Z": //Elf: Scissors   You: Win
                return totalScore += WON + ROCK;
            default:
                System.out.println(roundChoices);
                return totalScore;
        }
    }
}
