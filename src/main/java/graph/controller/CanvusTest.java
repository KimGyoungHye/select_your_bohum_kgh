package graph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CanvusTest {

	private final String command = "canvusTest.gp";
	private String getPage = "/canvusTest";

	@RequestMapping(value=command)
	public String doAction() {
		return getPage;
	}
}
