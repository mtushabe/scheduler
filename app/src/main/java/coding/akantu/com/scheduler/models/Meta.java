
package coding.akantu.com.scheduler.models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta implements Serializable {

    @SerializedName("@Version")
    @Expose
    private String version;
    @SerializedName("Link")
    @Expose
    private List<Link> link = null;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Link> getLink() {
        return link;
    }

    public void setLink(List<Link> link) {
        this.link = link;
    }

}
