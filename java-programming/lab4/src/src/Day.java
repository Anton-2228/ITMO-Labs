package src;

import src.En.TimeOfDay;
import src.Inter.ChangeDayCondition;

public class Day implements ChangeDayCondition<TimeOfDay> {

    private TimeOfDay currentTime;

    public Day(TimeOfDay a) {
        this.currentTime = a;
    }

    public TimeOfDay getCurrentTime() {
        return this.currentTime;
    }

    @Override
    public int hashCode() {
        return this.currentTime.ordinal();
    }

    @Override
    public String toString() {
        return this.currentTime.name();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (obj.getClass() != this.getClass()) {
            return false;
        } else {
            Day d = (Day) obj;
            return this.currentTime == d.getCurrentTime();
        }
    }

    @Override
    public void change(TimeOfDay a) {
        this.currentTime = a;
        System.out.println("Наступил " + a);
    }
}
