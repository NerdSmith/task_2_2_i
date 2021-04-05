package ru.vsu.cs;

public class ListCell<T> {
    public T value;
    public ListCell<T> next;

    public ListCell(T value, ListCell<T> next) {
        this.value = value;
        this.next = next;
    }

    public ListCell(T value) {
        this.value = value;
        this.next = null;
    }
}
