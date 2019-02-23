package newPackage.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "newPackage.ws.HelloWorld")

public class HelloWorldImpl implements HelloWorld {

    @Override
    public String getHelloWorldString(String name) {
        return "Hello World " + name;
    }
}
