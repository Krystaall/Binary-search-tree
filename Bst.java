/*
 
 NAME: SHARVARI SONKUSARE
 CNUM: C22019221458
 ASSIGNMENT-2
 
 
 PROBLEM STATEMENT: Write a program to create a BST and perform following operations
1. Find minimum or maximum node in a tree
2. Display tree level wise
3. Display tree in descending order
4. Count no.of leaf nodes recursive


 */

package bst;
import java.util.*;

class node{
	node left,right;
	int data;
	public node (int d)     //parameterized constructor
	{
		left=null;
		right=null;
		data=d;
		}
	}
class Bst{
	private node root;
	public Bst()
	{
		root=null;
		}
	void create(int data){        //TIME COMPLEXITY: O(N)
	
    //Create a new node  
		node newNode = new node(data);  

      //Check whether tree is empty  
		if(root == null){  
			root = newNode;  
			return;  
        }
		else {  
            //current node point to root of the tree  
			node current = root, parent = null;  
			while(true) {  
           
				parent = current;  

              //If data is less than current's data, node will be inserted to the left of tree  
				if(data < current.data) {  
					current = current.left;  
					if(current == null) {  
						parent.left = newNode;  
						return;  
						}  
					}  
              //If data is greater than current's data, node will be inserted to the right of tree  
				else {  
					current = current.right;  
					if(current == null) {  
						parent.right = newNode;  
						return;  
						}  
					}  
				}  
			}  
		}  

int minimum() {                 //O(N)
	node current = root;

    // loop to leftmost leaf 
    while (current.left != null) {
        current = current.left;
    }
    return (current.data);
}

int maximum()
{ 
    // loop down to find the rightmost leaf 
    node current = root;
    while (current.right != null) 
        current = current.right;
      
    return (current.data);
}


void levelwise()
{
    int h = height(root);
    int i;
    for (i=1; i<=h; i++)
        printCurrentLevel(root, i);
}

int height(node root)                    //TIME COMPLEXITY: O(1)
{
    if (root == null)
       return 0;
    else
    {
        // calculate  height of each subtree
        int lheight = height(root.left);
        int rheight = height(root.right);
         
        
        if (lheight > rheight)
            return(lheight+1);
        else return(rheight+1);
    }
}

// Prints node at the current level 
void printCurrentLevel (node root ,int level)    //TIME COMPLEXITY: O(N)
{
    if (root == null)
        return;
    if (level == 1)
        System.out.print(root.data + " ");
    else if (level > 1)
    {
        printCurrentLevel(root.left, level-1);
        printCurrentLevel(root.right, level-1);
    }
}


//for descending order
void recursiveInorder(node lRoot) {       //TIME COMPLEXITY: O(N)
	if (lRoot == null)
		return;

	 
	recursiveInorder(lRoot.right);


	System.out.print(lRoot.data + " ");

	 
	recursiveInorder(lRoot.left);
}


int getLeafCount()                               //TIME COMPLEXITY: O(1)
{
    return getLeafCount(root);
}

int getLeafCount(node node)                         //TIME COMPLEXITY: O(N)
{
    if (node == null)
        return 0;
    if (node.left == null && node.right == null)
        return 1;
    else
        return getLeafCount(node.left) + getLeafCount(node.right);
}
void recursiveInorder(){
	recursiveInorder(root); 
	}
int height() {
	int k= height(root);
	return k;
}


  
public static void main(String[] args) {
	int no;
	Bst b=new Bst();
	Scanner sc=new Scanner(System.in);
	do{
		System.out.println("\n**************************************");
		System.out.println("\nMENU: \n1.Create a Binary Tree \n2.Display tree Levelwise \n3.Minimum node \n4. Maximum\n5. Display Descending order \n6. Count no of leaf nodes\n7. Height\n");
		System.out.println("\n**************************************");
		System.out.println("\nEnter your choice: ");
		no=sc.nextInt();
		switch(no)
		{
		case 1://call create()
			System.out.println("Enter data: ");
			int m= sc.nextInt();
			b.create(m);
			break;
		case 2: //call Level wise display
			b.levelwise();
			break;
		case 3: //minimum
			System.out.println("The minimum element is: "+b.minimum());
			break;
		case 4:  //maximum element
			System.out.println("The minimum element is: "+b.maximum());
			break;
		case 5: //descending order
			b.recursiveInorder();
			break;
		case 6: //no. of leaves
			System.out.println("The number of leaf nodes present are: "+b.getLeafCount());
		    break;
	    case 7:  //OPTIONAL
	    	System.out.println("The height of the given tree is: " +b.height());
	    	System.out.println();
		    break;
		    default:
		    	System.out.println("INVALID CHOICE");
		    	break;
		    	}
		System.out.println("/nDo you want to continue Enter 1 to continue and 0 to exit");
		no=sc.nextInt();
		}while (no==1);
	}
}


