/* Marek Lubecki
 * CS320-SNHU
 * Module 3 Milestone 1
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    
    private ContactService service;

    // Initialize a new ContactService before each test to ensure a clean state
    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    @Test
    void testAddContactSuccess() { // Test adding a contact successfully
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Apple St");
        service.addContact(contact);
        
        // Verify the contact was actually added
        assertNotNull(service.getContact("12345"));
        assertEquals("John", service.getContact("12345").getFirstName());
    }

    @Test
    void testAddContactDuplicateId() { // Test adding a contact with a duplicate ID
        Contact contact1 = new Contact("12345", "John", "Doe", "1234567890", "123 Apple St");
        Contact contact2 = new Contact("12345", "Jane", "Smith", "0987654321", "456 Pear St");
        
        service.addContact(contact1);
        
        // Trying to add another contact with the same ID should throw an error
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    void testDeleteContactSuccess() { // Test deleting a contact successfully
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Apple St");
        service.addContact(contact);
        
        // Delete it
        service.deleteContact("12345");
        
        // Verify it was deleted
        assertNull(service.getContact("12345"));
    }

    @Test
    void testDeleteContactNotFound() { // Test deleting a contact that doesn't exist
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("99999");
        });
    }

    @Test
    void testUpdateContactSuccess() { // Test updating a contact successfully
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Apple St");
        service.addContact(contact);
        
        // Update the fields
        service.updateContact("12345", "Jane", "Smith", "0987654321", "456 Pear St");
        
        // Verify the fields changed, but the ID stayed the same
        Contact updatedContact = service.getContact("12345");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Pear St", updatedContact.getAddress());
    }

    @Test
    void testUpdateContactNotFound() { // Test updating a contact that doesn't exist
        // Trying to update a contact that doesn't exist should throw an error
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("99999", "Jane", "Smith", "0987654321", "456 Pear St");
        });
    }
}