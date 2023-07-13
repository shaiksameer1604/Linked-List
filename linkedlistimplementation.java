class Node{
    public Object item;
    public Node next;//pointing to next node
}
public class linkedlistimplementation {
    private int size;
    private Node head;

   public linkedlistimplementation(){
        this.size=0;
        this.head= null;   
   }
   public void insertingnode(String i){
    Node node= new Node();
    node.item= i;
    Node current=this.head;
    if (this.head==null){
        this.head=node;
        this.head.next= null;
        this.size=1;
        System.out.println(this.head.toString());
    }else{
        while(current.next!=null){
            current=current.next;
        }
        current.next=node;
        node.next=null;
        this.size+=1;
    }
   }
   public void addAtStarting(String i)
	{
		Node node=new Node();
		node.item=i;
		node.next=this.head;
		this.head=node;
        this.size += 1;
	}
    public void addAtMiddle(String i,int pos)
	{
		Node node=new Node();
        node.item=i;
		Node current=this.head;
		if(this.head!=null && pos<=this.size)
		{
			for(int j=0;j<pos-1;j++) {
				current=current.next;
			}
			node.next=current.next;
			current.next=node;
			this.size+=1;
		}
		else
		{
			System.out.println("position is greater than size");
		}
	}
    public void deleteFirstNode(){
        if(this.head == null){
            System.out.println("Linked list does not contain any elements..");
        }else{
            Node current;
            if(this.head.next == null){
                this.head = null;// if linked list contains only one elements it will be deleted and head = null;
            }else{
                current = this.head.next;
                this.head = null;
                this.head = current;
                this.size -=1;
            }
        }
    }
    public void deleteLastNode(){
        if(this.head == null){
            System.out.println("Linked list does not contain any elements..");
        }else{
            Node current;
            current = this.head;
            while(current.next.next != null){
                current = current.next;
            }
            current.next = null;
            this.size -=1;
        }
    }
    public void deleteAtMiddle(int pos){
        if(this.head == null && pos > this.size){
            System.out.println("Linked list does not contain any elements..");
        }else{
            Node current = this.head;
            for(int i= 0; i <pos-1; i++){
                current = current.next;
            }
            Node  p = current.next;// the node that going to be deleted
            current.next = current.next.next;
            //current = current.next;
            p.next = null;
            this.size -=1;
        }
    }
    public void find(String value){
        Node current = this.head;
        boolean flag = false;
        for(int i = 0; i < size; i++){
            if(current.item.equals(value)){
                System.out.println("Element is found at index : "+i);
                flag =true;
                break;
            }
            current = current.next;
        }
        if(!flag){
            System.out.println("The element is not found in the LinkedList");
        }
    }
    public void traverse(){
        
        if(this.head == null){
             System.out.println("Linked List is empty");
        }else{
            Node current = this.head;
            System.out.println("The element  in the LinkedList are :");
            for(int i = 0; i < size; i++){
                System.out.println(current.item+" ");
                current = current.next;
            }   
        }
    }
    public static void main(String[] args) {
        linkedlistimplementation llist = new linkedlistimplementation();
        llist.insertingnode("sharuk");
        llist.insertingnode("veera");
        llist.insertingnode("sathya");
        llist.insertingnode("suneel");
        llist.traverse();
        llist.addAtStarting("prabhas");
        llist.traverse();
        llist.addAtMiddle("prasad", 2);
        llist.traverse();
        llist.deleteFirstNode();
        llist.traverse();
        llist.deleteLastNode();
        llist.traverse();
        llist.deleteAtMiddle(1);
        llist.traverse();
        llist.find("sharuk");
        llist.traverse();
        llist.insertingnode("shannu");
        llist.traverse();
    }
}