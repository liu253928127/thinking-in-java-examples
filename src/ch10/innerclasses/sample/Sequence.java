//: innerclasses/Sequence.java
package ch10.innerclasses.sample;
// Holds a sequence of Objects.

/**
 * @author coofive
 */
public class Sequence {
    public static void main(String[] args) {
        final int size = 10;
        Sequence sequence = new Sequence(size);
        for (int i = 0; i < size; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }

    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }


}

interface Selector {
    /**
     * end
     *
     * @return boolean
     */
    boolean end();

    /**
     * current
     *
     * @return
     */
    Object current();

    /**
     * next
     */
    void next();
}
/* Output:
0 1 2 3 4 5 6 7 8 9
*///:~