package ch12.exceptions.exercise;

/**
 * exceptions/Ex22.java
 * <p>
 * ****************** Exercise 22 ******************
 * Create a class called FailingConstructor with a
 * constructor that might fail partway through the
 * construction process and throw an exception. In
 * main(). write code that properly guards against
 * this failure.
 * ************************************************
 *
 * @author coofive
 */
public class Ex22 {
    public static void main(String[] args) {
        for (boolean b = false; ; b = !b) {
            try {
                System.out.println("Constructing...");
                FailingConstructor fc = new FailingConstructor(b);
                try {
                    System.out.println("Processing...");
                } finally {
                    System.out.println("Cleanup...");
                }
            } catch (ConstructionException e) {
                System.out.println("Construction has failed: " + e);
                break;
            }
        }
    }
}

class ConstructionException extends Exception {
}

class FailingConstructor {
    FailingConstructor(boolean fail) throws ConstructionException {
        if (fail) {
            throw new ConstructionException();
        }
    }
}

/* Output:
Constructing...
Processing...
Cleanup... Constructing... Construction has failed: exceptions.ConstructionException
*///:~