/**
 * 
 */

/**
 * @author rahul *
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

class Node{
	String state;
	String parent;
	int heuristic;
	int level;
	int fvalue;
	
	public String getState(){
		return this.state;
	}
	public void setState(String state){
		this.state=state;
	}
	public String getParent(){
		return this.parent;
	}
	public void setParent(String parent){
		this.parent=parent;
	}
	public int getHeuristic(){
		return this.heuristic;
	}
	public void setHeuristic(int heuristic){
		this.heuristic=heuristic;
	}
	public int getLevel(){
		return this.level;
	}
	public void setLevel(int level){
		this.level=level;
	}
	public int getFvalue(){
		return this.fvalue;
	}
	public void setFvalue(int fvalue){
		this.fvalue=fvalue;
	}

	public int calculateHeuristic(String goal){
		
		int heuristic = 0;
		String str = this.getState();
		
		int diff = 0;
		
		if(str.charAt(0)!='1'){
			if(str.charAt(0)=='0'){
				diff+=2;
			}else if(str.charAt(0)=='2'){
				diff+=1;
			}else if(str.charAt(0)=='3'){
				diff+=2;
			}else if(str.charAt(0)=='4'){
				diff+=3;
			}else if(str.charAt(0)=='5'){
				diff+=4;
			}else if(str.charAt(0)=='6'){
				diff+=3;
			}else if(str.charAt(0)=='7'){
				diff+=2;
			}else if(str.charAt(0)=='8'){
				diff+=1;
			}
		}
		
		if(str.charAt(1)!='2'){
			if(str.charAt(1)=='0'){
				diff+=1;
			}else if(str.charAt(1)=='1'){
				diff+=1;
			}else if(str.charAt(1)=='3'){
				diff+=1;
			}else if(str.charAt(1)=='4'){
				diff+=2;
			}else if(str.charAt(1)=='5'){
				diff+=3;
			}else if(str.charAt(1)=='6'){
				diff+=2;
			}else if(str.charAt(1)=='7'){
				diff+=3;
			}else if(str.charAt(1)=='8'){
				diff+=2;
			}
		}
			
		if(str.charAt(2)!='3'){
			if(str.charAt(2)=='0'){
					diff+=2;
			}else if(str.charAt(2)=='1'){
					diff+=2;
			}else if(str.charAt(2)=='2'){
					diff+=1;
			}else if(str.charAt(2)=='4'){
					diff+=1;
			}else if(str.charAt(2)=='5'){
					diff+=2;
			}else if(str.charAt(2)=='6'){
					diff+=3;
			}else if(str.charAt(2)=='7'){
					diff+=4;
			}else if(str.charAt(2)=='8'){
					diff+=3;
			}
			
		}
		
		if(str.charAt(3)!='8'){
			if(str.charAt(3)=='0'){
					diff+=1;
			}else if(str.charAt(3)=='1'){
					diff+=1;
			}else if(str.charAt(3)=='2'){
					diff+=2;
			}else if(str.charAt(3)=='3'){
					diff+=3;
			}else if(str.charAt(3)=='4'){
					diff+=2;
			}else if(str.charAt(3)=='5'){
					diff+=3;
			}else if(str.charAt(3)=='7'){
					diff+=1;
			}else if(str.charAt(3)=='6'){
					diff+=2;
			}
			
		}
		
		if(str.charAt(4)!='0'){    
		    if(str.charAt(4)=='1'){
					diff+=2;
			}else if(str.charAt(4)=='2'){
					diff+=1;
			}else if(str.charAt(4)=='3'){
					diff+=2;
			}else if(str.charAt(4)=='4'){
					diff+=1;
			}else if(str.charAt(4)=='5'){
					diff+=2;
			}else if(str.charAt(4)=='6'){
					diff+=1;
			}else if(str.charAt(4)=='7'){
					diff+=2;
			}else if(str.charAt(4)=='8'){
					diff+=1;
			}
		}
	
	   if(str.charAt(5)!='4'){
		   if(str.charAt(5)=='0'){
			        diff+=1;
	       }else if(str.charAt(5)=='1'){
	    	   		diff+=3;
	       }else if(str.charAt(5)=='2'){
	    	   		diff+=2;
	       }else if(str.charAt(5)=='3'){
	    	   		diff+=1;
	       }else if(str.charAt(5)=='8'){
	    	   		diff+=2;
	       }else if(str.charAt(5)=='5'){
	    	   		diff+=1;
	       }else if(str.charAt(5)=='7'){
	    	   		diff+=3;
	       }else if(str.charAt(5)=='6'){
					diff+=2;
   	       }
        }
	   
	   if(str.charAt(6)!='7'){
		   if(str.charAt(6)=='0'){
			        diff+=2;
	       }else if(str.charAt(6)=='1'){
	    	   		diff+=2;
	       }else if(str.charAt(6)=='2'){
	    	   		diff+=3;
	       }else if(str.charAt(6)=='3'){
	    	   		diff+=4;
	       }else if(str.charAt(6)=='8'){
	    	   		diff+=1;
	       }else if(str.charAt(6)=='5'){
	    	   		diff+=2;
	       }else if(str.charAt(6)=='4'){
	    	   		diff+=3;
	       }else if(str.charAt(6)=='6'){
					diff+=1;
   	       }
        }
	   
	   if(str.charAt(7)!='6'){
		   if(str.charAt(7)=='0'){
			        diff+=1;
	       }else if(str.charAt(7)=='1'){
	    	   		diff+=3;
	       }else if(str.charAt(7)=='2'){
	    	   		diff+=2;
	       }else if(str.charAt(7)=='3'){
	    	   		diff+=3;
	       }else if(str.charAt(7)=='8'){
	    	   		diff+=2;
	       }else if(str.charAt(7)=='5'){
	    	   		diff+=1;
	       }else if(str.charAt(7)=='4'){
	    	   		diff+=2;
	       }else if(str.charAt(7)=='7'){
					diff+=1;
   	       }
        }
	   
	   if(str.charAt(8)!='5'){
		   if(str.charAt(8)=='0'){
			        diff+=2;
	       }else if(str.charAt(8)=='1'){
	    	   		diff+=4;
	       }else if(str.charAt(8)=='2'){
	    	   		diff+=3;
	       }else if(str.charAt(8)=='3'){
	    	   		diff+=2;
	       }else if(str.charAt(8)=='8'){
	    	   		diff+=3;
	       }else if(str.charAt(8)=='7'){
	    	   		diff+=2;
	       }else if(str.charAt(8)=='4'){
	    	   		diff+=1;
	       }else if(str.charAt(8)=='6'){
					diff+=1;
   	       }
        }
	   
		/*for(int i=0; i<str.length();i++){
			if(i!=8 && str.charAt(i)!=i+1){
		
				diff += str. 
			}
		}*/
		
		return heuristic;
	}
}

