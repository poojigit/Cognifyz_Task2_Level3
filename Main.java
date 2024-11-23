public class Main {
    public static void main(String[] args) {
        TicketBooking ticketBooking = new TicketBooking(5); // Total 5 tickets available

        // Create multiple user threads
        User user1 = new User(ticketBooking, "User 1");
        User user2 = new User(ticketBooking, "User 2");
        User user3 = new User(ticketBooking, "User 3");
        User user4 = new User(ticketBooking, "User 4");
        User user5 = new User(ticketBooking, "User 5");

        // Start all user threads
        user1.start();
        user2.start();
        user3.start();
        user4.start();
        user5.start();

        // Wait for all threads to finish
        try {
            user1.join();
            user2.join();
            user3.join();
            user4.join();
            user5.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("All bookings are done. Tickets left: " + ticketBooking.getAvailableTickets());
    }
}