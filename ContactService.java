/* Marek Lubecki
 * CS320-SNHU
 * Module 3 Milestone 1
 */
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // Using a HashMap to store contacts with contactId as the key for easy access
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) { // Add a new contact to the service
        if (contact == null || contacts.containsKey(contact.getContactId())) { // Check if the contact is null or if the contact ID already exists
            throw new IllegalArgumentException("Contact invalid or ID already exists");
        }
        contacts.put(contact.getContactId(), contact); // Add the contact to the HashMap
    }

    public void deleteContact(String contactId) { // Delete a contact from the service using the contact ID
        if (!contacts.containsKey(contactId)) { // Check if the contact ID exists in the HashMap
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.remove(contactId); // Remove the contact from the HashMap
    }

    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) { // Update an existing contact's information using the contact ID
        Contact contact = contacts.get(contactId);
        if (contact == null) { // Check if the contact ID exists in the HashMap
            throw new IllegalArgumentException("Contact ID not found");
        }
        
        // Update the contact's information using the setter methods
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
    }
    
    // Method to retrieve a contact by its ID
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}