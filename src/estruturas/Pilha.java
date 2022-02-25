package estruturas;

public class Pilha<T> {

    private No<T> no;

    public No<T> top() {
        return this.no;
    }

    public boolean isEmpty() {
        return this.no == null;
    }

    public void push(No<T> no) {
        no.setNextNo(this.no);
        this.no = no;
    }

    public No<T> pop() {
        No<T> currentNo = this.no;

        this.no = currentNo.getNextNo();
        currentNo.setNextNo(null);

        return currentNo;
    }

}
