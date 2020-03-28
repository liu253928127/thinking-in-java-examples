//: generics/ExplicitTypeSpecification.java
package ch15.generics;

import ch11.holding.sample.pets.Person;
import ch11.holding.sample.pets.Pet;
import ch15.net.mindview.util.New;

import java.util.List;
import java.util.Map;

/**
 * @author coofive
 */
public class ExplicitTypeSpecification {
    static void f(Map<Person, List<Pet>> petPeople) {
    }

    public static void main(String[] args) {
        f(New.<Person, List<Pet>>map());
    }
} ///:~