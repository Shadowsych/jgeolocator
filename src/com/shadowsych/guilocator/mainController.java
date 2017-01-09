package com.shadowsych.guilocator;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.shadowsych.locator.geoLocator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

@Deprecated
public class mainController implements javafx.fxml.Initializable, EventHandler<ActionEvent> {

	@FXML
	private Text waterMark;
	@FXML
	private TextField enterIP;
	@FXML
	private Button searchBTN;
	@FXML
	private TextArea results;

	public void initialize(URL location, ResourceBundle resources) {
	searchBTN.setOnAction(this);
	} 

	public void handle(ActionEvent E) {
		if(E.getSource() == searchBTN)
		{ //if user clicks the search button
			String ipAddress = enterIP.getText();
			if(ipAddress.contains(".") && !ipAddress.isEmpty())
			{ // if ip contains periods and is not empty
				
				// we will try and initialize the geoLocator variable
				geoLocator location = null;
				try {
					location = new geoLocator(ipAddress);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (GeoIp2Exception e) {
					e.printStackTrace();
				}
				
				results.setText(
			    "IP Address: " + ipAddress + "\n" +
			    "Country Abbreviation: " + location.country.getIsoCode() + "\n" +
			    "Country Name: " + location.country.getName() + "\n" +
			    "State or Subdivision Abbreviation: " + location.subdivision.getIsoCode() + "\n" +
			    "State or Subdivision Name: " + location.subdivision.getName() + "\n" +
			    "City Name: " + location.city.getName() + "\n" +
			    "Zip/Postal Code: " + location.postal.getCode() + "\n" +
			    "Latitude: " + location.location.getLatitude() + "\n" +
			    "Longitude: " + location.location.getLongitude() + "\n" +
			    "Metrocode: " + location.location.getMetroCode() + "\n" +
			    "Population Density of Location: " + ((location.location.getPopulationDensity() == null) ? "Unknown":location.location.getPopulationDensity()) + "\n" +
			    "Average Income of Location: " + ((location.location.getAverageIncome() == null) ? "Unknown":location.location.getAverageIncome()) + "\n"
				);
			} else { //either the ip does not have dots or is empty
				results.setText("Error - Invalid IP Address. \n"
						+ "Perhaps the IP Address is blank or is not real?");
			}
		}
	}

} // end class
