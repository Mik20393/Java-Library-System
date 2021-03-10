

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LibraryTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LibraryTest
{
    private Library library1;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;
    private Book book6;
    private LibraryMember libraryM1;
    private LibraryMember libraryM2;
    private Device device1;
    private Device device2;
    private Device device3;
    private ElectronicResource electron1;
    private ElectronicResource electron2;
    private ElectronicResource electron3;
    private LibraryMember libraryM3;

    /**
     * Default constructor for test class LibraryTest
     */
    public LibraryTest()
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
        library1 = new Library();
        book1 = new Book("Michael", "Title1", "123456", "", null);
        book2 = new Book("Michael", "Title2", "456789", "", null);
        book3 = new Book("Robyn", "Title3", "asd123", "", null);
        book4 = new Book("Dale", "Title4", "fgh123", "", null);
        book5 = new Book("Dale", "Title5", "jkl123", "", null);
        book6 = new Book("Dale", "Title6", "bnm123", "", null);
        libraryM1 = new LibraryMember("Michael", "123456");
        libraryM2 = new LibraryMember("Robyn", "456789");
        device1 = new Device("Ground Floor", "Computer");
        device2 = new Device("Gound Floor", "Computer");
        device3 = new Device("First Floor", "Computer");
        electron1 = new ElectronicResource("Michael", "title1");
        electron2 = new ElectronicResource("Robyn", "title2");
        electron3 = new ElectronicResource("Dale", "title3");
        libraryM3 = new LibraryMember("Dale", "2345678");
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
    public void testAddResource()
    {
        library1.addResource(book1);
        library1.addResource(book2);
        library1.addResource(book3);
        library1.addResource(electron1);
        library1.addResource(electron2);
        library1.addResource(electron3);
        assertEquals(6, library1.noOfResources());
    }

    @Test
    public void testAddDevice()
    {
        library1.addDevice(device1);
        library1.addDevice(device2);
        library1.addDevice(device3);
        assertEquals(3, library1.noOfDevices());
    }

    @Test
    public void testAddMember()
    {
        library1.addNewMember(libraryM1);
        library1.addNewMember(libraryM2);
        library1.addNewMember(libraryM3);
        assertEquals(3, library1.noOfMembers());
    }

    @Test
    public void testCheckCatalogue()
    {
        library1.addResource(book1);
        assertEquals(true, library1.checkCatalogue(book1));
        assertEquals(false, library1.checkCatalogue(book2));
    }

    @Test
    public void testSearchByResource()
    {
        library1.addResource(book1);
        assertEquals(book1, library1.searchByResource(book1));
        assertEquals(null, library1.searchByResource(book2));
    }

    @Test
    public void testSearchByIsbn()
    {
        library1.addResource(book1);
        assertEquals(1, library1.searchByIsbn("123456"));
    }

    @Test
    public void testSearchByAuthor()
    {
        library1.addResource(book1);
        library1.addResource(electron1);
        library1.addResource(book2);
        library1.addResource(electron2);
        library1.addResource(electron3);
        library1.addResource(book3);
        assertEquals(3, library1.searchByAuthor("Michael"));
    }

    @Test
    public void testEditTitle()
    {
        library1.addResource(book1);
        library1.editTitle(book1, "Title1.0");
        assertEquals("Title1.0", book1.getTitle());
    }

    @Test
    public void testAvailableBooks()
    {
        library1.addResource(book1);
        library1.addResource(book2);
        library1.addResource(book3);
        library1.addResource(book4);
        library1.addResource(book5);
        library1.addResource(electron1);
        library1.addResource(electron2);
        library1.addResource(electron3);
        assertEquals(5, library1.availableBooks());
    }

    @Test
    public void testRemoveResource()
    {
        library1.addResource(book1);
        library1.addResource(book2);
        assertEquals(2, library1.noOfResources());
        library1.removeResource(book1);
        assertEquals(1, library1.noOfResources());
    }

    @Test
    public void testRemoveResourceByIndex()
    {
        library1.addResource(book1);
        library1.addResource(book2);
        library1.removeResource(1);
        assertEquals(1, library1.noOfResources());
    }

    @Test
    public void testNoOfResources()
    {
        library1.addResource(book1);
        assertEquals(1, library1.noOfResources());
        library1.addResource(book1); //check method doesn't add same resource twice
        assertEquals(1, library1.noOfResources());
    }

    @Test
    public void testBorrowBook()
    {
        library1.addResource(book1);
        library1.addResource(book2);
        library1.addResource(book3);
        library1.addResource(book4);
        library1.addResource(book5);
        library1.addResource(book6);
        library1.addNewMember(libraryM1);
        library1.addNewMember(libraryM2);
        library1.addNewMember(libraryM3);
        library1.borrowBook(book1, libraryM1);
        assertEquals(false, book1.checkAvailability());//check availability updates
        assertEquals(1, libraryM1.noOfBooksBorrowed());//check library book list updates
        library1.borrowBook(book2, libraryM1);
        library1.borrowBook(book3, libraryM1);
        library1.borrowBook(book4, libraryM1);
        library1.borrowBook(book5, libraryM1);
        library1.borrowBook(book6, libraryM1);
        assertEquals(5, libraryM1.noOfBooksBorrowed());//check library member can't borrow
        assertEquals(true, book6.checkAvailability());//more than 5 books
    }

    @Test
    public void testReturnBook()
    {
        library1.addResource(book1);
        library1.addNewMember(libraryM1);
        library1.borrowBook(book1, libraryM1);
        library1.returnBook(libraryM1, book1, true, "Missing Pages");
        assertEquals(0, libraryM1.noOfBooksBorrowed());//check members book list deducted
        assertEquals(true, book1.checkAvailability());//check book availability updated
        assertEquals("Missing Pages", book1.getDamages());//check damages updated
    }

    @Test
    public void testSendNewMessage()
    {
        library1.addNewMember(libraryM1);
        library1.addNewMember(libraryM2);
        library1.addResource(book1);
        library1.borrowBook(book1, libraryM1);
        library1.sendNewMessage("Hello");
        assertEquals("Hello", libraryM1.getMessages());//check method only sends message
        assertEquals("", libraryM2.getMessages());//to members with borrowed books
    }

    @Test
    public void testRemoveMember()
    {
        library1.addNewMember(libraryM1);
        assertEquals(1, library1.noOfMembers());
        library1.removeMember(libraryM1);
        assertEquals(0, library1.noOfMembers());
    }

    @Test
    public void testNoOfMembers()
    {
        library1.addNewMember(libraryM1);
        assertEquals(1, library1.noOfMembers());
    }

    @Test
    public void testLogOnToDevice()
    {
        library1.addNewMember(libraryM1);
        library1.addDevice(device1);
        library1.logOnToDevice(device1, libraryM1);
        assertEquals(false, device1.checkAvailability());
    }

    @Test
    public void testLogOffDevice()
    {
        library1.addDevice(device1);
        library1.addNewMember(libraryM1);
        library1.logOnToDevice(device1, libraryM1);
        library1.logOffDevice(device1);
        assertEquals(true, device1.checkAvailability());
        assertEquals(null, device1.getMember());
    }

    @Test
    public void testAvailableDevices()
    {
        library1.addDevice(device1);
        library1.addDevice(device2);
        library1.addDevice(device3);
        assertEquals(3, library1.availableDevices());
    }

    @Test
    public void testRmoveDevice()
    {
        library1.addDevice(device1);
        assertEquals(1, library1.noOfDevices());
        library1.removeDevice(device1);
        assertEquals(0, library1.noOfDevices());
    }

    @Test
    public void testNoOfDevices()
    {
        library1.addDevice(device1);
        assertEquals(1, library1.noOfDevices());
    }
}























