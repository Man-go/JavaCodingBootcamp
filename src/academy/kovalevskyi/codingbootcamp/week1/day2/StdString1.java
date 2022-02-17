package academy.kovalevskyi.codingbootcamp.week1.day2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class StdString1 implements Iterable<Character> {

    private final char[] value;

    public StdString1(char[] base) {
        value = new char[base.length];
        System.arraycopy(base, 0, value, 0, base.length);
    }

    public StdString1() {
        this(new char[0]);
    }

    public StdString1(StdString1 stdString1) {
        this(stdString1.value);
    }

    public int length() {
        return value.length;
    }

    public StdString1 append(StdString1 that) {
        if (that == null) {
            throw new NullPointerException();
        }
        char[] concatValue = new char[value.length + that.value.length];
        System.arraycopy(value, 0, concatValue, 0, value.length);
        System.arraycopy(that.value, 0, concatValue, value.length, that.value.length);
        return new StdString1(concatValue);
    }

    public char[] toCharArray() {
        return this.value;
    }

    public char charAt(int index) {
        return this.value[index];
    }

    public int indexOf(char target) {
        for (int i = 0; i < value.length; i++) {
            if (value[i] == target) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean equals(final Object otherObj) {
        if (this == otherObj) {
            return true;
        }
        if (otherObj == null || getClass() != otherObj.getClass()) {
            return false;
        }
        StdString1 that = (StdString1) otherObj;
        if (that.toCharArray().length != this.value.length) {
            return false;
        }
        for (int i = 0; i < that.length(); i++) {
            if (this.value[i] != that.toCharArray()[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return IntStream.range(0, value.length)
                .mapToObj(i -> value[i])
                .mapToInt(value -> (int) value)
                .sum();
    }

    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < value.length;
            }

            @Override
            public Character next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return value[index++];
            }
        };
    }

    @Override
    public void forEach(final Consumer<? super Character> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        for (char c : value) {
            action.accept(c);
        }
    }
}
