package trees;

import exceptions.NoSuchElementException;
import exceptions.NullPointerException;
import exceptions.IllegalArgumentException;
import exceptions.SecurityException;

public class ListTree<T> implements MyTree<T> {
    
    private static class Element<Q> {       
        private Q value; 
        private Element<Q> left;
        private Element<Q> right;
        
        public Element(Q value) {
            this.value = value;
        }
        
        public Q getValue() {
            return value;
        }
        
        @SuppressWarnings("unused")
        public boolean equals(Element<Q> el) {
            if (el == null) {
                return false;
            }
            
            if ((el.value == null) && (this.value == null)) {
                return true;
            }
            
            if ((el.value == null) || (this.value == null)) {
                return false;
            }
            
            return (el.value.equals(this.value));
        }
    }
    
    private Element<T> data;    
    private int size;
    
    public ListTree(final T rootElement) {
        data = new Element<T>(rootElement);
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

    public Element<T> getData() {        
        return data;
    }

    @Override
    public void addValue(T newValue, T fatherValue, boolean isAddingAsLeftSon) throws NullPointerException, SecurityException,NoSuchElementException, IllegalArgumentException {
        
        if (null == newValue) {
            throw new NullPointerException();
        }
        
//        if (null != getElementByValue(data, newValue)) {
//            throw new exceptions.SecurityException();
//        }
        
        Element<T> fatherElement = getElementByValue(data, fatherValue);
        if (null == fatherElement) {
            throw new NoSuchElementException();
        }
        
        if (isAddingAsLeftSon) {
            if (null == fatherElement.left) {
                fatherElement.left = new Element<>(newValue);
                size++;
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            if (null == fatherElement.right) {
                fatherElement.right = new Element<>(newValue);
                size++;
            } else {
                throw new IllegalArgumentException();
            }
        }        
    }

    public void removeValue(final T value) throws NullPointerException {
        Element<T> element = getElementByValue(data, value);
        if (value == null || element == null)
          throw new NullPointerException();
        Element<T> father = fatherOfElement(data, new Element<T>(value));
        if (father == null) {
          if (data.left != null) {
            data = element.left;
            leftSonWithoutLeftSon(element.left).left = element.right;
          } else if (data.right != null) {
            data = element.right;
          } else {
            data = null;
          }
        } else {
          if (father.left == element) {
            if (element.left != null) {
              father.left = element.left;
              leftSonWithoutLeftSon(element.left).left = element.right;
            } else if (element.right !=null) {
              father.left = element.right;
            } else {
              father.left = null;
            }
          } else {
            if (element.left != null) {
              father.right = element.left;
              leftSonWithoutLeftSon(element.left).left = element.right;
            } else if (element.right !=null) {
              father.right = element.right;
            } else {
              father.right = null;
            }
          }
        }
        size--;
      }
    private Element<T> leftSonWithoutLeftSon(Element<T> head) {
        while (head.left != null) {
          head = head.left;
        }
        return head;
      }
    
    
   private Element<T> fatherOfElement(final Element<T> head, final Element<T> element) {
    		 if (head == null || head.getValue() == null) {
    		  return null;
    		 }

    		 if (head.left != null && head.left.equals(element)) {
    		  return head;
    		 }
    		 if (head.right != null && head.right.equals(element)) {
    	      return head;
             }

    Element<T> leftSearchResult = fatherOfElement(head.left, element);
    return (null != leftSearchResult ? leftSearchResult : fatherOfElement(head.right, element));
    }
    
    private Element<T> getElementByValue(final Element<T> head, final T value) {
        if (null == head || null == head.getValue()) {
            return null;
        }
        
        if (head.getValue().equals(value)) {
            return head;
        }
        
        Element<T> leftSearchResult = getElementByValue(head.left, value);
        return (null != leftSearchResult ? leftSearchResult : getElementByValue(head.right, value));
    }
    
    @Override
    public String toString() {
        return subtreeToString(data);
    }    
    
    private String subtreeToString(final Element<T> rootElement) {
        if (null == rootElement) {
            return "NULL";
        }
        return String.format("( %s ( %s, %s )", 
                (null == rootElement.getValue()) ? "NULL" : rootElement.getValue().toString(), 
                subtreeToString(rootElement.left), subtreeToString(rootElement.right));
    }

}
