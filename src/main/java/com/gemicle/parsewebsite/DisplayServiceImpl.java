package com.gemicle.parsewebsite;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisplayServiceImpl implements DisplayService{
	
	@Autowired
	DataRepos dataRepos;
	
	@Override
	public void openBrowser(){
		Desktop desktop=Desktop.getDesktop();
		try{
			desktop.browse(new URI(dataRepos.getUrl()));
		}catch(URISyntaxException e){
			System.out.println("URISyntaxException");
		}catch(IOException e){
			System.out.println("IOException");
		}catch(Exception e){
			System.out.println("Other exception");
		}
		
	}
	
	
	@Override
	public void run() {
		openBrowser();
		
	}
}
