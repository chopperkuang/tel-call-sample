package com.dooioo.tel.web.result;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "infos")
public class PhoneListResult {

    private List<PhoneResult> phoneResults = new ArrayList<PhoneResult>();

    @XmlElement(name = "info")
    public List<PhoneResult> getPhoneResults() {
        return phoneResults;
    }

    public void addPhone(PhoneResult phoneResult) {
        this.phoneResults.add(phoneResult);
    }
}
