package presentation;

import domainmodel.City;
import domainmodel.Game;
import domainmodel.DifficultyLevel;
import domainmodel.UserInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TextInterface implements UserInterface{

    private Game game;
    private Scanner scanner = new Scanner(System.in);

    public void setGame(Game game){
        this.game = game;
    }

    public void showMainMenu(){
        boolean running = true;
        while(running) {
            System.out.println("----- MAIN MENU -----");
            System.out.println("1) New domainmodel.Game");
            System.out.println("2) Quit");
            System.out.println("Please select an option: ");

            int input = getUserInput(1,2);
            switch (input){
                case 1:
                    game.start();
                    break;
                case 2:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input.");

            }
        }
    }

    public DifficultyLevel getDifficultyLevel(){
        System.out.println("----- DIFFICULTY -----");
        System.out.println("1) EASY");
        System.out.println("2) MEDIUM");
        System.out.println("3) HARD");

        int input = getUserInput(1,3);
        switch(input){
            case 1:
                return DifficultyLevel.EASY;
            case 2:
                return DifficultyLevel.MEDIUM;
            case 3:
                return DifficultyLevel.HARD;
        }
        throw new InputMismatchException("Invalid input.");

    }

    public void displayCityStatus(City city){
        System.out.format("Current statistics: %s", city);
    }

    public int getAcresToBuy(){
        System.out.println(game.showStatus());
        System.out.println("How many Acres do you want to buy?");
        System.out.format("Current price per Acres is: %d\n", game.getPRICE());
        System.out.print(">");
        return getUserInput();
    }

    public int getAcresToSell(){
        System.out.println(game.showStatus());
        System.out.println("How many Acres do you want to sell?");
        System.out.format("Current price per Acres is: %d\n", game.getPRICE());
        System.out.print(">");
        return getUserInput();
    }

    public int getBushelsToFeed(){
        System.out.println(game.showStatus());
        System.out.println("How many Bushels do you want to feed?");
        System.out.format("There are %d bushels required per person.\n", game.getREQUIRED_FOOD_PER_PERSON());
        System.out.print(">");
        return getUserInput();
    }

    public int getBushelsToPlant(){
        System.out.println(game.showStatus());
        System.out.println("How many Bushels do you want to plant?");
        System.out.print(">");
        return getUserInput();
    }

    private int getUserInput(int lowerBorder, int upperBorder) {
        while (true) {
            try {
                int num = scanner.nextInt();
                if (lowerBorder <= num && num <= upperBorder) {
                    return num;
                }
                System.out.format("Invalid input: %d. Please try again:", num);
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a number.");
            }

        }
    }

    private int getUserInput(){
        while(true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Please enter a number.");
            }
        }
    }

}
