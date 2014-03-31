package com.example.memory;

import junit.framework.TestCase;

public class SingletonTest extends TestCase {
    private Singleton instance;

    protected void setUp() throws Exception {
        super.setUp();
        instance = Singleton.getInstance();
        instance.register("user1", "pass1");
    }

    public void testVerifyRegister() {
        assertTrue("Checking for a registered user", instance.verifyRegister("user1"));
        assertFalse("Checking for an unregistered user", instance.verifyRegister("user2"));
    }

}