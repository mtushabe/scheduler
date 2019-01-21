
package coding.akantu.com.scheduler.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TotalJourney implements Serializable {

    @SerializedName("Duration")
    @Expose
    private String duration;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

}
