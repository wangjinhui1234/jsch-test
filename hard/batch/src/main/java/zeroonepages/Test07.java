package zeroonepages;

import java.util.ArrayList;

public class Test07 {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        Player player = new Player();
        player.guess();
        int s = player.number;
        System.out.println(s);
    }
}
class Player{
    int number = 0;
    public void guess(){
        number = (int)(Math.random() * 10);
        System.out.println("I'm guess" + number );
    }
}