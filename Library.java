import java.util.ArrayList;
/**
 * Class to hold all the information about a library
 * and simulate library functions
 *
 * @author (Michael Hird)
 * @version (02/12/2020)
 */
public class Library
{
    private ArrayList<Resource> catalogue; // list of library resources
    private ArrayList<Device> libraryDevice; // list of library devices
    private ArrayList<LibraryMember> memberslist; // list of library members
    
    /**
     * Create a new library
     * The library contains a list of all resources, a list of all current memebers
     * and a list of all library devices
     */
    public Library()
    {
        catalogue = new ArrayList<>();
        libraryDevice = new ArrayList<>();
        memberslist = new ArrayList<>();
    }
    
    /**
     * A Method to add a new resource to the library catalogue
     * The method checks if the resource already exists
     * and wont add if the catalogue already contains it
     * 
     * @param resource The resource to be added
     */
    public void addResource(Resource resource)
    {
        if(catalogue.contains(resource))
        {
            System.out.println("Resource already added to catalogue.");
        }
        
        else
        {
            catalogue.add(resource);
            System.out.println("Resource successfully added to catalogue.");
        }
    }
    
    /**
     * Methid to return whether a resource exists in the library catalogue
     * 
     * @param resource The resource to be looked for
     * @return Returns true if the resource exists
     * @return Returns false if the resource doesn't exist
     */
    public boolean checkCatalogue(Resource resource)
    {
        if(catalogue.contains(resource))
        {
            return true;
        }
        
        else
        {
            return false;
        }
    }
    
    /**
     * Method to search the library catalgue by resource
     * 
     * @param resource The resource to be searched for
     * @return Returns the resource if it exists in the catalogue
     * @return Returns null if the resource does not exist
     */
    public Resource searchByResource(Resource resource)
    {
        if(catalogue.contains(resource))
        {
            return resource;
        }
        
        else
        {
            return null;
        }
    }
    
    /**
     * Method to search for a resource in the library catalogue by ISBN
     * and print the details of resources with a matching ISBN
     * 
     * @param ISBN The ISBN to search for
     * @return The number of resources with matching ISBN
     */
    public int searchByIsbn(String ISBN)
    {
        int noOfResources = 0;
        for(Resource resource : catalogue)
        {
            if(((Book)resource).getIsbn() == ISBN)
            {
                resource.printResourceInfo();
                noOfResources++;
            }
            
            else
            {
                System.out.println("No resources have the ISBN provided.");
            }
        }
        System.out.println("Number of resources with ISBN " + ISBN + " : " + noOfResources);
        return noOfResources;
    }
    
    /**
     * Method to search for resources by a specific author
     * and print the details of all resources by the author
     * 
     * @param author The author to be searched for
     * @return The number of resources by the author searched for
     */
    public int searchByAuthor(String author)
    {
        int noOfResources = 0;
        for(Resource resource : catalogue)
        {
            if(resource.getAuthor().equals(author))
            {
                resource.printResourceInfo();
                noOfResources++;
            }
        }
        System.out.println("Number of resources found by " + author + " : " + noOfResources);
        return noOfResources;
    }
    
    /**
     * Method to edit the title of a resource in the library catalogue
     * 
     * @param resource The resource to be edited
     * @param Title The updated title of the resource
     */
    public void editTitle(Resource resource, String Title)
    {
        if(catalogue.contains(resource))
        {
            resource.setTitle(Title);
        }
        
        else
        {
            System.out.println("Resource does not exist in catalogue.");
        }
    }
    
    /**
     * Method to print the details of all available books in the catalogue
     * 
     * @return The total number of book available in the library
     */
    public int availableBooks()
    {
        int noOfMatches = 0;
        for(Resource resource : catalogue)
        {
            if(resource instanceof ElectronicResource)
            {
                continue;
            }
            
            if(((Book)resource).checkAvailability() == true)
            {
                resource.printResourceInfo();
                noOfMatches++;
            }
        }
        return noOfMatches;
    }
    
    /**
     * Method to print all the details of all books in the library catalogue
     */
    public void printBookDetails()
    {
        for (Resource resource : catalogue)
        {
            if (resource instanceof Book)
            {
                resource.printResourceInfo();
            }
        }
    }
    
    /**
     * Method to print all the details of all the eresources in the library catalogue
     */
    public void printElectronicResourceDetails()
    {
        for (Resource resource : catalogue)
        {
            if (resource instanceof ElectronicResource)
            {
                resource.printResourceInfo();
            }
        }
    }
    
    /**
     * Method to remove a resource at a specified index in the library catalogue
     * 
     * @param index The index of the resource to be removed
     */
    public void removeResource(int index)
    {
        if (index >= 0 && index < catalogue.size())
        {
            catalogue.remove(index);
            System.out.println("Resource successfully removed from Library catalogue.");
        }
        
        else
        {
            System.out.println("Index does not exist in Library catalogue.");
        }
    }
    
    /**
     * Method to remove a resource from the library catalogue
     * 
     * @param resource The resource to be removed
     */
    public void removeResource(Resource resource)
    {
        if(catalogue.contains(resource))
        {
            catalogue.remove(resource);
            System.out.println("Resource successfully removed from Library catalogue.");
        }
        
        else
        {
            System.out.println("Resource does not exist in catalogue.");
        }
    }
    
