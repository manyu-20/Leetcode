class MyCircularQueue {
    int arr[];
    int front = 0;
    int rear = -1;
    int len=0;
    

    public MyCircularQueue(int k) {
        arr = new int[k];
        
        
        
    }
    
    public boolean enQueue(int value) {
        if(!isFull()){
            
            rear = (rear+1)%arr.length;
            arr[rear] = value;
            len++;
            return true;
        }
        return false;
        
    }
    
    public boolean deQueue() {
        if(!isEmpty()){
            
            front = (front+1)%arr.length;
            len--;
            return true;
        }
        return false;
        
    }
    
    public int Front() {
        return isEmpty()? -1 : arr[front];
        
    }
    
    public int Rear() {
        return isEmpty()? -1 : arr[rear];
    }
    
    public boolean isEmpty() {
        return len==0;
        
    }
    
    public boolean isFull() {
        return len == arr.length;
    }
}