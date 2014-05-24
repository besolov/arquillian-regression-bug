package net.besolov.arquillian.regression;

//import javax.ejb.Stateless;

/**
 * @author Roman Besolov
 */
//@Stateless
public class HelloEJB {

    public String sayHello(String name) {
        return "Hello " + name;
    }
}
