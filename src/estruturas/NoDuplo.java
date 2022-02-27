package estruturas;

class NoDuplo<T> {

    private NoDuplo<T> previousNo;
    private final T value;
    private NoDuplo<T> nextNo;

    public NoDuplo(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public NoDuplo<T> getPreviousNo() {
        return previousNo;
    }

    public void setPreviousNo(NoDuplo<T> previousNo) {
        this.previousNo = previousNo;
    }

    public NoDuplo<T> getNextNo() {
        return nextNo;
    }

    public void setNextNo(NoDuplo<T> nextNo) {
        this.nextNo = nextNo;
    }

    @Override
    public String toString() {
        T previousValue = previousNo != null ? previousNo.getValue() : null;
        T nextValue = nextNo != null ? nextNo.getValue() : null;

        return "NoDuplo{" +
                "previousNo=" + previousValue +
                ", value=" + value +
                ", nextNo=" + nextValue +
                '}';
    }
}
