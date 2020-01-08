package com.codecool.reservationsbackend.service;


import com.codecool.reservationsbackend.model.Guest;
import com.codecool.reservationsbackend.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestStorage {

    private List<Guest> guestList = new LinkedList<>();

    @Autowired
    private GuestCreator guestCreator;

    public List<Guest> getGuestListByStatus(Status status) {
        return guestList.stream()
                .filter(guest -> guest.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public List<Guest> getGuestListByStatusAndDate(Status status, LocalDate date) {
        switch (status) {
            case CHECKOUT:
                return guestList.stream()
                        .filter(guest -> guest.getCheckOut().equals(date))
                        .collect(Collectors.toList());
            case CHECKIN:
                return guestList.stream()
                        .filter(guest -> guest.getCheckIn().equals(date))
                        .collect(Collectors.toList());
            default:
                return guestList.stream()
                        .filter(guest -> guest.getStatus().equals(status))
                        .collect(Collectors.toList());
        }
    }


    public void addGuestToList(Guest guest) {
        this.guestList.add(guest);
    }

    public List<Guest> getGuestList() {
        return guestList;
    }
}