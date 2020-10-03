import java.util.*;
import java.util.ArrayList;
/**
 * This BinarySearchTree object defines a reference based binary search tree
 * 
 * @author  
 * @version 
 */

public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T>
{
    protected BinaryNode<T> root;      // reference to the root of this BST
    boolean found;
    
    
    // Creates an empty Binary Search Tree object
    public BinarySearchTree()
    {
        root = null;
    }

    // Returns true if this BST is empty; otherwise, returns false.
    public boolean isEmpty()
    {
        return root == null;
    }

    // Returns the number of elements in this BST.
    public int size()
    {
        return recSize(root);
    }
    
    public int recSize(BinaryNode<T> tree)
    {
        if (tree == null)
        {
            return 0;
        }
        else
        {
            return recSize(tree.getLeft()) + recSize(tree.getRight()) + 1;
        }
    }

    public void add (T element)
    {
        root = recAdd(element, root);
    }
    
    // Adds element to this BST. The tree retains its BST property.
    public BinaryNode<T> recAdd (T element, BinaryNode<T> tree)
    {
        if (tree == null)
        {
            tree = new BinaryNode<T>(element);
        }
        else if (element.compareTo(tree.getInfo()) <= 0)
        {
            tree.setLeft(recAdd(element, tree.getLeft()));
        }
        else
        {
            tree.setRight(recAdd(element, tree.getRight()));
        }
        return tree;
    }

    // Returns true if this BST contains an element e such that 
    // e.compareTo(element) == 0; otherwise, returns false.
    public boolean contains (T element)
    {
        return recContains(element, root);
    }
    
    public boolean recContains(T element, BinaryNode<T> tree)
    {
        if (tree == null)
        {
            return false;
        }   
        else if (element.compareTo(tree.getInfo()) < 0)
        {
            return recContains(element, tree.getLeft());
        }   
        else if (element.compareTo(tree.getInfo()) > 0)
        {
            return recContains(element, tree.getRight());
        }
        else
        {
            return true;
        }
    }

    // Returns a graphical representation of the tree
    public String toString()
    {
        return toString(root, 0);
    }

    private String toString(BinaryNode<T> tree, int level)
    {
        String str = "";
        if (tree != null)
        {
            str += toString(tree.getRight(), level + 1);
            for (int i = 1; i <= level; ++i)
                str = str + "| ";
            str += tree.getInfo().toString() + "\n";
            str += toString(tree.getLeft(), level + 1);
        }
        return str;
    }

    // Returns a list of elements from a preorder traversal
    public List<T> preorderTraverse()
    {
        List<T> list = new ArrayList<T>();
        recPreorderTraverse(list, root);
        return list;
    }
    
    public void recPreorderTraverse(List list, BinaryNode<T> tree)
    {
        if (tree != null)
        {
            list.add(tree.getInfo());
            recPreorderTraverse(list, tree.getLeft());
            recPreorderTraverse(list, tree.getRight());
        }
    }

    // Returns a list of elements from an inorder traversal
    public List<T> inorderTraverse()
    {
        List<T> list = new ArrayList<T>();
        recInorderTraverse(list, root);
        return list;
    }
    
    public boolean recInorderTraverse(List list, BinaryNode<T> tree)
    {
        if (tree != null)
        {
            recInorderTraverse(list, tree.getLeft());
            list.add(tree.getInfo());
            recInorderTraverse(list, tree.getRight());
        }
        return true;
    }

    // Returns a list of elements from a postorder traversal
    public List<T> postorderTraverse()
    {
        List<T> list = new ArrayList<T>();
        recPostorderTraverse(list, root);
        return list;
    }
    
    public void recPostorderTraverse(List list, BinaryNode<T> tree)
    {
        if (tree != null)
        {
            recPostorderTraverse(list, tree.getLeft());
            recPostorderTraverse(list, tree.getRight());
            list.add(tree.getInfo());
        }
    }

    // Removes an element e from this BST such that e.compareTo(element) == 0
    public void remove (T element)
    {
        root = recRemove(element, root);
    }
    
    public BinaryNode<T> recRemove(T element, BinaryNode<T> tree)
    {
        if (tree == null)
        {
            found = false;
        }
        else if (element.compareTo(tree.getInfo()) < 0)
        {
            tree.setLeft(recRemove(element, tree.getLeft()));
        }
        else if (element.compareTo(tree.getInfo()) > 0)
        {
            tree.setRight(recRemove(element, tree.getRight()));
        }
        else 
        {
            tree = removeNode(tree);
            found = true;
        }
        return tree; 
    }
    
    public BinaryNode<T> removeNode(BinaryNode<T> tree)
    {
        T data;
        
        if (tree.getLeft() == null)
        {
            return tree.getRight();
        }
        else if (tree.getRight() == null)
        {
            return tree.getLeft();
        }
        else
        {
            data = getPredecessor(tree.getLeft());
            tree.setInfo(data);
            tree.setLeft(recRemove(data, tree.getLeft()));
            return tree;
        }
    }
    
    public T getPredecessor(BinaryNode<T> tree)
    {
        while (tree.getRight() != null)
        {
            tree = tree.getRight();
        }
        return tree.getInfo();
    }
    
    // Restructures this BST to be optimally balanced
    public void balance()
    {
        List<T> list = inorderTraverse();
        root = null;
        insertTree(list);
    }
    
    public void insertTree(List<T> list)
    {
        int size = list.size();
        if (size == 1)
        {
            add(list.get(0));
            return;
        }
        add(list.get(size/2));
        List<T> left = new ArrayList<T>();
        List<T> right = new ArrayList<T>();
        for (int i = 0; i < size/2;i++)
        {
            left.add(list.get(i));
        }
        for (int i = size/2+1; i < list.size(); i++)
        {
            right.add(list.get(i));
        }
        insertTree(left);
        insertTree(right);
    }
}