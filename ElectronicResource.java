import java.util.ArrayList;
/**
 * Class to hold details of electronic resources in library
 *Subclass to Resource class
 *
 * @author (Michael Hird)
 * @version (02/12/2020)
 */
public class ElectronicResource extends Resource
{
    private ArrayList<Device> device; // list of devices
    
    /**
     * Create a new electronic resource
     * 
     * @param author The eresources author
     * @param title The eresources title
     */
    public ElectronicResource(String author, String title)
    {
        super(author, title);
        device = new ArrayList<>();
    }
    
    /**
     * Method to add a device to a list of library devices 
     * used for accessing eresources
     * 
     * @param _device The device to be added
     */
    public void addDevice(Device _device)
    {
        if(device.contains(_device))
        {
            System.out.println("Device already on list.");
        }
        else
        {    
            device.add(_device);
        }
    }
    
    /**
     * Method to remove device from the list of library devices
     * 
     * @param _device The device to be removed
     */
    public void removeDevice(Device _device)
    {
        if(device.contains(_device))
        {
            device.remove(_device);
        }
        else
        {    
            System.out.println("Device already removed.");
        }
    }
    
    /**
     * Method to return the number of devices in the list of library devices
     * 
     * @return The number of devices 
     */
    public int deviceListSize()
    {
        return device.size();
    }
    
    /**
     * Method to print all the details of an eresource
     */
    @Override
    public void printResourceInfo()
    {
        super.printResourceInfo();   
    }
}
