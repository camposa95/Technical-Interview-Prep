import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Iterators;

public class CollecitonsTest {

    // ---------------------------------------------------------------------------------
    //
    // Iterable related examples
    //
    // ---------------------------------------------------------------------------------

    @Test
    public void testIterable() {
        // Implementing this interface allows an object 
        // to be the target of an enhanced for loop
        // under the hood the enhanched for loop syntax is managed by the JVM.

        // ----------------------------------------------------------------------------
        //
        // Creating and instantiating and Iterable
        //
        // ----------------------------------------------------------------------------

        // Declaring an iterable from something that already implements iterable is easy
        Iterable<String> iterable = new LinkedList<>();

        // Creating a new class that implements iterable
        class MyIterable<T> implements Iterable<T> {

            @Override
            public Iterator<T> iterator() {
                // Normally we would define the Iterator here but
                // that is outside of the scope of this example
                throw new UnsupportedOperationException("Unimplemented method 'iterator'");
            }

            // other methods related to the class
        }

        // ----------------------------------------------------------------------------
        //
        // Iterable methods usable examples
        //
        // ----------------------------------------------------------------------------

        Consumer<String> consumer = (value) -> {System.out.println(value);}; // sample action, more on this below
        iterable.forEach(consumer); // performs the given action on each object of the iterable


        Iterator<String> iterator = iterable.iterator(); // returns a new iterator over the elements
        Spliterator<String> spliterator = iterable.spliterator(); // returns a new spliterator over the elements
    }

    @Test
    public void testConsumer() {
        // this functional interface defines a method that takes one argument and returns nothing
        // also provides default behavior for chaining using the "andThen" default method.
        // it essentially allows you to declare a function as an object that can be passed around as an object.
        // the consumer is one of many functional interfaces

        // -------------------------------------------------------------
        //
        // different ways to create a Consumer
        //
        // -------------------------------------------------------------
        
        // lambda expression
        Consumer<String> labdaConsumer = (inputString) -> {
            System.out.println(inputString); // do something
        };

        // use an existing method with the same signature as the consumer/
        // Note: "this" could be anything we wanted it to be
        Consumer<String> referenceConsumer = this::printValue;

        // or create an instance of Consumer using an anomynous class
        Consumer<String> instanceConsumer = new Consumer<String>() { // Note Consumer can't be directly instantiated

            @Override
            public void accept(String inputString) {
                printValue(inputString); 
            }
            
        };

        // -------------------------------------------------------------
        //
        // Method examples
        //
        // -------------------------------------------------------------
        
        // excecuting the consumer
        labdaConsumer.accept("sampleInputString");

        // chaining consumers
        Consumer<String> chainedConsumer = labdaConsumer.andThen(referenceConsumer).andThen(instanceConsumer);
    }

    public void printValue(String inputString) {
        System.out.println(inputString);
    }

    @Test
    public void testIterator() {
        // An iterator is an interface that allows you to iterate over
        // a collection of objects in a way that does not expose the internal
        // representation of the datastructure. It also supports concurrent modification
        // with remove unlike a for loop does

        // ----------------------------------------------------------------------------
        //
        // Creating and instantiating and Iterator
        //
        // ----------------------------------------------------------------------------

        // getting the iterator of somthing that implements iterable
        Iterator<String> iterator = new LinkedList<String>().iterator();

        // implementing an iterator is the same as implementing an other interface
        // Note: normally an iterator would be defnined as an inner class of some datastructure
        class MyIterator<T> implements Iterator<T> {

            @Override
            public boolean hasNext() {
                // Implementation of hasNext() would go here
                throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
            }

            @Override
            public T next() {
                // Implementation of next() would go here
                throw new UnsupportedOperationException("Unimplemented method 'next'");
            }
            
            // other optional methods like remove() and forEachRemaining() could go here
            // as well as other methods not required by the Iterator interface
        }

        // ----------------------------------------------------------------------------
        //
        // Iterator Methods
        //
        // ----------------------------------------------------------------------------

        Boolean hasNext = iterator.hasNext(); // returns whether the iterator has another item
        String nextString = iterator.next(); // returns the next item. Warning: will throw runtime exception if the 
                                            // iterator has not items left

        iterator.remove();  // removes the last element returned by the iterator
                            // will throw some runtime exceptions if it is not used correctly

        iterator.forEachRemaining((inputString)-> { // Does specified action for each remaining item
            System.out.println(inputString); // Define the Consumer
        });
    }

    // ---------------------------------------------------------------------------------
    //
    // Collection related examples
    //
    // ---------------------------------------------------------------------------------

    @Test
    public void testCollection() {
        // This is one of the base interfaces for the Java collecitons framework.
        // This implements the Iterable interface

        Collection<String> collection = new LinkedList<>();
        Collection<String> secondCollection = new LinkedList<>();

        // Collecton basic methods
        int size = collection.size();
        boolean isEmpty = collection.isEmpty();
        boolean contains = collection.contains("Example String Object");

        // Modification methods
        boolean added = collection.add("Example String to Add");
        boolean removed = collection.remove("Example String to Remove");

        // Bulk Operations
        boolean containsAll = collection.containsAll(secondCollection);
        boolean addedAll = collection.addAll(secondCollection);
        boolean removedAll = collection.removeAll(secondCollection);
        boolean retainedAll = collection.retainAll(secondCollection);
        collection.clear();
        

        // Other methods
        collection.toArray(); // Note: there are other toArray via Overloading


        // There also exists a Collections utility class which has static methods
        // for common Collection operations like sorting and copying over elements


    }
}
