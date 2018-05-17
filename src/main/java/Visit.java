import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Author: shawn
 */
public class Visit {

    private GeoLocation geoLocation;
    private Date arrival_time_local;
    private Date departure_time_local;


    public Visit(GeoLocation geoLocation, String arrival_time_local, String departure_time_local) {
        this.geoLocation = geoLocation;
        try {
            this.arrival_time_local = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(arrival_time_local);
            this.departure_time_local = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(departure_time_local);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    public Date getArrival_time_local() {
        return arrival_time_local;
    }

    public void setArrival_time_local(Date arrival_time_local) {
        this.arrival_time_local = arrival_time_local;
    }

    public Date getDeparture_time_local() {
        return departure_time_local;
    }

    public void setDeparture_time_local(Date departure_time_local) {
        this.departure_time_local = departure_time_local;
    }


}
