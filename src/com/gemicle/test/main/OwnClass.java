package com.gemicle.test.main;

import org.jsoup.select.Elements;

import com.gemicle.test.service.DisplayServiceImpl;
import com.gemicle.test.service.LinksServiceImpl;

public class OwnClass {
	public static String uri = "https://www.google.com.ua";
	public static Elements links;
	
	public static void main(String[] args){
		LinksServiceImpl linkService = new LinksServiceImpl();
		DisplayServiceImpl displayService = new DisplayServiceImpl(uri);
		displayService.run();
		links=linkService.initialLinksURI(uri);
		if(links!=null){
			linkService.printLinksInConsole(links);
			linkService.writeLinksToFileBuf(links);
		}else{
			System.out.println("Non found links");
		}
	}
}
