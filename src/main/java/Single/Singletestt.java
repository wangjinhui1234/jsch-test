package Single;

public class Singletestt {
    //懒汉式线程线程安全
    private static  volatile  Singletestt people = null;
    private Singletestt(){}


    public void getSingle(){
        if (people == null){
          synchronized(Singletestt.class){
              if (people == null){
                  people = new Singletestt();
              }
          }
        }
    }
}
