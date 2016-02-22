package com.kimmin.rest.example.POJO;

/**
 * Created by min.jin on 2016/2/22.
 */
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestJAXB {
    private String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}