public class BST<T extends Comparable<T>>{
    private Node<T> head;
    BST() {
        head = null;
    }
    boolean find(T item) {
        return find(head, item);
    }

    boolean find(Node<T> node, T item) {
        if(node == null) {
            return false;
        }
        if(item.compareTo(node.data) == 0) {
            return true;
        }
        if(item.compareTo(node.data) < 0) {
            return find(node.left, item);
        }else{
            return find(node.right, item);
        }
    }
    public void insert(T data) {
        head = insert(this.head, data);
    }
    private Node<T> insert(Node<T> node, T item) {

        if(node == null) {
            return new Node<T>(item);
        }else if(item.compareTo(node.data) < 0) {
            node.left = insert(node.left, item);
        }else{
            node.right = insert(node.right, item);
        }
        return node;
    }
    public void print() {
        print(this.head);
    }
    private void print(Node<T> node) {
        if(node != null) {
            print(node.left);
            System.out.println(node.data);
            print(node.right);
        }
    }
    void print(Comparable item) {
        Node curr = new Node(item);
        if(curr.data != null) {
            print(curr.left);
            System.out.println(curr.data);
            print(head.right);
        }
    }
    public void delete(T item) {
        // delete and then rebuild
        head = delete(this.head, item);

    }
    private Node<T> delete(Node<T> node, T data) {
        if(node == null) {
            return node;
        }else if(data.compareTo(node.data) < 0) {
            delete(node.left, data);
        }else if(data.compareTo(node.data) > 0) {
            delete(node.right, data);
        }else{
            if(head.left == null && node.right == null) {
                head = null;
            }else if(head.left == null) {
                head = head.right;
            }else if(head.right == null) {
                head = head.left;
            }else{
                Node<T> tempMin = findSmallest(head);
                head = tempMin;
                head = delete(head.right, data);
            }
        }
        return head;
    }
    public Node<T> findSmallest(Node<T> node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
}
