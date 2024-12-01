package kaer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

public class testQue {
    public static void main(String[] args) {
        try {
            //基于双向链表实现的队列
            Queue<String> queue = new LinkedList<>();
            queue.peek();
            String str = "/home/ap/dkbs/qwertyuiop";
            int i = str.lastIndexOf("/") -1;
            System.out.println(i);
            String str1= "uiop";
            if (str.contains(str1)){
                System.out.println("存在包含关系");
            }else {
                System.out.println("不包含竟然");
            }
            Stack<Character> chars = new Stack()  ;

            System.out.println();
            ArrayList<String> list = new ArrayList<>();


            //是基于可调整大小的数组实现的双端队列
            Queue<String> arrQue = new ArrayBlockingQueue<>(1);
            arrQue.offer("nihao");
            queue.peek();
            //arrQue.add("laowang");
            System.out.println("查看队列的首个元素:"+ arrQue.element());
            System.out.println(arrQue.peek());
           // arrQue.peek()
            System.out.println(queue.peek());
            System.out.println("peek -->" + queue.peek());
            System.out.println("element -->" + queue.element());
            System.out.println("将一个元素放入队列尾部:" + arrQue );
        }catch (Exception e){
            System.out.println("add异常:" + e);
        }finally {

        }

    }
}
