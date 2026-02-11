package com.scaler.bookyshow6feb.services;

import com.scaler.bookyshow6feb.models.Booking;
import com.scaler.bookyshow6feb.repositories.BookingRepository;
import com.scaler.bookyshow6feb.repositories.ShowRepository;
import com.scaler.bookyshow6feb.repositories.ShowSeatRepository;
import com.scaler.bookyshow6feb.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService
{
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;

    public BookingServiceImpl(ShowRepository showRepository,
                              ShowSeatRepository showSeatRepository,
                              UserRepository userRepository,
                              BookingRepository bookingRepository) {
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking booking(List<Long> showSeatIds, Long userId, Long showId)
    {
        /*
        * 1. Get the user by UserId
        * 2. Get the show by ShowId
        * ------ Take the lock ---------
        * 3. Get the list of ShowSeats using showSeatIds
        * 4. Check if the seats are available
        * 5. If not, throw an exception
        * 6. Update the status of the seats to 'BLOCKED'
        * 7. Save the details to DB
        * ------- Release the lock --------
        * 8. Create a booking Object
        * 9. Save to DB and return the booking Object created
        * */
        return null;
    }
}

