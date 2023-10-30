package Lap6;

import java.security.spec.ECFieldF2m;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;
	
	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}
	
	//creates an array of double-size if the array of
	//elements is full
	public void growSize() {
		if (size == elements.length) {
			E[] tam = (E[]) new Object[elements.length * 2];
			System.arraycopy(elements, 0, tam, 0, size);
			elements = tam;
		}
	}
	
	// Returns the number of elements in this list.
	public int size() {
		return size;
	}
	
	// Returns whether the list is empty.
	public boolean isEmpty() {
		return size() == 0;
	}
	
	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException{
		//quăng ra một cái ngoại lệ
		if (i<0 || i >= size) 
			throw new IndexOutOfBoundsException();
		return elements[i];
	}
	
	// thay thế phần tử tại mục i bằng e và trả về phần tử
	// được thay thế.
	public E set(int i, E e) throws IndexOutOfBoundsException{
		if (i<0 || i >= size) 
			throw new IndexOutOfBoundsException();
		E newElement = elements[i];
		elements[i] = e;
		return newElement;
	}
	
	//nối thêm phần tử đã chỉ định vào cuối một danh sách
	public boolean add(E e) {
		if (size == elements.length)
			growSize();
		elements[size] = e;
		size++;
		
		return true;
	}
	
	//chèn phần tử thứ e vào chỉ mục i
	// dịch chuyển tất cả các phần tử tiếp theo vào phía sau
	public void add(int i, E e) throws IndexOutOfBoundsException{
		//quăng ra một ngoại lệ
		if (i<0 || i >= size) 
			throw new IndexOutOfBoundsException();
		if (size == elements.length)
			growSize();
		for (int j= size -1; j >= i; j--) {
			elements[j+1] = elements[j];
		}
		elements[i] = e;
		size++;
	}
	
	//loại bỏ và trả về phần tử tại mục chỉ i 
	// dịch chuyển các phần tử tiếp theo vào trước đó
	public E remove(int i) throws IndexOutOfBoundsException{
		//quăng ra một ngoại lệ
		if (i<0 || i >= size) 
			throw new IndexOutOfBoundsException();
		E newElement = elements[i];
		for (int j= i; j< size-1; j++) {
			elements[j] = elements[j+1];
		}
		size--;
		return newElement;
	}
	
	//xóa tất cả các phần tử trong danh sách
	public void clear() {
		//chỉnh số phần tử về 0
		size =0;
	}
	
	//trả về chỉ mục của danh sách này lần cuối cùng 
	// của phần tử được chỉ định hoặc -1 
	// nếu danh sách không chứa phần tử này
	public int lastIndexOf(Object o) {
		for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
	}
	
	//trả về một mảng chứa tất cả các phần tử trong
	// danh sách này theo đúng thứ tự
	public E[] toArray() {
		E[] array = (E[]) new Object[size];
        System.arraycopy(elements, 0, array, 0, size);
        return array;
	}
	
	// nó trả về một bản shallow copy của ArrayList
	public MyArrayList<E> clone(){
        MyArrayList<E> cloneList = new MyArrayList<>();
        cloneList.size = this.size;
        cloneList.elements = (E[]) new Object[this.elements.length];

        for (int i = 0; i < this.elements.length; i++) {
            cloneList.elements[i] = this.elements[i];
        }

        return cloneList;

	}
	
	// It returns true if the list contains the specified 
	// element
	public boolean contains(E o) {
		for (int i=0; i< size; i++) {
			if (elements[i].equals(o))
				return true;
		}
		return false;
	}

	// It is used to return the index in this list of the 
	//first occurrence of the specified element, or -1 if the 
	//List does not contain this element
	public int indexOf(E o) {
		for (int i=0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
	}
	
	// It is used to remove the first occurrence of the 
	//specified element.
	public boolean remove(E e) {
		for (int i=0; i < size; i++) {
            if (elements[i].equals(e)) {
                remove(i);
                return true;
            }
        }
		return false;
	}
	
	public static void main(String[] args) {
		MyArrayList<Integer> arrayList = new MyArrayList<>();
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.growSize();
		System.out.println(arrayList.get(1));
		System.out.println(arrayList.set(2,4));
		arrayList.add(6);
		arrayList.add(0,-1);
		for (int i =0; i< arrayList.size; i++) {
			System.out.print(arrayList.get(i) + "\t");
		}
		System.out.println();
		
		
		arrayList.remove(2);
		System.out.println(arrayList.lastIndexOf(3));
		
		arrayList.clear();
		System.out.println(arrayList.isEmpty());

	}
}
