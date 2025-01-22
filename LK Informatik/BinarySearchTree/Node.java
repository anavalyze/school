import java.util.Arrays;
public class Node{
    private Node leftNode;
    private Node rightNode;
    private final int value;

    public Node(int value){
        this.value = value;
    }
    public Node(int value, Node leftNode, Node rightNode){
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    //getter
    public int getValue(){
        return value;
    }
    public Node getLeftNode(){
        return leftNode;
    }
    public Node getRightNode(){
        return rightNode;
    }

    //setter
    public void setLeftNode(Node leftNode){
        this.leftNode = leftNode;
    }
    public void setRightNode(Node rightNode){
        this.rightNode = rightNode;
    }
    
    //searching
    public boolean searchFromNode(int i){
        if (value == i){return true;}
        else{
            return (leftNode != null && leftNode.searchFromNode(i)) || ((rightNode != null && rightNode.searchFromNode(i))); //if the method finds the value on the left or right side it will return true
        }
    }
    public int getMinFromNode(){
        int i = value;
        if(leftNode != null){i = leftNode.getMinFromNode();}
        return i;
    }
    public int getMaxFromNode(){
        int i = value;
        if(rightNode != null){i = rightNode.getMaxFromNode();}
        return i;
    }

    //counting
    public int countFromNode(int i){
        i++;
        if(leftNode != null){i = leftNode.countFromNode(i);}
        if(rightNode != null){i = rightNode.countFromNode(i);}
        return i;
    }
    public int countNodesWithValueFromNode(int value, int i){
        if(this.value == value){i++;}
        if(leftNode != null){i = leftNode.countNodesWithValueFromNode(value, i);}
        if(rightNode != null){i = rightNode.countNodesWithValueFromNode(value, i);}
        return i;
    }
    public int depthFromNode(int i, int j){
        i++;
        if(i>j){j = i;}
        if(leftNode != null){j = leftNode.depthFromNode(i, j);}
        if(rightNode != null){j = rightNode.depthFromNode(i, j);}
        return j;
    }

    //deleting
    public void deleteLeftNode(){
        if(leftNode.leftNode != null && leftNode.rightNode == null){ //if left node has no children
            leftNode = leftNode.leftNode;
        }else if(leftNode.rightNode != null && leftNode.leftNode == null){ //if leftnode has a right child
            leftNode = leftNode.rightNode;
        }else if(leftNode.leftNode == null){ //if leftnode has a left child
            leftNode = null;
        }else{ //if leftnode has both a left and right child
            Node pointer = leftNode.leftNode; //goes to the left once, and then as far as possible to the right, that node will replace the node that is to be deleted whilst still upholding the rules of the BST
            if(pointer.rightNode != null){
                while(pointer.rightNode.rightNode != null){
                    pointer = pointer.rightNode;
                }
                leftNode = new Node(pointer.rightNode.value, leftNode.leftNode, leftNode.rightNode);
                pointer.rightNode = null;
            }else{
                leftNode = new Node(leftNode.rightNode.value, leftNode.leftNode, null);
            }
            pointer = null;
        }
    }
    public void deleteRightNode(){ //mirrored to "deleteLeftNode()"
        if(rightNode.leftNode != null && rightNode.rightNode == null){
            rightNode = rightNode.leftNode;
        }else if(rightNode.rightNode != null && rightNode.leftNode == null){
            rightNode = rightNode.rightNode;
        }else if(rightNode.leftNode == null){
            rightNode = null;
        }else{
            Node pointer = rightNode.rightNode;
            if(pointer.leftNode != null){
                while(pointer.leftNode.leftNode != null){
                    pointer = pointer.leftNode;
                }
                rightNode = new Node(pointer.leftNode.value, rightNode.leftNode, rightNode.rightNode);
                pointer.leftNode = null;
            }else{
                rightNode = new Node(rightNode.leftNode.value, null, rightNode.rightNode);
            }
            pointer = null;
        }
    }
    public Node deleteMinNode(Node node) {
        if (node.leftNode == null) return node.rightNode; //remove current min
        node.leftNode = deleteMinNode(node.leftNode);    //recur left
        return node;
    }
    public Node deleteMaxNode(Node node) {
        if (node.rightNode == null) return node.leftNode; //remove current max
        node.rightNode = deleteMaxNode(node.rightNode);   //recur right
        return node;
    }
    public void deleteAllFromNode(int value){
        while(rightNode != null && rightNode.value == value){ //if right node has the value delete it, then check again until the right node doesn't have that value anymore
            deleteRightNode();
        }
        if (rightNode != null) {rightNode.deleteAllFromNode(value);} //if there still is a right node after deletion(s), recur right
        while (leftNode != null && leftNode.value == value){ //vice versa
            deleteLeftNode();
        }
        if (leftNode != null) {leftNode.deleteAllFromNode(value);}

    }
    public Node findDeepestFromNode(int value, Node pointer){ //helper function for single deletion; returns a pointer, which points to the parent of the deepest Node with a value
        if(leftNode != null){ //pointer always points to the parent of the deepest value, to know if it's the left or right child, pointers pointer to it either left or right
            if(leftNode.value == value){
                pointer.rightNode = null;
                pointer.leftNode = this;
            }
            leftNode.findDeepestFromNode(value, pointer);
        }
        if(rightNode != null){
            if(rightNode.value == value){
                pointer.leftNode = null;
                pointer.rightNode = this;
            }
            pointer = rightNode.findDeepestFromNode(value, pointer);
        }
        return pointer;
    }

    //balancing
    public static Node balanceFromArray(int[] arr){
        if (arr.length == 0) return null; //stop if the Array is empty
        if (arr.length == 1) return new Node(arr[0]); //if the Array is a single Element return it as a Node
        //node form middle of the Array
        int mid = arr.length / 2;
        Node node = new Node(arr[mid]);
        //repeat for left and right side
        node.leftNode = balanceFromArray(Arrays.copyOfRange(arr, 0, mid));
        node.rightNode = balanceFromArray(Arrays.copyOfRange(arr, mid + 1, arr.length));

        return node;
    }


    //printing
    public class ArrayNode{ //array nodes have the attribute dash, which store the dashes used for printing, so if the value is 0 one can look up the dash
        private char dash;
        //getter for outer class
        public int getValue(){
            return value;
        }
        //getter
        public char getDash(){
            return dash;
        }
        public void setDash(char dash){
            this.dash = dash;
        }
        
        public ArrayNode(char dash){
            this.dash = dash;
        }
    }

    public ArrayNode[][] twoDArrayFromNode(ArrayNode[][] arr, int c, int r){ //fill a 2d-array by traversing the tree
        //r holds the row position, c the column position
        int r2 = r;
        arr[r][c] = this.new ArrayNode(' '); //make arraynode objects for nodes
        c++; //so every additional depth is one step to the right
        if(leftNode != null){
            r++; //go down
            if(leftNode.rightNode != null){r = r + leftNode.rightNode.countFromNode(0);} //leave space for nodes in between if there are any
            arr = leftNode.twoDArrayFromNode(arr, c, r); //recursion
        }
        r = r2; //reset r
        if(rightNode != null){ //vice versa
            r--;
            if(rightNode.leftNode != null){r = r - rightNode.leftNode.countFromNode(0);}
            arr = rightNode.twoDArrayFromNode(arr, c, r);
        }
        return arr;
    }
    public ArrayNode[][] addDashes(ArrayNode[][] arr, int c, int r){ //traverses the tree and adds the dashes, positional changes are handles in the same way as in the method above
        int r2 = r;
        c++;
        if(leftNode != null){
            arr[r][c].setDash('┐');
            r++;
            if(leftNode.rightNode != null){
                r = r + leftNode.rightNode.countFromNode(0);
                for(int r3 = r2+1; r3 < r; r3++){ //fill "|" until correct height
                    arr[r3][c].setDash('|');
                }
            }
            arr = leftNode.addDashes(arr, c, r); //recursion
        }
        r = r2;
        if(rightNode != null){ //vice versa
            arr[r][c].setDash('┘');
            r--;
            if(rightNode.leftNode != null){
                r = r - rightNode.leftNode.countFromNode(0);
                for(int r3 = r2-1; r3 > r; r3--){
                    arr[r3][c].setDash('|');
                }
            }
            arr = rightNode.addDashes(arr, c, r);
        }
        if(leftNode != null && rightNode != null){
            arr[r2][c].setDash('+');
        }
        return arr;
    }
}

    
