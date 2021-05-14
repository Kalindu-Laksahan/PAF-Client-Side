package com;
import model.researcher;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class researcherAPI
 */
@WebServlet("/researcherAPI")
public class researcherAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       researcher reObj = new researcher();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public researcherAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String output = reObj.insertResearcher(request.getParameter("ResearcherName"),request.getParameter("ResearcherEmail"),request.getParameter("AboutResearcher"),request.getParameter("ProjectName"),request.getParameter("ProjectDescription"),request.getParameter("ProjectPrice"));
		
		response.getWriter().write(output); 
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map paras = getParasMap(request);
		
		String output = reObj.updateResearcher(paras.get("hidResearcherIDSave").toString(), paras.get("ResearcherName").toString(), paras.get("ResearcherEmail").toString(),paras.get("AboutResearcher").toString(),paras.get("ProjectName").toString(),paras.get("ProjectDescription").toString(),paras.get("ProjectPrice").toString());
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Map paras = getParasMap(request);
		String output = reObj.deleteResearcher(paras.get("ResearcherID").toString());
		response.getWriter().write(output);
	}

	
	private static Map getParasMap(HttpServletRequest request) 
	{ 
	 Map<String, String> map = new HashMap<String, String>(); 
	try
	 { 
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
	 String queryString = scanner.hasNext() ? 
	 scanner.useDelimiter("\\A").next() : ""; 
	 scanner.close(); 
	 String[] params = queryString.split("&"); 
	 for (String param : params) 
	 { 
	String[] p = param.split("=");
	 map.put(p[0], p[1]); 
	 } 
	 } 
	catch (Exception e) 
	 { 
	 } 
	return map; 
	}

	
	
	
}
