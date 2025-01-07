public class Test {
    public static void main(String[] args) {
        Tree tree = new Tree(5);
        tree.insert(2);
        tree.insert(18);
        tree.insert(3002);
        tree.insert(92);
        tree.insert(93);
        tree.insert(182);
        tree.insert(3002);
        tree.insert(14);
        tree.insert(4);
        tree.insert(1);



        //System.out.println(tree.countNodes());
        //System.out.println(tree.search(3002));
        //System.out.println(tree.getMax());
        tree.print();

        
    }
}
