// generyczna lista liniowa
public class LinkedList<T> {

    private Node<T> first;
    private Node<T> last;

    // anonimowa klasa Node implementowana na wzor tej znajdujacej sie w bibliotece standardowej
    // Javy w implementacji listy liniwoej
    private static class Node<T> {

        T item;
        Node<T> next;
        Node<T> previous;

        Node(Node<T> previous, T item, Node<T> next) {
            this.previous = previous;
            this.item = item;
            this.next = next;
        }
    }

    public LinkedList() {}

    // sygnatury metod sa raczej tak zdefiniowane ze mozna sie domyslec
   
    // iteracyjne dodwanie elementu na koniec listy
    public void addLast(T item) {
        if (first == null) {
            first = new Node<T>(null, item, null);
        } else {
            Node<T> current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<T>(current, item, null);
            last = current.next;
        }
    }
    // rekurencyjne dodawanie elementu na koniec listy
    public void addLastRec(T item) {
        if (first != null)
            addLastRec(item, first);
        else
            addFirst(item);
    }

    private void addLastRec(T item, Node<T> f) {
        if (f.next != null)
            addLastRec(item, f.next);
        else {
            f.next = new Node<T>(f, item, null);
            last = f;
        }
    }

    public void insertBetween(T before, T item, T next) {
        if (contains(before) && contains(next))
            for (Node<T> f = first.next; f != null; f = f.next) {
                if (f.previous.item.equals(before) && f.item.equals(next)) {
                    Node<T> newNode = new Node<T>(f.previous, item, f);
                    f.previous.next = newNode;
                    f.previous = newNode;
                }
            }
    }

    public void insertBefore(T before, T item) {
        if (first == null) {
            addLast(item);
        }
        if (first.next == null)
            addFirst(item);
        if (contains(before))
            for (Node<T> f = first; f != null; f = f.next) {
                if (f.item.equals(before)) {
                    Node<T> newNode = new Node<T>(f.previous, item, f);
                    f.previous.next = newNode;
                    f.previous = newNode;
                }
            }
    }

    public void insertAfter(T after, T item) {
        if (first == null)
            addLast(item);
        if (contains(after))
            for (Node<T> f = first; f != null; f = f.next) {
                if (f.item.equals(after)) {
                    Node<T> newNode = new Node<T>(f, item, f.next);
                    f.next = newNode;
                    f.next.previous = newNode;
                }
            }
    }

    public void addFirst(T item) {
        Node<T> f = first;
        Node<T> newFirst = new Node(null, item, first);
        first = newFirst;
        if (f != null)         
            f.previous = newFirst;
    }

    public T get(T item) {
        if (first.item.equals(item)) {
            first.next.previous = null;
            first = first.next;
            return first.item;
        }
        Node<T> current = first;
        while (current != null) {
            if (current.item.equals(item)) {
                current.previous.next = current.next;
                if (current.next != null)
                    current.next.previous = current.previous;
                else
                    current.next = null;
                return current.item;
            }
            current = current.next;
        }
        // Nie fajne
        return null;
    }

    public void remove(T item) {
        if (first != null && first.item.equals(item)) {
            first = first.next;
        }
        Node<T> current = first;
        while (current != null) {
            if (current.item.equals(item)) {
                current.previous.next = current.next;
                if (current.next != null)
                    current.next.previous = current.previous;
            }
            current = current.next;
        }
    }

    /*
    public T getItemAndRemoveFromList(T t) {
    }
    */
    public boolean contains(T t) {
        return indexOf(t) >= 0;
    }

    private int indexOf(T t) {
        int i = 0;
        if (t != null) {
            for (Node<T> n = first; n != null; n = n.next) {
                if (n.item.equals(t))
                    return i;
                i++;
            }
        }
        return -1;
    }

    public void traverse() {
        Node<T> current = first;
        while (current != null) {
            System.out.println(current.item.toString());
            current = current.next;
        }
    }
}

