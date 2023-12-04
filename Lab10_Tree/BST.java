package Lab10_Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

	public class BST <E extends Comparable<E>>{
	private BNode<E> root;
	
	public BST() {
		this.root = null;
	}
	
	//Task 1
	
	// phương thức đệ quy trợ giúp thêm một phần tử vào BST
		private BNode<E> addRecursive(BNode<E> node, E e) {

			if (node == null)
				return new BNode<>(e);

			if (e.compareTo(node.getData()) < 0)
				node.setLeft(addRecursive(node.getLeft(), e));
			else if (e.compareTo(node.getData()) > 0)
				node.setRight(addRecursive(node.getRight(), e));
			return node;
		}
		
		public void add(E e) {
			root = addRecursive(root, e);
		}

	
	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e: col) {
			add(e);
		}
	}
	
	// Phương thức đệ quy trợ giúp tính độ sâu của một nút
		private int depthRecursive(BNode<E> current, E node, int depth) {
			if (current == null) {
				return -1;
			}
			
			if (node.compareTo(current.getData()) < 0) {
				return depthRecursive(current.left, node, depth +1);
			}	
			else if (node.compareTo(current.getData()) >0) {
				return depthRecursive(current.right, node, depth +1);
			} else return depth;
		}
		
		public int depth(E node) {
			return depthRecursive(root, node, 0);
		}
		
		// phương thức đệ quy trợ giúp tính chiều dài của BST
		private int heightRecursive(BNode<E> current) {
	        if (current == null) {
	            return -1;
	        }

	        int leftHeight = heightRecursive(current.left);
	        int rightHeight = heightRecursive(current.right);

	        return Math.max(leftHeight, rightHeight) + 1;
	    }
		
		public int height() {
			return heightRecursive(root);
		}

		public int size() {
	        return sizeRecursive(root);
	    }

	    private int sizeRecursive(BNode<E> current) {
	        if (current == null) {
	            return 0;
	        }

	        return sizeRecursive(current.left) + sizeRecursive(current.right) + 1;
	    }
	    
	    // Check whether element e is in BST
	    public boolean contains(E e) {
	        return findNode(root, e);
	    }

	    private boolean findNode(BNode<E> node, E e) {
	        if (node == null) {
	            return false;
	        }

	        if (e.compareTo(node.getData()) == 0) {
	            return true;
	        } else if (e.compareTo(node.getData()) < 0) {
	            return findNode(node.left, e);
	        } else {
	            return findNode(node.right, e);
	        }
	    }
	    
	    // Find the minimum element in BST
	    public E findMin() {
	        return findMinimum(root);
	    }

	    private E findMinimum(BNode<E> node) {
	        if (node == null) {
	            return null;
	        }

	        if (node.left == null) {
	            return node.getData();
	        } else {
	            return findMinimum(node.left);
	        }
	    }
	    
	    // Find the maximum element in BST
	    public E findMax() {
	        return findMaximum(root);
	    }

	    private E findMaximum(BNode<E> node) {
	        if (node == null) {
	            return null;
	        }

	        if (node.right == null) {
	            return node.getData();
	        } else {
	            return findMaximum(node.right);
	        }
	    }
	    
	 // Get the descendants of a node
	    public List<E> descendants(E data) {
	        List<E> descendantsList = new ArrayList<>();
	        BNode<E> node = getNode(root, data);

	        if (node != null) {
	            getDescendants(node, descendantsList);
	        }

	        return descendantsList;
	    }

	    private void getDescendants(BNode<E> node, List<E> descendantsList) {
	        if (node != null) {
	            descendantsList.add(node.getData());

	            getDescendants(node.getLeft(), descendantsList);
	            getDescendants(node.getRight(), descendantsList);
	        }
	    }

	    // Get the ancestors of a node
	    public List<E> ancestors(E data) {
	        List<E> ancestorsList = new ArrayList<>();
	        findAncestors(root, data, ancestorsList);
	        return ancestorsList;
	    }
	    
	    private BNode<E> getNode(BNode<E> node, E e) {
	        if (node == null) {
	            return null;
	        }

	        if (e.compareTo(node.getData()) == 0) {
	            return node;
	        } else if (e.compareTo(node.getData()) < 0) {
	            return getNode(node.left, e);
	        } else {
	            return getNode(node.right, e);
	        }
	    }

	    private boolean findAncestors(BNode<E> node, E data, List<E> ancestorsList) {
	        if (node == null) {
	            return false;
	        }

	        if (node.getData().equals(data)) {
	            return true;
	        }

	        if (findAncestors(node.getLeft(), data, ancestorsList) || findAncestors(node.getRight(), data, ancestorsList)) {
	            ancestorsList.add(node.getData());
	            return true;
	        }

	        return false;
	    }
	
	// Remove element e from BST
    public boolean remove(E e) {
        root = removeRecursive(root, e);
        return root != null;
    }

    private BNode<E> removeRecursive(BNode<E> node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.getData()) < 0) {
            node.setLeft(removeRecursive(node.getLeft(), e));
        } else if (e.compareTo(node.getData()) > 0) {
            node.setRight(removeRecursive(node.getRight(), e));
        } else {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            } else if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                BNode<E> minNode = findMinNode(node.getRight());
                node.setData(minNode.getData());
                node.setRight(removeRecursive(node.getRight(), minNode.getData()));
            }
        }

        return node;
    }
    
    private BNode<E> findMinNode(BNode<E> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }
    
	// Task 2
    
    public void inorder() {
        inorderTraversal(root);
    }
    
    private void inorderTraversal(BNode<E> node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.getData() + " ");
            inorderTraversal(node.right);
        }
    }
    
    public void preorder() {
        preorderTraversal(root);
    }
    
    private void preorderTraversal(BNode<E> node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preorderTraversal(node.getLeft());
            preorderTraversal(node.getRight());
        }
    }
    
    public void postorder() {
        postorderTraversal(root);
    }
    
    private void postorderTraversal(BNode<E> node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.getData() + " ");
        }
    }
    
	public static void main(String[] args) {
BST<Integer> bst = new BST<>();
        
        bst.root = new BNode<>(5);
        bst.root.setLeft(new BNode<>(3));
        bst.root.setRight(new BNode<>(7));
        bst.root.left.left = new BNode<>(2);
        bst.root.left.right = new BNode<>(4);
        bst.root.right.left = new BNode<>(6);
        bst.root.right.right = new BNode<>(8);
        
        //Task 1
        
        bst.add(9);
        
        System.out.println(bst.depth(6));
        
        System.out.println(bst.contains(9));
        
        bst.remove(4);
        System.out.println("BST after removing 4:");
        bst.inorder();
        System.out.println();
        
        List<Integer> descendants = bst.descendants(5);
        System.out.println("Descendants of 5:");
        for (int desc : descendants) {
            System.out.print(desc + " ");
        }
        System.out.println();
        
        List<Integer> ancestors = bst.ancestors(6);
        System.out.println("Ancestors of 6:");
        for (int ancestor : ancestors) {
            System.out.print(ancestor + " ");
        }
        System.out.println();
        
        // task 2
        System.out.println("Inorder traversal:");
        bst.inorder();
        
        System.out.println("\nPreorder traversal:");
        bst.preorder();
        
        System.out.println("\nPostorder traversal:");
        bst.postorder();
	}
}