/*
OUTPUT:



**************************************

MENU: 
1.Create a Binary Tree 
2.Display tree Levelwise 
3.Minimum node 
4. Maximum
5. Display Descending order 
6. Count no of leaf nodes
7. Height


**************************************

Enter your choice: 
1
Enter data: 
6
Do you want to continue Enter 1 to continue and 0 to exit
1

**************************************

MENU: 
1.Create a Binary Tree 
2.Display tree Levelwise 
3.Minimum node 
4. Maximum
5. Display Descending order 
6. Count no of leaf nodes
7. Height


**************************************

Enter your choice: 
1
Enter data: 
4
Do you want to continue Enter 1 to continue and 0 to exit
1

**************************************

MENU: 
1.Create a Binary Tree 
2.Display tree Levelwise 
3.Minimum node 
4. Maximum
5. Display Descending order 
6. Count no of leaf nodes
7. Height


**************************************

Enter your choice: 
1
Enter data: 
9
Do you want to continue Enter 1 to continue and 0 to exit
1

**************************************

MENU: 
1.Create a Binary Tree 
2.Display tree Levelwise 
3.Minimum node 
4. Maximum
5. Display Descending order 
6. Count no of leaf nodes
7. Height


**************************************

Enter your choice: 
1
Enter data: 
3
Do you want to continue Enter 1 to continue and 0 to exit
1

**************************************

MENU: 
1.Create a Binary Tree 
2.Display tree Levelwise 
3.Minimum node 
4. Maximum
5. Display Descending order 
6. Count no of leaf nodes
7. Height


**************************************

Enter your choice: 
1
Enter data: 
8
Do you want to continue Enter 1 to continue and 0 to exit
1

**************************************

MENU: 
1.Create a Binary Tree 
2.Display tree Levelwise 
3.Minimum node 
4. Maximum
5. Display Descending order 
6. Count no of leaf nodes
7. Height


**************************************

Enter your choice: 
2
6 4 9 3 8 
Do you want to continue Enter 1 to continue and 0 to exit
1

**************************************

MENU: 
1.Create a Binary Tree 
2.Display tree Levelwise 
3.Minimum node 
4. Maximum
5. Display Descending order 
6. Count no of leaf nodes
7. Height


**************************************

Enter your choice: 
3
The minimum element is: 3
Do you want to continue Enter 1 to continue and 0 to exit
1

**************************************

MENU: 
1.Create a Binary Tree 
2.Display tree Levelwise 
3.Minimum node 
4. Maximum
5. Display Descending order 
6. Count no of leaf nodes
7. Height


**************************************

Enter your choice: 
4
The minimum element is: 9
Do you want to continue Enter 1 to continue and 0 to exit
1

**************************************

MENU: 
1.Create a Binary Tree 
2.Display tree Levelwise 
3.Minimum node 
4. Maximum
5. Display Descending order 
6. Count no of leaf nodes
7. Height


**************************************

Enter your choice: 
5
9 8 6 4 3 
Do you want to continue Enter 1 to continue and 0 to exit
1

**************************************

MENU: 
1.Create a Binary Tree 
2.Display tree Levelwise 
3.Minimum node 
4. Maximum
5. Display Descending order 
6. Count no of leaf nodes
7. Height


**************************************

Enter your choice: 
6
The number of leaf nodes present are: 2
Do you want to continue Enter 1 to continue and 0 to exit
1

**************************************

MENU: 
1.Create a Binary Tree 
2.Display tree Levelwise 
3.Minimum node 
4. Maximum
5. Display Descending order 
6. Count no of leaf nodes
7. Height


**************************************

Enter your choice: 
7
The height of the given tree is: 3

Do you want to continue Enter 1 to continue and 0 to exit
0





 */

