import java.util.Arrays;

public class List {
    private Node first;
    private Node current;
    private Node last;

    public List() {
        this.first = null;
    }

    public List(Node first) {
        this.first = first;
    }

    public boolean isEmpty() {
        if (this.first == null) {
            return true;
        } else {
            return false;
        }
    }

    // add
    public void addLast(Object content) {
        if (this.isEmpty()) {
            this.first = this.last = new Node(content);
        } else {
            this.last.setNext(this.last = new Node(content));
        }
    }

    public void addFirst(Object content) {
        if (this.isEmpty()) {
            this.first = this.last = new Node(content);
        } else {
            this.current = this.first;
            this.first = new Node(content);
            this.first.setNext(this.current);

        }
    }

    public void addAt(Object content, int position) {
        if (this.length() < position) {
            System.out.println("This position is beyond the array.");
            return;
        }
        if (position == 0) {
            this.first = new Node(content, this.first);
            return;
        }
        this.current = this.first;
        int i = 1;
        while (i < position - 1) {
            i++;
            this.current = this.current.getNext();
        }
        this.current.setNext(new Node(content, this.current.getNext()));
    }

    // delete
    public void deleteLast() {
        if (this.isEmpty()) {
            return;
        } // preventing NullPointerException
        this.current = this.first;
        while (this.current.getNext() != this.last) {
            this.current = this.current.getNext();
        }
        this.current.setNext(null);
    }

    public void deleteFirst() {
        if (this.isEmpty()) {
            return;
        } // preventing NullPointerException
        this.first = this.first.getNext();
    }


    public void deleteAt(int position) {
        if (position < 1 || position > this.length()) {
            System.out.println("This position is beyond the array.");
            return;
        }
    
        if (position == 1) {
            this.first = this.first.getNext();
            if (this.first == null) {
                this.last = null;
            }
            return;
        }
    
        this.current = this.first;
        int i = 1;
        while (i < position - 1) {
            this.current = this.current.getNext();
            i++;
        }
    
        Node nodeToDelete = this.current.getNext();
        if (nodeToDelete != null) {
            this.current.setNext(nodeToDelete.getNext());
            if (nodeToDelete == this.last) {
                this.last = this.current;
            }
        }
    }
    

    public int length() {
        int length = 0;
        for (current = first; current != null; current = current.getNext()) {
            length++;
        }
        return length;
    }

    // get content
    public Object first() {
        return first.getContent();
    }

    public Object last() {
        return last.getContent();
    }

    public Object at(int position) {
        if (this.length() < position) {
            System.out.println("This position is beyond the array.");
            return null;
        }
        this.current = this.first;
        int i = 1;
        while (i < position) {
            i++;
            this.current = this.current.getNext();
        }
        return (this.current.getContent());
    }// (as string)

    public void printAll() {
        int i = 0;
        String[] p = new String[this.length()];
        for (current = first; current != null; current = current.getNext()) {
            p[i] = this.current.getContent().toString();
            i++;
        }
        System.out.println(Arrays.toString(p));
    }

    // get index of content
    public int indexOf(Object content) {
        int i = 1;
        for (current = first; current != null; current = current.getNext()) {
            if (this.current.getContent() == content) {
                return i;
            } else {
                i++;
            }
        }
        return -1;
    }

    // sort -> insertion sort
    public int smallestInt() {
        for (current = first; current != null; current = current.getNext()) {
            if (!(this.current.getContent() instanceof Integer)) {
                System.out.println("This list contains non-integers.");
                return -1;
            }
        }
        int min = (int) first.getContent();
        int indexMin = 1;
        int indexCount = 1;
        for (current = first; current != null; current = current.getNext()) {
            if ((int) this.current.getContent() < min) {
                min = (int) this.current.getContent();
                indexMin = indexCount;
                indexCount++;
            } else {
                indexCount++;
            }
        }
        return indexMin;
    }

    public void sort() {
        for (current = first; current != null; current = current.getNext()) {
            if (!(this.current.getContent() instanceof Integer)) {
                System.out.println("List contains non-integers!");
                return;
            }
        }
        Node newFirst = new Node(this.at(smallestInt()));
        System.out.println(newFirst.getContent());
        this.deleteAt(this.smallestInt());
        Node newCurrent = newFirst;
        while (!this.isEmpty() && this.smallestInt() > 0) {
            newCurrent.setNext(new Node(this.at(smallestInt())));
            this.deleteAt(smallestInt());
            newCurrent = newCurrent.getNext();
        }
        newCurrent.setNext(this.first);
        this.last = newCurrent;
        this.first = newFirst;
        this.current = null;
    }

    public void newSort(){
        Node newFirst = new Node(this.at(smallestInt()), this.first);
        Node border = newFirst;
        int j = this.length();
        deleteAt(smallestInt());
        for(int i = 1; i < j; i++){
            border.setNext(new Node(this.at(smallestInt()), border.getNext()));
            this.deleteAt(this.smallestInt());
            border = border.getNext();
        }
        this.first = newFirst;
        this.last = border;
    }

    



    public boolean isSorted() {
        for (current = first; current != null; current = current.getNext()) {
            if (!(this.current.getContent() instanceof Integer)) {
                System.out.println("List contains non-Integers");
                return false;
            } else if ((int) this.current.getContent() > (int) this.current.getNext().getContent()) {
                System.out.println("List is not sorted.");
                return false;
            }

        }
        System.out.println("List is sorted.");
        return true;
    }

}
