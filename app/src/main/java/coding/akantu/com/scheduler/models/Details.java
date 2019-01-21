
package coding.akantu.com.scheduler.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Details implements Serializable {

    @SerializedName("Stops")
    @Expose
    private Stops stops;
    @SerializedName("DaysOfOperation")
    @Expose
    private Integer daysOfOperation;
    @SerializedName("DatePeriod")
    @Expose
    private DatePeriod datePeriod;

    public Stops getStops() {
        return stops;
    }

    public void setStops(Stops stops) {
        this.stops = stops;
    }

    public Integer getDaysOfOperation() {
        return daysOfOperation;
    }

    public void setDaysOfOperation(Integer daysOfOperation) {
        this.daysOfOperation = daysOfOperation;
    }

    public DatePeriod getDatePeriod() {
        return datePeriod;
    }

    public void setDatePeriod(DatePeriod datePeriod) {
        this.datePeriod = datePeriod;
    }

}
