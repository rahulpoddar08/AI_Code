import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 
 */

/**
 * @author rahul
 *
 */

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
		
		int heuristic=0;
		
		//bbb0www
		if(goal.charAt(0)=='b'){
			heuristic+=1;
		}
		if(goal.charAt(1)=='b'){
			heuristic+=1;
		}
		if(goal.charAt(2)=='b'){
			heuristic+=1;
		}
		if(goal.charAt(4)=='w'){
			heuristic+=1;
		}
		if(goal.charAt(5)=='w'){
			heuristic+=1;
		}
		if(goal.charAt(6)=='w'){
			heuristic+=1;
		}
		return heuristic;
	}
}

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

public class SlidingTileBestFirst {

	String goal = "www0bbb";
	
	Comparator comparator = new HeuristicComparator();

	PriorityQueue<Node> pq = new PriorityQueue<Node>(100000, comparator);

	//Queue<Node> q = new LinkedList<Node>();    
	Map<String,Integer> map = new HashMap<String, Integer>(); // HashMap is used to ignore repeated nodes
	Map<String, String> parentMap = new HashMap<String, String>();
	Stack<String> path = new Stack();
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str="bbb0www";
		
		Node top=new Node();
		Node node = new Node();
		int h = 0;
		int f = 0;
		
		SlidingTileBestFirst e = new SlidingTileBestFirst(); 		
		node.setState(str);
		node.setParent(null);
		node.setLevel(0);
		h = node.calculateHeuristic(e.goal);
		f = h;
		node.setHeuristic(h);
		node.setFvalue(f);
		
		e.add(node,0); 							
		
