public class CustomerArray {
    int[] arr;
    int Capacity;
    int Size;

    public CustomerArray(int capacity) {
        arr = new int[capacity];
        this.Capacity = capacity;
        Size = 0;
    }

    //Getter
    public int getSize() {
        return Size;
    }

    //Getter
    public int getCapacity() {
        return Capacity;
    }

    //Getter
    public boolean isEmpty() {
        return (Size == 0 || Capacity == 0);
    }

    public int at(int index) {
        if (index >= Size) {
            return 0;
        } else {
            return arr[0 + index];
        }
    }

    public void pushBack(int val) {
        checkSize();
        arr[Size] = val;
        Size++;
    }

    public void pushFront(int val) {
        if (Size == 0) {
            arr[Size] = val;
        } else {
            shiftRight(0);
            arr[0] = val;
        }
    }

    public void pushAt(int index, int val) {
        checkSize();
        shiftRight(index);
        arr[index] = val;
        Size++;
    }

    public int popFront() {
        int result = arr[0];
        arr[0] = 0;
        shiftLeft(0);
        Size--;
        return result;
    }

    public int popBack() {
        int result = arr[Size - 1];
        arr[Size - 1] = 0;
        Size--;
        return result;
    }

    public void fillIndex(boolean half) {
        if (half) {
            for (int i = 0; i < Capacity / 2; i++) {
                arr[i] = i + 1;
                Size++;
            }
        }
        else {
            for (int i = 0; i < Capacity; i++) {
                arr[i] = i + 1;
                Size++;
            }
        }
    }

    /**
     * shifting all element down so index will be available
     * @param index location where it will be available
     */
    private void shiftRight(int index) {
        if (index < 0) {
            return;
        }
        checkSize();
        for (int i = Size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
    }

    private void shiftLeft(int index) {
        if (index < 0) {
            return;
        }
        checkSize();
        for (int i = index; i < Size; i++) {
            arr[i] = arr[i + 1];
        }
    }

    private void checkSize()  {
        if (Size == Capacity) {
            reSize();
        }
    }

    /**
     * Method resize array capacity with a specific length
     */
    private void reSize() {
        Capacity = Capacity * 2;
        int[] newArr = new int[Capacity];
        for (int i = 0; i < Size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public void printAll() {
        System.out.print("[");
        for (int i = 0; i < Capacity; i++) {
            System.out.print(arr[i]);
            System.out.print(", ");

        }
        System.out.println("]");
        System.out.println("Size: " + Size);
        System.out.println("Capacity: " + Capacity);
    }






}