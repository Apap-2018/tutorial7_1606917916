package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.repository.CarDb;

/*
 * CarServiceImpl
 */
@Service
@Transactional
public class CarServiceImpl implements CarService {
	@Autowired
	private CarDb CarDb;
		
	@Override
	public CarModel addCar(CarModel car){
		return CarDb.save(car);
		//return car;
	}
//	public void addCar(CarModel Car) {
//		CarDb.save(Car);
//	}
	
	@Override
	public void deleteById(Long id) {
		CarDb.deleteById(id);
	}

	@Override
	public void updateCar(Long id, CarModel newCar) {
		CarModel carUpdated = CarDb.findById(id).get();
		carUpdated.setBrand(newCar.getBrand());
		carUpdated.setType(newCar.getType());
		carUpdated.setPrice(newCar.getPrice());
		carUpdated.setAmount(newCar.getAmount());
		CarDb.save(carUpdated);
	}
	
	public CarModel getCar(Long id) {
		return CarDb.findById(id).get();
	}

	@Override
	public List<CarModel> getListCarOrderByPriceAsc(Long dealerId) {
		return CarDb.findByDealerIdOrderByPriceAsc(dealerId);
	}

	@Override
	public void deleteCar(CarModel car) {
		// TODO Auto-generated method stub
		CarDb.delete(car);
	}

	@Override
	public Optional<CarModel> getCarDetailById(Long id) {
		return CarDb.findById(id);
	}

	@Override
	public List<CarModel> viewAllCar() {
		return CarDb.findAll();
	}
}