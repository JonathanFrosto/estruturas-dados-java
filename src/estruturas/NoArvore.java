package estruturas;

import java.util.Objects;

class NoArvore<T extends Comparable<T>> implements Comparable<NoArvore<T>> {

    private NoArvore<T> left;
    private final T value;
    private NoArvore<T> right;

    public NoArvore(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public NoArvore<T> getLeft() {
        return left;
    }

    public void setLeft(NoArvore<T> left) {
        this.left = left;
    }

    public NoArvore<T> getRight() {
        return right;
    }

    public void setRight(NoArvore<T> right) {
        this.right = right;
    }

    @Override
    public int compareTo(NoArvore<T> o) {
        return this.value.compareTo(o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoArvore<T> noArvore = (NoArvore<T>) o;
        return compareTo(noArvore) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        T previousValue = left != null ? left.getValue() : null;
        T nextValue = right != null ? right.getValue() : null;

        return "NoArvore{" +
                "left=" + previousValue +
                ", value=" + value +
                ", right=" + nextValue +
                '}';
    }
}
