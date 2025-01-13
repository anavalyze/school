import java.util.Arrays;

public class Node {
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
        return this.value;
    }
    public Node getLeftNode(){
        return this.leftNode;
    }
    public Node getRightNode(){
        return this.rightNode;
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
            return (leftNode != null && leftNode.searchFromNode(i)) || ((rightNode != null && rightNode.searchFromNode(i)));
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

    //printing
    public char[][] twoDArrayFromNode(char[][] arr, int c, int r){
        int r2 = r;
        arr[r][c] = (char)value;
        c++;
        if(leftNode != null){
            r++;
            if(leftNode.rightNode != null){r = r + leftNode.rightNode.countFromNode(0);}
            arr = leftNode.twoDArrayFromNode(arr, c, r);
        }
        r = r2;
        if(rightNode != null){
            r--;
            if(rightNode.leftNode != null){r = r - rightNode.leftNode.countFromNode(0);}
            arr = rightNode.twoDArrayFromNode(arr, c, r);
        }
        return arr;
    }
    public char[][] addDashes(char[][] arr, int c, int r){
        int r2 = r;
        c++;
        if(leftNode != null){
            arr[r][c] = '┐';
            r++;
            if(leftNode.rightNode != null){
                r = r + leftNode.rightNode.countFromNode(0);
                for(int r3 = r2+1; r3 < r; r3++){
                    arr[r3][c] = '|';
                }
            }
            arr = leftNode.addDashes(arr, c, r);
        }
        r = r2;
        if(rightNode != null){
            arr[r][c] = '┘';
            r--;
            if(rightNode.leftNode != null){
                r = r - rightNode.leftNode.countFromNode(0);
                for(int r3 = r2-1; r3 > r; r3--){
                   arr[r3][c] = '|';
                }
            }
            arr = rightNode.addDashes(arr, c, r);
        }
        if(leftNode != null && rightNode != null){
            arr[r2][c] = '+';
        }
        return arr;
    }


    //deleting
    public void deleteLeftNode(){
        if(leftNode.leftNode != null && leftNode.rightNode == null){
            leftNode = leftNode.leftNode;
        }else if(leftNode.rightNode != null && leftNode.leftNode == null){
            leftNode = leftNode.rightNode;
        }else if(leftNode.leftNode == null && leftNode.rightNode == null){
            leftNode = null;
        }else{
            Node pointer = leftNode.leftNode;
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
    public void deleteRightNode(){
        if(rightNode.leftNode != null && rightNode.rightNode == null){
            rightNode = rightNode.leftNode;
        }else if(rightNode.rightNode != null && rightNode.leftNode == null){
            rightNode = rightNode.rightNode;
        }else if(rightNode.leftNode == null && rightNode.rightNode == null){
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
        if (node.leftNode == null) return node.rightNode; // Remove current min
        node.leftNode = deleteMinNode(node.leftNode);    // Recur left
        return node;
    }
    public Node deleteMaxNode(Node node) {
        if (node.rightNode == null) return node.leftNode; // Remove current max
        node.rightNode = deleteMaxNode(node.rightNode);   // Recur right
        return node;
    }


    public Node getSmallestParent(){
        Node n = this;
        if(this.leftNode != null && this.leftNode.leftNode != null) {
           n = this.leftNode.getSmallestParent();
        }
       return n;
    }
    public Node getLargestParent(){
        Node n = this;
        if(this.rightNode != null && this.rightNode.rightNode != null) {
            n = this.rightNode.getLargestParent();
        }
        return n;
    }


    /*public class ArrayNode extends Node{
        public char dash;

        public ArrayNode(int value, Node leftNode, Node rightNode){
            super(value, leftNode, rightNode);
        }
        public ArrayNode(int value, char dash, Node leftNode, Node rightNode){
            super(value, leftNode, rightNode);
            this.dash = dash;
        }

        //printing
        public ArrayNode[][] twoDArrayFromNode(ArrayNode[][] arr, int c, int r){
            int r2 = r;
            arr[r][c] = new ArrayNode(value, leftNode, rightNode);
            c++;
            if(leftNode != null){
                r++;
                if(leftNode.rightNode != null){r = r + leftNode.rightNode.countFromNode(0);}
                arr = new ArrayNode(leftNode.value, leftNode.leftNode, leftNode.rightNode).twoDArrayFromNode(arr, r, c);
            }
            r = r2;
            if(rightNode != null){
                r--;
                if(rightNode.leftNode != null){r = r - rightNode.leftNode.countFromNode(0);}
                arr = new ArrayNode(rightNode.value, rightNode.leftNode, rightNode.rightNode).twoDArrayFromNode(arr, r, c);
            }
            return arr;
        }
        public ArrayNode[][] addDashes(ArrayNode[][] arr, int c, int r){
            int r2 = r;
            c++;
            if(leftNode != null){
                arr[r][c].dash = '┐';
                r++;
                if(leftNode.rightNode != null){
                    r = r + leftNode.rightNode.countFromNode(0);
                    for(int r3 = r2+1; r3 < r; r3++){
                        arr[r3][c].dash = '|';
                    }
                }
                arr = new ArrayNode(leftNode.value, leftNode.leftNode, leftNode.rightNode).addDashes(arr, c, r);
            }
            r = r2;
            if(rightNode != null){
                arr[r][c].dash = '┘';
                r--;
                if(rightNode.leftNode != null){
                    r = r - rightNode.leftNode.countFromNode(0);
                    for(int r3 = r2-1; r3 > r; r3--){
                        arr[r3][c].dash = '|';
                    }
                }
                arr = new ArrayNode(rightNode.value, rightNode.leftNode, rightNode.rightNode).addDashes(arr, c, r);
            }
            if(leftNode != null && rightNode != null){
                arr[r2][c].dash = '+';
            }
            return arr;
        }
    }*/


    public static Node balanceFromArray(int[] arr) {
        if (arr.length == 0) return null; //Stop if the Array is empty
        if (arr.length == 1) return new Node(arr[0]); //If the Array is a single Element return it as a Node

        //Node form middle of the Array
        int mid = arr.length / 2;
        Node node = new Node(arr[mid]);

        //Repeat for left and right side
        node.leftNode = balanceFromArray(Arrays.copyOfRange(arr, 0, mid));
        node.rightNode = balanceFromArray(Arrays.copyOfRange(arr, mid + 1, arr.length));

        return node;
    }


}

    
