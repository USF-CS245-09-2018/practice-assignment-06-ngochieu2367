public class ArrayQueue implements Queue{
	int head;
	int tail;
	Object[] array;

	public ArrayQueue(){
		array = new Object[10];
		head = 0;
		tail = 0;
	}

	public void grow_array(){
		Object [] newArray = new Object[array.length * 2];
		tail = 0;
		for(int i = head ; i < array.length - head ; i++){
			newArray[tail++] = array[i % array.length];
		}
		// Update head and tail after resize. 
		head = 0;
		tail = array.length-1;
		array = newArray;
		
	}

	public void enqueue(Object obj){
		if((tail+1) % array.length == head){
			grow_array();
		}
		array[tail++] = obj;
		if(tail >= array.length){
			tail = 0;
		}

	}

	public Object dequeue(){
		Object obj = array[head];
		head++;
		//head = head % array.length;
		if(head == array.length){
			head = 0;
		}
		return obj;
	}

	public boolean empty(){
		if(head == tail){
			return true;
		}
		return false;
	}

}