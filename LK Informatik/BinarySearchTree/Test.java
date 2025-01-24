public class Test {
    public static void main(String[] args) {
        Tree tree = new Tree(500);



        for(int i = 200; i > 0; i--){
            tree.insert((int)(Math.random()*10000));
        }

        tree.balance();
        tree.print();


    }
}
