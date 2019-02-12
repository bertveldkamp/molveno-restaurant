package com.capgemini.molveno.restaurant.Reservation.control;

import com.capgemini.molveno.restaurant.Reservation.InvalidProposalException;
import com.capgemini.molveno.restaurant.Reservation.ReservationProposal;
import com.capgemini.molveno.restaurant.Reservation.model.Reservation;
import com.capgemini.molveno.restaurant.Reservation.model.TableType;
import com.capgemini.molveno.restaurant.Reservation.model.Tablex;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TablePlannerTest {

    @Mock
    TableRepository tableRepository;

    @Mock
    ReservationRepository reservationRepository;

    @InjectMocks
    TablePlanner tbp = new TablePlanner();

    //Test de beschikbaarheid van een oneigenlijk reserveringsvoorstel
    @Test (expected = InvalidProposalException.class)
    public void checkAvailable1() throws InvalidProposalException {
        //Given
        ReservationProposal a = new ReservationProposal();
        a.setDate(LocalDate.now().plusDays(1));
        a.setBeginTime(LocalTime.of(17,00));
        a.setNumberOfAdults(0);

        //When
        try {
            tbp.checkAvailable(a);
        }

        //Then
        catch (InvalidProposalException e){
            throw e;
        }
    }

    @Test
    //Test de beschikbaarheid van een reserveringsvoorstel met positief resultaat
    public void checkAvailable2() throws InvalidProposalException {
        //Given
        List<Tablex> tablexes = new ArrayList<Tablex>();
        tablexes.add(new Tablex(TableType.RoundTable));
        tablexes.add(new Tablex(TableType.SquareTable));
        Mockito.when(tableRepository.findAll()).thenReturn(tablexes);

        ReservationProposal a = new ReservationProposal();
        a.setDate(LocalDate.now().plusDays(1));
        a.setBeginTime(LocalTime.of(17,0));
        a.setNumberOfAdults(3);

        List<Reservation> reservations = new ArrayList<Reservation>();
        Mockito.when(reservationRepository.findAll()).thenReturn(reservations);

        boolean result;

        //When
        try {
            result = tbp.checkAvailable(a);
        }catch (InvalidProposalException e){
            throw e;
        }

        //Then
        Assert.assertTrue(result);
    }

    @Test
    //Test de beschikbaarheid van een reserveringsvoorstel die faalt vanwege te weinig plekken maar geen lege tafellijst
    public void checkAvailable3() throws InvalidProposalException {
        //Given (parts to be replaced with Mock's when code is rewritten to use repositories)
        List<Tablex> tablexes = new ArrayList<Tablex>();
        tablexes.add(new Tablex(TableType.RoundTable));
        tablexes.add(new Tablex(TableType.SquareTable));
        Mockito.when(tableRepository.findAll()).thenReturn(tablexes);

        ReservationProposal a = new ReservationProposal();
        a.setDate(LocalDate.now().plusDays(1));
        a.setBeginTime(LocalTime.of(17,0));
        a.setNumberOfAdults(20);

        List<Reservation> reservations = new ArrayList<Reservation>();
        Mockito.when(reservationRepository.findAll()).thenReturn(reservations);

        boolean result;

        //When
        try {
            result = tbp.checkAvailable(a);
        }catch (InvalidProposalException e){
            throw e;
        }
        //Then
        Assert.assertFalse(result);

    }

    @Test
    public void processReservation() {
    }

    @Test
    public void availableTables() {
    }

    @Test
    public void firstMatchingTable() {
    }

    @Test
    public void availableSeats() {
    }

    @Test
    public void addToTableList() {
    }

    @Test
    public void addToReservationList() {
    }

    @Test
    public void intIsBetween() {
    }
}