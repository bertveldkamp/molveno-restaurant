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
import java.util.List;

@Service
@Transactional
public class TablePlanner {

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    private  List<Tablex> tablexList;
    private  List<Reservation> reservationList;



    public boolean checkAvailable(ReservationProposal reservationProposal) throws InvalidProposalException {

        if (!reservationProposal.checkValidity())
        {
            InvalidProposalException invalidProposalException = new InvalidProposalException();
            throw invalidProposalException;
        }

        int numberOfPeople = reservationProposal.getNumberOfPeople();

        return !availableTables(reservationProposal).isEmpty() && numberOfPeople <= availableSeats(reservationProposal);

    }

    public void processReservation(ReservationProposal reservationProposal, Guest guest) throws InvalidProposalException{
        Assert.isTrue(checkAvailable(reservationProposal), "komt al niet door de checkAvailable");
        //Stukje voor Guest input checken
        //TODO

        //tafel toewijzen
        int numberOfPeople = reservationProposal.getNumberOfPeople();
        Tablex reservedTablex;
        if (intIsBetween(numberOfPeople,1,4)) {
            reservedTablex = firstMatchingTable(availableTables(reservationProposal), TableType.SquareTable);
            Reservation reservation = new Reservation(reservationProposal, guest, reservedTablex);
        }
        if (intIsBetween(numberOfPeople,8,12)){
            reservedTablex = firstMatchingTable(availableTables(reservationProposal), TableType.RoundTable);
            Reservation reservation = new Reservation(reservationProposal, guest, reservedTablex);
        }

    }

    List<Tablex> availableTables(ReservationProposal reservationProposal){
        List<Tablex> availableTablexes = tablexList;
        LocalDateTime proposalBeginTime = reservationProposal.getBeginTime();
        LocalDateTime proposalEndTime = reservationProposal.getEndTime();

        //Loop fills available table List
        for (Reservation reservation: reservationList) {

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


    public void addToTableList(Tablex tablex){
        tablexList.add(tablex);
    }

    public void addToReservationList(Reservation reservation){
        reservationList.add(reservation);
    }

    public boolean intIsBetween(int x, int lower, int upper){
        return lower <= x && x <= upper;
    }

    private boolean dateIsBetween(LocalDateTime x, LocalDateTime begin, LocalDateTime end){
        return begin.isBefore(x) && x.isBefore(end);
    }
}
