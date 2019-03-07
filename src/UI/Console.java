package UI;
import Domain.Person;
import Domain.RoomAverageRating;
import Service.PersonService;

import java.util.Scanner;


public class Console {
    private PersonService service;
    private Scanner scanner;

    public Console (PersonService service){
        this.service = service;
        scanner = new Scanner(System.in);
}

    private void showMenu() {
        System.out.println("1. Check in");
        System.out.println("2. Check out");
        System.out.println("3. Medie rating/camera");
        System.out.println("4. Afisarea raportului/camera");
        System.out.println("x. Iesire program");
    }
    public void run(){
        while (true){
            showMenu();
            String options = scanner.nextLine();
            if (options.equals("1")) {
                handleRoomCheckIn();
            } else if (options.equals("2")){
                handleRoomCheckOut();
            }else if (options.equals("3")){
                handleRoomRating();
            }else if (options.equals("4")) {
                handleShowAll();
            }else if (options.equals("x")){
                break;
            }
        }
    }
    private void handleRoomRating(){
        for (RoomAverageRating roomAverage : service.getRoomRatingAverages())
            System.out.println(roomAverage);
    }
    private void handleRoomCheckOut() {
        try {
            System.out.println("Dati numarul camerei");
            int room = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati feedback-ul:");
            String feedback = scanner.nextLine();
            System.out.println("Dati rating-ul:");
            double rating = Double.parseDouble(scanner.nextLine());
            service.checkOut(room, feedback, rating);
        } catch (RuntimeException runtimeException) {
            System.out.println("Avem erori: " + runtimeException.getMessage());
        }
    }
            private void handleShowAll () {
                for (Person p : service.getAll())
                    System.out.println(p);
            }
            private void handleRoomCheckIn () {
                try {
                    System.out.println("Dati id-ul:");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Dati numarul camerei:");
                    int room = Integer.parseInt(scanner.nextLine());
                    System.out.println("Dati numarul de persoane:");
                    int person = Integer.parseInt(scanner.nextLine());
                    System.out.println("Dati numarul de zile:");
                    int days = Integer.parseInt(scanner.nextLine());

                    service.checkIn(id, room, person, days);
                } catch (RuntimeException runtimeException) {
                    System.out.println("Avem erori: " + runtimeException.getMessage());
                }
            }
        }

