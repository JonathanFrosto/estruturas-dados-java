package estruturas;

import java.util.Optional;

public class ArvoreBinaria<T extends Comparable<T>> {

    private static final String SEPARATOR = ", ";
    private NoArvore<T> sourceNo;

    public void add(T value) {
        Optional.ofNullable(value)
                .ifPresent(element -> {
                    NoArvore<T> newNo = new NoArvore<>(element);
                    sourceNo = addInternal(newNo, sourceNo);
                });
    }

    private NoArvore<T> addInternal(NoArvore<T> newNo, NoArvore<T> referenceNo) {
        if (referenceNo == null) {
            return newNo;
        }

        int comparableResult = newNo.compareTo(referenceNo);
        if (comparableResult > 0) {
            referenceNo.setRight(addInternal(newNo, referenceNo.getRight()));
        } else if (comparableResult < 0) {
            referenceNo.setLeft(addInternal(newNo, referenceNo.getLeft()));
        } else {
            throw new IllegalArgumentException("Value already exists in tree");
        }
        return referenceNo;
    }


    public void remove(T value) {
        Optional.ofNullable(value)
                .ifPresent(element -> {
                    NoArvore<T> userInput = new NoArvore<>(element);
                    sourceNo = removeInternal(userInput, sourceNo);
                });
    }

    private NoArvore<T> removeInternal(NoArvore<T> userInput, NoArvore<T> referenceNo) {
        if (referenceNo == null) {
            return null;
        } else {
            int comparableResult = referenceNo.compareTo(userInput);

            if (comparableResult == 0) {
                NoArvore<T> substitute = referenceNo.getLeft();

                if (substitute == null) {
                    return null;
                } else if (substitute.getRight() != null) {
                    NoArvore<T> firstLeft = substitute;
                    NoArvore<T> father = substitute;

                    while (substitute.getRight() != null) {
                        father = substitute;
                        substitute = substitute.getRight();
                    }

                    father.setRight(null);
                    substitute.setLeft(firstLeft);
                }

                substitute.setRight(referenceNo.getRight());
                return substitute;
            } else if (comparableResult > 0) {
                referenceNo.setLeft(removeInternal(userInput, referenceNo.getLeft()));
                return referenceNo;
            } else {
                referenceNo.setRight(removeInternal(userInput, referenceNo.getRight()));
                return referenceNo;
            }
        }
    }

    public String inOrder() {
        if (this.sourceNo == null) {
            return "Empty";
        }
        return inOrderInternal(sourceNo);
    }

    private String inOrderInternal(NoArvore<T> noArvore) {
        String content = noArvore.getValue().toString();

        if (noArvore.getLeft() == null && noArvore.getRight() == null) {
            return content;
        }

        String finalString = content;
        if (noArvore.getLeft() != null) {
            finalString = inOrderInternal(noArvore.getLeft()) + SEPARATOR + finalString;
        }
        if (noArvore.getRight() != null) {
            finalString = finalString + SEPARATOR + inOrderInternal(noArvore.getRight());
        }

        return finalString;
    }

    public boolean contains(T value) {
        if (!Optional.ofNullable(value).isPresent()) {
            return false;
        }

        NoArvore<T> userInput = new NoArvore<>(value);
        return containsInternal(userInput, sourceNo);
    }

    private boolean containsInternal(NoArvore<T> userInput, NoArvore<T> referenceNo) {
        if (referenceNo == null) {
            return false;
        }

        int comparableResult = referenceNo.compareTo(userInput);

        if (comparableResult == 0) {
            return true;
        } else if (comparableResult > 0) {
            return containsInternal(userInput, referenceNo.getLeft());
        } else {
            return containsInternal(userInput, referenceNo.getRight());
        }
    }

}
