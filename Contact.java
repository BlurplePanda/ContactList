import ecs100.*;
/**
 * Support class for Contacts
 * A Contact contains an id, name, number, image
 * 
 * @author Amy
 * @version 02/05/22
 */
public class Contact
{
    // fields
    private String name;
    private String phone;
    private String image;
    static final String DEFAULT_IMAGE = "contact.png";
    
    /**
     * Constructor for objects of class Contact
     * @param nm - name of contact
     * @param ph - phone number of contact
     * @param img - image to display with contact
     */
    public Contact(String nm, String ph, String img)
    {
        name = nm;
        phone = ph;
        if (img == null) {
            this.image = DEFAULT_IMAGE; // add default img if user clicks cancel
        }
        else {
            this.image = img;
        }
    }
    
    /**
     * Constructor overloading
     * Set default image
     * @param nm - name of contact
     * @param ph - phone number of contact
     */
    public Contact(String nm, String ph) {
        this(nm, ph, DEFAULT_IMAGE);
    }
    
    /**
     * Getter for name
     * @return String - name of contact
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Getter for author
     * @return String - phone number of contact
     */
    public String getPhone() {
        return this.phone;
    }
    
    /**
     * Getter for image
     * @return String - image related to contact
     */
    public String getImage() {
        return this.image;
    }
}
