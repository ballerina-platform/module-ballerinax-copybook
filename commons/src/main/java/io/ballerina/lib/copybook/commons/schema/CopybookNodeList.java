/*
 * Copyright (c) 2023, WSO2 LLC. (http://www.wso2.com) All Rights Reserved.
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.ballerina.lib.copybook.commons.schema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CopybookNodeList implements List<CopybookNode> {
    private final List<CopybookNode> copybookNodeList = new ArrayList<>();

    @Override
    public int size() {
        return copybookNodeList.size();
    }

    @Override
    public boolean isEmpty() {
        return copybookNodeList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return copybookNodeList.contains(o);
    }

    @Override
    public Iterator<CopybookNode> iterator() {
        return copybookNodeList.iterator();
    }

    @Override
    public Object[] toArray() {
        return copybookNodeList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return copybookNodeList.toArray(a);
    }

    @Override
    public boolean add(CopybookNode copybookNode) {
        return copybookNodeList.add(copybookNode);
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("This operation is not permitted");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return new HashSet<>(copybookNodeList).containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends CopybookNode> c) {
        return this.copybookNodeList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends CopybookNode> c) {
        return this.copybookNodeList.addAll(index, c);
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
    public CopybookNode get(int index) {
        return this.copybookNodeList.get(index);
    }

    @Override
    public CopybookNode set(int index, CopybookNode element) {
        throw new UnsupportedOperationException("This operation is not permitted");
    }

    @Override
    public void add(int index, CopybookNode element) {
        this.copybookNodeList.add(index, element);
    }

    @Override
    public CopybookNode remove(int index) {
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
    public ListIterator<CopybookNode> listIterator() {
        return this.copybookNodeList.listIterator();
    }

    @Override
    public ListIterator<CopybookNode> listIterator(int index) {
        return this.copybookNodeList.listIterator(index);
    }

    @Override
    public List<CopybookNode> subList(int fromIndex, int toIndex) {
        return this.copybookNodeList.subList(fromIndex, toIndex);
    }

    @Override
    public String toString() {
        return Arrays.toString(copybookNodeList.toArray());
    }
}
