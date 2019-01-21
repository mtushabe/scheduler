
package coding.akantu.com.scheduler.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Airports {

    @SerializedName("Airport")
    @Expose
    private Airport airport;

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

}
