package com.kimmin.rest.example.POJO;

/**
 * Created by min.jin on 2016/2/22.
 */
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseJAXB {
    private int respCode;
    private String respDesc;

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }
}