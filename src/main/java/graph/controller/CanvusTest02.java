package graph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CanvusTest02 {

	private final String command = "canvusTest02.gp";
	private String getPage = "/canvusTest02";

	@RequestMapping(value=command)
	public String doAction() {
		return getPage;
	}
}
