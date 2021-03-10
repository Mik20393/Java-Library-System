
/**
 * Class to hold details of a physical book in the library
 *Subclass to Resource class
 *
 * @author (Michael Hird)
 * @version (02/12/2020)
 */
public class Book extends Resource{

    private String isbn;
    private String damages;
    private LibraryMember member;



    /**
     * Create a new book
     * 
     * @param author Books author
     * @param title Books title
     * @param ISBN Books ISBN number
     * @param Damages Record any current defects with book
     * @param Member the library member currently loaning the book
     */
    public Book(String author, String title, String ISBN, String Damages, LibraryMember Member)
    { 
        super(author, title);
        isbn = ISBN;
        damages = Damages;
        member = Member;
    }
    
    /**
     * Method to get the books isbn
     * 
     * @return isbn The books isbn
     */
    public String getIsbn()
    {
        return isbn;
    }
    
    /**
     * Method to return recorded defects on the book
     * 
     * @return damages Current recorded defects
     */
    public String getDamages()
    {
        return damages;
    }
    
    /**
     * Method to return the library member currently loaning the book
     * 
     * @return member The member currently loaning the book
     */
    public LibraryMember getMember()
    {
        return member;
    }
    
    /**
     * Method to set the books ISBN
     * 
     * @param ISBN The books ISBN
     */
    public void setIsbn(String ISBN)
    {
        isbn = ISBN;
    }
    
    /**
     * Method to record new defects with book
     * 
     * @param newDamages The new defects to be recorded
     */
    public void setNewDamages(String newDamages)
    {
        damages += newDamages;
    }
    
    /**
     * Method to set the current library member loaning the book
     * 
     * @param _member The current member loaning the book
     */
    public void setMember(LibraryMember _member)
    {
        member = _member;
    }
    
    /**
     * Method to check a books availability
     * 
     * @return Returns true if book is not currently on loan
     * @return Returns false if book is currently on loan
     */
    public boolean checkAvailability()
    {
        if(member == null)
        {
            return true;
        }

        return false;
    }
    
    /**
     * Method to print all the details of a book in the library
     */
    @Override
    public void printResourceInfo()
    {
        super.printResourceInfo();
        System.out.println("Book ISBN:" + isbn);
        System.out.println("Recorded damages:" + damages);
        
        if(member == null)
        {
            System.out.println("Book is currently available.");
        }
        else
        {
            System.out.println("Book is currently unavailable.");
        }
        System.out.println();
    }
}
