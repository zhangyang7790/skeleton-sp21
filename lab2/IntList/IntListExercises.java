package IntList;

public class IntListExercises {

    /**
     * Part A: (Buggy) mutative method that adds a constant C to each
     * element of an IntList
     *
     * @param lst IntList from Lecture
     */
    public static IntList addConstant(IntList lst, int c) {
        // // first check if the list is empty
        // if (lst == null) {
        //     return null;
        // }
        // // Here Create a new IntList with the updated first element
        // IntList result = new IntList(lst.first + c, null);
        // IntList tail = result;

        // // Iterate through the rest of the list and update elements
        // IntList head = lst.rest;
        // while (head != null) {
        //     tail.rest = new IntList(head.first + c , null);
        //     head = head.rest;
        //     tail = tail.rest;
        // }
        // return result;
        IntList tmp = lst;
        while (tmp != null) {
            tmp.first += c;
            tmp = tmp.rest;
        }
        return lst;
    }

    /**
     * Part B: Buggy method that sets node.first to zero if
     * the max value in the list starting at node has the same
     * first and last digit, for every node in L
     *
     * @param L IntList from Lecture
     */
    public static void setToZeroIfMaxFEL(IntList L) {
        IntList p = L;
        while (p != null) {
            if (firstDigitEqualsLastDigit(max(p))) {
                p.first = 0;
            }
            p = p.rest;
        }
    }

    /** Returns the max value in the IntList starting at L. */
    public static int max(IntList L) {
        if ( L == null) {
            return 1;

        }
        int max = L.first;
        // Iterate through the rest of the list and update max
        IntList p = L.rest;
        while (p != null) {
            if (p.first > max) {
                max = p.first;
            }
            p = p.rest;
        }
        return max;
    }

    /** Returns true if the last digit of x is equal to
     *  the first digit of x.
     */
    public static boolean firstDigitEqualsLastDigit(int x) {
        // Convert x to positive to handle negative numbers
        x = Math.abs(x);

        int lastDigit = x % 10;
        while (x >= 10) {
            x = x / 10;
        }
        int firstDigit = x;
        return firstDigit == lastDigit;
    }

    /**
     * Part C: (Buggy) mutative method that squares each prime
     * element of the IntList.
     *
     * @param lst IntList from Lecture
     * @return True if there was an update to the list
     */
    public static boolean squarePrimes(IntList lst) {
        // Base Case: we have reached the end of the list
        if (lst == null) {
            return false;
        }

        boolean currElemIsPrime = Primes.isPrime(lst.first);

        if (currElemIsPrime) {
            lst.first *= lst.first;
        }
        // Recursively process the rest of the list
        boolean restUpdated = squarePrimes(lst.rest);
        // Return true if either the current element was updated 
        // or the rest of the list was updated
        return currElemIsPrime || restUpdated;
    }
}
