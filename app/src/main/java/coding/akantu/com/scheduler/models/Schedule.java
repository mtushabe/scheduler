
package coding.akantu.com.scheduler.models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Schedule implements Serializable {

    @SerializedName("TotalJourney")
    @Expose
    private TotalJourney totalJourney;
    @SerializedName("Flight")
    @Expose
    private Flight flight;


    public TotalJourney getTotalJourney() {
        return totalJourney;
    }

    public void setTotalJourney(TotalJourney totalJourney) {
        this.totalJourney = totalJourney;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }


}
