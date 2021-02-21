package ca.wihraiech.mytestapp.api.model.pojo;

import com.squareup.moshi.Json;

public class JokePojo {

    @Json(name = "id")
    private Integer id;
    @Json(name = "type")
    private String type;
    @Json(name = "setup")
    private String setup;
    @Json(name = "punchline")
    private String punchline;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }

}