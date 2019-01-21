
package coding.akantu.com.scheduler.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AirportDetails {

    @SerializedName("AirportResource")
    @Expose
    private AirportResource airportResource;

    public AirportResource getAirportResource() {
        return airportResource;
    }

    public void setAirportResource(AirportResource airportResource) {
        this.airportResource = airportResource;
    }

}
