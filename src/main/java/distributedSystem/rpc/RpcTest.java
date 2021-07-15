package distributedSystem.rpc;

import java.net.InetSocketAddress;

public class RpcTest {
    public static void main(String[] args) {
        new Thread(()-> {
            try {
                RpcExporter.exporter("localhost", 8088);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        RpcImporter<EchoService> importer = new RpcImporter<>();
        EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8088));
        System.out.println(echo.echo("Are you OK?"));
    }
}
