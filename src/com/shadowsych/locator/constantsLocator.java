package com.shadowsych.locator;
 
public class constantsLocator {
 
   // get the local directory of this project
   public static final String workingDir = System.getProperty("user.dir");
	   
   // country data
   public static final String DATABASE_COUNTRY_PATH = workingDir + "\\databases\\GeoLite2-Country.mmdb";
    
   // city data
   public static final String DATABASE_CITY_PATH = workingDir + "\\databases\\GeoLite2-City.mmdb";
    
}