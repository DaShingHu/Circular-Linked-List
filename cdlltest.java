
public class cdlltest {
    /* 
       Author: Dustin Hu
       Date: 29-11-2014
       Purpose: To demonstrate the circular doubly linked list 
     */

    public static void main(String[] args) {
	// AUthor: Dustin Hu
	// Date: 1-12-2014
	// Purpose: To demonstrate the doubly linked list
	// Input: None
	// Output: None
	CircularList George = new CircularList();
	CircularList Frank;
	System.out.println("Well hello there, my friend, George here.");
	System.out.println("I'm getting ready to leave the station, so let's take a look at my train.");
	System.out.println(George.toStringRight());
	System.out.println("Well that's odd, there are no cars.");
	System.out.println("Well is there a car called 1?");
	System.out.println(George.inList(1));
	System.out.println("Nope.");
	System.out.println("Well then, let's try to delete this nonexistent 1 car.");
	George.delete(1);
	System.out.println(George.toStringRight());
	System.out.println("Welp, nothing happens.");
	System.out.println("Well then, what if we go the other way?");
	System.out.println(George.toStringLeft());
	System.out.println("Still nothing.");
	System.out.println("Well then, what if we try to give away half my cars?");
	Frank = George.splitInTwo();
	System.out.println(George.toStringRight());
	System.out.println("Well then, let's add in a car with a value of 6");
	George.insertLeft(6, 0);
	System.out.println("And this is what the car looks like if you go around it clockwise.");
	System.out.println(George.toStringRight());
	System.out.println("And it should be the same if you go around it counterclockwise");
	System.out.println(George.toStringLeft());
	System.out.println("And let's add in a few more cars.");
	System.out.println("First off, the car 4 before the car 6.");
	George.insertLeft(4, 6);
	System.out.println("Now, I'm going to take a walk clockwise.");
	System.out.println(George.toStringRight());
	System.out.println("And the other way.");
	System.out.println(George.toStringLeft());
	System.out.println("Well I don't want the car 4, it's bad luck.");
	George.delete(4);
	System.out.println("Well then, let's go for another walk and check whether or not my train is nice and tidy.");
	System.out.println(George.toStringRight());
	System.out.println("Looks fine, but we're missing a few cars.");
	System.out.println("So Pacific Railways decided to give me a few new cars.");
	George.insertLeft(5, 6);
	George.insertLeft(14, 4);
	George.insertLeft(3, 14);
	System.out.println("Well then, I guess it's time to inspect them.");
	System.out.println("Going clockwise:");
	System.out.println(George.toStringRight());
	System.out.println("And counterclockwise");
	System.out.println(George.toStringLeft());
	System.out.println("Well then, according to Pacific Railways, it'd be a good idea to hire Frank, so they decided to give him half my cars.");
	Frank = George.splitInTwo();
	System.out.println("So now here's my train, going clockwise,'");
	System.out.println(George.toStringRight());
	System.out.println("And here's Frank's train, going clockwise.");
	System.out.println(Frank.toStringRight());
	
    }

}

class Node {
    /*
      Author: DUstin Hu
      Date: 29-11-2014
      Purpose: To be a node

      Fields:
          left: The left node
	  right: The right node
	  data: The data

      Methods:
          Node: Constructor with no inputs
	  Node: Constructor with two inputs
     */

    public int data;
    public Node left;
    public Node right;

    public Node(){
	// Author: Dustin Hu
	// Date: 29-11-2014
	// Purpose: TO cerate the node
	// Input: None
	// OUtput: None
	this.data = 0;
	this.left = null;
	this.right = null;
    }
    public Node(int data){
	// Author: Dustin Hu
	// Date: 29-11-2014
	// Purpose: TO cerate the node
	// Input: The data
	// Output: None
	this.data = data;
	this.left = null;
	this.right = null;

    }


}

class CircularList{
    /*
      Author: Dustin Hu
      Date: 29-11-2014
      Purpoes: To be the circular, doubly linked list
      
      Fields: 
          header: The header node

      Methods:
          CircularList: Consturcotr with no parameters
	  CircularList: Consturcotr with one parameter
	  numNodes: Gets the number of nodes
	  toStringLeft: Creates a string of the values going left
	  toSTringRight: Cerateas a stirng of the values going right
	  inList: Checks if a value is in the list
	  insertLeft: Inserts a node to teh left of a given value
	  find: Finds a node given the value
	  pop: Pops the last node
	  push: Pushes a node;
	  splitInTwo: Splits it in two
	  delete: Deletes a node
     */

    protected Node header;
    
