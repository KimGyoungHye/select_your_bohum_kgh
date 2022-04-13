package graph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CanvusTest01 {

	private final String command = "canvusTest01.gp";
	private String getPage = "/canvusTest01";

	@RequestMapping(value=command)
	public String doAction() {
		return getPage;
	}
}
