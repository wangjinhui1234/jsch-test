package recursiveTraversal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solustion {
  /* 1、确定递归函数的参数和返回值
   2、确定种植条件
   3、确定单层递归的逻辑*/
    //中前后 前序遍历

    @Test
    public void qianMethod(TreeNode treeNode) {
        List list = new ArrayList<Integer>();
        traversql(treeNode, list);
    }

    //前序遍历
    public void traversql(TreeNode treeNode, List list) {
        if (treeNode == null) {
            return;
        }
        list.add(treeNode.val);
        qianMethod(treeNode.left);
        qianMethod(treeNode.right);
    }

    //非递归，迭代法

    @Test
    public void diedai(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        test(treeNode, stack);
    }

    public static void test(TreeNode treeNode, Stack<TreeNode> stack) {
        ArrayList<Integer> result = new ArrayList<>();
        stack.push(treeNode);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            stack.pop();
            if (node != null) {
                result.add(node.val);
            } else {
                continue;
            }
            stack.push(node.left);
            stack.push(node.right);
            Collections.reverse(result);
        }
    }


}
