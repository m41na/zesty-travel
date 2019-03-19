package com.practicaldime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.practicaldime.common.util.AppResult;
import com.practicaldime.dao.entity.Airline;
import com.practicaldime.dao.entity.Airplane;
import com.practicaldime.dao.entity.Airport;
import com.practicaldime.dao.entity.Country;
import com.practicaldime.dao.entity.Flight;
import com.practicaldime.dao.repo.AirlinesDao;
import com.practicaldime.dao.repo.AirplanesDao;
import com.practicaldime.dao.repo.AirportsDao;
import com.practicaldime.dao.repo.CountriesDao;
import com.practicaldime.dao.repo.FlightsDao;

@Service
@Transactional
public class TravelServiceImpl implements TravelService{
    
    private final AirportsDao airports;
    private final AirlinesDao airlines;
    private final AirplanesDao airplanes;
    private final FlightsDao flights;
    private final CountriesDao countries;

    public TravelServiceImpl(
    		@Autowired AirportsDao airports, 
    		@Autowired AirlinesDao airlines, 
    		@Autowired AirplanesDao airplanes, 
    		@Autowired FlightsDao flights,
    		@Autowired CountriesDao countries) {
		super();
		this.airports = airports;
		this.airlines = airlines;
		this.airplanes = airplanes;
		this.flights = flights;
		this.countries = countries;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public AppResult<Airline> create(Airline airline) {
		return airlines.create(airline);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public AppResult<List<Airline>> findAirliness(int start, int size) {
		return airlines.retrieve(start, size);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public AppResult<Airplane> create(Airplane airplane) {
		return airplanes.create(airplane);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public AppResult<List<Airplane>> findAirplanes(int start, int size) {
		return airplanes.retrieve(start, size);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public AppResult<Airport> create(Airport airport) {
		return airports.create(airport);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public AppResult<List<Airport>> findAirports(int start, int size) {
		return airports.retrieve(start, size);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public AppResult<Country> create(Country country) {
		return countries.create(country);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public AppResult<List<Country>> retrieveCountries(int start, int size) {
		return countries.retrieve(start, size);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public AppResult<Flight> create(Flight flight) {
		return flights.create(flight);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public AppResult<List<Flight>> retrieveFlights(int start, int size) {
		return flights.retrieve(start, size);
	}
}
