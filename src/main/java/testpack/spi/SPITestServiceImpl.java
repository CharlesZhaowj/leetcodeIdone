package testpack.spi;

public class SPITestServiceImpl implements SPITestService {
    @Override
    public void execute() {
        System.out.println("SPITestServiceImpl.execute()");
    }
}
