import Domain.PersonValidator;
import Repository.PersonRepository;
import Service.PersonService;
import UI.Console;

public class Main {

    public static void main(String[] args) {
        PersonValidator validator= new PersonValidator();
        PersonRepository repository = new PersonRepository(validator);
        PersonService service = new PersonService(repository);
        Console console = new Console(service);
        console.run();
    }
}
