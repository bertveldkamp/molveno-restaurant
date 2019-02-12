package com.capgemini.molveno.restaurant.Reservation.control;

import com.capgemini.molveno.restaurant.Reservation.InvalidProposalException;
import com.capgemini.molveno.restaurant.Reservation.ReservationProposal;
import com.capgemini.molveno.restaurant.Reservation.model.Guest;
import com.capgemini.molveno.restaurant.Reservation.model.Reservation;
import com.capgemini.molveno.restaurant.Reservation.model.Tablex;
import com.capgemini.molveno.restaurant.Reservation.model.TableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TablePlanner {

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private ReservationRepository reservationRepository;


    public boolean checkAvailable(ReservationProposal reservationProposal) throws InvalidProposalException {

        if (!reservationProposal.checkValidity())
        {
            InvalidProposalException invalidProposalException = new InvalidProposalException();
            throw invalidProposalException;
        }

        int numberOfPeople = reservationProposal.getNumberOfPeople();

        return !availableTables(reservationProposal).isEmpty() && numberOfPeople <= availableSeats(reservationProposal);

    }

    public Reservation processReservation(ReservationProposal reservationProposal, Guest guest) throws InvalidProposalException{
        Assert.isTrue(checkAvailable(reservationProposal), "komt al niet door de checkAvailable");
        //Stukje voor Guest input checken
        //

        //tafel toewijzen
        int numberOfPeople = reservationProposal.getNumberOfPeople();
        Reservation reservation = null;
        List<Tablex> reservedTablex = new ArrayList<Tablex>();
        if (intIsBetween(numberOfPeople,1,4)) {
            reservedTablex.add(firstMatchingTable(availableTables(reservationProposal), TableType.SquareTable));
            reservation = new Reservation(reservationProposal, guest, reservedTablex);
        }
        if (intIsBetween(numberOfPeople, 5, 8)) {
            reservedTablex.add(firstMatchingTable(availableTables(reservationProposal), TableType.SquareTable));
            reservedTablex.add(firstMatchingTable(availableTables(reservationProposal), TableType.SquareTable));
            reservation = new Reservation(reservationProposal, guest, reservedTablex);
        }
        if (intIsBetween(numberOfPeople,9,12)){
            reservedTablex.add(firstMatchingTable(availableTables(reservationProposal), TableType.RoundTable));
            reservation = new Reservation(reservationProposal, guest, reservedTablex);
        }
        return reservation;
    }

    List<Tablex> availableTables(ReservationProposal reservationProposal){
        List<Tablex> availableTablexes = tableRepository.findAll();
        LocalDateTime proposalBeginTime = reservationProposal.getBeginTime();
        LocalDateTime proposalEndTime = reservationProposal.getEndTime();

        //Loop fills available table List
        for (Reservation reservation: reservationRepository.findAll()) {

            LocalDateTime end = reservation.getEndDateTime();
            LocalDateTime begin = reservation.getBeginDateTime();


            if (dateIsBetween(proposalBeginTime, begin, end) || dateIsBetween(proposalEndTime, begin, end)){
                availableTablexes.remove(reservation.getTableId());
            }
        }
        return availableTablexes;
    }

    Tablex firstMatchingTable(List<Tablex> tablexList, TableType tableType){
        for (Tablex tablex : tablexList) {
            if (tablex.getType() == tableType){
                return tablex;
            }
        }
        return null;
    }

    int availableSeats(ReservationProposal reservationProposal){
        int seats = 0;

        for (Tablex tablex : availableTables(reservationProposal)) {
            seats = seats + tablex.getType().getValue();
        }
        return seats;
    }

    public boolean intIsBetween(int x, int lower, int upper){
        return lower <= x && x <= upper;
    }

    private boolean dateIsBetween(LocalDateTime x, LocalDateTime begin, LocalDateTime end){
        return begin.isBefore(x) && x.isBefore(end);
    }
}
