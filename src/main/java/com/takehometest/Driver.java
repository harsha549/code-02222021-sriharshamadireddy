package com.takehometest;

import java.util.Properties;

public class Driver {
	
	 PropertiesUtil propUtil =new PropertiesUtil();
	 CSVIngester csvIngester=new CSVIngester();
	 DownloadManager downloadManager=new DownloadManager();
	public void run(String configFileName) throws Exception {
		Properties prop=propUtil.getPropertiesFromFile(configFileName);
		String url=prop.getProperty("url");
		String fileName=prop.getProperty("fileName");
		if(url!=null && fileName!=null) {
			boolean fileDownloaded =downloadManager.downloadFile(url, fileName);
			if(fileDownloaded)
				csvIngester.parseCSV(fileName);
			else {
				System.out.println("Unable to download the file");
			}
		}
		else {
			System.out.println("Property file is missing required args url and fileName");
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Driver().setValues(new PropertiesUtil(), new DownloadManager(), new CSVIngester()).run("config.properties");
	}
	
	public  Driver setValues(PropertiesUtil prop,DownloadManager downloadManager,CSVIngester csvIngester) {
	 this.propUtil=prop;
	 this.downloadManager=downloadManager;
	 this.csvIngester=csvIngester;
	 return this;
	}

}
