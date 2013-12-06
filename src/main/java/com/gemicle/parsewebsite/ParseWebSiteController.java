package com.gemicle.parsewebsite;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ParseWebSiteController {
	
	@Autowired
	DisplayService displayService;
	
	@Autowired
	LinksService linkService;

	@PostConstruct
	public void startUpApplication(){
		displayService.run();
		try{
			linkService.printLinksInConsole();
		}catch(NullPointerException e){
			System.out.println("NullPointerException");
		}
		try{
			linkService.writeLinksToFileBuf();
		}catch(NullPointerException e){
			System.out.println("NullPointerException");
		}
	}
	
}
