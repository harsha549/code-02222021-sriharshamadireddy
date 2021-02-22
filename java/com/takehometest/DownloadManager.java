package com.takehometest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class DownloadManager {

	
	 public Boolean downloadFile(String url,String fileName) throws IOException,RuntimeException {
           
	        try {
	            //connectionTimeout, readTimeout = 10 seconds
	        	if(url==null || fileName ==null ) {
	        		if(url==null && fileName==url)
	        		throw new RuntimeException("Please pass the url,fileName values");
	        		else if(url==null)
	        			throw new RuntimeException("Please pass the url ");	
	        		else
	        			throw new RuntimeException("Please pass the fileName");
	        	}
	        	URL apiUrl =getUrl(url);
	            FileUtils.copyURLToFile(apiUrl, new File(fileName), 10000, 10000);
	            return true;

	        } catch (FileNotFoundException e) {
	        	e.printStackTrace();
	            throw e;
	        	//e.printStackTrace();
	        }

	    }
	 
	 public URL getUrl(String url) throws MalformedURLException {
		 return new URL(url);
	 }
	 
	 public static void main(String[] args) {
		 String url="https://raw.githubusercontent.com/vamstar/challenge/master/Dataset3.csv";
		 String toFile="csv.txt";
		 try {
		 new DownloadManager().downloadFile(url, toFile);
		 }
		 catch(IOException e) {
			 System.out.println(e.getMessage()+" "+e.getLocalizedMessage());
		 }
	 }
	
}
