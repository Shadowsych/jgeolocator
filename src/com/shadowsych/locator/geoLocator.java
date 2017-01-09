package com.shadowsych.locator;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Location;
import com.maxmind.geoip2.record.Postal;
import com.maxmind.geoip2.record.Subdivision;

public class geoLocator {

	public DatabaseReader reader;
	public File dbFile;
	public InetAddress ipAddress;
	public CityResponse response;
	public Country country;
	public Subdivision subdivision;
	public City city;
	public Postal postal;
	public Location location;

	public geoLocator(String targetIPAddress) throws IOException, GeoIp2Exception {

		// A File object pointing to your GeoLite2 database
		dbFile = new File(constantsLocator.DATABASE_CITY_PATH);
		// This creates the DatabaseReader object,
		// which should be reused across lookups.

		reader = new DatabaseReader.Builder(dbFile).build();

		// An IP Address
		ipAddress = InetAddress.getByName(targetIPAddress);

		// Get City info
		response = reader.city(ipAddress);

		// Country Info
		country = response.getCountry();

	    subdivision = response.getMostSpecificSubdivision();

		// City Info.
		city = response.getCity();

		// Postal/Zip code info
		postal = response.getPostal();

		// Geo Location info.
		location = response.getLocation();

	}

}