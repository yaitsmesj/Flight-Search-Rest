package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.model.FlightDetail;
import com.nagarro.model.UserInput;
import com.nagarro.service.FlightDetailsService;

@Controller
public class FlightDetailsController {

	@Autowired
	FlightDetailsService flightDetailsService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView openUserInput() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("userInput", new UserInput());
		return modelAndView;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView showAvailableFlights(@ModelAttribute("userInput") UserInput userInput) {
		ModelAndView modelAndView = new ModelAndView("result");

		List<FlightDetail> flightList = flightDetailsService.findFlights(userInput);
		modelAndView.addObject("flightList", flightList);
		modelAndView.addObject("userFlight", userInput);

		return modelAndView;
	}

}
