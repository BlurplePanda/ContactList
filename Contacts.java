import java.util.HashMap;
import ecs100.*;
/**
 * Holds a collection of contacts in a hashmap
 * Allows a user to add, find, print all, edit from a menu, delete
 * Prevent user from adding a duplicate
 *
 * @author Amy
 * @version 02/05/22
 */
public class Contacts
{
    // instance variables
    private HashMap<Integer, Contact> contactList; // declaring the hashmap
    private int currContactId = 1; // store the current id of the contact being added
    private Contact currContact; // store the instance of the current contact

    /**
     * Constructor for objects of class Contacts
     */
    public Contacts()
    {
        // initialise instance variables
        contactList = new HashMap<Integer, Contact>(); // initialise hashmap
        
        // creating + adding contacts to collection
        contactList.put(1, new Contact(1, "Amy", "0272509089"));
        contactList.put(2, new Contact(2, "Evie", "284829813"));
        currContactId = 2;
    }
    
    /**
     * Set current contact ID
     */
    public void setContactId() {
        this.currContactId += 1;
    }
    
    /**
     * Add a contact to the map
     */
    public void addContact(String name, String phone, String img) {
        contactList.put(currContactId, new Contact(currContactId, name, phone, img));
    }
    
    /** 
     * Finds a contact based on name
     * Sets the current contact instance if found
     * @return boolean false if not found
     */
    public boolean findContact(String name) {
        // search for contact
        for (int contactId : contactList.keySet()) {
            if (contactList.get(contactId).getName().toLowerCase().equals(name.toLowerCase())) {
                currContact = contactList.get(contactId); // set the current contact
                contactList.get(contactId).displayContact();
                return true;
            }
        }
        return false;
    }
    
    /**
     * Getter for the current Contact instance
     */
    public Contact getContact() {
        return currContact;
    }
    
    /**
     * Print details of all contacts
     */
    public void printAll() {
        // traverse map
        for (int contactId : contactList.keySet()) {
            currContact = contactList.get(contactId);
            UI.println(contactId + " Details:");
            UI.println(currContact.getName() + " "
                       + currContact.getPhone());
        }
    }
}