package aero.dnk.infomonitor.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Maps security requests.
 */
@Controller
public class SecurityController {
	/**
	 * Maps requests to /login.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Model model) {
		return "login";
	}
}