package com.example.demoOne;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class DemoOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoOneApplication.class, args);
	}
}

@Component
class BookingCommandLineRunner implements CommandLineRunner
{
    @Override
    public void run(String... strings) throws Exception {

    }
}

interface BookingRepository extends JpaRepository<Booking, Long>
{
    Collection<Booking> findByBookingName(String bookingName);
}

@Entity
class Booking
{
	@Id @GeneratedValue
	private Long id;
	@Column(name = "booking_name")
	private String bookingNmae;

	public Booking() {
	}

	public Booking(Long id, String bookingNmae) {
		this.id = id;
		this.bookingNmae = bookingNmae;
	}

	public Long getId() {
		return id;
	}

//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getBookingNmae() {
		return bookingNmae;
	}

//	public void setBookingNmae(String bookingNmae) {
//		this.bookingNmae = bookingNmae;
//	}

	@Override
	public String toString() {
		return "Booking{" +
				"id=" + id +
				", bookingNmae='" + bookingNmae + '\'' +
				'}';
	}
}


