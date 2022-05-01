package BST;

class Node {
	  public int data;
	  public Node left;
	  public Node right;

	  public Node(int value) {
	    data = value;
	    left = null;
	    right = null;
	  }
	}
public class BST {
	
	public Node root;
	public int counter;
	  BST() {
	    root = null;
	    counter = 0;
	  }
	  public void add(int value) { 
	    Node new_node = new Node(value);

	    if (root == null) {
	        root = new_node;
	      } else {
	        Node find = root;

	        while (find != null) {
	          if (find.data >= value) {
	            if (find.left == null) {
	              find.left = new_node;
	              break;
	            } else {
	            	
	              find = find.left;
	            }
	          } else {
	            if (find.right == null) {
	              find.right = new_node;
	              break;
	            } else {
	              find = find.right;
	            }
	          }
	        }
	      }
	  }
	  int counter_nodes(Node head) {
	    if (head != null) {

	      return counter_nodes(head.left) + counter_nodes(head.right) + 1;

	    }
	    return 0;
	  }
	  public void get_elements(Node head, int[] auxiliary) {
	    if (head != null) {


	      get_elements(head.left, auxiliary);
	      auxiliary[this.counter] += head.data;
	      this.counter++;
	      get_elements(head.right, auxiliary);
	    }
	  }
	  public void pair_sum(int sum) {
	    if (root != null) {

	      int size = counter_nodes(root);

	      int[] auxiliary = new int[size];

	      int i = 0, index = 0;

	      boolean status = false;

	      this.counter = 0;

	      get_elements(root, auxiliary);

	      size--;
	
	      while (index < size) {
	        if (auxiliary[index] + auxiliary[size] == sum) {
	          status = true;
	          break;
	        } else if (auxiliary[index] + auxiliary[size] > sum) {
	          size--;
	        } else {
	          index++;
	        }
	      }
	      if (status == false) {
	        System.out.print("\nPair of Sum " + sum + " are not found \n");
	      } else {

	        System.out.print("\nSum : " + sum + "\n");
	        
	        while (index <= size) {

	          i = index + 1;

	          while (i <= size) {

	            if (auxiliary[index] + auxiliary[i] == sum) {
	              System.out.print("Print is (" + auxiliary[index] + "," + auxiliary[i] + ")");
	            }
	            i++;
	          }

	          index++;
	        }
	      }
	    }

	  }
	  public static void main(String[] args) {

	    BST obj = new BST();

	    obj.add(40);
	    obj.add(20);
	    obj.add(10);
	    obj.add(30);
	    obj.add(60);
	    obj.add(50);
	    obj.add(70);

	    obj.pair_sum(130);
	  }

}
