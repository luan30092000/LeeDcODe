import java.util.Vector;

public class Adapter {
    public static void main(String[] args) {
        Stack<String> s1 = new Stack_Class_Adapter<>();

        s1.push("foo");
        s1.push("bar");
        System.out.println(s1.pop());
        System.out.println(s1.pop());

        Stack<String> s2 = new Stack_Object_Adapter<>();

        s2.push("foo2");
        s2.push("bar2");
        System.out.println(s2.pop());
        System.out.println(s2.pop());
    }
}

interface Stack<T> {
    public void push(T t);
    public T pop();
    public int size();
}

class Stack_Class_Adapter<T> implements Stack<T> {

    private Vector<T> _adaptee;

    Stack_Class_Adapter() {
        _adaptee = new Vector<T>();
    }

    public void push(T t) {
        _adaptee.insertElementAt(t, _adaptee.size());
    }

    public T pop() {
        T t = _adaptee.elementAt(_adaptee.size() - 1);
        _adaptee.removeElementAt(_adaptee.size() - 1);
        return t;
    }

    public int size() {
        return _adaptee.size();
    }
}

class Stack_Object_Adapter<T> extends Vector<T> implements Stack<T> {

    Stack_Object_Adapter() {
        super();
    }

    public void push(T t) {
        this.insertElementAt(t, size());
    }

    public T pop() {
        T t = elementAt(size() - 1);
        this.removeElementAt(size() - 1);
        return t;
    }
}
