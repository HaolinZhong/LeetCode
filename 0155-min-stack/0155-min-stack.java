class MinStack {

    private Stack<int[]> s;
    
    
    public MinStack() {
        this.s = new Stack<>();
    }
    
    public void push(int val) {
        int curMin;
        if (s.isEmpty()) {
            curMin = val;
        } else {
            curMin = Math.min(getMin(), val);
        }
        s.push(new int[]{val, curMin});
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek()[0];
    }
    
    public int getMin() {
        return s.peek()[1];
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