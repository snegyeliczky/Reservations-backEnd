package com.codecool.reservationsbackend;

import com.codecool.reservationsbackend.entity.Guest;
import com.codecool.reservationsbackend.entity.Status;
import com.codecool.reservationsbackend.repositories.GuestRepository;
import com.codecool.reservationsbackend.service.GuestCreator;
import com.codecool.reservationsbackend.service.RoomCreator;
import com.codecool.reservationsbackend.service.RoomStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
public class ReservationsBackendApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationsBackendApplication.class);

    @Autowired
    private GuestRepository guestRepository;

    public static void main(String[] args) {
        SpringApplication.run(ReservationsBackendApplication.class, args);

    }

    @Bean
    @Profile("production")
    public CommandLineRunner afterInit(){

        return args -> {
            Guest bela1 =  Guest.builder().checkIn(LocalDate.of(2010,2,10))
                    .checkOut(LocalDate.of(2010,2,15))
                    .name("Béca")
                    .email("bela@bela.com")
                    .status(Status.CHECKIN)
                    .build();

            Guest Sándi =  Guest.builder().checkIn(LocalDate.now())
                    .checkOut(LocalDate.now())
                    .name("Sándi")
                    .email("sadi@sandi.com")
                    .status(Status.CHECKIN)
                    .build();

            guestRepository.save(bela1);
            guestRepository.save(Sándi);
        };
    }



}
