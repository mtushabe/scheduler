
package coding.akantu.com.scheduler.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Arrival implements Serializable {

    @SerializedName("AirportCode")
    @Expose
    private String airportCode;
    @SerializedName("ScheduledTimeLocal")
    @Expose
    private ScheduledTimeLocal scheduledTimeLocal;
    @SerializedName("Terminal")
    @Expose
    private Terminal terminal;

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public ScheduledTimeLocal getScheduledTimeLocal() {
        return scheduledTimeLocal;
    }

    public void setScheduledTimeLocal(ScheduledTimeLocal scheduledTimeLocal) {
        this.scheduledTimeLocal = scheduledTimeLocal;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

}
