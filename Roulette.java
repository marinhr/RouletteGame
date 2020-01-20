import java.util.Random;

public class Roulette implements Game{

    Random rand = new Random();
    private int number = rand.nextInt((36 - 0) + 1);

    public Roulette() {}

    public int getNumber()
        {
        return number;
        }

    @Override
    public void run()
        {
        Menu menu = new Menu();
        welcomingUser();
        menu.showMenu();
        }

    private void welcomingUser()
        {
        System.out.println("Welcome to our roulette. Please choose a way to bet (Options [1-3])\n"
                + "Click 1 if you want to place a bet on a number\n"
                + "Click 2 if you want to place a bet on a color\n"
                + "Click 3 if you want to place a bet on a section");
        }


}
