
package coding.akantu.com.scheduler.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MarketingCarrier implements Serializable {

    @SerializedName("AirlineID")
    @Expose
    private String airlineID;
    @SerializedName("FlightNumber")
    @Expose
    private Integer flightNumber;

    public String getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

}
