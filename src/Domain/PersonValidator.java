package Domain;

public class PersonValidator {
    /**
     * Validates a person
     * @param person the person to validate.
     * @throws RuntimeException if there are validation errors.
     */
    public void validate (Person person) {
        int roomnumber = person.getRoom();
        String errors ="";
        if (roomnumber < 1 || roomnumber > 50) {
            errors += "Is not a correct room number.";
        }
        if (person.isCheckOut() && person.getRating() < 1 || person.getRating() > 5) {
            throw new RuntimeException("Rating must be 1,2,3,4 or 5!");
        }

        if (person.isCheckOut() && person.getFeedback() == null){
            throw new RuntimeException("Feedback not be null!");
        }
        if (person.getDays() <= 0){
            throw new RuntimeException("The number of days cannot be 0 or negative!");
        }
        if (!errors.equals("")){
            throw new RuntimeException(errors);
        }
    }
}
