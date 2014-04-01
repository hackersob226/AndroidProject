import com.example.memory.Singleton;

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

    public void testCreateAccount() {
        instance.createAccount("user1", "user1AccFN", "user1AccDN", "10", "1.2");
        
        assertEquals("user1AccFN", instance.getAccount("user1AccDN").getFullName());
    }
    
    public void testFindUser() {
    	assertNull(instance.findUser(null));
    	assertNull(instance.findUser("NotaUser"));
    	assertEquals(instance.retrieveUser(1), instance.findUser("user1"));
    }

}
