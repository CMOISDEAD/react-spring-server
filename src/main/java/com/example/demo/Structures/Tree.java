package com.example.demo.Structures;

import com.example.demo.Classes.Artist;

/*
 * NOTE: Tipo de arbol BST Recursivo.
 */

private class Node {
  Artist data;
  Node left;
  Node right;

  // Constructor
  public Node(Artist data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

public class Tree {
  private Node root;

  // Constructor
  public Tree() {
    root = null;
  }

  // Getters and Setters
  public Node getRoot() {
    return root;
  }

  public void setRoot(Node root) {
    this.root = root;
  }

  // Methods

  /**
   * Recursive insertion of value in BST.
   *
   * @param node to check if the data can be inserted in current node or its
   *             subtree
   * @param data the value to be inserted
   * @return the modified value of the root parameter after insertion
   */
  private Node insert(Node node, Artist data) {
    if (node == null) {
      node = new Node(data);
    } else if (node.data.name.length() > data.name.length()
        || node.data.name.length() == data.name.length()) {
      node.left = insert(node.left, data);
    } else if (node.data.name.length() < data.name.length()) {
      node.right = insert(node.right, data);
    }
    return node;
  }

  /**
   * add in BST. if the value is not already present it is inserted or else no
   * change takes place.
   *
   * @param data the value to be inserted
   */
  public void add(Artist data) {
    this.root = insert(this.root, data);
  }

  /**
   * Recursive method to delete a data if present in BST.
   *
   * @param node the current node to search for data
   * @param data the value to be deleted
   * @return Node the updated value of root parameter after delete operation
   */
  private Node delete(Node node, Artist data) {
    if (node == null) {
      System.out.println("No such data present in BST.");
    } else if (node.data.name.length() > data.name.length()) {
      node.left = delete(node.left, data);
    } else if (node.data.name.length() < data.name.length()) {
      node.right = delete(node.right, data);
    } else {
      if (node.right == null && node.left == null) { // If it is leaf node
        node = null;
      } else if (node.left == null) { // If only right node is present
        Node temp = node.right;
        node.right = null;
        node = temp;
      } else if (node.right == null) { // Only left node is present
        Node temp = node.left;
        node.left = null;
        node = temp;
      } else { // both child are present
        Node temp = node.right;
        // Find leftmost child of right subtree
        while (temp.left != null) {
          temp = temp.left;
        }
        node.data = temp.data;
        node.right = delete(node.right, temp.data);
      }
    }
    return node;
  }

  /**
   * If data is present in BST delete it else do nothing.
   *
   * @param data the value to be removed
   */
  public void remove(Artist data) {
    this.root = delete(this.root, data);
  }
}
