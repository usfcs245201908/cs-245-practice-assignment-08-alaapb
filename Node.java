public class Node<T> {
    public T data;
    public Node<T> left, right;

    Node(Comparable data) {
        this.data = (T) data;
        this.right = null;
        this.left = null;
    }
}
