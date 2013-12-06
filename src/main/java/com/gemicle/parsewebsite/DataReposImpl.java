package com.gemicle.parsewebsite;

import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

@Repository
public class DataReposImpl implements DataRepos {
	
	private Elements links;
	
	@Override
	public Elements getLinks() {
		return links;
	}
	
	@Override
	public void setLinks(Elements links) {
		this.links = links;
	}

	@Override
	public String getUrl() {
		return "https://www.google.com.ua";
	}

	@Override
	public String getDirectoryFolderName() {
		return "links.txt";
	}

}
