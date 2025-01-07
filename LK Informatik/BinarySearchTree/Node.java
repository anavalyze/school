public class Node {
    private Node leftNode;
    private Node rightNode;
    private final int value;

    public Node(int value){
        this.value = value;
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
    
    
    public boolean searchFromNode(int i){
        if (value == i){return true;}
        else{
            return (leftNode != null && leftNode.searchFromNode(i)) || ((rightNode != null && rightNode.searchFromNode(i)));
        }
    }

    public int countFromNode(int i){
        i++;
        if(leftNode != null){i = leftNode.countFromNode(i);}
        if(rightNode != null){i = rightNode.countFromNode(i);}
        return i;
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



    public char[][] twoDArrayFromNode(char[][] arr, int c, int r){
        int r2 = r;
        arr[r][c] = (char)value;
        c++;
        if(leftNode != null){
            r--;
            if(leftNode.rightNode != null){r = r - leftNode.rightNode.countFromNode(0);}
            arr = leftNode.twoDArrayFromNode(arr, c, r);
        }
        r = r2;
        if(rightNode != null){
            r++;
            if(rightNode.leftNode != null){r = r + rightNode.leftNode.countFromNode(0);}
            arr = rightNode.twoDArrayFromNode(arr, c, r);
        }
        return arr;
    }

    
}
