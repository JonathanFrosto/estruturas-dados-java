package estruturas;

public class ListaCircular<T> {

    private No<T> referenceNo;
    int size = 0;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void add(T value) {
        add(value, this.size);
    }

    public void add(T value, int index) {
        if (index > this.size || index < 0) {
            throwInvalidIndex(index);
        }

        No<T> newNo = new No<>(value);
        if (isEmpty()) {
            this.referenceNo = newNo;
            this.referenceNo.setNextNo(this.referenceNo);
            this.size += 1;
        } else if (index == size) {
            newNo.setNextNo(this.referenceNo);
            this.referenceNo = newNo;
            this.size += 1;
            makeCircular();
        } else {
            No<T> currentNo = getInternal(index);

            newNo.setNextNo(currentNo.getNextNo());
            currentNo.setNextNo(newNo);
            this.size += 1;
        }

    }

    private void throwInvalidIndex(int index) {
        throw new IndexOutOfBoundsException("Index: " + index + ", size: " + this.size);
    }

    private void makeCircular() {
        No<T> firstNo = getInternal(0);
        firstNo.setNextNo(this.referenceNo);
    }

    public T get(int index) {
        return getInternal(index).getValue();
    }

    public No<T> getInternal(int index) {
        if (index >= this.size || index < 0) {
            throwInvalidIndex(index);
        }

        No<T> currentNo = this.referenceNo;
        int lastIndex = getLastIndex();

        if (index == lastIndex) {
            return currentNo;
        } else {
            for (int i = lastIndex; i > index; i--) {
                currentNo = currentNo.getNextNo();
            }
        }
        return currentNo;
    }

    private int getLastIndex() {
        return this.size - 1;
    }

    public void remove(int index) {
        if (index >= this.size || index < 0) {
            throwInvalidIndex(index);
        }

        if (this.size == 1) {
            this.referenceNo = null;
            this.size -= 1;
        } else if (index == getLastIndex()) {
            this.referenceNo = referenceNo.getNextNo();
            this.size -= 1;
            makeCircular();
        } else {
            No<T> previousNo = getInternal(index + 1);
            previousNo.setNextNo(previousNo.getNextNo());
            this.size -= 1;
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Empty";
        }

        StringBuilder sb = new StringBuilder();
        No<T> currentNo = this.referenceNo;
        int counter = getLastIndex();

        do {
            sb.append("Index: ")
                    .append(counter)
                    .append(" = ")
                    .append(currentNo)
                    .append(" -> ")
                    .append(currentNo.getNextNo())
                    .append("\n");
            currentNo = currentNo.getNextNo();
            counter -= 1;
        } while (counter >= 0);

        return sb.toString();
    }
}
