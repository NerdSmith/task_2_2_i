package ru.vsu.cs;

public class LinkedListUtils {
    public static LinkedList<Integer> getIntegerLinkedListFromString(String[] splittedStr) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (String item: splittedStr) {
            linkedList.addLast(Integer.parseInt(item));
        }
        return linkedList;
    }

    public static LinkedList<String> getStringLinkedListFromString(String[] splittedStr) {
        LinkedList<String> linkedList = new LinkedList<>();
        for (String item: splittedStr) {
            linkedList.addLast(item);
        }
        return linkedList;
    }
}