    public CircularList (){
	// Author: Dustin Hu
	// Date: 29-11-2014
	// Purpose: to cerate the list
	// Input: None
	// Output: None
	this(0);
    }
    public CircularList(int data){
	// Author: DUstin Hu
	// Date: 29-11-2014
	// Purpose: To create the cirucalr list
	// Input: The number of nodes
	// Output: None
	this.header = new Node(data);
	this.header.left = this.header;
	this.header.right = this.header;
	
    }
    public int numNodes (){
	// Autohr: DUsitn Hu
	// Date: 30-11-2014
	// Purpose: To get the number of nodes
	// Input: None
	// Output: THe number of nodes, an integer
	return this.header.data;
    }
    public String toStringLeft(){
	// Author: DUstin Hu
	// Date: 30-11-2014
	// Purpoes: To prnt all the list values going left
	// Input: None
	// Output: A string, containing the values
	String output = "";
	Node current = this.header.left;

	for (int i = 0; i < this.numNodes()  && current != this.header; i++){
	    output = output + current.data;
	    if (i < this.numNodes() - 1){
		output = output + " <-> ";
	    }
	    current = current.left;
	}
	output = output + " [" + this.numNodes() + "]";
	return output;
    }
    public String toStringRight(){
	// Author: DUstin Hu
	// Date: 30-11-2014
	// Purpoes: To print all the list values going right
	// Input: None
	// Output: A string containing the nodes

	String output = "";
	Node current = this.header.right;

	for (int i = 0; i < this.numNodes() && current != this.header; i++){
	    output = output + current.data;
	    if (i < this.numNodes() - 1){
		output = output + " <-> ";
	    }
	    current = current.right;
	}
	output = output + " [" + this.numNodes() + "]";
	return output;
    }
    public boolean inList(int data){
	// Author: Dustin Hu
	// Date: 30-11-2014
	// Purpoes: To check if a node is in the list
	// Input: The data to check
	// output: Boolean true if found, false if not
	boolean output = false;
	Node current = this.header.right;
	for (int i = 0; i < this.numNodes() && output == false ; i++){
	    if (current.data == data){
		output = true;
	    }
	    else{
		current = current.right;
	    }
	}
	return output;
	
    }
    public void insertLeft (int data, int target){
	// Author: DUstin Hu
	// Date: 30-11-2014
	// Purpoes: To inselt a node to the left of its target
	// Input: The data for the new node and the target
	// Output: None
	boolean walk = true;
	Node input = new Node(data);
	Node current;
	Node before;

	if (this.inList(target) == false){
	    input.right = this.header;
	    input.left = this.header.left;
	    this.header.left.right = input;
	    this.header.left = input;
	}
	else{
	    // The right of the target now points to the input, 
	    // The input's 'left now points to what was once the right of the target
	    // The target's left now points to the input
	    // The input's right now points to the input
	    
	    current = this.find(target);

	    input.left = current.left;
	    input.right = current;
	    
	    current.left.right = input;
	    current.left = input;
	    
	    

	    // input.left = current.left;
	    // current.right = input;
	    // input.right = current;
	    // current.left = input;
	}

	this.header.data = this.header.data + 1;
    }
    public Node find(int target){
	// Author: Dustin H
	// Date: 30-11-2014
	// Purpose: To find the node
	// Input: THe data of the node to find
	// Output: Null if not found, otherwise, the node.
	Node output = null;
	Node current = header.left;
	boolean walk = true;

	int i = 0;
	if (this.inList(target) == false){
	    output = null;
	}
	else{
	    while (walk == true){
		if (current.data == target){
		    walk = false;
		    output = current;
		}
		else{
		    current = current.left;
		}
	    }
	}
	return output;
    }
    public Node pop(){
	// AUthor: Dustin Hu
	// Date: 1-12-2014
	// Purpose: To return the last node
	// Input: None
	// Output: THe last node of tihs list


	Node output;

	if (this.header.left != this.header){

	    output = this.header.left;
	    this.header.left = output.left;
	    this.header.left.right = output.right;


	    output.left = null;
	    output.right = null;

	    this.header.data = this.header.data - 1;
	
	}
	else{
	    output = null;
	}
	
	
	return output;
    }
    public void push(Node input){
	// AUthor: Dustin Hu
	// Date: 1-12-2014
	// Purpose: To push a new node into the front of the list
	// Input: THe node to push
	// Output: None

	input.left = this.header;
	input.right = this.header.right;

	this.header.right.left = input;
	this.header.right = input;
	

	this.header.data = this.header.data + 1;
    }
    public CircularList splitInTwo(){
    	// Autohr: Dusitn Hu
    	// Date: 1-12-2014
    	// Purpose: To split the list in two if there are an even number of nodes, otherwise, return null
    	// Input: None
    	// OUtput: A circularlist, split in two.
	
    	CircularList output;
    	if (this.numNodes() % 2 != 0){
    	    output = null;
    	}
    	else if (this.numNodes() > 0){
    	    output = new CircularList(0);
    	    for (int i = 0; i < (this.numNodes() / 2) + 1; i++){
		output.push(this.pop());
    	    }
    	}
	else{
	    output = null;
	}

	return output;
    }
    public void delete(int data){
	// Author: Dustin Hu
	// Date: 1-12-2014
	// Purpoes: To delet a node
	// Input: The node to delet's data
	// OUtput: None
	Node input;
	if (this.inList(data)){
	    input = this.find(data);
	    input.left.right = input.right;
	    input.right.left = input.left;
	    this.header.data = this.header.data - 1;
	}
    }

    
}
