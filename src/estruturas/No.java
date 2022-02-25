package estruturas;

class No<T> {

    private final T value;
    private No<T> nextNo;

    public No(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public No<T> getNextNo() {
        return nextNo;
    }

    public void setNextNo(No<T> nextNo) {
        this.nextNo = nextNo;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
