
/**
 * Class to hold deatils about device in library
 *
 * @author (Michael Hird)
 * @version (02/12/2020)
 */
public class Device
{
    private String location; // devices location in library
    private String deviceType; // type of device
    private boolean availability; // shows if device is currently in use
    private LibraryMember member; // member using device
    
    /**
     * Create a new device
     * 
     * @param Location Set devices location
     * @param type Set type of device
     */
    public Device(String Location, String type)
    {
        location = Location;
        deviceType = type;
        availability = true; //availability set to true as no member will use devide imediately
    }
    
    /**
     * Method to return the location of a device
     * 
     * @return The location of the device
     */
    public String getLocation()
    {
        return location;
    }
    
    /**
     * Method to return the type of the device
     * 
     * @return The type of the device
     */
    public String getDeviceType()
    {
        return deviceType;
    }
    
    /**
     * Method to return the availability of a device
     * 
     * @return Returns true is device is aviailable for use
     * @return Returns false if device is unavailable for use
     */
    public boolean checkAvailability()
    {
        return availability;
    }
    
    /**
     * Methid to return the library member currently using the device
     * 
     * @return The member currently using the device
     */
    public LibraryMember getMember()
    {
        return member;
    }
    
    /**
     * Method to set the location of a device
     * 
     * @param Location The devices location
     */
    public void setLocation(String Location)
    {
        location = Location;
    }
    
    /**
     * Method to set the type of a device
     * 
     * @param DeviceType The type of a device
     */
    public void setDeviceType(String DeviceType)
    {
        deviceType = DeviceType;
    }
    
    /**
     * Method to set the library member who is currenlty using the device
     * also sets the availability accordingly
     * 
     * @param Member The member using the device
     */
    public void setLibraryMember(LibraryMember Member)
    {
        member = Member;
        if(member == null)
        {
            availability = true;
        }
        else
        {
            availability = false;
        }
    }
    
    /**
     * Method to print all the details of a device
     */
    public void printDeviceInfo()
    {
        System.out.println("Device location:" + location);
        System.out.println("Device type:" + deviceType);
        if(member == null)
        {
            System.out.println("Device is currently available.");
        }
        else
        {
            System.out.println("Device is currently in use.");
        }
        System.out.println();
    }
}