    /**
     * Method to return the number of resources in the catalogue
     * 
     * @return The number of resources in the catalogue
     */
    public int noOfResources()
    {
        return catalogue.size();
    }
    
    /**
     * Method to add a new member to the library 
     * 
     * @param member The member to be added
     */
    public void addNewMember(LibraryMember member)
    {
        if(memberslist.contains(member))
        {
            System.out.println("Person is already a member of the Library");
        }
        
        else
        {
            memberslist.add(member);
            System.out.println("New member successfully added");
        }
    }
    
    /**
     * Method to simulate borrwoing a book
     * 
     * @param book Book being borrowed
     * @param meber Member borrowing book
     */
    public void borrowBook(Book book, LibraryMember member)
    {
        if(!catalogue.contains(book))
        {
            System.out.println("Book does not exist in catalogue.");
        }
        
        else if(book.checkAvailability() == false)
        {
            System.out.println("Book is already on loan.");
        }
        
        else if(member.noOfBooksBorrowed() == 5)
        {
            System.out.println("Member has currently borrowed the maximum amount allowed.");
        }
        
        else
        {
            book.setMember(member);
            member.borrowBook(book);
            System.out.println("Book has been successfully borrowed.");
        }
    }
    
    /**
     * Method to simulate returning a book
     * 
     * @param member Member returning a book
     * @param book Book being returned
     * @param newDamage Declare if any new damages to be recorded
     * @param additionalDamage Damage to be recorded
     */
    public void returnBook(LibraryMember member, Book book, boolean newDamage, 
                           String additionalDamage)
    {
        if (catalogue.contains(book))
        {
            book.setMember(null);
            member.returnBook(book);
        }
        
        else
        {
            System.out.println("Book does not exist in catalogue.");
        }
        
        if (newDamage == true)
        {
            book.setNewDamages(additionalDamage);
        }
    }
    
    /**
     * Method to send message to all library users who have borrowed at least one book
     * 
     * @param newMessage Message to be sent
     */
    public void sendNewMessage(String newMessage)
    {
        for (LibraryMember member : memberslist)
        {
            if (member.noOfBooksBorrowed() >= 1)
            {
                member.sendMessage(newMessage);
            }
        }
    }
    
    /**
     * Method to remove member from library member list
     * 
     * @param member Member to be removed
     */
    public void removeMember(LibraryMember member)
    {
        if(memberslist.contains(member))
        {
            memberslist.remove(member);
            System.out.println("Member successfully removed from members list.");
        }
        
        else
        {
            System.out.println("Member not present in memebers list.");
        }
    }
    
    /**
     * Method to return the number of members for the library
     * 
     * @return The number of members
     */
    public int noOfMembers()
    {
        return memberslist.size();
    } 
    
    /**
     * Method to add a device to the library device list
     * 
     * @param device Device to be added
     */
    public void addDevice(Device device)
    {
        if(libraryDevice.contains(device))
        {
            System.out.println("Device already added to list");
        }
        
        else
        {
            libraryDevice.add(device);
            System.out.println("Device details logged successfully.");
        }
    }
    
    /**
     * Method to simulate logging on to a device
     * 
     * @param device Device being logged in to
     * @param member Member singing in
     */
    public void logOnToDevice(Device device, LibraryMember member)
    {
        if(device.checkAvailability() == true)
        {
            device.setLibraryMember(member);
        }
        
        else
        {
            System.out.println("Device already in use.");
        }
    }
    
    /**
     * Method to simulate logging off device
     * 
     * @param device Device being logged off
     */
    public void logOffDevice(Device device)
    {
        if(device.checkAvailability() == false)
        {
            device.setLibraryMember(null);
        }
        
        else
        {
            System.out.println("Device already logged off.");
        }
    }
    
    /**
     * Method to return the number of available devices
     * 
     * @return The number of avilable devices
     */
    public int availableDevices()
    {
        int noOfMatches = 0;
        for(Device device : libraryDevice)
        {
            if(device.checkAvailability() == true)
            {
                device.printDeviceInfo();
                noOfMatches++;
            }
            
            else
            {
                System.out.println("No available devices.");
            }
        }
        return noOfMatches;
    }
    
    /**
     * Method to remove devices from the library device list
     * 
     * @param device Device to be removed
     */
    public void removeDevice(Device device)
    {
        if(libraryDevice.contains(device))
        {
            libraryDevice.remove(device);
        }
        
        else
        {
            System.out.println("Device does not exist.");
        }
    }
    
    /**
     * Method to return the number of devices in the library
     * 
     * @return The number of devices
     */  
    public int noOfDevices()
    {
        return libraryDevice.size();
    }
    
    /**
     * Method to print all details of library resources, devices
     * and members
     */
    public void printAllLibraryDetails()
    {
        System.out.println("Details of all library resources");
        System.out.println();
        for(Resource resource : catalogue)
        {
            resource.printResourceInfo();
        }
        System.out.println();
        System.out.println("Details of current library members");
        System.out.println();
        for (LibraryMember member : memberslist)
        {
            member.printMemberDetails();
        }
        System.out.println();
        System.out.println("Details of all current library devices");
        System.out.println();
        for (Device device : libraryDevice)
        {
            device.printDeviceInfo();
        }
    }
}

