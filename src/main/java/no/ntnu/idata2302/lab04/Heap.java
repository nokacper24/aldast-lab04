package no.ntnu.idata2302.lab04;

import java.util.ArrayList;

public class Heap<Item extends Comparable<Item>> {
  private final ArrayList<Item> items;

  public Heap() {
    this.items = new ArrayList<>();
  }

  /*
  Extract the minimum element from the heap and return it.
  it will also reorganize the heap to maintain the heap property.
  using bubble down. and swap the last element with the root with the function swap
   */
  public Item extractMin() {
    Item min = items.get(0);
    swap(0, items.size() - 1);
    items.remove(items.size() - 1);
    bubbleDown(0);
    return min;


  }


  private int parentIndex(int index) {
    return (index - 1) / 2;
  }

  private int leftChildIndex(int index) {
    return index * 2 + 1;
  }

  private int rightChildIndex(int index) {
    return index * 2 + 2;
  }

  public Heap<Item> insert(Item item) {
    items.add(item);
    bubbleUp(lastIndex());
    return this;
  }

  private int lastIndex() {
    return items.size() - 1;
  }

  private void bubbleUp(int nodeIndex) {
    while (!isRoot(nodeIndex)) {
      int parentIndex = parentIndex(nodeIndex);
      int difference = itemAt(parentIndex).compareTo(itemAt(nodeIndex));
      if (difference > 0) {
        swap(parentIndex, nodeIndex);
      }
      nodeIndex = parentIndex;
    }
  }

  private void swap(int parentIndex, int nodeIndex) {
    Item temp = items.get(parentIndex);
    items.set(parentIndex, items.get(nodeIndex));
    items.set(nodeIndex, temp);
  }

  private Item itemAt(int index) {
    return items.get(index);
  }

  private boolean isRoot(int nodeIndex) {
    return nodeIndex == 0;
  }

  public Item next() {
    swap(lastIndex(), 0);
    Item item = items.remove(lastIndex());
    bubbleDown(0);
    return item;
  }


  private void bubbleDown(int parentIndex) {
    while (hasAnyChildren(parentIndex)) {
      int leastChildIndex = leastChildIndex(parentIndex);
      int difference = itemAt(parentIndex).compareTo(itemAt(leastChildIndex));
      if (difference <= 0) {
        break;
      }
      swap(parentIndex, leastChildIndex);
      parentIndex = leastChildIndex;
    }
  }

  private int leastChildIndex(int parentIndex) {
    if (!hasLeftChild(parentIndex)) {
      return rightChildIndex(parentIndex);
    }
    if (!hasRightChild(parentIndex)) {
      return leftChildIndex(parentIndex);
    }
    int leftDifference =
        itemAt(leftChildIndex(parentIndex)).compareTo(itemAt(rightChildIndex(parentIndex)));
    if (leftDifference <= 0) {
      return leftChildIndex(parentIndex);
    }
    return rightChildIndex(parentIndex);
  }

  private boolean hasRightChild(int parentIndex) {
    return rightChildIndex(parentIndex) < items.size();
  }

  private boolean hasLeftChild(int parentIndex) {
    return leftChildIndex(parentIndex) <= lastIndex();
  }

  private boolean hasAnyChildren(int index) {
    return leftChildIndex(index) <= lastIndex();
  }
}
