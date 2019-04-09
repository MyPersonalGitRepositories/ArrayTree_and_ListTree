package trees;

import exceptions.NoSuchElementException;
import exceptions.NullPointerException;
import exceptions.IllegalArgumentException;
import exceptions.SecurityException;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayTree<T> implements MyTree<T> {

    private Object[] data;
    private int size;

    public ArrayTree(final T rootElement) {
        this(rootElement, 0);
    }

    public ArrayTree(final T rootElement, final int n) {
        if (null == rootElement) {
            try {
                throw new NullPointerException();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }

        data = new Object[(int) Math.pow(2, n + 1) - 1];
        data[0] = rootElement;
        size = 1;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int getSize() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public T[] getData() {
        return (T[])Arrays.copyOf(data, data.length);
    }

    @Override
    public void addValue(final T newValue, final T fatherValue, final boolean isAddingAsLeftSon) throws NullPointerException, SecurityException, NoSuchElementException, IllegalArgumentException {
        if (null == newValue) {
            throw new NullPointerException();
        }

//        if (getIndexOfElement(newValue) != -1) {
//            throw new exceptions.SecurityException();
//        }

        int indexOfFather = getIndexOfElement(fatherValue);
        if (indexOfFather == -1) {
            throw new NoSuchElementException();
        }

        if (2*indexOfFather + 1 >= data.length) {
            Object[] newData = Arrays.copyOf(data, 2*data.length + 1);
            data = newData;
        }

        if (isAddingAsLeftSon) {
            if (null == data[2*indexOfFather + 1]) {
                data[2*indexOfFather + 1] = newValue;
                size++;
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            if (null == data[2*indexOfFather + 2]) {
                data[2*indexOfFather + 2] = newValue;
                size++;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    @SuppressWarnings("unchecked")
    private int getIndexOfElement(final T element) {
        return IntStream.range(0, data.length)
                .filter(i -> ((null != data[i]) && ((T)data[i]).equals(element)))
                .findFirst()
                .orElse(-1);
    }

    @Override
    public String toString() {
        return subtreeToString(0);
    }

    private String subtreeToString(final int rootIndex) {
        if (rootIndex >= data.length) {
            return "_";
        }
        return String.format("( %s ( %s , %s )",
                (null == data[rootIndex]) ? "NULL" : data[rootIndex].toString(),
                subtreeToString(2*rootIndex + 1), subtreeToString(2*rootIndex + 2));
    }



    @SuppressWarnings("unchecked")
    private T[] delete(final T[] array) {
        T[] arr;
        arr = (T[]) new  Object[array.length - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = array[i];
        }
        return arr;
    }

    @SuppressWarnings("unchecked")
    public void removeValue(final T value) throws NullPointerException, NoSuchElementException {
        if(isEmpty() == false || getIndexOfElement(value) == -1) {
            if(value != null) {
                int b = getIndexOfElement(value);
                data[b] = data[b*2+1];
                data[b*2+1] = data[b*2+2];
                int counter = 0;
                while (b*2+2+counter+1 < data.length) {
                    data[b*2+2+counter] = data[b*2+2+counter+1];
                    counter++;
                }
                data = delete((T[]) data);
            } else {
                throw new NullPointerException();
            }
        } else {
            throw new NoSuchElementException();
        }
    }

}

