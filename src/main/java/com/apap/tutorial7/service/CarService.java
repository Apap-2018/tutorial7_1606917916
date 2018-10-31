package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial7.model.CarModel;

/*
 * CarService
 */
public interface CarService {
//	void addCar(CarModel car);
	CarModel addCar(CarModel car);
	CarModel getCar(Long id);
	public void deleteById(Long id);
	void updateCar(Long id,CarModel car);
	List<CarModel> getListCarOrderByPriceAsc(Long dealerId);
	void deleteCar(CarModel car);
	Optional<CarModel> getCarDetailById(Long id);
	List<CarModel> viewAllCar();

}