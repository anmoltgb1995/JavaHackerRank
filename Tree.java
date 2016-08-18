import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node {
       int data;
       Node left;
       Node right;

       Node(){}

       Node(int data){
       	this.data=data;
       }
   }

public class Tree{
	Node root;

//iterative method to decode Huffman encoded string
void decode(String S ,Node root){
    int len=S.length(),i=0;
    while(i<len){
        Node node=root;
        //traverse acc to input string till you hit a leaf
        while(!(node.left==null && node.right==null)){
            char c=S.charAt(i);
            if(c=='0') node=node.left;
            else node=node.right;
            i++;
        }
        //print leaf data(decoded character)
        System.out.print(node.data);
    }


   int height(Node root){
   	   if(root==null) return 0;
       if(root.left==null&&root.right==null) return 0; //leaf node
       return 1+Math.max(height(root.left),height(root.right));
    }

    //level order traversal of binary tree = breadth first traversal of graph
    //tree is a type of acyclic graph
    void levelOrder(){
      LinkedList<Node> queue = new LinkedList<Node>();
      queue.add(this.root);
      while(queue.size() != 0){
        Node node = queue.poll();
        System.out.print(node.data+" ");
        if(node.left != null)
        queue.add(node.left);
        if(node.right != null)
        queue.add(node.right);
      }
      
    }

    //BST insertion
    Node Insert(Node root,int value){
        
    if(root==null){
      //System.out.println("Root is null");
      root = new Node();
      root.data=value;
      //return new root node if new node is allocated to it
      return root;
    }
    
    else if(value < root.data){
        if(root.left==null){
            root.left = new Node();
            root.left.data=value;
        }else Insert(root.left,value);
    }
    
    else {
        if(root.right==null){
            root.right = new Node();
            root.right.data=value;
        }else Insert(root.right,value);
    }
    
    return null;  //no need to return if insertion is not at the ultimate root
}

//another version of BST insertion
Node Insert(Node root,int value){
    if(root==null){
        root=new Node();
        root.data=value;
    }
    if(root.data>value) root.left=Insert(root.left,value);
    else if(root.data<value) root.right=Insert(root.right,value);
    return root;
}

//recursive method to find lowest common ancestor of two nodes in BST
static Node lca(Node root,int v1,int v2){
    //if both v1,v2 equal
    //if(root.left.data==v1 || root.right.data==v1) return root;
    if(v1<root.data){
        if(v2<root.data) return lca(root.left,v1,v2);
    }
    else if(v1>root.data){
        if(v2>root.data) return lca(root.right,v1,v2);
    }
    return root;
}


void inOrder(Node root) {
    if(root==null) return;
    inOrder(root.left);
    System.out.print(root.data+" ");
    inOrder(root.right);

}

}



class Solution{

    public static void main(String[] args){
    	Tree tree = new Tree();

      /*
    	Node root = new Node(3);
    	root.left = new Node(2);
    	root.right = new Node(4);
    	root.left.left = new Node(1);
    	root.right.left = new Node(4);
    	root.right.right = new Node(5);
    	root.right.right.right = new Node(6);

    	tree.root = root;
    */
    tree.root = tree.Insert(tree.root,4);
    tree.Insert(tree.root,2);
    tree.Insert(tree.root,7);
    tree.Insert(tree.root,1);
    tree.Insert(tree.root,3);
    tree.Insert(tree.root,6);

    System.out.println("In order traversal of tree: ");
    tree.inOrder(tree.root);
    }
}
