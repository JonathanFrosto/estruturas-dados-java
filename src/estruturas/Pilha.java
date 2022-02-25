package estruturas;

public class Pilha<T> {

    private No<T> no;

    public T top() {
        if (!isEmpty()) {
            return this.no.getValue();
        }
        return null;
    }

    public boolean isEmpty() {
        return this.no == null;
    }

    public void push(T value) {
        No<T> newNo = new No<>(value);
        newNo.setNextNo(this.no);
        this.no = newNo;
    }

    public T pop() {
        if (!isEmpty()) {
            No<T> currentNo = this.no;

            this.no = currentNo.getNextNo();
            currentNo.setNextNo(null);

            return currentNo.getValue();
        }
        return null;
    }

}
