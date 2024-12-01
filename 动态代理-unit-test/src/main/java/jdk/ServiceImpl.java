package jdk;

public class ServiceImpl implements MService {

    @Override
    public void execute() {
        System.out.println("Service is executing");
    }
}
