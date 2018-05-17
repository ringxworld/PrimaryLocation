
public class GeoLocation {

    private float latitude;
    private float longitude;
    private float altitude;

    public GeoLocation(float x, float y, float z) {
        this.latitude = x;
        this.longitude = y;
        this.altitude = z;
    }

    public GeoLocation(float x, float y) {
        this.latitude = x;
        this.longitude = y;
        this.altitude = 0;
    }

    public GeoLocation() {
        this.latitude = 0;
        this.longitude = 0;
        this.altitude = 0;
    }

    public float getLatitude() {
        return this.latitude;

    }

    public float getLongitude() {
        return this.longitude;

    }

    public float getAltitude() {
        return this.altitude;

    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public GeoLocation get() {
        return this;
    }

    public void set(float i, float j, float k) {
        this.latitude = i;
        this.longitude = j;
        this.altitude = k;

    }

    public GeoLocation subFrom(GeoLocation other) {
        this.latitude -= other.getLatitude();
        this.longitude -= other.getLongitude();
        this.altitude -= other.getAltitude();
        return this;
    }

    public GeoLocation sub(GeoLocation other) {
        return new GeoLocation(this.latitude - other.getLatitude(), this.longitude - other.getLongitude(), this.altitude - other.getAltitude());
    }

    public GeoLocation add(GeoLocation other) {
        this.latitude += other.getLatitude();
        this.longitude += other.getLongitude();
        this.altitude += other.getAltitude();
        return this;
    }

    public double dot(GeoLocation other) {
        return (this.latitude * other.getLatitude()) + (this.longitude * other.getLongitude()) + (this.altitude * other.getAltitude());
    }

    public GeoLocation mul(double other) {
        this.latitude *= other;
        this.longitude *= other;
        this.altitude *= other;
        return this;
    }

    @Override
    public int hashCode() {
        return (int) (latitude * longitude);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeoLocation location = (GeoLocation) o;
        return (this.almostEqual(location.longitude, this.longitude) && this.almostEqual(location.latitude, this.latitude));
    }

    private boolean almostEqual(float a, float b) {
        final double EPSILON = 0.001;
        return Math.abs(a - b) < EPSILON;
    }

    @Override
    public String toString() {
        return "[" + this.latitude + "," + this.longitude + "," + this.altitude + "]";
    }

}