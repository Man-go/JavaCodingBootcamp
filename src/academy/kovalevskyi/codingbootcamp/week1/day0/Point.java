package academy.kovalevskyi.codingbootcamp.week1.day0;

public class Point implements Comparable<Point> {

    private final int coordinateX;
    private final int coordinateY;

    public Point(final int coordinateX, final int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public Point sum(final Point that) {
        return new Point(coordinateX + that.getX(), coordinateY + that.getY());
    }

    public Point updateX(int newX) {
        return new Point(newX, this.getY());
    }

    public Point updateY(int newY) {
        return new Point(this.getX(), newY);
    }

    public int distanceTo(Point that) {
        return (this.coordinateX - that.coordinateX) * (this.coordinateX - that.coordinateX)
                + (this.coordinateY - that.coordinateY) * (this.coordinateY - that.coordinateY);
    }

    public int getX() {
        return coordinateX;
    }

    public int getY() {
        return coordinateY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return coordinateX == point.coordinateX && coordinateY == point.coordinateY;
    }

    @Override
    public int hashCode() {
        return this.coordinateX + this.coordinateY;
    }

    @Override
    public String toString() {
        return "Point{" + "X:" + coordinateX + ", Y:" + coordinateY + '}';
    }

    @Override
    public int compareTo(Point that) {
        return (this.coordinateX + this.coordinateY - that.coordinateX + that.coordinateY);
    }
}

