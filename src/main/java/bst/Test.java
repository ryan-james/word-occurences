package bst;


public class Test {

    public static void main (String[] args) {

        int[] nodeVals = {10,5,15,8,23,3};

        SimpleBST node = new SimpleBST();

        for(int i = 0; i < nodeVals.length; i++) {
            System.out.println("Sending new node value: " + nodeVals[i]);
            node.addNode(nodeVals[i]);
        }
    }

}
