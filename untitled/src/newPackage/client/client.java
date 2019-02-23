package newPackage.client;

import newPackage.ws.HelloWorld;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class client {
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://localhost:5000/ws/hello?wsdl");

        QName qname = new QName("http://ws.newPackage/", "HelloWorldImplService");

        Service service = Service.create(url, qname);

        HelloWorld hello = service.getPort(HelloWorld.class);
        System.out.println(hello.getHelloWorldString("Daniela"));

    }
}
