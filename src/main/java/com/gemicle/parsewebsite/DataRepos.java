package com.gemicle.parsewebsite;

import org.jsoup.select.Elements;

public interface DataRepos {
	
	public String getUrl();
	
	public String getDirectoryFolderName();
	
	public Elements getLinks();
	
	public void setLinks(Elements links);

}
