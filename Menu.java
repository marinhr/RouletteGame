import java.util.Scanner;

public class Menu {

    Roulette rlt = new Roulette();
    Scanner scanner = new Scanner(System.in);
    public Menu() {}

    public void showMenu()
        {

        String userChoice = scanner.nextLine();

        switch (userChoice)
            {
            case "1":
                betOnDigit();
                break;
            case "2":
                betOnColor();
                break;
            case "3":
                betOnSector();
                break;
            default:
                System.out.println("Invalid choice");
                showMenu();
            }
        }

    private double betOnDigit()
        {
        int rouletteNumber = rlt.getNumber();
        double wining;
        System.out.println("Chose a number to bet on");
        try
            {
            int userDigit = Integer.parseInt(scanner.nextLine());

            if (userDigit >= 0 && userDigit <= 36)
                {
                System.out.println("Chose a bet");
                double userBet = Double.parseDouble(scanner.nextLine());

                if (userDigit == rouletteNumber)
                    {
                    wining = userBet * 36;
                    System.out.println("You guessed the number, you win the amount of " + wining + " leva");
                    return wining;
                    }
                else
                    {
                    System.out.println("You lost, the number is " + rouletteNumber);
                    return 0.0;
                    }
                }
            else
                {
                System.out.println("You should choose a number between 0 and 36");
                betOnDigit();
                return 0.0;
                }
            } catch (NumberFormatException e)
            {
            System.out.println("Your inputs are not correct");
            betOnDigit();
            }
        return 0.0;
        }

    private void betOnColor()
        {
        double wining;
        System.out.println("Choose a color");
        try
            {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("red") || input.equalsIgnoreCase("black") || input.equalsIgnoreCase("green"))
                {
                System.out.println("Choose a bet");
                double bet = Double.parseDouble(scanner.nextLine());

                if (input.equalsIgnoreCase(determineColor()))
                    {
                    wining = bet * 2;
                    System.out.println("Congratulations! You guessed the color. You win the amount of: " + wining + " leva");
                    }
                else
                    System.out.println("You lost");
                }
            else
                {
                System.out.println("You should choose red, black, or green!");
                betOnColor();
                }
            } catch (NumberFormatException e)
            {
            System.out.println("Please input correct values!");
            betOnColor();
            }
        }

    private void betOnSector()
        {
        System.out.println("Choose a section to bet\n" + "From 1 to 12, click 1\n" + "From 13 to 24, click 2\n" + "From 25 to 36, click 3");
        int rouletteNumber = rlt.getNumber();
        double wining;
        boolean isUserWinning;

        try
            {
            int input = Integer.parseInt(scanner.nextLine());
            if (input > 0 && input < 4)
                {
                System.out.println("Chose your bet");
                double bet = Double.parseDouble(scanner.nextLine());
                int sector;

                if (rouletteNumber >= 0 && rouletteNumber < 13)
                    sector = 1;
                else if (rouletteNumber > 12 && rouletteNumber < 25)
                    sector = 2;
                else
                    sector = 3;u

                if (sector == 1 && input == 1)
                    isUserWinning = true;
                else if (sector == 2 && input == 2)
                    isUserWinning = true;
                else if (sector == 3 && input == 3)
                    isUserWinning = true;
                else
                    isUserWinning = false;

                if (isUserWinning)
                    {
                    wining = bet * 3;
                    System.out.println("You win the amount of: " + wining + " leva");
                    }
                else
                    System.out.println("You lose, the sector is " + sector);
                }
            else
                {
                System.out.println("Wrong section! Choose a number between 1 and 3!");
                betOnSector();
                }
            } catch (NumberFormatException e)
            {
            System.out.println("Please input correct values!");
            betOnSector();
            }

        }

    public String determineColor()
        {
        int input = rlt.getNumber();
        if (input == 0)
            return "green";
        else if (input > 0 && input < 11)
            if (input % 2 != 0)
                return "red";
            else
                return "black";
        else if (input >= 11 && input < 19)
            if (input % 2 != 0)
                return "black";
            else
                return "red";
        else if (input >= 19 && input < 29)
            if (input % 2 != 0)
                return "red";
            else
                return "black";
        else if (input >= 29 && input < 37)
            if (input % 2 != 0)
                return "black";
            else
                return "red";
        return "Choose a number between 0 and 36";
        }

}
