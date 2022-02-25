package estruturas;

public class Fila<T> {

    private No<T> no;

    public boolean isEmpty() {
        return this.no == null;
    }

    public void enqueue(T value) {
        No<T> newNo = new No<>(value);
        newNo.setNextNo(this.no);
        this.no = newNo;
    }

    public T first() {
        if (!isEmpty()) {
            No<T> currentNo = this.no;

            while (currentNo.getNextNo() != null) {
                currentNo = currentNo.getNextNo();
            }

            return currentNo.getValue();
        }
        return null;
    }

    public T dequeue() {
        if (!isEmpty()) {

            No<T> currentNo = this.no;
            No<T> previousNo = null;

            while (currentNo.getNextNo() != null) {
                previousNo = currentNo;
                currentNo = currentNo.getNextNo();
            }

            if (previousNo != null) {
                previousNo.setNextNo(null);
            }

            this.no = previousNo;
            return currentNo.getValue();
        }
        return null;
    }
}
