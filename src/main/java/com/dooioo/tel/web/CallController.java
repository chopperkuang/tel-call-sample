package com.dooioo.tel.web;

import com.dooioo.tel.service.PhoneService;
import com.dooioo.tel.web.result.PhoneListResult;
import com.dooioo.tel.web.result.PhoneResult;
import com.dooioo.tel.web.result.TicketRequest;
import com.dooioo.tel.websocket.SocketSession;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/call/*")
public class CallController {
    private static Log logger = LogFactory.getLog(CallController.class);

    @Autowired
    private PhoneService phoneService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody String add() {
        phoneService.insert("匡前阳", "15601622811");
        return JSON.serialize("{status:ok}");
    }


    @RequestMapping(value = "/startCall", method = RequestMethod.GET)
    public @ResponseBody String startCall(@RequestParam(value = "id", required = true) int id,
                     @RequestParam(value = "phoneGo", required = true) String phoneGo,
                     @RequestParam(value = "phoneCome", required = false) String phoneCome) {

        logger.info("startCall => " + id);
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("id", id);
        ret.put("type", "startCall");

        SocketSession.sendMessage(JSON.serialize(ret));

        return "200";
    }

    @RequestMapping(value = "/answered", method = RequestMethod.GET)
    public @ResponseBody String answered(@RequestParam(value = "id", required = true) int id,
                    @RequestParam(value = "phoneGo", required = true) String phoneGo,
                    @RequestParam(value = "phoneCome", required = false) String phoneCome) {

        logger.info("answered => " + id);
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("id", id);
        ret.put("type", "answered");
        SocketSession.sendMessage(JSON.serialize(ret));

        return "200";
    }

    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
    public @ResponseBody String ticket(@RequestBody TicketRequest ticketRequest) {
        logger.info("ticket => " + ticketRequest.getId());

        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("id", ticketRequest.getId());
        ret.put("keepTime", ticketRequest.getKeepTime());
        ret.put("type", "ticket");

        SocketSession.sendMessage(JSON.serialize(ret));

        return "200";
    }

    @RequestMapping(value = "/toSubmit", method = RequestMethod.GET)
    public @ResponseBody String toSubmit() {
        List<DBObject> dbObjectList = phoneService.query();

        PhoneListResult phoneListResult = new PhoneListResult();
        for (DBObject dbObject : dbObjectList) {
            PhoneResult phoneResult = new PhoneResult();
            phoneResult.setId(Integer.parseInt(dbObject.get("id") + ""));
            phoneResult.setPhoneCome(dbObject.get("phoneCome") + "");
            phoneResult.setPhoneGo(dbObject.get("phoneGo") + "");
            phoneResult.setPhoneView(dbObject.get("phoneCome") + "");
            phoneListResult.addPhone(phoneResult);
        }
        return J2XMarshaller.marshal(phoneListResult);
    }

    private static class J2XMarshaller {

        public static String marshal(Object object) {
            try {
                Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
                marshaller.setClassesToBeBound(new Class<?>[]{PhoneListResult.class, PhoneResult.class});
                marshaller.afterPropertiesSet();

                StringWriter string = new StringWriter();
                marshaller.marshal(object, new StreamResult(string));
                return string.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";

        }
    }

}
