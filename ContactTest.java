/* Marek Lubecki
 * CS320-SNHU
 * Module 3 Milestone 1
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testContactIdTooLong() { // Test for contact ID longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Apple St");
        });
    }

    @Test
    void testContactIdNull() { // Test for null contact ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Apple St");
        });
    }

    @Test
    void testFirstNameTooLong() { // Test for first name longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "JohnathanDo", "Doe", "1234567890", "123 Apple St");
        });
    }

    @Test
    void testFirstNameNull() { // Test for null first name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Doe", "1234567890", "123 Apple St");
        });
    }

    @Test
    void testLastNameTooLong() { // Test for last name longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "DoeSmithson", "1234567890", "123 Apple St");
        });
    }

    @Test
    void testLastNameNull() { // Test for null last name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", null, "1234567890", "123 Apple St");
        });
    }

    @Test
    void testPhoneTooShort() { // Test for phone number shorter than 10 digits
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "123456789", "123 Apple St");
        });
    }

    @Test
    void testPhoneTooLong() { // Test for phone number longer than 10 digits
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "12345678901", "123 Apple St");
        });
    }

    @Test
    void testPhoneNull() { // Test for null phone number
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", null, "123 Apple St");
        });
    }

    @Test
    void testAddressTooLong() { // Test for address longer than 30 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", "1234567890123456789012345678901");
        });
    }

    @Test
    void testAddressNull() { // Test for null address
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", null);
        });
    }
}