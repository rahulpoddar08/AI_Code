/**
 * @author rahul *
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Node{
	String state;
	String parent;
	
	public String getState(){
		return this.state;
	}
	public String getParent(){
		return this.parent;
	}
	public void setState(String state){
		this.state=state;
	}
	public void setParent(String parent){
		this.parent=parent;
	}
}

public class BFSEightPuzzle {
	
	Queue<Node> q = new LinkedList<Node>();    
	Map<String,Integer> map = new HashMap<String, Integer>(); // HashMap is used to ignore repeated nodes
	Map<String, String> parentMap = new HashMap<String, String>();
	Stack<String> path = new Stack();
	
	/**
	 * @param args
	 */
	public static void main(String args[]){
		
		
		String str="074685132";	//078465132		087465132		// Initial Board State as a String with 0 as the Blank Space 
		Node top=new Node();
		Node node = new Node();
		
		System.out.println("Start state: "+str);
		for(int i=0;i<str.length();i++){
			if(i%3==0){
				System.out.println("");
			}
			System.out.print(str.charAt(i)+"\t");
		}
		BFSEightPuzzle e = new BFSEightPuzzle(); 		
		node.setState(str);
		node.setParent(null);
		e.add(node,0); 							
		
		while(e.q.peek()!=null){
			
			e.up(e.q.peek());					// Move the blank space up and add new state to queue
			e.down(e.q.peek());					// Move the blank space down 
			e.left(e.q.peek());					// Move left
			e.right(e.q.remove());				// Move right and remove the current node from Queue
		}
		System.out.println("Solution doesn't exist");
	}
	
	void add(Node node,int n){
		String tempState="";
		String tempParent="";
		if(node!=null){
			tempState = node.getState();
			tempParent = node.getParent();
		}
		if(!map.containsKey(tempState)){
			map.put(tempState,n);
			parentMap.put(tempState,tempParent);
			q.add(node);
		}
	}
	
	
	void up(Node node){
		String str = node.getState();
		String parent = node.getParent();
		Node newState = new Node();
		int a = str.indexOf("0");
		if(a>2){
			String s = str.substring(0,a-3)+"0"+str.substring(a-2,a)+str.charAt(a-3)+str.substring(a+1);
			newState.setState(s);
			newState.setParent(str);
			add(newState,map.get(str)+1);
			//add(s,map.get(str)+1);
			if(s.equals("123804765")) {
				System.out.println("Solution found at level "+map.get(s)+" of the tree");
				printSolution();
				System.exit(0);
			}
		}
	}
	void down(Node node){
		String str = node.getState();
		String parent = node.getParent();
		Node newState = new Node();
		int a = str.indexOf("0");
		if(a<6){
			String s = str.substring(0,a)+str.substring(a+3,a+4)+str.substring(a+1,a+3)+"0"+str.substring(a+4);
			newState.setState(s);
			newState.setParent(str);
			add(newState,map.get(str)+1);
			if(s.equals("123804765")) {
				System.out.println("Solution found after searching through "+map.get(s)+" states of the tree");
				printSolution();
				System.exit(0);
			}
		}
	}
	void left(Node node){
		String str = node.getState();
		String parent = node.getParent();
		Node newState = new Node();
		int a = str.indexOf("0");
		if(a!=0 && a!=3 && a!=6){
			String s = str.substring(0,a-1)+"0"+str.charAt(a-1)+str.substring(a+1);
			newState.setState(s);
			newState.setParent(str);
			add(newState,map.get(str)+1);
			if(s.equals("123804765")) {
				System.out.println("Solution found after searching through "+map.get(s)+" states of the tree");
				printSolution();
				System.exit(0);
			}
		}
	}
	void right(Node node){
		String str = node.getState();
		String parent = node.getParent();
		Node newState = new Node();
		int a = str.indexOf("0");
		if(a!=2 && a!=5 && a!=8){
			String s = str.substring(0,a)+str.charAt(a+1)+"0"+str.substring(a+2);
			newState.setState(s);
			newState.setParent(str);
			add(newState,map.get(str)+1);
			if(s.equals("123804765")) {
				System.out.println("Solution found after searching through "+map.get(s)+" states of the tree");
				printSolution();
				System.exit(0);
			}
		}
	}
		
	public void printSolution(){
		String currState = "123804765";
		File file = new File("solution_bfs.txt");
		try{
		FileWriter fw = new FileWriter(file);
		path.push(currState);
		while(parentMap.get(currState)!=null){
			//System.out.println("inside while, parentMap.get(currState)!=null");
			path.push(parentMap.get(currState));
			currState = parentMap.get(currState);
		}
		System.out.println("Solution path:");
				
			while(!path.empty()){
			//System.out.println("inside while, stack not empty");
			//System.out.println(path.pop());
			fw.write(path.pop());
			fw.write("\n");
			}
	fw.close();
		}catch(IOException ie){
			ie.printStackTrace();	
		 }
		finally{
			
		}
		}
	
}