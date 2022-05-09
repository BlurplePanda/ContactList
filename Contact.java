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
    private int id;
    private String name;
    private String phone;
    private String image;
    static final String DEFAULT_IMAGE = "contact.png";
    
    /**
     * Constructor for objects of class Book
     */
    public Contact(int key, String nm, String ph, String img)
    {
        id = key;
        name = nm;
        phone = ph;
        image = img;
        if (img == null) {
            this.image = DEFAULT_IMAGE; // add default img if user clicks cancel
        } else {
            this.image = img;
        }
    }
    
    /**
     * Constructor overloading
     * Set default image to obj
     */
    public Contact(int key, String nm, String ph) {
        this(key, nm, ph, DEFAULT_IMAGE);
    }
    
    /**
     * Display image on GUI
     */
    public void displayContact(String img, double x, double y, double width, double height) {
        double locX = x;
        double locY = y;
        double imgWidth = width;
        double imgHeight = height;
        
        UI.drawImage(this.image, locX, locY, imgWidth, imgHeight);
    }
    public void displayContact() {
        UI.drawImage(this.image, 100, 100, 100, 100);
    }
    
    /**
     * Getter for id
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Getter for name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Getter for author
     */
    public String getPhone() {
        return this.phone;
    }
}
