package Patterns_Intern;

package Patterns_Intern;

import java.util.*;

public class WillysBooleanDemo {
    public static void main(String[] args) {
        WillysBoolean wb1 = WillysBoolean.valueOf(true);
        WillysBoolean wb2 = WillysBoolean.valueOf(true);
        System.out.println("wb1 == wb2: " + (wb1 == wb2)); // in order to get proper result (true),
        // equals and hashcode should be overridden
    }
}

class WillysBoolean {
    private boolean value;

    private WillysBoolean(boolean value) {
        this.value = value;
    }

    private static Map<WillysBoolean, WillysBoolean> cache =
            new HashMap<WillysBoolean, WillysBoolean>();

    public static WillysBoolean valueOf(boolean value) {
        WillysBoolean tmp = new WillysBoolean(value);
        if (cache.containsKey(tmp))
            return cache.get(tmp);
        else {
            cache.put(tmp, tmp);
            return tmp;
        }
    }

    /* Overridden methods */
    @Override
    public int hashCode() {
        return value ? 1231 : 1237;
    }

    @Override
    public boolean equals(Object bv) {
        if (bv == null) {
            return false;
        }
        if (!(bv instanceof WillysBoolean)) {
            return false;
        }

        return this.hashCode() == bv.hashCode();

    }
}