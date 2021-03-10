import java.util.ArrayList;
/**
 * Class to hold details about a library member.
 *
 * @author (Michael Hird)
 * @version (02/12/2020)
 */
public class LibraryMember
{
    private String name; // library members name
    private String id; // library members id
    private ArrayList <Book> borrowed; // list of books borrowed by member
    private String messages; // messages received from library
    
    /**
     * Create a new library member profile
     * 
     * @param Name The members name
     * @param Id The members id number
     */
    public LibraryMember(String Name, String Id)
    {
        name = Name;
        id = Id;
        borrowed = new ArrayList<>();
        messages = "";
    }
    
    /**
     * Method to return the name of a member
     * 
     * @return The members name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Method to return a members ID
     * 
     * @return the members ID
     */
    public String getId()
    {
        return id;
    }
    
    /**
     * Method to return any messages sent to the member
     * by the library
     * 
     * @return Messages sent to the member
     */
    public String getMessages()
    {
        return messages;
    }
    
    /**
     * Method to set the name of a library member
     * 
     * @param updatedName The members name
     */
    public void setName(String updatedName)
    {
        name = updatedName;
    }
    
    /**
     * Method to set the ID of a library member
     * 
     * @param Id The members ID
     */
    public void setId(String Id)
    {
        id = Id;
    }
    
    /**
     * Method to print all details of a library member
     */
    public void printMemberDetails()
    {
        System.out.println("Member's name:" + name);
        System.out.println("Member's ID:" + id);
        System.out.println("Title of books currently borrowed by member:");
        
        for(Book _book : borrowed)
        {
            _book.getTitle();
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     * Method to add new messages to members profile
     * 
     * @param newMessage New message to send to members profile
     */
    public void sendMessage(String newMessage)
    {
        messages += newMessage;
    }
    
    /**
     * Method to add books borrowed by a member to their borrowed books list
     * 
     * @param _book Book being borrowed
     */
    public void borrowBook(Book _book)
    {
        borrowed.add(_book);
    }
    
    /**
     * Method to remove book from members borrowed books list
     * 
     * @param _book Book to be removed
     */
    public void returnBook(Book _book)
    {
        borrowed.remove(_book);
    }
    
    /**
     * Method to print the details of all books currently borrowed by the member
     */
    public void printBookDetails()
    {
        if(borrowed.isEmpty())
        {
            System.out.println("This member has currently no books on loan.");
        }
        
        else
        {
            for(Book _book : borrowed)
            {
                _book.printResourceInfo(); 
                System.out.println();
            }
        }
    }
    
    /**
     * Method to return the number of books currently borrowed by the member
     * 
     * @return The number of books on loan by the member
     */
    public int noOfBooksBorrowed()
    {
        return borrowed.size();
    }
}
