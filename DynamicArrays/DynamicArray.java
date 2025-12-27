package DynamicArrays;
class DynamicArray {
    private int capacity;
    private int size;
    private int[] array;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        // better to assign length = 0;
        this.size = 0;
        this.array = new int[capacity];
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if (size < capacity) {
            array[size] = n;
        }
        else { // if max cap
        // COULD just do 1 condition size == cap, then resize()
            resize();
            array[size] = n;
        }

        if (size >= capacity) {
            resize();
        }
        array[size] = n;
        size++;
    }

    public int popback() {
        // save what we're popping
        int popped = array[size-1];
        // popping element at size-1
        array[size - 1] = 0;
        // decrement size--
        size--;
        return popped;
        // COULD soft delete by just dec length
    }

    // activated when size == capacity
    private void resize() {
        capacity = capacity * 2;
        int[] newArray = new int[capacity];

        // copy elements
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray; // replace refererence
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
