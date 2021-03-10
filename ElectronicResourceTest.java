

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElectronicResourceTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElectronicResourceTest
{
    private ElectronicResource electron1;
    private Device device1;

   /**
     * Default constructor for test class ElectronicResourceTest
     */
    public ElectronicResourceTest()
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
        electron1 = new ElectronicResource("Michael", "title1");
        device1 = new Device("Ground Floor", "Computer");
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
        assertEquals("Michael", electron1.getAuthor());
        assertEquals("title1", electron1.getTitle());
    }

    @Test
    public void testSetAuthor()
    {
        electron1.setAuthor("Dale");
        assertEquals("Dale", electron1.getAuthor());
    }

    @Test
    public void testSetTitle()
    {
        electron1.setTitle("title2");
        assertEquals("title2", electron1.getTitle());
    }

    @Test
    public void testAddDevice()
    {
        electron1.addDevice(device1);
        assertEquals(1, electron1.deviceListSize());
        electron1.addDevice(device1); //check the method does not add the same device twice
        assertEquals(1, electron1.deviceListSize());
    }

    @Test
    public void testRemoveDevice()
    {
        electron1.addDevice(device1);
        assertEquals(1, electron1.deviceListSize());
        electron1.removeDevice(device1);
        assertEquals(0, electron1.deviceListSize());
    }

    @Test
    public void testDeviceListSize()
    {
        electron1.addDevice(device1);
        assertEquals(1, electron1.deviceListSize());
    }
}














