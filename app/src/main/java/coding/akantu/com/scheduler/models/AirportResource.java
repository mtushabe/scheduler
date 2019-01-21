
package coding.akantu.com.scheduler.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AirportResource {

    @SerializedName("Airports")
    @Expose
    private Airports airports;

    public Airports getAirports() {
        return airports;
    }

    public void setAirports(Airports airports) {
        this.airports = airports;
    }

}
