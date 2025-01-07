public class Tree{
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

    /*public String rowToString(char[] row){
        String str = "";
        for (char i : row) {
            if(i == 0){str = str + "    ";}
            else{str = str + (int)i;}
        }
        return str;
    }

    public void twoDArray(){
        char[][] arr = new char[this.countNodes()][this.depth() + 1];
        int c = 0;
        int r = root.getLeftNode().countFromNode(0);
        arr = root.twoDArrayFromNode(arr, c, r);
        for (char[] row : arr) {
            System.out.println(rowToString(row));
        }
    }*/

    public void print(){
        PrintArray tdArr = new PrintArray();
        tdArr.print();
        tdArr.rotate();
    }

    private class PrintArray {
        char[][] tdArr;
        public PrintArray(){
            char[][] arr = new char[Tree.this.countNodes()][Tree.this.depth() + 1];
            tdArr = root.twoDArrayFromNode(arr, 0, Tree.this.root.getLeftNode().countFromNode(0));
        }

        public String rowToString(char[] row){
            String str = "";
            for (char i : row) {
                if(i == 0){str = str + "    ";}
                else{str = str + (int)i;}
            }
            return str;
        }

        public void print(){
            for (char[] row : tdArr) {
                System.out.println(rowToString(row));
            }
        }

        public void rotate(){
            char[][] newTdArr = new char[Tree.this.depth() + 1][Tree.this.countNodes()];
            int c = 0;
            int r = 0;

            for (char[] row : tdArr) {
                for (char value : row) {
                    newTdArr[r][c] = value;
                    c++;
                }
                r++;
            }

            for (char[] row : tdArr) {
                System.out.println(rowToString(row));
            }

        }

    }

}