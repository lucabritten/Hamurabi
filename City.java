public class City {

    private String name;
    private int bushels = 2800;
    private int acres = 1000;
    private int inhabitants = 100;
    private int food;
    private int plantedFields;
    private int cityAge = 1;
    private static final int price = 10;

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

    public int getPrice(){
        return price;
    }

    public String getStatus(){
        return acres + " acres of land, " + bushels +" bushels of grain, " + inhabitants + "  residents.";
    }

    public void setInhabitants(int number){
        if(number >= 0){
            inhabitants = number;
        }

    }

}
