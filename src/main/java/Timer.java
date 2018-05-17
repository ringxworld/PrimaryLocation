/*
@Author: Shawn
 */
public class Timer {

    private long cachedTime = 0L;

    public void setTimeElapsed(long elapsed) {
        this.cachedTime += elapsed;
    }

    public long getTimeElapsed() {
        return this.cachedTime;
    }

    public String getFormattedTime() {
        return formatTime(this.cachedTime);
    }

    public String formatTime(final long time) {
        final int sec = (int) (time / 1000), d = sec / 86400, h = sec / 3600 % 24, m = sec / 60 % 60, s = sec % 60;
        return (d < 10 ? "" + d : d) + "d " + (h < 10 ? "" + h : h) + "h " + (m < 10 ? "" + m : m) + "m " + (s < 10 ? "" + s : s) + "s";
    }

}