package trees;

import exceptions.NullPointerException;
import exceptions.NoSuchElementException;

public interface MyTree<T> {
    
    boolean isEmpty();
    
    int getSize();
    
    void addValue(T newValue, T fatherValue, boolean isAddingAsLeftSon) throws NullPointerException, NoSuchElementException, IllegalArgumentException, SecurityException, exceptions.SecurityException, exceptions.IllegalArgumentException;


    void removeValue(T value) throws NullPointerException, NoSuchElementException;
}
