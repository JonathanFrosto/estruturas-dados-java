package estruturas;

public class ListaDupla<T> {

    public static final String INDEX = "Index: ";
    NoDuplo<T> firstNo;
    NoDuplo<T> lastNo;
    int size;

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void add(T value) {
        add(value, size);
    }

    public void add(T value, int index) {
        if (index > size || index < 0) {
            throwInvalidIndex(index);
        }

        NoDuplo<T> newNo = new NoDuplo<>(value);

        if (isEmpty()) {
            this.firstNo = newNo;
            this.lastNo = newNo;
        } else {
            if (index == size) {
                newNo.setNextNo(lastNo);
                lastNo.setPreviousNo(newNo);
                this.lastNo = newNo;
            } else {
                NoDuplo<T> currentNo = getInternal(index);
                NoDuplo<T> nextNo = currentNo.getNextNo();
                currentNo.setNextNo(newNo);
                newNo.setPreviousNo(currentNo);
                newNo.setNextNo(nextNo);

                if (index == 0) {
                    this.firstNo = newNo;
                } else {
                    nextNo.setPreviousNo(newNo);
                }
            }
        }
        this.size += 1;
    }

    private void throwInvalidIndex(int index) {
        throw new IndexOutOfBoundsException(INDEX + index + ", size: " + this.size);
    }

    private NoDuplo<T> getInternal(int index) {
        if (index >= size || index < 0) {
            throwInvalidIndex(index);
        }

        int distance = size - index;
        double pontoMedio = (double) distance / 2;

        NoDuplo<T> currentNo;

        if (index <= pontoMedio) {
            currentNo = this.firstNo;

            for (int i = 1; i <= index; i++) {
                currentNo = currentNo.getNextNo();
            }
        } else {
            currentNo = this.lastNo;

            for (int i = size - 2; i >= index; i--) {
                currentNo = currentNo.getNextNo();
            }
        }
        return currentNo;
    }

    public T get(int index) {
        return getInternal(index).getValue();
    }

    public void remove(int index) {
        NoDuplo<T> toBeRemoved = getInternal(index);

        if (this.size == 1) {
            this.firstNo = null;
            this.lastNo = null;
        } else if (isLastIndex(index)) {
            NoDuplo<T> newLastNo = toBeRemoved.getNextNo();
            toBeRemoved.setNextNo(null);
            newLastNo.setPreviousNo(null);
            this.lastNo = newLastNo;
        } else if (index == 0) {
            NoDuplo<T> newFirstNo = toBeRemoved.getPreviousNo();
            toBeRemoved.setPreviousNo(null);
            newFirstNo.setNextNo(null);
            this.firstNo = newFirstNo;
        } else {
            toBeRemoved.getPreviousNo().setNextNo(toBeRemoved.getNextNo());
            toBeRemoved.getNextNo().setPreviousNo(toBeRemoved.getPreviousNo());
            toBeRemoved.setNextNo(null);
            toBeRemoved.setPreviousNo(null);
        }

        this.size -= 1;
    }

    private boolean isLastIndex(int index) {
        return index == this.size - 1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "empty";
        }

        StringBuilder sb = new StringBuilder();

        NoDuplo<T> currentNo = this.firstNo;

        int counter = 0;

        sb.append(INDEX)
                .append(counter)
                .append(" = ")
                .append(currentNo)
                .append("\n");

        while (currentNo.getPreviousNo() != null) {
            counter += 1;
            currentNo = currentNo.getPreviousNo();
            sb.append(INDEX)
                    .append(counter)
                    .append(" = ")
                    .append(currentNo)
                    .append("\n");
        }

        return sb.toString();
    }
}
