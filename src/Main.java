import exceptions.IllegalArgumentException;
import exceptions.NoSuchElementException;
import exceptions.NullPointerException;
import exceptions.SecurityException;
import trees.ArrayTree;
import trees.ListTree;

public class Main {

    public static void main(String[] args) {

        System.out.println("ARRAY TREE");
        ArrayTree<Integer> at = new ArrayTree<>(10, 2);

        try {
            at.addValue(5, 10, true);
        } catch (NullPointerException | SecurityException | IllegalArgumentException | NoSuchElementException e) {
            e.printStackTrace();
        }
        try {
            at.addValue(12, 10, false);
        } catch (NullPointerException | SecurityException | IllegalArgumentException | NoSuchElementException e) {
            e.printStackTrace();
        }
        try {
            at.addValue(6, 12, true);
        } catch (NullPointerException | SecurityException | IllegalArgumentException | NoSuchElementException e) {
            e.printStackTrace();
        }
        try {
            at.addValue(7, 5, false);
        } catch (NullPointerException | SecurityException | IllegalArgumentException | NoSuchElementException e) {
            e.printStackTrace();
        }
        System.out.println(at.toString());

        try {
            at.removeValue(12);
        } catch (NullPointerException | NoSuchElementException e) {
            e.printStackTrace();
        }

        try {
            at.removeValue(null);
        } catch (NullPointerException | NoSuchElementException e) {
            e.printStackTrace();
        }

        try {
            at.addValue(10, 12, false);
        } catch (NullPointerException | SecurityException | IllegalArgumentException | NoSuchElementException e) {
            e.printStackTrace();
        }


        System.out.println(at.toString());

        System.out.println("\n\nLINKED TREE");
        ListTree<Integer> lt = new ListTree<>(20);

        try {
            lt.addValue(10, 20, true);
        } catch (NullPointerException | NoSuchElementException | SecurityException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            lt.addValue(24, 20, false);
        } catch (NullPointerException | SecurityException | NoSuchElementException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            lt.addValue(12, 24, true);
        } catch (NullPointerException | NoSuchElementException | SecurityException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            lt.addValue(14, 10, false);
        } catch (NullPointerException | NoSuchElementException | IllegalArgumentException | SecurityException e) {
            e.printStackTrace();
        }
        System.out.println(lt.toString());

        try {
            lt.removeValue(10);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        try {
            lt.addValue(20, 24, false);
        } catch (NullPointerException | IllegalArgumentException | SecurityException | NoSuchElementException e) {
            e.printStackTrace();
        }

        System.out.println(lt.toString());

    }
}
