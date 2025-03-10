import java.util.Random;

public class City {

    private String name;
    private int bushels = 2800;
    private int acres = 1000;
    private int inhabitants = 100;
    private int food;
    private int plantedFields;
    private int cityAge = 1;
    public static final int PRICE = 10;
    private static final int REQUIRED_FOOD_PER_PERSON = 20;
    private Random random = new Random();

    @Override
    public String toString(){
        return "City Status: In the year " + cityAge + " after its foundation, " + inhabitants + " inhabitants live in the town of Codeopolis. The town owns " + bushels + " bushels of grain and " + acres + " acres of land.";
    }

    public int getAcres(){
        return acres;
    }

    public int getBushels(){
        return bushels;
    }

    public int getFood(){
        return food;
    }

    public int getPlantedFields(){
        return plantedFields;

    }

    public String getStatus(){
        return acres + " acres of land, " + bushels +" bushels of grain, " + inhabitants + "  residents.";
    }

    public void setInhabitants(int number){
        if(number >= 0){
            inhabitants = number;
        }

    }

    public boolean buy(int amount){
        if(amount*10 < bushels){
            bushels -= amount*10;
            acres += amount;
            return true;
        }
        return false;
    }

    public boolean sell(int amount){

        if(amount < acres && amount >= 0){
            acres -= amount;
            bushels += amount*10;
            return true;
        }
        return false;
    }

    public boolean feed(int amount){
        if(amount < bushels){
            bushels -= amount;
            food = amount;
            return true;
        }
        return false;
    }

    public boolean plant(int amount){
        plantedFields = 0;
        if(amount <= inhabitants*10 && amount <= bushels) {
            plantedFields = amount;
            bushels -= amount;
            return true;
        }
        return false;
    }

    public void runTurn() {
        int inhabitantsBeforeDeath = inhabitants;
        int deathPeople = 0;

        // Hungertote berechnen
        int maxSurvivors = food / REQUIRED_FOOD_PER_PERSON;
        if (maxSurvivors < inhabitants) {
            deathPeople = inhabitants - maxSurvivors;
            inhabitants = maxSurvivors;
        }
        System.out.format("%d people starved...\n", deathPeople);

        // Einwohnerzuwachs
        int newPeople = 0;
        if (deathPeople < (inhabitantsBeforeDeath * 0.4)) {
            newPeople = (int) (random.nextDouble() * 0.4 * inhabitants);
            inhabitants += newPeople;
        }
        System.out.format("%d people came to the city\n", newPeople);

        // Ernterate (Ernte vervielfachen, aber nicht mehr als 6x)
        int harvestedBushels = (int) (random.nextDouble() * 0.9 + 0.1) * 6 * bushels;
        bushels += harvestedBushels;
        System.out.format("%d Bushels are now in stock\n", bushels);

        // Rattenplage (bis zu 25% der Vorräte)
        int eatenBushels = (int) (random.nextDouble() * 0.25 * bushels);
        bushels -= eatenBushels;
        System.out.format("%d bushels were eaten by rats...\n", eatenBushels);

        // Jahr erhöhen
        cityAge++;
    }

}
