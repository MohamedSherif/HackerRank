package imp;

import java.util.HashMap;
import java.util.Scanner;

public class Contacts {

	/* This implementation is somewhat based off the tutorial video in this problem */
	private static class ArrayTrieNode{
		private static int NUMBER_OF_CHARACTERS = 26;
		ArrayTrieNode[] children = new ArrayTrieNode[NUMBER_OF_CHARACTERS];
		
//		public HashMap<Character, TrieNode> children = new HashMap<>();
        
		int size = 0; // this was the main trick to decrease runtime to pass tests.
        
//        public void addChild(Character ch) {
//            children.put(ch, new TrieNode());
//        }
		
		private static int getCharIndex(char c){
			return c - 'a';	
		}
		
		private ArrayTrieNode getNode(char c){
			return children[getCharIndex(c)];
		}
		
		private void setNode(char c, ArrayTrieNode node){
			children[getCharIndex(c)] = node;
		}
		
		public void add(String s){
			add(s, 0);
		}
		
		private void add(String s, int index){
			size++;
			if(index == s.length()) return;
			
			char current = s.charAt(index);
//			int charCode = getCharIndex(current);
			
			ArrayTrieNode child = getNode(current);
			if(child == null){
				child = new ArrayTrieNode();
				setNode(current, child);
			}
			child.add(s, index+1);
		}
		
		public int findCount(String s, int index){
			if(index == s.length()){
				return size;
			}
			ArrayTrieNode child = getNode(s.charAt(index));
			
			if(child == null){
				return 0;
			}
			
			return child.findCount(s, index+1);
		}
	}
	
	
	/* This implementation is somewhat based off the tutorial video in this problem */
	private static class HashMapTrieNode{
		public HashMap<Character, HashMapTrieNode> children = new HashMap<>();
		int size = 0; // this was the main trick to decrease runtime to pass tests.
        
//        public void addChild(Character ch) {
//            children.put(ch, new TrieNode());
//        }
		
		private HashMapTrieNode getNode(char c){
			return children.get(c);
		}
		
		private void setNode(char c, HashMapTrieNode node){
			children.put(c,node);
		}
		
		public void add(String s){
			add(s, 0);
		}
		
		private void add(String s, int index){
			size++;
			if(index == s.length()) return;
			
			char current = s.charAt(index);
			
			HashMapTrieNode child = getNode(current);
			if(child == null){
				child = new HashMapTrieNode();
				setNode(current, child);
			}
			child.add(s, index+1);
		}
		
		public int findCount(String s, int index){
			if(index == s.length()){
				return size;
			}
			HashMapTrieNode child = getNode(s.charAt(index));
			
			if(child == null){
				return 0;
			}
			
			return child.findCount(s, index+1);
		}
	}
	
	private static void addName(String name){
		
	}
	
	private static int finPartial(String partial){
		int count = 0;
		
		
		return count;
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
//        ArrayTrieNode node = new ArrayTrieNode();
        
        HashMapTrieNode node = new HashMapTrieNode();
        
        for(int a0 = 0; a0 < t; a0++){
            String fnctn = in.next();
            String name = in.next();
            if(fnctn.equalsIgnoreCase("add")){
            	node.add(name);
            }else if(fnctn.equalsIgnoreCase("find")){
            	System.out.println(node.findCount(name, 0));
            }
        }
    }
}
