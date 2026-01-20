class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;
    public MinStack() {
        st= new Stack<>();
        min= new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(min.isEmpty() || min.peek()>=val){
            min.push(val);
        }
    }
    
    public void pop() {
        int temp=0;
        if(!st.isEmpty()){
            temp = st.pop();
        }
        if(temp==min.peek()){
            min.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        // int min=Integer.MAX_VALUE;
        // while(!st.isEmpty()){
        //     int temp = st.pop();
        //     if(min>temp){
        //         min=temp;
        //     }
        // }
        // return min;

        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */