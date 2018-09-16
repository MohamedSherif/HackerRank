package trees;

public class Node {
    public Node left;
    public Node right;
    public int data;
    
   public Node(int data) {
        this.data = data;
        left = null;
        right = null;
   }
   
   public void insert(int value){
	   if(value <= data){
		   if(left == null)
			   left = new Node(value);
		   else
			   left.insert(value);
	   }else{
		   if(right == null)
			   right = new Node(value);
		   else
			   right.insert(value);
	   }
   }
   
   public boolean contains(int value){
	   if(data == value){
		   return true;
	   }else{
		   if(value < data){
			   if(left == null){
				   return false;
			   }else{
				   return left.contains(value);
			   }
		   }else{
			   if(right == null){
				   return false;
			   }else{
				   return right.contains(value);
			   }
			   
		   }
	   }
   }
   
   public void prinInOrder(){
	   if(left != null){
		   left.prinInOrder();
	   }
	   
	   System.out.println(data);
	   
	   if(right != null){
		   right.prinInOrder();
	   }
   }
   
   public void prinPreOrder(){
	   System.out.println(data);
	   
	   if(left != null){
		   left.prinInOrder();
	   }
	   
	   if(right != null){
		   right.prinInOrder();
	   }
   }
   
   public void prinPostOrder(){
	   if(left != null){
		   left.prinInOrder();
	   }
	   
	   if(right != null){
		   right.prinInOrder();
	   }
	   System.out.println(data);
   }
   
}
