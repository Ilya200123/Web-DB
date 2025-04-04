package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImp;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	private final CarServiceImp carService;

	public HelloController(CarServiceImp carService) {
		this.carService = carService;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);

		return "index";
	}

	@GetMapping("/cars")
	public String showCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
		List<Car> cars = carService.selectAllCars(count);
		model.addAttribute("cars", cars);
		return "cars";
	}

}