package newPackage.ws;

import newPackage.ws.HelloWorld;

import javax.jws.WebService;

@WebService(endpointInterface = "newPackage.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello World "+name;
    }
}
