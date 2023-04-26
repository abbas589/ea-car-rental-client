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
import java.time.LocalDate;

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


		System.out.println("UPDATING CUSTOMERS==============");
		restTemplate.put(customerUrl+"/update/{customernumber}", new CustomerDto(1L,"Farida Irekeola","fashir@gmail.com"),1L);
		restTemplate.put(customerUrl+"/update/{customernumber}", new CustomerDto(2L,"Saidu Ogono","smusa@gmail.com"),2L);
		System.out.println("CREATING CARS DONE 5 ==============");

		System.out.println("GET ALL CUSTOMERS==============");
		CustomersDto customersDto = restTemplate.getForObject(customerUrl + "", CustomersDto.class);
		System.out.println("Customers ;:::: " + customersDto);
		System.out.println("GET ALL CUSTOMERS DONE 1 ==============");

		System.out.println("GET ALL CUSTOMERS==============");
		UriComponentsBuilder ajouriBuilder = UriComponentsBuilder.fromUriString(customerUrl+"/search")
				.queryParam("searchBy", "customernumber")
				.queryParam("value", 1L);
		CustomersDto ajoDtos = restTemplate.getForObject(ajouriBuilder.toUriString(), CustomersDto.class);

		System.out.println("Customers Ajo ;:::: " + ajoDtos);
		System.out.println("GET ALL CUSTOMERS DONE 1 ==============");




		System.out.println("SEARCH CARS ==============");


		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(reservationUrl+"/search")
				.queryParam("type", "IS250");
		CarsDto carsDto = restTemplate.getForObject(uriBuilder.toUriString(), CarsDto.class);
		System.out.println("Car DTO REST Response searchCarFromFleet()::: {} "+carsDto);
		System.out.println("SEARCH CARS DONE  ==============");

		System.out.println("CREATING RESERVATIONS ==============");
		restTemplate.postForLocation(reservationUrl+"/create", new ReservationRequestDto("IS250",1L, LocalDate.of(2023,4,26), LocalDate.of(2023,12,26)));
		restTemplate.postForLocation(reservationUrl+"/create", new ReservationRequestDto("COROLLA",2L,LocalDate.of(2023,4,26), LocalDate.of(2023,11,26)));
		restTemplate.postForLocation(reservationUrl+"/create", new ReservationRequestDto("GLE450",3L,LocalDate.of(2023,4,26), LocalDate.of(2023,10,26)));
		restTemplate.postForLocation(reservationUrl+"/create", new ReservationRequestDto("PATHFINDER",4L,LocalDate.of(2023,4,26), LocalDate.of(2023,9,26)));
		restTemplate.postForLocation(reservationUrl+"/create", new ReservationRequestDto("IS250",5L,LocalDate.of(2023,4,26), LocalDate.of(2023,8,26)));
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



		System.out.println("GET ALL CUSTOMERS WITH PAYMENT AND RESERVATION INFO==============");
		CustomerDataDto customer = restTemplate.getForObject(customerUrl + "/{customerNumber}/get", CustomerDataDto.class, 1L);

		System.out.println("Customers ;:::: " + customer);
		System.out.println("GET ALL CUSTOMERS WITH PAYMENT AND RESERVATION INFO DONE 1 ==============");


		System.out.println("GET ALL CAR DATA WITH  RESERVATION INFO==============");
		CarDataPojo carDataPojo = restTemplate.getForObject(reservationUrl + "/{licensePlate}/get", CarDataPojo.class, "AB1");

		System.out.println("CarDataPojo ;:::: " + customer);
		System.out.println("GET ALL CAR DATA WITH  RESERVATION INFO DONE 1 ==============");

	}
}
