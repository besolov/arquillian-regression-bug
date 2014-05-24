package net.besolov.arquillian.regression;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

@RunWith(Arquillian.class)
public class HelloEJBIT {

    @EJB
    private HelloEJB helloEJB;

    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addClasses(HelloEJB.class);
    }

    @Test
    public void testSayHello() {
        assertNotNull(helloEJB);
        String result = helloEJB.sayHello("Roman");
        assertEquals("Hello Roman", result);
        fail("Should fail");
    }
}