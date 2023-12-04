package Lab10_Tree;

import java.util.ArrayList;
import java.util.List;

public class BNode <E extends Comparable<E>>{
	private E data;
	BNode<E> left;
	BNode<E> right;
	public BNode(E data) {
	this.data = data;
	this.left = null;
	this.right = null;
	}
	public BNode(E data, BNode<E> left, BNode<E> right) {
	this.data = data;
	this.left = left;
	this.right = right;
	}
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public BNode<E> getLeft() {
		return left;
	}
	public void setLeft(BNode<E> left) {
		this.left = left;
	}
	public BNode<E> getRight() {
		return right;
	}
	public void setRight(BNode<E> right) {
		this.right = right;
	}
	
	
    
    
}

	