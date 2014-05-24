Demonstration of Arquillian 1.1.4.Final regression bug
======================================================

Description
-----------
This is demonstration of arquillian 1.1.4.Final regression [bug](https://issues.jboss.org/browse/ARQ-1758).
It doesn't fail with 1.1.4.Final and fails with 1.1.3.Final.

This test should fail, because the injection error (there is no @Stateless annotation on HelloEJB) and this test:

    @Test
    public void testSayHello() {
        assertNotNull(helloEJB);
        String result = helloEJB.sayHello("Roman");
        assertEquals("Hello Roman", result);
        fail("Should fail");
    }

You can change version of arquillian in build.gradle to 1.1.3.Final:

    def versionArquillian = "1.1.4.Final"

Build and run
-------------

You should set up your JBOSS_HOME environment variable: it must point to the root directory of the JBoss 7.2.0.Final or 
[JBoss EAP 6.1.0 GA](https://www.jboss.org/download-manager/content/origin/files/sha256/16/16ea1e0cef29e94c0d795bbc4b4c431dcb14c4d10831dce5ff48194ff4fb2aee/jboss-eap-6.1.0.zip) 
installation directory.

To build and test it on Linux or MacOS, just run:

    ./gradlew
On Windows:

    gradlew