
public class CityTestDrive {

    public static void main(String[] args){

        City testCity = new City();
        System.out.println("Test-process of buy-method:");
        testCity.buy(10);
        test(testCity.getAcres(), 1010);
        test(testCity.getBushels(), 900);

    }

    public static void test(int expected, int actual){
        if(expected == actual){
            System.out.format("✅ PASSED: Expected: %s ... Actual: %s\n", expected, actual);
        }
    }
}
