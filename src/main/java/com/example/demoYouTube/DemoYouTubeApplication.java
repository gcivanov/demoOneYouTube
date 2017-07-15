package com.example.demoYouTube;

//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
////import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;

//@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class DemoYouTubeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoYouTubeApplication.class, args);

	}
}

@Component
class BookingCommandLineRunner implements CommandLineRunner
{
	@Override
	public void run(String... strings) throws Exception {
		for( Booking b : this.bookingRepository.findAll() ) {
			System.out.println( b.toString() );
		}
	}

	@Autowired BookingRepository bookingRepository;

}

interface BookingRepository extends JpaRepository<Booking, Long>
{
	Collection<Booking> findByBookingName(String bookingName);
}

@RestController
class BookingRestController {

	@RequestMapping("/bookings")
	Collection<Booking> bookings () {
		return this.bookingRepository.findAll();
	}
	@Autowired BookingRepository bookingRepository;
}


@Entity
class Booking
{
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "booking_name")
	private String bookingName;

	public Booking() {
	}

	public Booking(Long id, String bookingNmae) {
		this.id = id;
		this.bookingName = bookingNmae;
	}

	public Long getId() {
		return id;
	}

//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getBookingNmae() {
		return bookingName;
	}

//	public void setBookingNmae(String bookingNmae) {
//		this.bookingNmae = bookingNmae;
//	}

	@Override
	public String toString() {
		return "Booking{" +
				"id=" + id +
				", bookingNmae='" + bookingName + '\'' +
				'}';
	}
}




