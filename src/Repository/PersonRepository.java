package Repository;

import Domain.Person;
import Domain.PersonValidator;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonRepository {
    private Map<Integer, Person> storage = new HashMap<>();

    private PersonValidator validator;

    /**
     * Instantiates a repository for person.
     * @param validator the validator used by this reposotory.
     */
    public PersonRepository(PersonValidator validator) {
        this.validator = validator;
    }
    // metode CRUD: Create, Read, Update, Delete

    /**
     * Adds a person to the reposotory.
     * @param person the person to add.
     * Raises RuntimeException if there already is a person whit the given id
     */
    public void add(Person person) {
        if (storage.containsKey(person.getId())) {
            throw new RuntimeException("A person with that ID already exists!");
        }
        validator.validate(person);
        storage.put(person.getId(), person);
    }

    /**
     * Updates an existing person.
     * @param person the person to be updated.
     * Raises RuntimeException if there is no person with person's id or the new person failsvalidation.
     */
    public void update(Person person) {
        if (!storage.containsKey(person.getId())) {
            throw new RuntimeException("There is no person with the given id to update! ");
        }
        validator.validate(person);
        storage.put(person.getId(), person);
        /**
         * @return a list of all person.
         */
    }

    /**
     * @return
     */
    public List<Person> getAll() {
        return new ArrayList<>(storage.values());
       //return (List<Person>) storage.values();
       // return storage.values().toArray();

    }
}


