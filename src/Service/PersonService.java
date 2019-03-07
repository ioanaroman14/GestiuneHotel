package Service;

import Domain.Person;
import Domain.RoomAverageRating;
import Repository.PersonRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonService {
    private PersonRepository repository;
    /**
     * Instantiates a car service.
     * @param repository the repository used by this service.
     */
    public PersonService(PersonRepository repository){
        this.repository = repository;
    }

    /**
     * Adds a person in hotel.
     * @param id the person id.
     * @param room the room number.
     * @param person
     * @param days the number of days the person will be in hotel.
     * Raises RuntimeException if the room number is taken if there are other errors.
     */

    public void checkIn (int id, int room, int person, int days){
        Person person1 = new Person(id, room, person, days);
        List<Person> persons = repository.getAll();
        for (Person p : persons){
            if (p.getRoom() == room && !p.isCheckOut()){
                throw new RuntimeException(" That room is already taken!");
            }
        }
        repository.add(person1);
    }

    /**
     * Removes                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         2K2
     * @param room the room number to clear
     * @param feedback
     * @param rating the rate that the person gave
     * Raises RuntimeException if the room number is not empty.
     */
    public void checkOut (int room, String feedback, double rating){
        Person personInRoom = null;
        List<Person> persons = repository.getAll();
        for (Person p : persons){
            if (p.getRoom() == room && !p.isCheckOut()){
                personInRoom = p;
            }
        }
        if (personInRoom != null){
            personInRoom.setFeedback(feedback);
            personInRoom.setRating(rating);
            personInRoom.setCheckOut(true);
            repository.update(personInRoom);
        } else {
            throw new RuntimeException("There is no person in the given room!");
        }
    }

    /**
     * @return a list of rooms ordered descendingly by average room ratings.
     */
    public List<RoomAverageRating> getRoomRatingAverages(){
        List<RoomAverageRating> results = new ArrayList<>();
        Map<Integer, List<Double>> ratingsForRooms = new HashMap<>();
        for (Person p : repository.getAll()) {
            if (p.isCheckOut()) {
                int room = p.getRoom();
                double rating = p.getRating();

                if (!ratingsForRooms.containsKey(room)) {
                    ratingsForRooms.put(room, new ArrayList<>());
                }
                ratingsForRooms.get(room).add(rating);
            }
        }
            for (int room : ratingsForRooms.keySet()){
                List<Double> ratings = ratingsForRooms.get(room);
                double average = 0;
                for (double ra : ratings){
                    average += ra;
                }
                average /= ratings.size();
                results.add(new RoomAverageRating(room, average));
            }
            //results.sort((r1, r2) -> r1.getAverageRating()> r2.getAverageRating() ? -1 : 1);

            results.sort((r1 , r2) -> {
                if (r1.getAverageRating() > r2.getAverageRating())
                    return -1;
                else if (r1.getAverageRating() == r2.getAverageRating())
                    return 0;
                else return 1;
            });
            return results;
        }
        public List<Person> getAll(){
            return repository.getAll();
        }
    }

