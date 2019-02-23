package newPackage.endpoint;

import javax.xml.ws.Endpoint;
import newPackage.ws.HelloWorldImpl;

public class HelloWorldPublisher {
    public static void main(String[] args) {
        System.out.println("Running...");
        Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
    }
}
