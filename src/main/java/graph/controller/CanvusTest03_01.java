package graph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CanvusTest03_01 {

	private final String command = "canvusTest03_01.gp";
	private String getPage = "/canvusTest03_01";

	@RequestMapping(value=command)
	public String doAction() {
		return getPage;
	}
}
