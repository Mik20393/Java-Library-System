
/**
 * Resource superclass to hold matching data fields of books and electronic resources
 *
 * @author (Michael Hird)
 * @version (02/12/2020)
 */
public class Resource
{
    private String author;
    private String title;
    
    /**
     * Create a new resource
     * 
     * @param Author The author of the resource
     * @param Title The title of the resource
     */
    public Resource(String Author, String Title)
    {
        author = Author;
        title = Title;
    }
    
    /**
     * Method to return the author of a resource
     * 
     * @return the author of a resource
     */
    public String getAuthor()
    {
        return author;
    }
    
    
    /**
     * Method to return the title of a resource
     * 
     * @return The title of a resource
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Method to set the author of a resource
     * 
     * @param Author The author of the resource
     */
    public void setAuthor(String Author)
    {
        author = Author;
    }
    
    /**
     * Method to set the title of a resource
     * 
     * @param Title The title of the resource
     */
    public void setTitle(String Title)
    {
        title = Title;
    }
    
    /**
     * Method to print resource info
     */
    public void printResourceInfo()
    {
        System.out.println("Author:" + author);
        System.out.println("Title:" + title);
    }
}
