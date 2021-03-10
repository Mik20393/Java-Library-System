

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LibraryMemberTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LibraryMemberTest
{
    private LibraryMember libraryM1;
    private Book book1;

    /**
     * Default constructor for test class LibraryMemberTest
     */
    public LibraryMemberTest()
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
        libraryM1 = new LibraryMember("Michael", "123456");
        book1 = new Book("Dale", "Title1", "123asd", "", null);
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
        assertEquals("Michael", libraryM1.getName());
        assertEquals("", libraryM1.getMessages());
        assertEquals("123456", libraryM1.getId());
    }

    @Test
    public void testSetName()
    {
        libraryM1.setName("Robyn");
        assertEquals("Robyn", libraryM1.getName());
    }

    @Test
    public void testSetId()
    {
        libraryM1.setId("456789");
        assertEquals("456789", libraryM1.getId());
    }

    @Test
    public void testSendMessage()
    {
        libraryM1.sendMessage("Hello");
        assertEquals("Hello", libraryM1.getMessages());
    }

    @Test
    public void testBorrowBook()
    {
        libraryM1.borrowBook(book1);
        assertEquals(1, libraryM1.noOfBooksBorrowed());
    }

    @Test
    public void testNoOfBooksBorrowed()
    {
        libraryM1.borrowBook(book1);
        assertEquals(1, libraryM1.noOfBooksBorrowed());
    }
}






