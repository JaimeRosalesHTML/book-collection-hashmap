package griffith;

//JAIME ROSALES 3142108

import java.util.HashSet;
import java.util.LinkedList;

// Generic HashList class to store elements using hash buckets
public class HashList<E> {
    private LinkedList<E>[] data;

    // Constructor to create an array of empty buckets
    @SuppressWarnings("unchecked")
    public HashList(int n) {
        data = (LinkedList<E>[])(new LinkedList[n]);
        for (int j = 0; j < data.length; j++) {
            data[j] = new LinkedList<E>();
        }
    }

    // Hash function to find index for an element
    private int hash(E x) {
        return Math.abs(x.hashCode()) % data.length;
    }

    // Add element to the correct bucket
    public void add(E x) {
        int index = hash(x);
        data[index].add(x);
    }

    // Check if an element exists in the HashList
    public boolean contains(E x) {
        int index = hash(x);
        return data[index].contains(x);
    }

    // Remove an element from the HashList
    public boolean remove(E x) {
        int index = hash(x);
        return data[index].remove(x);
    }

    // Display all buckets and their contents
    public void displayLists() {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Bucket " + i + ": " + data[i]);
        }
    }

    // Calculate and return the percentage of buckets that are used
    public double percentUsed() {
        int usedBuckets = 0;
        for (LinkedList<E> bucket : data) {
            if (!bucket.isEmpty()) {
                usedBuckets++;
            }
        }
        return (usedBuckets * 100.0) / data.length;
    }

    // Return a HashSet containing all entries
    public HashSet<E> getAllEntries() {
        HashSet<E> entries = new HashSet<>();
        for (LinkedList<E> bucket : data) {
            entries.addAll(bucket);
        }
        return entries;
    }

    // Return the number of buckets
    public int getSize() {
        return data.length;
    }
}
