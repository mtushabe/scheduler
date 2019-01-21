
package coding.akantu.com.scheduler.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Stops implements Serializable {

    @SerializedName("StopQuantity")
    @Expose
    private Integer stopQuantity;

    public Integer getStopQuantity() {
        return stopQuantity;
    }

    public void setStopQuantity(Integer stopQuantity) {
        this.stopQuantity = stopQuantity;
    }

}
