package kaer;



import java.util.Stack;

abstract   class testStack {
    public static void main(String[] args) {
       String s = "ssss";
       //创建一个时间对列
        Stack<String> timeStack = new Stack<>();
        //压栈操作:push 将元素压入栈顶
        timeStack.push("你好");
        timeStack.push("老王");
        //弹栈:pop  从栈顶弹出元素
        System.out.println("弹出栈顶元素:" + timeStack.pop());
        //获取栈顶元素：查看但不移除栈顶元素
        System.out.println("查看栈顶元素:"+timeStack.peek());
        //检查栈中是否有元素
        System.out.print("检查栈中是否有元素:"+timeStack.isEmpty());
        //检查栈中的元素个数
        System.out.println("检查栈中元素的个数:"+ timeStack.size());


    }
}
