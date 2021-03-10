

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BookTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BookTest
{
    private Book book1;
    private LibraryMember libraryM1;

    /**
     * Default constructor for test class BookTest
     */
    public BookTest()
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
        book1 = new Book("Michael", "Title1", "123asd", "", null);
        libraryM1 = new LibraryMember("Dale", "12as34");
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
        assertEquals("Michael", book1.getAuthor());
        assertEquals("Title1", book1.getTitle());
        assertEquals("", book1.getDamages());
        assertEquals("123asd", book1.getIsbn());
        assertEquals(null, book1.getMember());
    }

    @Test
    public void testSetAuthor()
    {
        book1.setAuthor("Robyn");
        assertEquals("Robyn", book1.getAuthor());
    }

    @Test
    public void testSetTitle()
    {
        book1.setTitle("Title2");
        assertEquals("Title2", book1.getTitle());
    }

    @Test
    public void testSetIsbn()
    {
        book1.setIsbn("456asd");
        assertEquals("456asd", book1.getIsbn());
    }

    @Test
    public void testSetMember()
    {
        book1.setMember(libraryM1);
        assertEquals(libraryM1, book1.getMember());
    }

    @Test
    public void testCheckAvailability()
    {
        assertEquals(true, book1.checkAvailability());
        book1.setMember(libraryM1); //check availability changes after adding member
        assertEquals(false, book1.checkAvailability());
    }

    @Test
    public void testSetNewDamages()
    {
        book1.setNewDamages("Page Missing");
        assertEquals("Page Missing", book1.getDamages());
    }
}















