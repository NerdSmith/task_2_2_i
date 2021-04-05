package ru.vsu.cs;


import java.util.Iterator;

public class LinkedList<T extends Comparable<T>> implements Iterable<T>{
    private ListCell<T> head = null;
    private ListCell<T> tail = null;
    private int size = 0;
    private ListCell<T> sorted = null;

    public int size() {
        return size;
    }

    public void addFirst(T value) {
        head = new ListCell<>(value, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(T value) {
        ListCell<T> newCell = new ListCell<>(value);
        if (size > 0) {
            tail.next = newCell;
        }
        else {
            head = newCell;
        }
        tail = newCell;
        size++;
    }

    public void insertionSort() {
        sorted = null;
        ListCell<T> currentCell = head;
        while (currentCell != null) {
            ListCell<T> nextCell = currentCell.next;
            sortedInsert(currentCell);
            currentCell = nextCell;
        }
        head = sorted;
        for (ListCell<T> newTail = head; newTail != null; newTail = newTail.next) {
            tail = newTail;
        }
    }

    private void sortedInsert(ListCell<T> newCell) {
        if (sorted == null || (sorted.value.compareTo(newCell.value) > 0)) {
            newCell.next = sorted;
            sorted = newCell;
        }
        else
        {
            ListCell<T> currentCell = sorted;
            while (currentCell.next != null && (currentCell.next.value.compareTo(newCell.value) < 0)) {
                currentCell = currentCell.next;
            }
            newCell.next = currentCell.next;
            currentCell.next = newCell;
        }
    }

    private ListCell<T> getCell(int index) {
        ListCell<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public T get(int index) {
        return getCell(index).value;
    }

    public T removeFirst() {
        T value = head.value;
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return value;
    }

    public T removeLast() {
        T value = tail.value;
        size--;
        if (size == 0) {
            head = tail = null;
        } else {
            tail = getCell(size - 1);
            tail.next = null;
        }
        return value;
    }

    public T remove(int index) {
        T value;
        if (index == 0) {
            value = head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            ListCell<T> prev = getCell(index - 1);
            value = prev.next.value;
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
        }
        size--;
        return value;
    }

    @Override
    public Iterator<T> iterator() {
        class LinkedListIterator implements Iterator<T> {
            ListCell<T> currentCell;

            public LinkedListIterator(ListCell<T> head) {
                currentCell = head;
            }

            @Override
            public boolean hasNext() {
                return currentCell != null;
            }

            @Override
            public T next() {
                T result = currentCell.value;
                currentCell = currentCell.next;
                return result;
            }
        }
        return new LinkedListIterator(head);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (ListCell<T> currentCell = head; currentCell != null; currentCell = currentCell.next) {
            sb.append(currentCell.value);
            sb.append(" ");
        }

        return sb.toString();
    }
}
