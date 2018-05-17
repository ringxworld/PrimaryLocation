import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

/*
Author: Shawn
 */
public class VisitManager {

    HashMap<GeoLocation, Timer> temp = new HashMap<>();


    public void findHome(Visit... visits) {
        for (Visit v : visits) {
            if (this.locationAtNight(v.getArrival_time_local(), v.getDeparture_time_local())) {
                if (temp.containsKey(v.getGeoLocation())) {
                    temp.get(v.getGeoLocation()).setTimeElapsed(v.getDeparture_time_local().getTime() - v.getArrival_time_local().getTime());
                } else {
                    temp.put(v.getGeoLocation(), new Timer());
                    temp.get(v.getGeoLocation()).setTimeElapsed(v.getDeparture_time_local().getTime() - v.getArrival_time_local().getTime());
                }
            }
        }
    }

    public void testHome(Visit... visits) {
        for (Visit v : visits) {
            if (temp.containsKey(v.getGeoLocation())) {
                temp.get(v.getGeoLocation()).setTimeElapsed(v.getDeparture_time_local().getTime() - v.getArrival_time_local().getTime());
            } else {
                temp.put(v.getGeoLocation(), new Timer());
                temp.get(v.getGeoLocation()).setTimeElapsed(v.getDeparture_time_local().getTime() - v.getArrival_time_local().getTime());
            }
        }
    }


    public boolean locationAtNight(Date begin, Date end) {
        LocalTime beginnning = Instant.ofEpochMilli(begin.getTime()).atZone(ZoneId.systemDefault()).toLocalTime();
        LocalTime ending = Instant.ofEpochMilli(end.getTime()).atZone(ZoneId.systemDefault()).toLocalTime();
        LocalTimeRange original = new LocalTimeRange(beginnning, ending);
        LocalTime start = LocalTime.parse("20:00:00");
        LocalTime stop = LocalTime.parse("08:00:00");
        LocalTimeRange test = new LocalTimeRange(start, stop);
        return original.overlaps(test);
        //System.out.println(test.overlaps(original));
    }

    public GeoLocation getMostVisitedRegion() {
        return temp.entrySet().stream().max((entry1, entry2) -> entry1.getValue().getTimeElapsed() > entry2.getValue().getTimeElapsed() ? 1 : -1).get().getKey();
    }

    public long getHighestValue() {
        return temp.entrySet().stream().max((entry1, entry2) -> entry1.getValue().getTimeElapsed() > entry2.getValue().getTimeElapsed() ? 1 : -1).get().getValue().getTimeElapsed();
    }

    public String formatTime(final long time) {
        final int sec = (int) (time / 1000), d = sec / 86400, h = sec / 3600 % 24, m = sec / 60 % 60, s = sec % 60;
        return (d < 10 ? "" + d : d) + "d " + (h < 10 ? "" + h : h) + "h " + (m < 10 ? "" + m : m) + "m " + (s < 10 ? "" + s : s) + "s";
    }

    public Set getKeySet() {
        return temp.keySet();
    }
}
