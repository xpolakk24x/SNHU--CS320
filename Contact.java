/* Marek Lubecki
 * CS320-SNHU
 * Module 3 Milestone 1
 */
public class Contact {
	// Contact class with fields for contact ID, first name, last name, phone number, and address
    private final String contactId; // Final because the contact Id shouldnt be updated
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validation for Contact ID (Required, max 10 chars, not null)
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        // Validation for First Name (Required, max 10 chars, not null)
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        // Validation for Last Name (Required, max 10 chars, not null)
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        // Validation for Phone (Required, exactly 10 digits, not null)
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        // Validation for Address (Required, max 30 chars, not null)
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.contactId = contactId; // Set the contact ID (final, so it cannot be changed later)
        this.firstName = firstName; // Set the first name
        this.lastName = lastName; // Set the last name
        this.phone = phone; // Set the phone number
        this.address = address; // Set the address
    }

    // Getters for all fields
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    // Setters (No ID setter since it shouldnt be updated)
    public void setFirstName(String firstName) { // Validate and set the first name
        if (firstName == null || firstName.length() > 10) throw new IllegalArgumentException("Invalid first name");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) { // Validate and set the last name
        if (lastName == null || lastName.length() > 10) throw new IllegalArgumentException("Invalid last name");
        this.lastName = lastName;
    }

    public void setPhone(String phone) { // Validate and set the phone number
        if (phone == null || phone.length() != 10) throw new IllegalArgumentException("Invalid phone");
        this.phone = phone;
    }

    public void setAddress(String address) { // Validate and set the address
        if (address == null || address.length() > 30) throw new IllegalArgumentException("Invalid address");
        this.address = address;
    }
}