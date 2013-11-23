package com.gemicle.test.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinksServiceImpl implements LinksService {
	private final static String FILE_NAME = "links.txt";
	
	@Override
	public void printLinksInConsole(Elements links) {
		for (Element link : links) {
			System.out.println("link : " + link.attr("href"));
        }
		
	}

	@Override
	public void writeLinksToFileBuf(Elements links) {
		try {
			File file = new File(FILE_NAME);
			if (!file.exists()){
				file.createNewFile();
			}
			System.out.println(file.getCanonicalPath());
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
			for (Element link : links) {
				bufferedWriter.write("link : " + link.attr("href"));
				bufferedWriter.newLine();
	        }
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Elements initialLinksURI(String uri) {
		Document doc;
		try {
	        doc = Jsoup.connect(uri).get();
	        Elements listLinks = doc.select("a[href]");
	        return listLinks;
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return null;
	}

	

}
