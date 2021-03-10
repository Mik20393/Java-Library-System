

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DeviceTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DeviceTest
{
    private Device device1;
    private LibraryMember libraryM1;

    /**
     * Default constructor for test class DeviceTest
     */
    public DeviceTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        device1 = new Device("Ground Floor", "Computer");
        libraryM1 = new LibraryMember("Michael", "123456");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testConstructor()
    {
        assertEquals(true, device1.checkAvailability());
        assertEquals("Computer", device1.getDeviceType());
        assertEquals("Ground Floor", device1.getLocation());
    }

    @Test
    public void testSetLocation()
    {
        device1.setLocation("First Floor");
        assertEquals("First Floor", device1.getLocation());
    }

    @Test
    public void testSetDeviceType()
    {
        device1.setDeviceType("Tablet");
        assertEquals("Tablet", device1.getDeviceType());
    }

    @Test
    public void testSetMember()
    {
        device1.setLibraryMember(libraryM1);
        assertEquals(false, device1.checkAvailability());//check method updates availability
        assertEquals(libraryM1, device1.getMember());
    }
}














