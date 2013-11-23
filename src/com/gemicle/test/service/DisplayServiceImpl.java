package com.gemicle.test.service;

import java.awt.Desktop;
import java.net.URI;

public class DisplayServiceImpl implements DisplayService, Runnable{
	public String uri;
	
	public DisplayServiceImpl(String uri){
		setURI(uri);
	}
	
	@Override
	public void setURI(String uri) {
		this.uri=uri;		
	}

	@Override
	public void openBrowser() {
		Desktop desktop=Desktop.getDesktop();
		try{
			desktop.browse(new URI(uri));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		openBrowser();
	}
}
