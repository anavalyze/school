public class Tree{

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    private Node root;
    private Node current;

    public Tree(){
    }
    public Tree(int value){
        this.root = new Node(value);
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public void insert(int value){
        if(this.root == null){
            this.root = new Node(value);
        }else{
            current = root;
            boolean inserting = true;
            while(inserting){ //traverse the tree until an empty spot is found
                if(value < current.getValue()){
                    if(current.getLeftNode() == null){
                        current.setLeftNode(new Node(value));
                        inserting = false;
                    }else{
                        current = current.getLeftNode();
                    }
                }else{
                    if(current.getRightNode() == null){
                        current.setRightNode(new Node(value));
                        inserting = false;
                    }else{
                        current = current.getRightNode();
                    }
                }
            }
        }
    }



    public int countNodes(){
        if(root == null){
            return 0;
        }else{
            int i = 0;
            return root.countFromNode(i);
        }
    }
    public int countNodesWithValue(int value){
        int i = 0;
        return root.countNodesWithValueFromNode(value, i);
    }

    public boolean search(int i){
        return root.searchFromNode(i);
    }

    public int getMin(){
        return root.getMinFromNode();
    }
    public int getMax(){
        return root.getMaxFromNode();
    }

    public int depth(){
        return root.depthFromNode(0, 0);
    }

    public void clear(){
        this.root = null;
    }
    private void deleteMin() {
        if (root == null) return;
        root = root.deleteMinNode(root);
    }
    private void deleteMax() {
        if (root == null) return;
        root = root.deleteMaxNode(root);
    }
    public void deleteAll(int value){
        root.deleteAllFromNode(value);
        if(root.getValue() == value){
            root = new Node(root.getRightNode().getValue(), null, root);
            root.deleteRightNode();
            balance();
        }
    }
    public void deleteOne(int value){
        Node pointer = new Node(0);
        root.findDeepestFromNode(value, pointer);

        if(pointer.getRightNode() == null && pointer.getLeftNode() == null){ //if the root is the deppest node with the value
            if(root.getValue() == value){
                root = new Node(root.getRightNode().getValue(), null, root);
                root.deleteRightNode();
                balance();
            }
        }else if(pointer.getLeftNode() != null){ //dependent wether the node is the right or left node of the pointer delete that child
            pointer.getLeftNode().deleteLeftNode();
        }else if(pointer.getRightNode() != null){
            pointer.getRightNode().deleteRightNode();
        }
        pointer = null;
    }

    private class PrintArray { //class for printing; creates a two-dimensional array, which gets printed line by line
        Node.ArrayNode[][] tdArr;
        public PrintArray(){

            Node.ArrayNode[][] arr = new Node.ArrayNode[Tree.this.countNodes()][Tree.this.depth() + 1]; //create 2d array
            tdArr = root.twoDArrayFromNode(arr, 0, Tree.this.root.getRightNode().countFromNode(0)); //fill by traversing the tree
            this.fillEmptys(); // fill empty spots, so they can be accessed
            tdArr = root.addDashes(tdArr, 0, Tree.this.root.getRightNode().countFromNode(0)); //add dashes
        }

        public Node.ArrayNode[][] fillEmptys(){ //fill empty spots
            for (int r = 0; r < tdArr.length; r++) {
                for (int c = 0; c < tdArr[0].length ; c++) {
                    if(tdArr[r][c] == null){
                        tdArr[r][c] = new Node(0).new ArrayNode(' ');
                    }
                }
            }
            return tdArr;
        }

        public String rowToString(Node.ArrayNode[] row){ //convert numbers and symbols to strings
            String str = "";
            for (Node.ArrayNode i : row) {

                String emptySpace = "";
                for(int j = 5 - String.valueOf(i.getValue()).length(); j > 0; j--){
                    emptySpace = emptySpace + " ";
                }

                //library: ⎨ ┐ ┘ — │
                if(i.getValue() == 0){ //if there isn't a number check for symbols
                    if(i.getDash() == ' '){
                        str = str + "     ";
                    }else if(i.getDash() == '-'){
                        str = str + "—————";
                    }else if(i.getDash() == '+'){
                        str = str + "————⎨";
                    }else if(i.getDash() == '┐'){
                        str = str + "————┐";
                    }else if(i.getDash() == '┘'){
                        str = str + "————┘";
                    }else if(i.getDash() == '|'){
                        str = str + "    │";
                    }
                }else{ //if there is a number print it
                    str = str  + emptySpace + ANSI_YELLOW + i.getValue() + ANSI_RESET;
                }
            }
            return str;
        }

        public void print(){ //loop through the arrays and print them line by line
            for (Node.ArrayNode[] row : tdArr) {
                System.out.println(rowToString(row));
            }
        }

        public void doubleSize(){ //double the size by inserting rows and columns
            Node.ArrayNode[][] newTdArr = new Node.ArrayNode[tdArr.length * 2][tdArr[0].length * 2];

            for (int r = 0; r < tdArr.length; r++) {
                for (int c = 0; c < tdArr[0].length; c++) {
                    newTdArr[r * 2][c * 2] = tdArr[r][c];
                }
            }
            tdArr = newTdArr;
            this.fillEmptys(); //fill the empgy spots again with empty ArrayNode objects
        }

        public void extendDashes(){ //fill the empgy spots with symbols in the in size increased array
            for (int r = 0; r < tdArr.length; r++) { //traverse the 2d-array
                for (int c = 0; c < tdArr[0].length; c++) {


                    if(tdArr[r][c].getDash() == '+' ||tdArr[r][c].getDash() == '┘' || tdArr[r][c].getDash() == '┐'){
                        tdArr[r][c-1].setDash('-'); //"-" between "-" and other symbols
                        if(r-2 > -1 && tdArr[r-2][c].getValue() != 0){ //extends "|"
                            tdArr[r-1][c].setDash('|');
                        }
                        if(r+2 < tdArr.length){
                            if(tdArr[r+2][c].getValue() != 0){
                                tdArr[r+1][c].setDash('|'); //--||--
                            }
                        }

                    }else if(tdArr[r][c].getDash() == '|'){ //--||--
                        if(tdArr[r-1][c].getValue() == 0 && tdArr[r-1][c].getDash() == ' '){
                            tdArr[r-1][c].setDash('|');
                        }
                        if(tdArr[r+1][c].getValue() == 0 && tdArr[r+1][c].getDash() == ' '){
                            tdArr[r+1][c].setDash('|');
                        }
                    }
                }
            }
        }

    }
    public void print(){
        PrintArray tdArr = new PrintArray();
        tdArr.doubleSize();
        tdArr.extendDashes();
        tdArr.print();
    }

    public int[] toArray(){
        int[] arr = new int[countNodes()]; //create array with number of nodes
        int l = 0, r = arr.length - 1; //left pointer and right pointer

        while (root != null){ //add smallest value at the position of the left pointer and delete
            arr[l++] = getMin();
            deleteMin();

            if (root != null){ //avoid processing after last node; vice versa
                arr[r--] = getMax();
                deleteMax();
            }
        }

        return arr;
    }

    public void balance() {
        int[] arr = this.toArray();
        if (arr.length == 0) return; //Prevent balancing an empty tree
        this.root = Node.balanceFromArray(arr);
    }


}