// Depth First Search for Eight Puzzle Problem.
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

class SlidingTileDFS{
	
	Stack<Node> s = new Stack();    
	Map<String,Integer> map = new HashMap<String, Integer>();   // HashMap is used to ignore repeated nodes
	Map<String, String> parentMap = new HashMap<String, String>();
	Stack<String> path = new Stack();
	
	public static void main(String args[]){
		
		
		String str= "bbb0www";//"087465132";		054832761			// Initial Board State as a String with 0 as the Blank Space 
     
		Node top=new Node();
		Node node = new Node();
		System.out.println("Start state: "+str);
		/*for(int i=0;i<str.length();i++){
			if(i%3==0){
				System.out.println("");
			}
			System.out.print(str.charAt(i)+"\t");
		}*/
		SlidingTileDFS e = new SlidingTileDFS(); 		
		node.setState(str);
		node.setParent(null);
		
		e.add(node,0);
		
		//e.s.push(str);
		while(!(e.s.empty())){
			top = e.s.pop();
			//node.setState(top);
			//node.setParent(null);
			e.left(top);					// Move the blank space up and add new state to queue
			e.leftjump1(top);
			e.leftjump2(top);
			e.right(top);					// Move the blank space down 
			e.rightjump1(top);					// Move left
			e.rightjump2(top);				// Move right and remove the current node from Queue
			
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
			//s.push(str);
			parentMap.put(tempState,tempParent);
			this.s.push(node);
			
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
			//newState.setLevel(node.getLevel()+1);
			//newState.setHeuristic(newState.calculateHeuristic(goal));
			//newState.setFvalue(newState.getHeuristic() + newState.getLevel());
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
			//newState.setLevel(node.getLevel()+1);
			//newState.setHeuristic(newState.calculateHeuristic(goal));
			//newState.setFvalue(newState.getHeuristic() + newState.getLevel());
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
			//newState.setLevel(node.getLevel()+1);
			//newState.setHeuristic(newState.calculateHeuristic(goal));
			//newState.setFvalue(newState.getHeuristic() + newState.getLevel());
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
			//newState.setLevel(node.getLevel()+1);
			//newState.setHeuristic(newState.calculateHeuristic(goal));
			//newState.setFvalue(newState.getHeuristic() + newState.getLevel());
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
			//newState.setLevel(node.getLevel()+1);
			//newState.setHeuristic(newState.calculateHeuristic(goal));
			//newState.setFvalue(newState.getHeuristic() + newState.getLevel());
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
			//newState.setLevel(node.getLevel()+1);
			//newState.setHeuristic(newState.calculateHeuristic(goal));
			//newState.setFvalue(newState.getHeuristic() + newState.getLevel());
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
		File file = new File("solution_slidingtile_dfs.txt");
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