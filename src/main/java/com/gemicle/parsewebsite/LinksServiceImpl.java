package com.gemicle.parsewebsite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinksServiceImpl implements LinksService {
	
	@Autowired
	DataRepos dataRepos;

	@Override
	public void printLinksInConsole() {
		for (Element link : dataRepos.getLinks()) {
			System.out.println("link : " + link.attr("href"));
        }
		
	}

	@Override
	public void writeLinksToFileBuf() {
		try {
			File file = new File(dataRepos.getDirectoryFolderName());
			if (!file.exists()){
				file.createNewFile();
			}
			//System.out.println(file.getCanonicalPath());
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
			for (Element link : dataRepos.getLinks()) {
				bufferedWriter.write("link : " + link.attr("href"));
				bufferedWriter.newLine();
	        }
			bufferedWriter.close();
		} catch (IOException e) {
			System.out.println("IOException when write to file");
		}
		
	}

	@Override
	@PostConstruct
	public void initialLinksURI() {
		Document doc;
		try {
	        doc = Jsoup.connect(dataRepos.getUrl()).get();
	        Elements listLinks = doc.select("a[href]");
	        dataRepos.setLinks(listLinks);
	    } catch (IOException e) {
	    	System.out.println("IOException when initializing");
	    }
	}
}
