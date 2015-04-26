package exercise0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 * <p>
 * Exercise 0: Iterate over the keys of a Map using keySet method (this method returns a Set of all the map keys) and
 * print all its elements.
 */
public class Exercise0 {

    public Exercise0() {

    }

    public void iterateThroughMap() {

        // TODO Exercise #0 a) Create a Map (HashMap) and add elements to it (using put() method)
        // TODO Exercise #0 a) Hint: Don't forget to specify the types of the key and value when creating the Map
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "Unu");
        map.put("2", "Doi");
        map.put("3", "Trei");
        // TODO Exercise #0 b) Iterate over the Map using keySet() method and print all its elements
        // TODO Exercise #0 b) The elements could be printed like this: [key1=value1, key2=value2, ...]
        Iterator<String> mapIterator = map.keySet().iterator();
        String string = "[";

        while (mapIterator.hasNext()) {
            String obj = mapIterator.next();
            string += obj + "=" + map.get(obj);
            if (mapIterator.hasNext()) {
                string += ", ";
            }
        }

        string += "]";
        System.out.println(string);
    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
