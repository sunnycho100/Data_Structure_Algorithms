import java.util.LinkedList;

public class testbench {
    /**
     * Creates a LinkedList based on the array details.
     * @param arr - array that contains the value of the nodes to be created.
     * @return head node, that points the next node.
     */
    public static LinkedList<Integer> makeList(int[] arr) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }
    /**
     * Main method to run the testbench.
     * @param args
     */
    public static void main(String[] args) {
        int[] l1 = {2,4,3};
        int[] l2 = {5,6,4};

        // expected output
        int[] l3 = {7,0,8};

        LinkedList<Integer> list1 = makeList(l1);
        LinkedList<Integer> list2 = makeList(l2);
        LinkedList<Integer> result = makeList(l3);

        System.out.println(list1.toArray());
        System.out.println(list2.toArray());
        System.out.println(result.toArray());


        // AddTwoNumbers add = new AddTwoNumbers();
        // add.addTwoNumbers(l1,l2);
    }
}
