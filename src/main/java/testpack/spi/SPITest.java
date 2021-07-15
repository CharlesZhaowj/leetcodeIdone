package testpack.spi;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SPITest {
    public static void main(String[] args) {
        Iterator<SPITestService> providers = Service.providers(SPITestService.class);
        ServiceLoader<SPITestService> load = ServiceLoader.load(SPITestService.class);

        while (providers.hasNext()) {
            SPITestService ser = providers.next();
            ser.execute();
        }
        System.out.println("-----------------------------------------------------");
        Iterator<SPITestService> iterator = load.iterator();
        while (iterator.hasNext()) {
            SPITestService ser = iterator.next();
            ser.execute();
        }
    }
}
