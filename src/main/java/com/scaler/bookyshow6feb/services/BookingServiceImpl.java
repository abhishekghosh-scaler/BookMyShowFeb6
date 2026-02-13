package com.scaler.bookyshow6feb.services;

import com.scaler.bookyshow6feb.models.*;
import com.scaler.bookyshow6feb.repositories.BookingRepository;
import com.scaler.bookyshow6feb.repositories.ShowRepository;
import com.scaler.bookyshow6feb.repositories.ShowSeatRepository;
import com.scaler.bookyshow6feb.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService
{
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final PriceCalculator priceCalculator;

    public BookingServiceImpl(ShowRepository showRepository,
                              ShowSeatRepository showSeatRepository,
                              UserRepository userRepository,
                              BookingRepository bookingRepository, PriceCalculator priceCalculator) {
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
        this.priceCalculator = priceCalculator;
    }

    @Override
    public Booking booking(List<Long> showSeatIds, Long userId, Long showId)
    {
//        * 1. Get the user by UserId
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty())
        {
            throw new RuntimeException("User not found");
        }

        User bookedBy = userOptional.get();

//        * 2. Get the show by ShowId
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty())
        {
            throw new RuntimeException("Show not found");
        }

        Show bookedShow = showOptional.get();

//        * ------ Take the lock ---------
//        * 3. Get the list of ShowSeats using showSeatIds
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        if(showSeats.isEmpty())
        {
            throw new RuntimeException("Seats for the show not found");
        }

//        * 4. Check if the seats are available
        for(ShowSeat showSeat : showSeats)
        {
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))
            {
                if(showSeat.getShowSeatStatus().equals(ShowSeatStatus.BLOCKED)
                && Duration.between(showSeat.getBookedAt().toInstant(), new Date().toInstant()).toMinutes() > 15)
                {
                    throw new RuntimeException("Blocked seat must be released");
                }
//        * 5. If not, throw an exception
                throw new RuntimeException("Seats for the show seat is not available");
            }
        }

        for(ShowSeat showSeat : showSeats)
        {
//        * 6. Update the status of the seats to 'BLOCKED'
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeat.setBookedAt(new Date());

//        * 7. Save the details to DB
            showSeatRepository.save(showSeat);
        }
//        * ------- Release the lock --------
//        * 8. Create a booking Object
        Booking booking = new Booking();
        booking.setBookedAt(new Date());
        booking.setBookedBy(bookedBy);
        booking.setPayments(new ArrayList<>());
        booking.setSeats(showSeats);
        booking.setStatus(BookingStatus.PENDING);
        booking.setTotalAmount(priceCalculator.calculatePrice(showSeats, bookedShow));

//        * 9. Save to DB and return the booking Object created
        return bookingRepository.save(booking);
    }
}

