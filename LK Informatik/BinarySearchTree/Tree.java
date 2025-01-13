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
            while(inserting){
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

    
    public void clear(){
        this.root = null;
    }

    public Node getRoot(){
        return this.root;
    }

    public int countNodes(){
        if(root == null){
            return 0;
        }else{
            int i = 0;
            return root.countFromNode(i);
        }
    }

    public boolean search(int i){
        return getRoot().searchFromNode(i);
    }

    public int getMin(){
        return root.getMinFromNode();
    }
    public int getMax(){
        return root.getMaxFromNode();
    }

    public int countNodesWithValue(int value){
        int i = 0;
        return root.countNodesWithValueFromNode(value, i);
    }

    public int depth(){
        return root.depthFromNode(0, 0);
    }


    public void print(){
        PrintArray tdArr = new PrintArray();
        tdArr.doubleSize();
        tdArr.extendDashes();
        tdArr.print();
    }

    /*public void print(String direction){
        PrintArray tdArr = new PrintArray();
        if(direction == "ltr" || direction == "left to right"){
            tdArr.doubleSize();
            tdArr.extendDashes();
            tdArr.print();
        }else if(direction == "ttb" || direction == "top to bottom"){
            tdArr.rotate();
            tdArr.doubleSize();
        }else{
            System.out.println("Invalid direction! Valid directions are 'ttb'/'top to bottom' and 'ltr'/left to right'!");
        }
    }*/


    private void deleteMin() {
        if (root == null) return;
        root = root.deleteMinNode(root);
    }

    private void deleteMax() {
        if (root == null) return;
        root = root.deleteMaxNode(root);
    }


    private class PrintArray {
        char[][] tdArr;
        public PrintArray(){
            char[][] arr = new char[Tree.this.countNodes()][Tree.this.depth() + 1];
            tdArr = root.twoDArrayFromNode(arr, 0, Tree.this.root.getRightNode().countFromNode(0));
            tdArr = root.addDashes(tdArr, 0, Tree.this.root.getRightNode().countFromNode(0));
        }

        public String basicRowToString(char[] row){
            String str = "";
            for (char i : row){
                str = str + (int)i + "  ";
            }
            return  str;
        }


        public String rowToString(char[] row){
            String str = "";
            for (char i : row) {

                String emptySpace = "";
                for(int j = 5 - String.valueOf((int)i).length(); j > 0; j--){
                    emptySpace = emptySpace + " ";
                }

                //library: ⎨ ┐ ┘ — │
                if((int)i == 0){
                    str = str + "     ";
                }else if(i == '-'){
                    str = str + "—————";
                }else if(i == '+') {
                    str = str + "————⎨";
                }else if(i == '┐') {
                    str = str + "————┐";
                }else if(i == '┘') {
                    str = str + "————┘";
                }else if(i == '|') {
                    str = str + "    │";
                }else{
                    str = str  + emptySpace + ANSI_YELLOW + (int)i + ANSI_RESET;
                }
            }
            return str;
        }


        public void print(){
            for (char[] row : tdArr) {
                System.out.println(rowToString(row));
            }
        }


        public void rotate(){
            char[][] newTdArr = new char[tdArr[0].length][tdArr.length];

            for (int r = 0; r < tdArr.length; r++) {
                for (int c = 0; c < tdArr[0].length; c++) {
                    newTdArr[c][tdArr.length-1-r] = tdArr[r][c];
                }
            }
            tdArr = newTdArr;
        }

        public void doubleSize(){
            char[][] newTdArr = new char[tdArr.length * 2][tdArr[0].length * 2];

            for (int r = 0; r < tdArr.length; r++) {
                for (int c = 0; c < tdArr[0].length; c++) {
                    newTdArr[r * 2][c * 2] = tdArr[r][c];
                }
            }
            tdArr = newTdArr;
        }

        public void extendDashes(){
            for (int r = 0; r < tdArr.length; r++) {
                for (int c = 0; c < tdArr[0].length; c++) {
                    if(tdArr[r][c] == '+' ||tdArr[r][c] == '┘' || tdArr[r][c] == '┐'){
                        tdArr[r][c-1] = '-';
                        if(tdArr[r-2][c] != (char)0){
                            tdArr[r-1][c] = '|';
                        }
                        if(r+2 < tdArr.length){
                            if(tdArr[r+2][c] != (char)0){
                                tdArr[r+1][c] = '|';
                            }
                        }

                    }else if(tdArr[r][c] == '|'){
                        if(tdArr[r-1][c] == (char)0){
                            tdArr[r-1][c] = '|';
                        }
                        if(tdArr[r+1][c] == (char)0){
                            tdArr[r+1][c] = '|';
                        }
                    }
                }
            }
        }


    }




    public int[] toArray() {
        int[] arr = new int[countNodes()];
        int l = 0, r = arr.length - 1;

        while (root != null) {
            arr[l++] = getMin();
            deleteMin();

            if (root != null) { // Avoid processing after last node
                arr[r--] = getMax();
                deleteMax();
            }
        }

        return arr;
    }



    public void balance() {
        int[] arr = this.toArray();
        if (arr.length == 0) return; //Preven balancing an empty tree
        this.root = Node.balanceFromArray(arr);
    }




}