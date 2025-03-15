package domainmodel;

public class CityTestDrive {

    private static int counter = 0;

    public static void main(String[] args){

        City testCity = new City(new GameConfig(DifficultyLevel.EASY));
        System.out.println("Test-process of buy-method:");
        testCity.buy(10);
        test(1010, testCity.getAcres());
        test(2700, testCity.getBushels());
        //Testing: Trying to buy more than possible, checking all values
        test(false, testCity.buy(10000));
        test(1010, testCity.getAcres());
        test(2700, testCity.getBushels());

        System.out.println("\nTest-process of sell-method:");
        testCity = new City(new GameConfig(DifficultyLevel.EASY));
        testCity.sell(100);
        test(900, testCity.getAcres());
        test(3800, testCity.getBushels());
        //Testing: Trying to sell more than possible, checking all values
        test(false, testCity.sell(1000));
        test(900, testCity.getAcres());
        test(3800, testCity.getBushels());

        System.out.println("\nTest-process of feed-method:");
        testCity = new City(new GameConfig(DifficultyLevel.EASY));
        testCity.feed(500);
        test(2300, testCity.getBushels());
        test(500, testCity.getFood());
        //Testing: Trying to feed more than possible, checking all values
        test(false,testCity.feed(4000));
        test(2300, testCity.getBushels());

        System.out.println("\nTest-process of plant-method:");
        testCity = new City(new GameConfig(DifficultyLevel.EASY));
        System.out.println(testCity.getStatus());
        test(true, testCity.plant(100));
        test(100, testCity.getPlantedFields());
        test(2700, testCity.getBushels());
        //Testing: Trying to plant more than possible, checking all values
        test(testCity.plant(1001), false);
        test(0, testCity.getPlantedFields());
        test(2700, testCity.getBushels());
        //Testing: Edge-case 1: inhabitants
        test(true, testCity.plant(1000));
        test(1000, testCity.getPlantedFields());
        test(1700, testCity.getBushels());
        //Testing: Edge-case 2:
        testCity.setInhabitants(170);
        test(true, testCity.plant(1700));
        test(1700, testCity.getPlantedFields());
        test(0, testCity.getBushels());

        System.out.println("\n Test-process of toString-method:");
        testCity = new City(new GameConfig(DifficultyLevel.EASY));
        test("domainmodel.City Status: In the year 1 after its foundation, 100 inhabitants live in the town of presentation.Codeopolis. The town owns 2800 bushels of grain and 1000 acres of land.",testCity.toString());

        testCity = new City(new GameConfig(DifficultyLevel.HARD));
        test("> Acres: 800,  > Bushels: 2800,  > Inhabitants: 100", testCity.getStatus());




    }

    public static void test(int expected, int actual){
        counter++;
        if(expected == actual){
            System.out.format("[%d] ✅ PASSED: Expected: %s ... Actual: %s\n",counter, expected, actual);
        }
        else{
            System.out.format("[%d] ❌ FAILED: Expected: %s ... Actual: %s\n",counter, expected, actual);

        }
    }

    public static void test(boolean expected, boolean actual){
        counter++;
        if(expected == actual){
            System.out.format("[%d] ✅ PASSED: Expected: %s ... Actual: %s\n",counter, expected, actual);
        }
        else{
            System.out.format("[%d] ❌ FAILED: Expected: %s ... Actual: %s\n",counter, expected, actual);

        }
    }

    public static void test(String expected, String actual){
        counter++;
        if(expected.equals(actual)){
            System.out.format("[%d] ✅ PASSED: Expected: %s ... Actual: %s\n",counter, expected, actual);
        }
        else{
            System.out.format("[%d] ❌ FAILED: Expected: %s ... Actual: %s\n",counter, expected, actual);

        }
    }
}
