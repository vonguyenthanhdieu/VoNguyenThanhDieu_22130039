package Lap6;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;
	
	public SinglyLinkedList() {
		super();
	}
	
	// return the number of elements in the list.
	public int size() {
		return size;
	}
	
	// Returns true if the list is empty, and false 
	//otherwise.
	public boolean isEmpty() {
		return size == 0;
	}
	
	// Returns (but does not remove) the first element in 
	//the list.
	public E first() {
		if (head != null)
			return head.data;
		return null;
	}
	
	// Returns (but does not remove) the last element in 
	//the list.
	public E last() {
		if (tail != null)
			return tail.data;
		return null;
	}

	// adds a new element to the front of the list.
    public void addfirst(E element) {
        Node<E> newNode = new Node<>(element);
        
        if (head == null) {
            // If the list is empty, new node becomes both head and tail.
            head = newNode;
            tail = newNode;
        } else {
            // Set the next pointer of the new node to the current head node.
            newNode.next = head;
            // Set the new node as the new head node.
            head = newNode;
        }
        
        size++;
    }
    
    // adds a new element to the end of the list.
    public void addlast(E e) {
        Node<E> newNode = new Node<>(e);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    // Removes and returns the last element of the list.
    public E removeLast() {
    	if (head == null) { 
            return null;
        }
        
        E data = head.data; 
        head = head.next; 
        
        if (head == null) { 
            tail = null; 
        }
        
        size--; 
        
        return data;
    }
	// Removes and returns the first element of the list.
	public E removeFirst() {
		if (head != null) {
            E data = head.data;
            head = head.next;
            size--;

            if (head == null) {
                tail = null;
            }
            return data;
        } else {
            return null;
        }
    }
	
}
