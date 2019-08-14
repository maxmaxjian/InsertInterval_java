public class Interval {
    int start;
    int end;

    public Interval() {
        this(0,0);
    }

    public Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Interval) {
            Interval that = (Interval)other;
            return start == that.start && end == that.end;
        }
        return false;
    }
}
