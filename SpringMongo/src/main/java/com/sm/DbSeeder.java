
package com.sm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
	private HotelRepository hotelRepository;
	public static Hotel marriot = new Hotel("Marriot", 130, new Address("Paris", "France"),
			Arrays.asList(new Review("John", 8, false), new Review("Mary", 7, true)));

	public DbSeeder(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		Hotel marriot = new Hotel("Marriot", 130, new Address("Paris", "France"),
				Arrays.asList(new Review("John", 8, false), new Review("Mary", 7, true)));

		Hotel ibis = new Hotel("Ibis", 90, new Address("Bucharest", "Romania"),
				Arrays.asList(new Review("Teddy", 9, true)));

		Hotel sofitel = new Hotel("Sofitel", 200, new Address("Rome", "Italy"), new ArrayList<>());

		// drop all hotels
		this.hotelRepository.deleteAll();

		// add our hotels to the database
		List<Hotel> hotels = Arrays.asList(marriot, ibis, sofitel);
		this.hotelRepository.saveAll(hotels);

		System.out.println("Listing the document details:");
		for (Hotel hotel : hotelRepository.findAll()) {
			System.out.println(hotel);
		}

		System.out.println("Listing only one founded document");
		System.out.println(hotelRepository.findByName("Ibis"));
	}
}
