import java.util.Date;

public class Main {

    public static void main(String[] args) {

        //Object that handles parsing the data
        VisitManager vm = new VisitManager();

        //represents the data input, could be streamed or read from file. Just hard coded array for now
        Visit[] temp = {
                new Visit(new GeoLocation(0, 0), "2000/01/02 01:01:01", "2000/01/02 02:01:01")
                , new Visit(new GeoLocation(0.00001f, 0.00001f), "2000/01/03 01:01:01", "2000/01/03 03:01:01")
                , new Visit(new GeoLocation(0.0001f, 0.0001f), "2000/01/04 01:01:01", "2000/01/04 04:01:01")
                , new Visit(new GeoLocation(1, 1), "1999/12/31 01:01:01", "2000/01/01 02:01:01")
                , new Visit(new GeoLocation(1.00001f, 1.00001f), "2000/01/01 21:01:01", "2000/01/02 03:01:01")
                , new Visit(new GeoLocation(1.0001f, 1.0001f), "2000/01/03 21:01:01", "2000/01/04 07:01:01")};

        //consumes values of temp and places them in a hashmap
        vm.findHome(temp);

        //result gives obj containing lat/long
        GeoLocation g = vm.getMostVisitedRegion();
        System.out.println("Lat:" + g.getLatitude() + ",Long:" + g.getLongitude());
    }

}
