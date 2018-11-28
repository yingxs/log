package com.yingxs.shunfengkuaidi.impl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import com.yingxs.shunfengkuaidi.AddressInfoI;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-11-28T22:26:07.370+08:00
 * Generated source version: 3.2.4
 *
 */
@WebServiceClient(name = "sfkd",
                  wsdlLocation = "http://127.0.0.1:5555/ShunFengKuaiDi?wsdl",
                  targetNamespace = "http://impl.shunfengkuaidi.yingxs.com/")
public class Sfkd extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://impl.shunfengkuaidi.yingxs.com/", "sfkd");
    public final static QName AddressInfoPort = new QName("http://impl.shunfengkuaidi.yingxs.com/", "AddressInfoPort");
    static {
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:5555/ShunFengKuaiDi?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(Sfkd.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://127.0.0.1:5555/ShunFengKuaiDi?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public Sfkd(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public Sfkd(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Sfkd() {
        super(WSDL_LOCATION, SERVICE);
    }

    public Sfkd(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public Sfkd(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public Sfkd(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns AddressInfoI
     */
    @WebEndpoint(name = "AddressInfoPort")
    public AddressInfoI getAddressInfoPort() {
        return super.getPort(AddressInfoPort, AddressInfoI.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AddressInfoI
     */
    @WebEndpoint(name = "AddressInfoPort")
    public AddressInfoI getAddressInfoPort(WebServiceFeature... features) {
        return super.getPort(AddressInfoPort, AddressInfoI.class, features);
    }

}
