package testpack.spi;

public class SPITestServiceImplBiteTheDust implements SPITestService{
    @Override
    public void execute() {
        System.out.println("SPITestServiceImplBiteTheDust.execute()");
    }
}
