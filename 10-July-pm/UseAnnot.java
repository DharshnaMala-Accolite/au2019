package com.accolite.au;

@Servlet(servletName = "controlServlet", urlPattern = "*.html")
public class UseAnnot {
void print()
{
	System.out.println("UseAnnot class uses the custom Servlet Annotation");
}
}
