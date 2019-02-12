package com.capgemini.molveno.restaurant.Reservation.api;

import com.capgemini.molveno.restaurant.Reservation.InvalidProposalException;
import com.capgemini.molveno.restaurant.Reservation.ReservationProposal;
import com.capgemini.molveno.restaurant.Reservation.control.GuestRepository;
import com.capgemini.molveno.restaurant.Reservation.control.ReservationRepository;
import com.capgemini.molveno.restaurant.Reservation.control.TablePlanner;
import com.capgemini.molveno.restaurant.Reservation.control.TableRepository;
import com.capgemini.molveno.restaurant.Reservation.model.Guest;
import com.capgemini.molveno.restaurant.Reservation.model.Reservation;
import com.capgemini.molveno.restaurant.Reservation.model.TableType;
import com.capgemini.molveno.restaurant.Reservation.model.Tablex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("reservation")
public class Controller {

    @Autowired
    private TablePlanner tablePlanner;

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private GuestRepository guestRepository;

    @PostMapping(value = "/checkAvailable", consumes = "application/json")
    public boolean checkAvailable(@RequestBody ReservationProposal reservationProposal1) throws InvalidProposalException {
        System.out.println("in /checkAvailable");
        return tablePlanner.checkAvailable(reservationProposal1);
    }

    @PostMapping(value = "/createReservation", consumes = "application/json")
    public Reservation createReservation(@RequestBody RequestWrapper requestWrapper) throws InvalidProposalException{
        System.out.println("in controller /createReservation");
        Assert.isTrue(tablePlanner.checkAvailable(requestWrapper.reservationProposal), "not available");
        guestRepository.save(requestWrapper.guest);
        System.out.println("Guest saved");
        Reservation reservation = tablePlanner.processReservation(requestWrapper.reservationProposal, requestWrapper.guest);
        reservationRepository.save(reservation);
        System.out.println("Reservation saved");
        return reservation;
    }

    @GetMapping(value = "/getReservations", produces = "application/json")
    public List<Reservation> getReservations(){
        List<Reservation> reservations = reservationRepository.findAll();
        System.out.println(reservations.get(0).getBeginDateTime());
        return reservations;
    }

    @GetMapping(value = "/getTables", produces = "application/json")
    public List<Tablex> getTables(){
        List<Tablex> tablexes = tableRepository.findAll();
        return tablexes;
    }

    @GetMapping("/createRoundTable")
    public void createRoundTable(){
        tableRepository.save(new Tablex(TableType.RoundTable));
    }

    @GetMapping("/createSquareTable")
    public void createSquareTable(){
        tableRepository.save(new Tablex(TableType.SquareTable));
    }

    @PostMapping(value = "/createTable")
    public void createTable(@RequestBody TableType tableType){
        tableRepository.save(new Tablex(tableType));
    }



}
