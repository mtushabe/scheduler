
package coding.akantu.com.scheduler.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Names {

    @SerializedName("Name")
    @Expose
    private List<Name> name = null;

    public List<Name> getName() {
        return name;
    }

    public void setName(List<Name> name) {
        this.name = name;
    }

}
