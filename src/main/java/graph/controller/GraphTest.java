package graph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GraphTest {

	private final String command = "graphTest.gp";
	private String getPage = "/graphTest";

	@RequestMapping(value=command)
	public String doAction() {
		return getPage;
	}
}
