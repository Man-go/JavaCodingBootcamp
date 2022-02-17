package academy.kovalevskyi.codingbootcamp.week1.day1;

import academy.kovalevskyi.codingbootcamp.week1.day0.Point;

public class PointWithLabel extends PointWithValue<String> {

    public PointWithLabel(int coordinateX, int coordinateY, String value) {
        super(coordinateX, coordinateY, value);
    }

    public String getLabel() {
        return super.getValue();
    }

    @Override
    public int compareTo(Point that) {
        if (that.getClass() != PointWithLabel.class) {
            return super.compareTo(that);
        }
        PointWithLabel o = (PointWithLabel) that;
        return this.getLabel().compareTo(o.getLabel());
    }
}
