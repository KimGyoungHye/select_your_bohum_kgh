package graph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CanvusTest03 {

	private final String command = "canvusTest03.gp";
	private String getPage = "/canvusTest03";

	@RequestMapping(value=command)
	public String doAction() {
		return getPage;
	}
}
