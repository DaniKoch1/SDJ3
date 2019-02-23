package newPackage.endpoint;

import newPackage.ws.HelloWorldImpl;

import javax.xml.ws.Endpoint;

public class HelloWorldPublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:5000/ws/hello", new HelloWorldImpl());
    }
}
