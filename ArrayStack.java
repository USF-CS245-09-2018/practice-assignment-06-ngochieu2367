public class ArrayStack implements Stack{
	private Object[] array;
	private int top;

	public ArrayStack(){
		top = 0;
		array = new Object[10];
	}

	public void push(Object obj){
		if(top == array.length)
			double_array_size();
		array[top++] = obj;
	}

	public void double_array_size(){
		Object[] new_array = new Object[array.length*2];
		for(int i = 0; i < array.length; i++){
			new_array[i] = array[i];
		}
		array = new_array;
	}

	public Object pop(){
		if(empty()){
			return null;
		}
		return array[--top];
	}

	public boolean empty(){
		return top == 0;
	}

	public Object peek(){
		if(empty()){
			return null;
		}
		return array[top];
	}

	
}