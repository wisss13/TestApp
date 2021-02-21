package ca.wihraiech.mytestapp.api.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;

public class UserPojo {

    @Json(name = "userId")
    private Integer userId;
    @Json(name = "id")
    private Integer id;
    @Json(name = "title")
    private String title;
    @Json(name = "body")
    private String body;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

//    @SerializedName("userId")
//    @Expose
//    private Integer userId;
//    @SerializedName("id")
//    @Expose
//    private Integer id;
//    @SerializedName("title")
//    @Expose
//    private String title;
//    @SerializedName("body")
//    @Expose
//    private String body;
//
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
}
