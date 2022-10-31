package com.example.demo.Structures;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * NOTE: Usar esta clase o usar Linked List ?
 */

import com.example.demo.Classes.Song;

// Node class
class Node implements Serializable {
  public Song song;
  public Node next;
  public Node prev;

  // Contructor
  public Node(Song song) {
    this.song = song;
  }
}

// DoublyLinkedList class
public class DoublyLinkedList implements Iterable<Song>, Serializable {
  private Node head;
  private Node tail;
  private int size;

  // Contructor
  public DoublyLinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  // Getters and Setters
  public Node getHead() {
    return head;
  }

  public void setHead(Node head) {
    this.head = head;
  }

  public Node getTail() {
    return tail;
  }

  public void setTail(Node tail) {
    this.tail = tail;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  // Methods

  /**
   * Returns true if list is empty
   *
   * @return true if list is empty
   */
  public boolean isEmpty() {
    return (head == null);
  }

  /**
   * Insert an element at the head
   *
   * @param song Element to be inserted
   */
  public void insertHead(Song song, DoublyLinkedList doublyLinkedList) {
    Node newLink = new Node(song);
    if (doublyLinkedList.isEmpty()) {
      tail = newLink;
    } else {
      head.prev = newLink;
    }
    newLink.next = head;
    head = newLink;
    ++size;
  }

  /**
   * Delete the element at the head
   *
   * @return The new head
   */
  public Node deleteHead() {
    Node temp = head;
    head = head.next;

    if (head == null) {
      tail = null;
    } else {
      head.prev = null;
    }
    --size;
    return temp;
  }

  /**
   * Delete the element at the tail
   *
   * @return The new tail
   */
  public Node deleteTail() {
    Node temp = tail;
    tail = tail.prev;

    if (tail == null) {
      head = null;
    } else {
      tail.next = null;
    }
    --size;
    return temp;
  }

  /**
   * Delete the element from somewhere in the list
   *
   * @param song element to be deleted
   * @return Link deleted
   */
  public void delete(Song song) {
    Node current = head;

    while (current.song != song) {
      if (current != tail) {
        current = current.next;
      } else {
        throw new RuntimeException(
            "The Song to be deleted does not exist!");
      }
    }

    if (current == head) {
      deleteHead();
    } else if (current == tail) {
      deleteTail();
    } else {
      current.prev.next = current.next;
      current.next.prev = current.prev;
    }
    --size;
  }

  @Override
  public Iterator<Song> iterator() {
    Iterator<Song> i = new Iterator<Song>() {
      @Override
      public boolean hasNext() {
        return head != tail;
      }

      @Override
      public Song next() {
        if (!hasNext())
          throw new NoSuchElementException();
        Song song = head.song;
        head = head.next;
        return song;
      }
    };
    return i;
  }
}
