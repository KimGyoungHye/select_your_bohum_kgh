package graph.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bohum.model.BohumDao;
import bohum.model.BohumDataBean;
import graph.model.GraphBean;
import graph.model.GraphDao;

@Controller
public class CanvusTest04 {

	private final String command = "canvusTest04.gp";
	private String getPage = "/canvusTest04";

	@Autowired
	GraphDao graphDao;
	
	@RequestMapping(value=command)
	public String doAction(HttpServletRequest request) {
		
		
		List<GraphBean> graphDataAgeNBohum = new ArrayList<GraphBean>();
		
		graphDataAgeNBohum = graphDao.GetGraphDataAgeNBohum();
		
		request.setAttribute("graphDataAgeNBohum", graphDataAgeNBohum);
		return getPage;
	}
}
