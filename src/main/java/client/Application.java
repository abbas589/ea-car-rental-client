package client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;

@SpringBootApplication
public class Application implements CommandLineRunner {

	RestTemplate restTemplate = new RestTemplate();

	Logger logger = LoggerFactory.getLogger(Application.class);
	private String customerUrl = "http://localhost:8200/customer";
	private String reservationUrl = "http://localhost:8200/reservation";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		// ADD CARS

		System.out.println("CREATING CUSTOMERS==============");
		restTemplate.postForLocation(customerUrl+"/create", new CustomerDto(1L,"Farida Ashir","fashir@gmail.com"));
		restTemplate.postForLocation(customerUrl+"/create", new CustomerDto(2L,"Saidu Musa","smusa@gmail.com"));
		restTemplate.postForLocation(customerUrl+"/create", new CustomerDto(3L,"Ayomide Oduba","aoduba@gmail.com"));
		restTemplate.postForLocation(customerUrl+"/create", new CustomerDto(4L,"Salim Shuaibu","shuaibu@gmail.com"));
		restTemplate.postForLocation(customerUrl+"/create", new CustomerDto(5L,"Abdaz Lasisi","alasisi@gmail.com"));
		System.out.println("CREATING CARS DONE 5 ==============");


		System.out.println("SEARCH CARS ==============");


		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(reservationUrl+"/search")
				.queryParam("type", "IS250");
		CarsDto carsDto = restTemplate.getForObject(uriBuilder.toUriString(), CarsDto.class);
		logger.info("Car DTO REST Response searchCarFromFleet()::: {}",carsDto);
		System.out.println("SEARCH CARS DONE  ==============");

		System.out.println("CREATING RESERVATIONS ==============");
		restTemplate.postForLocation(reservationUrl+"/create", new ReservationRequestDto("IS250",1L));
		restTemplate.postForLocation(reservationUrl+"/create", new ReservationRequestDto("COROLLA",2L));
		restTemplate.postForLocation(reservationUrl+"/create", new ReservationRequestDto("GLE450",3L));
		restTemplate.postForLocation(reservationUrl+"/create", new ReservationRequestDto("PATHFINDER",4L));
		restTemplate.postForLocation(reservationUrl+"/create", new ReservationRequestDto("IS250",5L));
		System.out.println("CREATING RESERVATIONS DONE 5 ==============");


		System.out.println("PICKING UP 3 CARS==============");
		restTemplate.postForLocation(reservationUrl+"/{licensePlate}/pickup/{customerNumber}", ReservationDto.class,"AB1",1L);
		restTemplate.postForLocation(reservationUrl+"/{licensePlate}/pickup/{customerNumber}", ReservationDto.class,"AB4",2L);
		restTemplate.postForLocation(reservationUrl+"/{licensePlate}/pickup/{customerNumber}", ReservationDto.class,"AB7",3L);
		System.out.println("PICKING UP 2 CARS DONE==============");


		System.out.println("RETURNING 3 CARS==============");
		restTemplate.postForLocation(reservationUrl+"/{licensePlate}/return", new ReturnCarDto("123394898223","567", BigDecimal.valueOf(500),"DEBIT_CARD",1L),"AB1");
		restTemplate.postForLocation(reservationUrl+"/{licensePlate}/return", new ReturnCarDto("123394898224","568", BigDecimal.valueOf(450),"CREDIT_CARD",2L),"AB4");
		restTemplate.postForLocation(reservationUrl+"/{licensePlate}/return", new ReturnCarDto("123394898225","569", BigDecimal.valueOf(300),"DEBIT_CARD",3L),"AB7");
    	System.out.println("RETURNING 3 CARS DONE==============");



	}
}
