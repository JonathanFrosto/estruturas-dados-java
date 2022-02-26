package estruturas;

public class Lista<T> {

    No<T> no;
    int size = 0;

    public boolean isEmpty() {
        return no == null;
    }

    public int size() {
        return size;
    }

    public void add(T value) {
        add(value, size);
    }

    public void add(T value, int index) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException(getIndexOutOfBoundExceptionMessage(index));
        }

        No<T> newNo = new No<>(value);

        if (index == this.size) {
            newNo.setNextNo(this.no);
            this.no = newNo;
        } else {
            No<T> currentNo = getInternal(index);

            newNo.setNextNo(currentNo.getNextNo());
            currentNo.setNextNo(newNo);
        }
        this.size += 1;
    }

    private String getIndexOutOfBoundExceptionMessage(int index) {
        return "Index: " + index + ", size: " + this.size + ".";
    }

    private No<T> getInternal(int index) {
        throwNonExistentIndex(index);

        No<T> currentNo = this.no;
        int distance = size - index;

        for (int i = 1; i < distance; i++) {
            currentNo = currentNo.getNextNo();
        }

        return currentNo;
    }

    private void throwNonExistentIndex(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException(getIndexOutOfBoundExceptionMessage(index));
        }
    }

    public T get(int index) {
        return getInternal(index).getValue();
    }

    public void remove(int index) {
        throwNonExistentIndex(index);

        if (index + 1 == size) {
            No<T> currentNo = this.no.getNextNo();
            this.no.setNextNo(null);
            this.no = currentNo;
        } else {
            No<T> currentNo = getInternal(index + 1);
            No<T> toBeRemoved = currentNo.getNextNo();
            currentNo.setNextNo(toBeRemoved.getNextNo());
            toBeRemoved.setNextNo(null);
        }

        size -= 1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "empty";
        }

        StringBuilder sb = new StringBuilder();

        No<T> currentNo = this.no;
        sb.append(currentNo);

        while (currentNo.getNextNo() != null) {
            currentNo = currentNo.getNextNo();
            sb.append(" -> ").append(currentNo);
        }

        return sb.toString();
    }
}
