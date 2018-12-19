package com.nagarro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.utils.ConstantsUtil;

@Controller
public class LoginController {

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied() {
		return "403";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(@RequestParam(value = "error", required = false) String error) {
		ModelAndView modelAndView = new ModelAndView("login");
		if (error != null)
			modelAndView.addObject("error", ConstantsUtil.AUTHENTICATION_FAIL_MESSGAE);
		return modelAndView;
	}
}
