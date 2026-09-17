public class SinglyListClass {

    private Node head;

    private static class Node {
        Integer element;
        Node next;

        Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    public int size() {
        return size(head);
    }

    private int size(Node n) {
        if (n == null) {
            return 0;
        }
        return 1 + size(n.next);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Integer first() {
        if (isEmpty()) {
            return null;
        }
        return head.element;
    }

    public Integer last() {
        return last(head);
    }

    private Integer last(Node n) {
        if (n == null) {
            return null;
        }
        if (n.next == null) {
            return n.element;
        }
        return last(n.next);
    }

    public void addFirst(Integer e) {
        head = new Node(e, head);
    }

    public void addLast(Integer e) {
        head = addLast(head, e);
    }

    private Node addLast(Node node, Integer element) {
        if (node == null) {
            return new Node(element, null);
        }
        node.next = addLast(node.next, element);
        return node;
    }

    public Integer penultimate() {
        return penultimate(head);
    }

    private Integer penultimate(Node node) {
        if (node == null || node.next == null) {
            return null;
        }
        if (node.next.next == null) {
            return node.element;
        }
        return penultimate(node.next);
    }

    private void swap(Node x, Node y) {
        if (x == y) return;

        Node prevX = null, prevY = null, cur;

        //On récupère les noeuds précédents x et y

        if (head != x) {
            cur = head;
            while (cur.next != x) cur = cur.next;
            prevX = cur;
        }
        if (head != y) {
            cur = head;
            while (cur.next != y) cur = cur.next;
            prevY = cur;
        }

        //Si x et y sont adjacent avec x -> y

        if (prevY == x) {
            if (prevX != null) prevX.next = y; else head = y;
            x.next = y.next;
            y.next = x;
        //Si x et y sont adjacent avec y -> x
        } else if (prevX == y) {
            if (prevY != null) prevY.next = x; else head = x;
            y.next = x.next;
            x.next = y;
        } else {
            if (prevX != null) prevX.next = y; else head = y;
            if (prevY != null) prevY.next = x; else head = x;
            Node temp = x.next;
            x.next = y.next;
            y.next = temp;
        }
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node node = head;
        while (node != null) {
            sb.append(node.element);
            if (node.next != null) sb.append(" -> ");
            node = node.next;
        }
        return sb.append("]").toString();
    }

    public Integer removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Integer value = head.element;
        head = head.next;
        return value;
    }
}