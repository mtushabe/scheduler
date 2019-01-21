
package coding.akantu.com.scheduler.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Terminal implements Serializable {

    @SerializedName("Name")
    @Expose
    private Integer name;

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

}
