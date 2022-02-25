package estruturas;

public class No<T> {

    private T value;
    private No<T> nextNo;

    public No(T value) {
        this.value = value;
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
