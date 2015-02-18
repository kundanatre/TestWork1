package com.mynews.service;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mynews.pojo.News;

// Plain old Java Object it does not extend as class or implements 
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/mynews")
public class NewsService {

  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello() {
    return "Hello Jersey";
  }

  // This method is called if XML is request
  @GET
  @Produces(MediaType.TEXT_XML)
  public String sayXMLHello() {
    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
  }

  // This method is called if HTML is request
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello() {
    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
  }
  
  @GET
  @Path("/news/{param}")
  @Produces(MediaType.APPLICATION_JSON)
  public ArrayList<News> getTopNews(@PathParam("param") String param){
	  ArrayList<News> newslist	=	new ArrayList<News>();
	  newslist.add(new News("Kundan 1", "User_1.png", "This is a first news. This is a first news. This is a first news. This is a first news. This is a first news. This is a first news.", true,false,true,"10:10 AM"));
	  newslist.add(new News("Kundan 2", "User_2.png", "This is a first news. This is a first news. This is a first news. This is a first news. This is a first news. This is a second news.", false,false,true,"10:20 AM"));
	  newslist.add(new News("Kundan 3", "User_3.png", "This is a first news. This is a first news. This is a first news. This is a first news. This is a first news. This is a third news.", true,false,false,"10:30 AM"));
	  newslist.add(new News("Kundan 4", "User_4.png", "This is a first news. This is a first news. This is a first news. This is a first news. This is a first news. This is a fourth news.",  true,false,true,"10:40 AM"));
	  newslist.add(new News("Kundan 5", "User_5.png", "This is a first news. This is a first news. This is a first news. This is a first news. This is a first news. This is a fifth news.",  true,false,true,"10:50 AM"));
	  newslist.add(new News("Kundan 6", "User_6.png", "This is a first news. This is a first news. This is a first news. This is a first news. This is a first news. This is a fifth news.",  true,false,true,"10:50 AM"));
	  newslist.add(new News("Kundan 7", "User_7.png", "This is a first news. This is a first news. This is a first news. This is a first news. This is a first news. This is a fifth news.",  true,false,true,"10:50 AM"));
	  newslist.add(new News("Kundan 8", "User_8.png", "This is a first news. This is a first news. This is a first news. This is a first news. This is a first news. This is a fifth news.",  true,false,true,"10:50 AM"));
	  newslist.add(new News("Kundan 9", "User_9.png", "This is a first news. This is a first news. This is a first news. This is a first news. This is a first news. This is a fifth news.",  true,false,true,"10:50 AM"));
	  newslist.add(new News("Kundan 10", "User_10.png", "This is a first news. This is a first news. This is a first news. This is a first news. This is a first news. This is a fifth news.",  true,false,true,"10:50 AM"));
	  newslist.add(new News("Kundan 11", "User_11.png", "This is a first news. This is a first news. This is a first news. This is a first news. This is a first news. This is a fifth news.",  true,false,true,"10:50 AM"));
	  newslist.add(new News("Kundan 12", "User_12.png", "This is a first news. This is a first news. This is a first news. This is a first news. This is a first news. This is a fifth news.",  true,false,true,"10:50 AM"));
	  
	  return newslist;
  }

} 