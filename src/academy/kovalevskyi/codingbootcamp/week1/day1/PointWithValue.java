package academy.kovalevskyi.codingbootcamp.week1.day1;

import academy.kovalevskyi.codingbootcamp.week1.day0.Point;
import java.util.function.Function;

public class PointWithValue<T> extends Point {

    private final T coordinateT;

    public PointWithValue(int coordinateX, int coordinateY, T value) {
        super(coordinateX, coordinateY);
        this.coordinateT = value;
    }

    public T getValue() {
        return coordinateT;
    }

    public <R> PointWithValue<R> mapPoint(Function<T, R> mapFunction) {
        return new PointWithValue<>(this.getX(), this.getY(), mapFunction.apply(getValue()));
    }

    @Override
    public String toString() {
        return "PointWithValue{X: " + this.getX() + ", Y: " + this.getY() + ", value: " + getValue() + "}";
    }
}
