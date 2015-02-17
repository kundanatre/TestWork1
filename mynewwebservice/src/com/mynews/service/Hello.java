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
public class Hello {

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
	  newslist.add(new News("Kundan", "http://api.androidhive.info/json/movies/1.jpg", "This is a first news. This is a first news. This is a first news. This is a first news. This is a first news. This is a first news.", 1,1,1,"10:10 AM"));
	  newslist.add(new News("Kundan", "http://api.androidhive.info/json/movies/2.jpg", "This is a first news. This is a first news. This is a first news. This is a first news. This is a first news. This is a first news.", 1,1,1,"10:10 AM"));
	  newslist.add(new News("Kundan", "http://api.androidhive.info/json/movies/3.jpg", "This is a first news. This is a first news. This is a first news. This is a first news. This is a first news. This is a first news.", 1,1,1,"10:10 AM"));
	  newslist.add(new News("Kundan", "http://api.androidhive.info/json/movies/4.jpg", "This is a first news. This is a first news. This is a first news. This is a first news. This is a first news. This is a first news.", 1,1,1,"10:10 AM"));
	  
	  return newslist;
  }

} 