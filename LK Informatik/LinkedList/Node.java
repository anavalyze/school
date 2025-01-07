public class Node{
    private Object content;
    private Node next;

    public Node(){
    }

    public Node(Object content){
        this.content = content;
    }

    public Node(Object content, Node next){
        this.content = content;
        this.next = next;
    }

    public void setContent(Object content){
        this.content = content;
    }
    public void setNext(Node next){
        this.next = next;
    }

    public Object getContent(){
        return this.content;
    }
    public Node getNext(){
        return this.next;
    }

}