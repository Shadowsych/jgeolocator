![Alt text](/rsrc/icon.png)
# Overview
JGeolocator(or Java Geolocator) is a Java-based application that is used to locate a person with his or her IP Address. 
The code uses the GeoIP2 API - http://maxmind.github.io/GeoIP2-java/
Proper documentation is provided below the README.

# Dependencies
JGeolocator utilizes two forms.
- The first form is an editable source code for programmers to code
- The second form is a default GUI to make an easy-to-use interface for the user
	- The default form is the JGeolocator.jar file
	- The jar file MUST be in the same directory as the original source. 
	- This is database dependencies are in certain directories to work
	
# Default GUI Overlook
![Alt text](/rsrc/gui.PNG)

# Setup
Copy and paste the entire JGeolocator's "com" folder into your project's "src" folder
Copy and paste the entire JGeolocator's "databases" folder in your project's main directory

# Documentation
Import the geoLocator class
```
import com.shadowsych.locator.geoLocator;
```
Make a geoLocator instance
```
String ipAddressorURL = "74.125.224.72";
geoLocator location = new geoLocator(ipAddressorURL);
```
Search possiblities
```
location.country.getIsoCode() //get the country's abbreviation
location.country.getName() //get the country's name
location.subdivision.getIsoCode() //get the state or subdivision's abbreviation
location.subdivision.getName() //get the state or subdivision's name
location.city.getName() //get the city's name
location.postal.getCode() //get the zip/postal code
location.location.getLatitude() //get the latitude
location.location.getLongitude() //get the longitude
location.location.getMetroCode() //get the metrocode
location.location.getPopulationDensity() //get the location's population density
location.location.getAverageIncome() //get the location's average income
```

