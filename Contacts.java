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
            contactList.put(3, new Contact(3, "Ella", "4995959992"));
            currContactId = 3;
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
            int previousWithout = 0; // checks how many previous letters didn't have contacts
            // for each letter of the alphabet
            for(char letter = 'A'; letter <= 'Z'; ++letter) {
                boolean current = false; // checks if current letter has contacts beginning with it
                String letterCheck = Character.toString(letter);
                // check if letter has any contacts
                for (int contact : contactList.keySet()) {
                    if (contactList.get(contact).getName().toUpperCase().startsWith(letterCheck)) {
                        current = true;
                        break;
                    }
                }
                // checks what to print based on current and previous letters
                // should print "..." before the letter if there were at least 2 letters
                // that didn't have contacts before the current letter
                // also changes previousWithout for use with the next letter
                if (current) {
                    if (previousWithout >= 2) {
                        UI.println("...");
                        UI.println(letterCheck);
                    } else {
                        UI.println(letterCheck);
                    }
                    previousWithout = 0;
                    // prints all contacts for current letter
                    for (int contactId : contactList.keySet()) {
                        currContact = contactList.get(contactId);
                        if (currContact.getName().toUpperCase().startsWith(Character.toString(letter))) {
                            UI.println(currContact.getName()+":");
                            UI.println(currContact.getPhone());
                            UI.sleep(100);
                        }
                    }
                } else {
                    previousWithout += 1;
                }
            }
            if (previousWithout >= 1) {
                UI.println("...");
                UI.println("Z");
            }
    }
}