//Comparator used by the priority queue to sort the elements in non decreasing order.
class HeuristicComparator implements Comparator, Serializable{

	public int compare(Object o1, Object o2){
		
		if(((Node)o1).getFvalue() < ((Node)o2).getFvalue()){
			return -1;
		}else if(((Node)o1).getFvalue() > ((Node)o2).getFvalue()){
			return 1;
		}else{
			return 0;
		}
			
	}
	
}


public class BestFirstEightPuzzle {
		
	String goal = "123804765";
	int count = 0;
	
	Comparator comparator = new HeuristicComparator();

	PriorityQueue<Node> pq = new PriorityQueue<Node>(100000, comparator);

	//Queue<Node> q = new LinkedList<Node>();    
	Map<String,Integer> map = new HashMap<String, Integer>(); // HashMap is used to ignore repeated nodes
	Map<String, String> parentMap = new HashMap<String, String>();
	Stack<String> path = new Stack();
	
	/**
	 * @param args
	 */
	public static void main(String args[]){
		
		
		String str="074685132";	//078465132				// Initial Board State as a String with 0 as the Blank Space 
		Node top=new Node();
		Node node = new Node();
		int h = 0;
		int f = 0;
		
		
		System.out.println("Start state: "+str);
		for(int i=0;i<str.length();i++){
			if(i%3==0){
				System.out.println("");
			}
			System.out.print(str.charAt(i)+"\t");
		}
		
		BestFirstEightPuzzle e = new BestFirstEightPuzzle(); 		
		node.setState(str);
		node.setParent(null);
		node.setLevel(0);
		h = node.calculateHeuristic(e.goal);
		f = h;
		node.setHeuristic(h);
		node.setFvalue(f);
		
		e.add(node,0); 							
		
		while(e.pq.peek()!=null){
			
			e.up(e.pq.peek());					// Move the blank space up and add new state to queue
			e.down(e.pq.peek());					// Move the blank space down 
			e.left(e.pq.peek());					// Move left
			e.right(e.pq.remove());             // Move right and remove the current node from Queue
			e.count++;
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
			pq.add(node);
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
			newState.setLevel(node.getLevel()+1);
			newState.setHeuristic(newState.calculateHeuristic(goal));
			newState.setFvalue(newState.getHeuristic() + newState.getLevel());
			add(newState,map.get(str)+1);
			//add(s,map.get(str)+1);
			if(s.equals("123804765")) {
				System.out.println("Solution found "+this.count);//after searching through "+map.get(s)+" states of the tree");
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
			newState.setLevel(node.getLevel()+1);
			newState.setHeuristic(newState.calculateHeuristic(goal));
			newState.setFvalue(newState.getHeuristic() + newState.getLevel());
			add(newState,map.get(str)+1);
			if(s.equals("123804765")) {
				System.out.println("Solution found "+this.count); //after searching through "+map.get(s)+" states of the tree");
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
			newState.setLevel(node.getLevel()+1);
			newState.setHeuristic(newState.calculateHeuristic(goal));
			newState.setFvalue(newState.getHeuristic() + newState.getLevel());
			add(newState,map.get(str)+1);
			if(s.equals("123804765")) {
				System.out.println("Solution found after "+this.count); //searching through "+map.get(s)+" states of the tree");
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
			newState.setLevel(node.getLevel()+1);
			newState.setHeuristic(newState.calculateHeuristic(goal));
			newState.setFvalue(newState.getHeuristic() + newState.getLevel());
			add(newState,map.get(str)+1);
			if(s.equals("123804765")) {
				System.out.println("Solution found after " + this.count); //searching through "+map.get(s)+" states of the tree");
				printSolution();
				System.exit(0);
			}
		}
	}
		
	public void printSolution(){
		String currState = "123804765";
		File file = new File("solution_bestfirst.txt");
		int no = 0;
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
			no++;	
			fw.write(path.pop());
			fw.write("\n");
			}
			System.out.println("path consists of "+no+" states.");
	fw.close();
		}catch(IOException ie){
			ie.printStackTrace();	
		 }
		finally{
			
		}
		}
	
	
}
