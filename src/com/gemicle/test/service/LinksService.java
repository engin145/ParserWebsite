package com.gemicle.test.service;

import org.jsoup.select.Elements;

public interface LinksService {
	
	public Elements initialLinksURI(String uri);
	
	public void printLinksInConsole(Elements links);
		
	public void writeLinksToFileBuf(Elements links);

}
