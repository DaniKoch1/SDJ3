package newPackage.client;

import newPackage.ws.HelloWorld;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class HelloWorldClient {
    public static void main(String[] args) throws Exception {
        URL url=new URL("http://localhost:9999/ws/hello?wsdl");
        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        //<definitions (...) targetNamespace="http://ws.newPackage/" name="HelloWorldImplService">

        QName qname = new QName("http://ws.newPackage/", "HelloWorldImplService");
        Service service=Service.create(url, qname);
        HelloWorld hello = service.getPort(HelloWorld.class);
        System.out.println(hello.getHelloWorldAsString("Dani"));
    }
}
