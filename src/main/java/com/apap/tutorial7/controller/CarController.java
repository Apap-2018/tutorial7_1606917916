package com.apap.tutorial7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.model.DealerModel;
import com.apap.tutorial7.service.CarService;
import com.apap.tutorial7.service.DealerService;

/*
 * CarController
 */
@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;

	@Autowired
	private DealerService dealerService;

//	@Autowired
//	RestTemplate restTemplate;
//
//	@Bean
//	public  RestTemplate rest(){
//		return new RestTemplate();
//	}
	//	@RequestMapping(value = "/car/update/{id}", method = RequestMethod.GET)
//	private String updateCar(@PathVariable(value = "id") long id, Model model) {
//		CarModel car = carService.getCar(id);
//		model.addAttribute("car",car);
//		return "update-car";
//	}
//
//	@RequestMapping(value = "/car/update/{id}", method = RequestMethod.POST)
//	private String updateCarSubmit(@PathVariable(value = "id") long id, @ModelAttribute CarModel car) {
//		carService.updateCar(id, car);
//		return "update";
//	}
	// PUT update car
	@PutMapping(value = "/{id}")
	private String updateCarSubmit(
			// {url}/car/{carID}?brand={brand}&type
			//={type}&price={price}&amount={amo
			//unt}&dealerID={dealerID}
			@PathVariable(value = "id") long id,
			@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "price", required = false) Long price,
			@RequestParam(value = "amount", required = false) Integer amount,
			@RequestParam(value = "dealerId", required = false) Long dealerId) {
//		CarModel car = (CarModel) carService.getCarDetailById(id).get();
		CarModel car = carService.getCarDetailById(id).get();
		if (car.equals(null)){
			return "Couldn't find your car";
		}

		if (brand != null){
			car.setBrand(brand);
		}

		if (type != null){
			car.setType(type);
		}

		if (price != null){
			car.setPrice(price);
		}

		if (amount != null){
			car.setAmount(amount);
		}
//
//		if (dealer != null){
//			DealerModel optDealer = (DealerModel) dealerService.getDealerDetailById(id).get();
//			if (optDealer != null){
//				return "Couldn't find your dealer";
//			}
//		}
		carService.updateCar(id, car);
		return "Car update success";
	}

	// POST add car
	@PostMapping()
	private CarModel addCarSubmit(@RequestBody CarModel car){
		return carService.addCar(car);
	}

	// GET car
	@GetMapping(value = "/{id}")
	private CarModel viewCar(@PathVariable("id") long id, Model model){
		return carService.getCarDetailById(id).get();
	}

	// GET all car
	@GetMapping()
	private List<CarModel> viewAllDealer(Model model){
		List<CarModel> listCar = carService.viewAllCar();
		return listCar;
	}


	// DELETE car
	@DeleteMapping(value = "/{id}")
	private String deleteCar(@RequestParam("id") long id, Model model){
		CarModel car = carService.getCarDetailById(id).get();
		carService.deleteCar(car);
		return "Car has been deleted";
	}

}
