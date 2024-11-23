public class User extends Thread {
    private TicketBooking ticketBooking;
    private String userName;

    public User(TicketBooking ticketBooking, String userName) {
        this.ticketBooking = ticketBooking;
        this.userName = userName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) { // Each user tries to book 3 tickets
            ticketBooking.bookTicket(userName);
            try {
                Thread.sleep(500); // Simulate time taken to book
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}