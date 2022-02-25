package estruturas;

public class Fila<T> {

    private No<T> no;

    public boolean isEmpty() {
        return this.no == null;
    }

    public void enqueue(No<T> no) {
        no.setNextNo(this.no);
        this.no = no;
    }

    public No<T> first() {
        No<T> currentNo = this.no;

        while (currentNo.getNextNo() != null) {
            currentNo = currentNo.getNextNo();
        }

        return currentNo;
    }

    public No<T> dequeue() {
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
            return currentNo;
        }
        return no;
    }
}
