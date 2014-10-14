package com.dooioo.tel.web.result;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "info")
public class TicketRequest {
    private int id;
    private String phoneCome;
    private String phoneGo;
    private String phoneView;
    private String startTime;
    private String finishTime;
    private String keepTime;
    private String isReceive;
    private String recordFile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneCome() {
        return phoneCome;
    }

    public void setPhoneCome(String phoneCome) {
        this.phoneCome = phoneCome;
    }

    public String getPhoneGo() {
        return phoneGo;
    }

    public void setPhoneGo(String phoneGo) {
        this.phoneGo = phoneGo;
    }

    public String getPhoneView() {
        return phoneView;
    }

    public void setPhoneView(String phoneView) {
        this.phoneView = phoneView;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getKeepTime() {
        return keepTime;
    }

    public void setKeepTime(String keepTime) {
        this.keepTime = keepTime;
    }

    public String getIsReceive() {
        return isReceive;
    }

    public void setIsReceive(String isReceive) {
        this.isReceive = isReceive;
    }

    public String getRecordFile() {
        return recordFile;
    }

    public void setRecordFile(String recordFile) {
        this.recordFile = recordFile;
    }
}
