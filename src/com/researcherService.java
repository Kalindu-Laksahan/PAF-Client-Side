package com;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*; 
//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

import model.researcher;

@Path("/researcher")
public class researcherService {

	//create researcher object
	researcher reObj = new researcher(); 
	
	//implement Get method to Retrieve data
	@GET
	@Path("/ViewResearcher")
	@Produces(MediaType.TEXT_HTML)
	public String readResearcher() {
		return reObj.readResearcher();
	}

	researcher reObj1 = new researcher(); 

	//implement post method to insert data
	@POST
	@Path("/InsertResearcher")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertResearcher(@FormParam("ResearcherName") String ResearcherName,
			@FormParam("ResearcherEmail") String ResearcherEmail, @FormParam("AboutResearcher") String AboutResearcher,
			@FormParam("ProjectName") String ProjectName, @FormParam("ProjectDescription") String ProjectDescription,
			@FormParam("ProjectPrice") String ProjectPrice) {
		String output = reObj1.insertResearcher(ResearcherName, ResearcherEmail, AboutResearcher, ProjectName,
				ProjectDescription, ProjectPrice);
		return output;
	}

	//implement Put method to Update data
	@PUT
	@Path("/UpdateResearcher")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateResearcher(String itemData) {
		// Convert the input string to a JSON object
		JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();
		// Read the values from the JSON object
		String ResearcherID = itemObject.get("ResearcherID").getAsString();
		String ResearcherName = itemObject.get("ResearcherName").getAsString();
		String ResearcherEmail = itemObject.get("ResearcherEmail").getAsString();
		String AboutResearcher = itemObject.get("AboutResearcher").getAsString();
		String ProjectName = itemObject.get("ProjectName").getAsString();
		String ProjectDescription = itemObject.get("ProjectDescription").getAsString();
		String ProjectPrice = itemObject.get("ProjectPrice").getAsString();

		String output = reObj.updateResearcher(ResearcherID, ResearcherName, ResearcherEmail, AboutResearcher,
				ProjectName, ProjectDescription, ProjectPrice);
		return output;
	}
	
	//implement Delete method to delete data
	
	@DELETE
	@Path("/DeleteResearcher")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteResearcher(String ResearcherData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(ResearcherData, "", Parser.xmlParser());

		// Read the value from the element <itemID>
		String ResearcherID = doc.select("ResearcherID").text();
		String output = reObj.deleteResearcher(ResearcherID);
		return output;

	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
