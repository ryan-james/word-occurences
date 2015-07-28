package bst;

public class SimpleBST {

    Node root;
    Node parent;
    Node floatingParent;

    public void addNode(int value) {

        Node newNode = new Node(value);
        // if no root, set it as the first created newNode
        if(root == null) {
            root = newNode;
            System.out.println("Root: " + root.value);
        }
        else {
            //we want to keep the root the same so create a new floating parent node
            //that will move around the tree until a space is available for a newNode
            floatingParent = root;
            placeNode(newNode);
        }
    }

    public void placeNode(Node newNode) {
        //we need as proper parent node that will act as the parent for each left and
        //right child anywhere in the tree
        parent = floatingParent;
        System.out.println("Parent: " + parent.value);

        //check if the newNode value is less than the current root value (which is assigned to floatingParent)
        if(newNode.value < floatingParent.value) {
            System.out.println("Setting left node...");
            //if less, switch floatingParent to be the leftChild
            floatingParent = floatingParent.leftChild;
            //if there's no node we can put the newNode in that place
            if(floatingParent == null) {
                //we set the leftChild of the parent to equal the newNode
                //we don't set the value of the floatingParent node because this effectively searches around the tree
                parent.leftChild = newNode;
                System.out.println("Parent left child: " + parent.leftChild.value);
            }
            else {
                //if there is no space, we start again, but this time the
                //floatingParent value has shifted down and to the left
                //the proper parent node is now assigned to the new floatingParent node
                placeNode(newNode);
            }
        }
        else {
            //same applies as above, but this checks if the value is higher
            System.out.println("Setting right node...");
            floatingParent = floatingParent.rightChild;
            if(floatingParent == null) {
                parent.rightChild = newNode;
                System.out.println("Parent right child: " + parent.rightChild.value);
            }
            else {
                placeNode(newNode);
            }
        }

    }

}
