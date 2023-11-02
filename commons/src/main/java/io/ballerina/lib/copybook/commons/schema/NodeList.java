package io.ballerina.lib.copybook.commons.schema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class NodeList implements List<Node> {

    private final List<Node> nodeList = new ArrayList<>();

    @Override
    public int size() {
        return nodeList.size();
    }

    @Override
    public boolean isEmpty() {
        return nodeList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return nodeList.contains(o);
    }

    @Override
    public Iterator<Node> iterator() {
        return nodeList.iterator();
    }

    @Override
    public Object[] toArray() {
        return nodeList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return nodeList.toArray(a);
    }

    @Override
    public boolean add(Node node) {
        return nodeList.add(node);
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("This operation is not permitted");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return new HashSet<>(nodeList).containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Node> c) {
        return this.nodeList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Node> c) {
        return this.nodeList.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("This operation is not permitted");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("This operation is not permitted");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("This operation is not permitted");
    }

    @Override
    public Node get(int index) {
        return this.nodeList.get(index);
    }

    @Override
    public Node set(int index, Node element) {
        throw new UnsupportedOperationException("This operation is not permitted");
    }

    @Override
    public void add(int index, Node element) {
        this.nodeList.add(index, element);
    }

    @Override
    public Node remove(int index) {
        throw new UnsupportedOperationException("This operation is not permitted");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("This operation is not permitted");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("This operation is not permitted");
    }

    @Override
    public ListIterator<Node> listIterator() {
        return this.nodeList.listIterator();
    }

    @Override
    public ListIterator<Node> listIterator(int index) {
        return this.nodeList.listIterator(index);
    }

    @Override
    public List<Node> subList(int fromIndex, int toIndex) {
        return this.nodeList.subList(fromIndex, toIndex);
    }

    @Override
    public String toString() {
        return Arrays.toString(nodeList.toArray());
    }
}
