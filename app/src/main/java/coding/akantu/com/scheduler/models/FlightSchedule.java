
package coding.akantu.com.scheduler.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FlightSchedule implements Serializable {

    @SerializedName("ScheduleResource")
    @Expose
    private ScheduleResource scheduleResource;

    public ScheduleResource getScheduleResource() {
        return scheduleResource;
    }

    public void setScheduleResource(ScheduleResource scheduleResource) {
        this.scheduleResource = scheduleResource;
    }

}
