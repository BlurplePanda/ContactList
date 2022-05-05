import ecs100.*;
/**
 * Write a description of class GUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUI
{
    private Contacts contacts; // declare contacts instance
    private Contact contact; // declare contact instance
    
    /**
     * Constructor for objects of class GUI
     */
    public GUI() {
        // initialise instance variables
        contacts = new Contacts(); // instantiate the contacts object
        UI.initialise();
        UI.addButton("Print all", contacts::printAll);
        UI.addButton("Add", this::addContact);
        UI.addButton("Find", this::findContact);
        UI.addButton("Quit", UI::quit);
    }
    
    /**
     * Add a contact to list
     */
    public void addContact() {        
        String name = UI.askString("Name: ");
        String phone = UI.askString("Number: ");
        
        // add a book image for display in the GUI
        String imgFileName = UIFileChooser.open("Choose image file: ");
        UI.println("Added");
        
        // increment the book ID count and add to hashmap
        contacts.setContactId(); // increment the id by 1
        contacts.addContact(name, phone, imgFileName);
    }
    
    /**
     * Finds book based on name
     * Prints out the author and qty if found
     */
    public void findContact() {
        String contactName = UI.askString("Name of contact: ");
        if (contacts.findContact(contactName.toLowerCase())) {
            UI.println("Found contact!");
            contact = contacts.getContact();
            UI.println("Name: " + contact.getName());
            UI.println("Number: " + contact.getPhone());
        } else {
            UI.println("That contact does not exist!");
        }
    }
}
