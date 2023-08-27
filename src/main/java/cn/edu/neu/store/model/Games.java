package cn.edu.neu.store.model;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Games {
    private int g_id;
    private String g_name;
    private float g_price;
    private String g_storage;
    private String g_platform;
    private String g_details;
    private String g_type;
    private String g_pic;

    private MultipartFile userPicFile;
    private MultipartFile file;
    private String filePath;

    private String img;
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public float getG_price() {
        return g_price;
    }

    public void setG_price(float g_price) {
        this.g_price = g_price;
    }

    public String getG_storage() {
        return g_storage;
    }

    public void setG_storage(String g_storage) {
        this.g_storage = g_storage;
    }

    public String getG_platform() {
        return g_platform;
    }

    public void setG_platform(String g_platform) {
        this.g_platform = g_platform;
    }

    public String getG_details() {
        return g_details;
    }

    public void setG_details(String g_details) {
        this.g_details = g_details;
    }

    public String getG_type() {
        return g_type;
    }

    public void setG_type(String g_type) {
        this.g_type = g_type;
    }

    public String getG_pic() {
        return g_pic;
    }

    public void setG_pic(String g_pic) {
        this.g_pic = g_pic;
    }

    @Override
    public String toString() {
        return "Games{" +
                "g_id=" + g_id +
                ", g_name='" + g_name + '\'' +
                ", g_price=" + g_price +
                ", g_storage='" + g_storage + '\'' +
                ", g_platform='" + g_platform + '\'' +
                ", g_details='" + g_details + '\'' +
                ", g_type='" + g_type + '\'' +
                ", g_pic='" + g_pic + '\'' +
                '}';
    }

    public MultipartFile getFile() {
        return file;
    }
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public MultipartFile getGoodsPicFile() {
        return userPicFile;
    }

    public void setGoodsPicFile(MultipartFile userPicFile) {
        this.userPicFile = userPicFile;
    }
}
