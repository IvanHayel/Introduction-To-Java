package classes_and_objects.task_6;

public class Time {
    private byte hours;
    private byte minutes;
    private byte seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = isHours(hours) ? (byte) hours : 0;
        this.minutes = isMinutes(minutes) ? (byte) minutes : 0;
        this.seconds = isSeconds(seconds) ? (byte) seconds : 0;
    }

    public Time(int hours, int minutes) {
        this(hours, minutes, 0);
    }

    public Time(int hours) {
        this(hours, 0, 0);
    }

    public Time() {
        this(0, 0, 0);
    }

    private boolean isHours(int hours) {
        return hours <= 24 && hours >= 0;
    }

    private boolean isMinutes(int hours) {
        return hours <= 60 && hours >= 0;
    }

    private boolean isSeconds(int hours) {
        return hours <= 60 && hours >= 0;
    }

    public void setTime(int hours, int minutes, int seconds) {
        this.hours = isHours(hours) ? (byte) hours : 0;
        this.minutes = isMinutes(minutes) ? (byte) minutes : 0;
        this.seconds = isSeconds(seconds) ? (byte) seconds : 0;
    }

    public void setTime(int hours, int minutes) {
        setTime(hours, minutes, 0);
    }

    public void setTime(int hours) {
        setTime(hours, 0, 0);
    }

    public void setTime() {
        setTime(0, 0, 0);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}