public class Test {
    public static void main(String[] args) {
        Tree tree = new Tree(200);
        tree.insert(20);
        tree.insert(1000);
        tree.insert(10);
        tree.insert(40);
        tree.insert(5);
        tree.insert(15);
        tree.insert(30);
        tree.insert(50);
        tree.insert(6);
        tree.insert(13);
        tree.insert(17);
        tree.insert(25);
        tree.insert(33);
        tree.insert(42);
        tree.insert(55);
        tree.insert(1500);
        tree.insert(1050);
        tree.insert(2000);

        tree.print();
        tree.balance();
        tree.print();

        
    }
}
