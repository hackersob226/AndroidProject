import com.example.memory.Singleton;

import junit.framework.TestCase;

public class SingletonTest extends TestCase {
    private Singleton instance;

    protected void setUp() throws Exception {
        super.setUp();
        instance = Singleton.getInstance();
        instance.register("user1", "pass1");
        instance.register("Trang", "Tu");
    }

    /**
    * @author Brandon
    */
    public void testVerifyRegister() {
        assertTrue("Checking for a registered user", instance.verifyRegister("user1"));
        assertFalse("Checking for an unregistered user", instance.verifyRegister("user2"));
    }

    /**
    * @author Devon
    */
    public void testCreateAccount() {
        instance.createAccount("user1", "user1AccFN", "user1AccDN", "10", "1.2");

        assertEquals("user1AccFN", instance.getAccount("user1AccDN").getFullName());
    }

    /**
    * @author Katie
    */
    public void testFindUser() {
    	assertNull(instance.findUser(null));
    	assertNull(instance.findUser("NotaUser"));
    	assertEquals(instance.retrieveUser(1), instance.findUser("user1"));
    }

    /**
    * @author Trang
    */
    public void testVerifyLogin(){
    	assertTrue("Check valid user", instance.verifyLogin("user1"));
    	assertTrue("Check valid user", instance.verifyLogin("Trang"));
    	assertFalse("Check invalid user", instance.verifyLogin("Tu"));
    	assertFalse("Check invalid user", instance.verifyLogin("Hermes"));

    }

    /**
    * @author Trang
    */
    public void testVerifyPass(){
    	assertTrue("Check valid password", instance.verifyLogin("pass1"));
    	assertTrue("Check valid password", instance.verifyLogin("Tu"));
    	assertFalse("Check invalid password", instance.verifyLogin("penguin"));
    	assertFalse("Check invalid password", instance.verifyLogin("Hermes"));

    }
    
    /**
    * Assumes createAccount works.
    *
    * @author Chase
    */
    public void testCheckDisplayName() {
        instance.createAccount("user1", "Full", "Display", "2.25", "0.2");
        assertTrue(instance.checkDisplayName("Display"));
        assertFlase(isntance.checkDisplayName("Banana"));
    }
}
