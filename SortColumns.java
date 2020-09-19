import java.util.ArrayList;
import java.util.List;

class SortColumns {

    // returns false if string array is empty
    // returns false if any of the string elements are different in length
    public boolean elementCheck(String[] A){

        if(A.length == 0){
            System.out.println("Array is empty!");
            return false;
        }

        int elmLength = A[0].length();

        for (String s : A) {
            if(s.length() != elmLength){
                System.out.println("Array elements are different in length!");
                return false;
            }
        }
        return true;
    }

    /* returns a list of deleted indices
     *  - the `deletedIndices` will be "empty" if all columns are sorted
     *  - the `deletedIndices` will contain the single element -1 if,
     *      - the length of elements differ
     *      - the input array i.e. `A` is empty
     */
    public List<Integer> minDeletionSize(String[] A) {

        List<Integer> deletionIndices = new ArrayList<>();

        if(!elementCheck(A)){
            deletionIndices.add(-1);
            return deletionIndices;
        }

        // decend traversal column by column
        //
        // use the first element in A to determine the column length,
        // since all elements have the same length
        for(int c = 0; c < A[0].length(); c++){

            // the number rows is equal to the number of elements in the array
            for(int r = 0; r < A.length-1; r++){

                if( A[r].charAt(c) > A[r+1].charAt(c) ){
                    deletionIndices.add(c);

                    // this algorithm is greedy because it immediately moves to the next choice without considering other elements after this evaluation
                    break;
                }
            }
        }
        System.out.println("size = " + deletionIndices.size());
        return deletionIndices;
    }

    // prints the elements in `l`
    // O(N) where N is the size of `l`
    public void printResults(List<Integer> l){
        System.out.print("{ ");

        for(int i = 0; i < l.size(); i++) {

            if( i == l.size() - 1){
                System.out.print(l.get(i));
            }else{
                System.out.print(l.get(i) + ", ");
            }

        }
        System.out.print(" }\n");
    }

    public static void main(String[] args) {

        String[] t1 = {"cba","daf","ghi"}; // {1} && size = 1
        String[] t2 = {"a", "b"}; // {} && size = 0
        String[] t3 = {"zyx","wvu","tsr"}; // {0, 1, 2} && size = 3

        String[] t4 = {"cbax","daf","ghi"}; // {-1}
        String[] t5 = {}; // {-1}
        String[] t6 = {"The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"}; // {-1}

        String[] t7 = {"abcdef","uvwxyz"}; // {} && size = 0
        String[] t8 = {"j"}; // {} && size = 0

        SortColumns s = new SortColumns();

        s.printResults(s.minDeletionSize(t1));
        s.printResults(s.minDeletionSize(t2));
        s.printResults(s.minDeletionSize(t3));
        s.printResults(s.minDeletionSize(t4));
        s.printResults(s.minDeletionSize(t5));
        s.printResults(s.minDeletionSize(t6));
        s.printResults(s.minDeletionSize(t7));
        s.printResults(s.minDeletionSize(t8));
    }
}