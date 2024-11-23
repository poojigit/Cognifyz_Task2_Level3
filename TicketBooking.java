import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketBooking {
    private int availableTickets;
    private Lock lock = new ReentrantLock();

    public TicketBooking(int totalTickets) {
        this.availableTickets = totalTickets;
    }

    public void bookTicket(String userName) {
        lock.lock(); // Acquire the lock
        try {
            if (availableTickets > 0) {
                System.out.println(userName + " booked a ticket. Tickets left: " + (availableTickets - 1));
                availableTickets--;
            } else {
                System.out.println(userName + " tried to book a ticket but none are available.");
            }
        } finally {
            lock.unlock(); // Always unlock in a finally block
        }
    }

    public int getAvailableTickets() {
        return availableTickets;
    }
}