		while(e.pq.peek()!=null){
			
			e.leftjump1(e.pq.peek());					// Move the blank space up and add new state to queue
			e.rightjump1(e.pq.peek());					// Move the blank space down 
			e.left(e.pq.peek());					// Move left
			e.right(e.pq.peek());				// Move right and remove the current node from Queue
			e.leftjump2(e.pq.peek());
			e.rightjump2(e.pq.remove());
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

	void left(Node node){
		String str = node.getState();
		String parent = node.getParent();
		Node newState = new Node();
		int a = str.indexOf("0");
		char temp;
		char[] s = str.toCharArray();
		String newStr;
		
		if(a!=0){
			temp = s[a-1];
			s[a-1]='0';
			s[a]=temp;
			newStr = this.gString(s);
			newState.setState(newStr);
			newState.setParent(str);
			newState.setLevel(node.getLevel()+1);
			newState.setHeuristic(newState.calculateHeuristic(goal));
			newState.setFvalue(newState.getHeuristic() + newState.getLevel());
			add(newState,map.get(str)+1);
			//add(s,map.get(str)+1);
			if(newStr.equals("www0bbb")) {
				System.out.println("Solution found after searching through "+map.get(newStr)+" states of the tree");
				printSolution();
				System.exit(0);
			}
		}
 
	}
	
	void leftjump1(Node node){
		String str = node.getState();
		String parent = node.getParent();
		Node newState = new Node();
		int a = str.indexOf("0");
		char temp;
		char[] s = str.toCharArray();
		String newStr;
		
		if(a!=0 && a!=1){
			temp = s[a-2];
			s[a-2]='0';
			s[a]=temp;
			newStr = this.gString(s);
			newState.setState(newStr);
			newState.setParent(str);
			newState.setLevel(node.getLevel()+1);
			newState.setHeuristic(newState.calculateHeuristic(goal));
			newState.setFvalue(newState.getHeuristic() + newState.getLevel());
			add(newState,map.get(str)+1);
			//add(s,map.get(str)+1);
			if(newStr.equals("www0bbb")) {
				System.out.println("Solution found after searching through "+map.get(newStr)+" states of the tree");
				printSolution();
				System.exit(0);
			}
		}
 
	}
	
	void leftjump2(Node node){
		String str = node.getState();
		String parent = node.getParent();
		Node newState = new Node();
		int a = str.indexOf("0");
		char temp;
		char[] s = str.toCharArray();
		String newStr;
		
		if(a!=0 && a!=1 && a!=2){
			temp = s[a-3];
			s[a-3]='0';
			s[a]=temp;
			newStr = this.gString(s);
			newState.setState(newStr);
			newState.setParent(str);
			newState.setLevel(node.getLevel()+1);
			newState.setHeuristic(newState.calculateHeuristic(goal));
			newState.setFvalue(newState.getHeuristic() + newState.getLevel());
			add(newState,map.get(str)+1);
			//add(s,map.get(str)+1);
			if(newStr.equals("www0bbb")) {
				System.out.println("Solution found after searching through "+map.get(newStr)+" states of the tree");
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
		char temp;
		char[] s = str.toCharArray();
		String newStr;
		
		if(a!=6){
			temp = s[a+1];
			s[a+1]='0';
			s[a]=temp;
			newStr = this.gString(s);
			newState.setState(newStr);
			newState.setParent(str);
			newState.setLevel(node.getLevel()+1);
			newState.setHeuristic(newState.calculateHeuristic(goal));
			newState.setFvalue(newState.getHeuristic() + newState.getLevel());
			add(newState,map.get(str)+1);
			//add(s,map.get(str)+1);
			if(newStr.equals("www0bbb")) {
				System.out.println("Solution found after searching through "+map.get(newStr)+" states of the tree");
				printSolution();
				System.exit(0);
			}
		}
 
	}
	
	void rightjump1(Node node){
		String str = node.getState();
		String parent = node.getParent();
		System.out.println("rightjump1 str: "+str);
		Node newState = new Node();
		int a = str.indexOf('0');
		System.out.println("index: "+a);
		char temp;
		char[] s = str.toCharArray();
		String newStr;
		
		if(a!=5 && a!=6){
			temp = s[a+2];
			s[a+2]='0';
			s[a]=temp;
			newStr = this.gString(s);
			System.out.println("newStr: "+newStr);
			newState.setState(newStr);
			newState.setParent(str);
			newState.setLevel(node.getLevel()+1);
			newState.setHeuristic(newState.calculateHeuristic(goal));
			newState.setFvalue(newState.getHeuristic() + newState.getLevel());
			add(newState,map.get(str)+1);
			//add(s,map.get(str)+1);
			if(newStr.equals("www0bbb")) {
				System.out.println("Solution found after searching through "+map.get(newStr)+" states of the tree");
				printSolution();
				System.exit(0);
			}
		}
 
	}
	
	void rightjump2(Node node){
		String str = node.getState();
		String parent = node.getParent();
		Node newState = new Node();
		int a = str.indexOf("0");
		char temp;
		char[] s = str.toCharArray();
		String newStr;
		
		if(a!=4 && a!=5 && a!=6){
			temp = s[a+3];
			s[a+3]='0';
			s[a]=temp;
			newStr = this.gString(s);
			newState.setState(newStr);
			newState.setParent(str);
			newState.setLevel(node.getLevel()+1);
			newState.setHeuristic(newState.calculateHeuristic(goal));
			newState.setFvalue(newState.getHeuristic() + newState.getLevel());
			add(newState,map.get(str)+1);
			//add(s,map.get(str)+1);
			if(newStr.equals("www0bbb")) {
				System.out.println("Solution found after searching through "+map.get(newStr)+" states of the tree");
				printSolution();
				System.exit(0);
			}
		}
 
	}
	
	public void printSolution(){
		String currState = "www0bbb";
		File file = new File("solution_bestfirst.txt");
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
	
	public String gString(char[] s){
		
		String str = null;
		StringBuffer strBuf = new StringBuffer();
		
		for(int i=0;i<s.length;i++){
			strBuf.append(s[i]);
		}
		str = strBuf.toString();
		
		return str;
	}
	
}
