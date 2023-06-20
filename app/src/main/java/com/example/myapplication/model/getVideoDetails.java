package com.example.myapplication.model;

public class getVideoDetails {

    String video_slide;
    String video_thumb;
    String video_category;
    String video_name;
    String video_url;

    public getVideoDetails(String video_slide, String video_thumb, String video_category, String video_name, String video_url) {
        this.video_slide = video_slide;
        this.video_thumb = video_thumb;
        this.video_category = video_category;
        this.video_name = video_name;
        this.video_url = video_url;
    }

    public String getVideo_slide() {
        return video_slide;
    }

    public void setVideo_slide(String video_slide) {
        this.video_slide = video_slide;
    }

    public String getVideo_thumb() {
        return video_thumb;
    }

    public void setVideo_thumb(String video_thumb) {
        this.video_thumb = video_thumb;
    }

    public String getVideo_category() {
        return video_category;
    }

    public void setVideo_category(String video_category) {
        this.video_category = video_category;
    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }
}
