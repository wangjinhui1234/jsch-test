package AnonymousInner.impelementClass;
import javax.swing.*;
import java.awt.event.*;

public class AnonymousClassExample2 {
    public static void main(String[] args) {
        // 创建一个简单的 JFrame 窗口
        JFrame frame = new JFrame("匿名内部类示例");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建一个按钮
        JButton button = new JButton("点击我");

        // 使用匿名内部类继承 MouseAdapter 类，并重写 mouseClicked 方法
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("按钮被点击了！");
            }
        });

        // 将按钮添加到窗口
        frame.add(button);
        frame.setVisible(true);
    }
}
