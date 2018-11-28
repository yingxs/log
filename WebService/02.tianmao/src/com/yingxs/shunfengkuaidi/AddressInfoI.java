package com.yingxs.shunfengkuaidi;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-11-28T22:26:07.327+08:00
 * Generated source version: 3.2.4
 *
 */
@WebService(targetNamespace = "http://shunfengkuaidi.yingxs.com/", name = "AddressInfoI")
@XmlSeeAlso({ObjectFactory.class})
public interface AddressInfoI {

    @WebMethod
    @RequestWrapper(localName = "getAllArea", targetNamespace = "http://shunfengkuaidi.yingxs.com/", className = "com.yingxs.shunfengkuaidi.GetAllArea")
    @ResponseWrapper(localName = "getAllAreaResponse", targetNamespace = "http://shunfengkuaidi.yingxs.com/", className = "com.yingxs.shunfengkuaidi.GetAllAreaResponse")
    @WebResult(name = "_return", targetNamespace = "")
    public com.yingxs.shunfengkuaidi.GetAllAreaResponse.Return getAllArea();

    @WebMethod
    @RequestWrapper(localName = "getAdressInfoByUserId", targetNamespace = "http://shunfengkuaidi.yingxs.com/", className = "com.yingxs.shunfengkuaidi.GetAdressInfoByUserId")
    @ResponseWrapper(localName = "getAdressInfoByUserIdResponse", targetNamespace = "http://shunfengkuaidi.yingxs.com/", className = "com.yingxs.shunfengkuaidi.GetAdressInfoByUserIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String getAdressInfoByUserId(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @RequestWrapper(localName = "getAllAddress", targetNamespace = "http://shunfengkuaidi.yingxs.com/", className = "com.yingxs.shunfengkuaidi.GetAllAddress")
    @ResponseWrapper(localName = "getAllAddressResponse", targetNamespace = "http://shunfengkuaidi.yingxs.com/", className = "com.yingxs.shunfengkuaidi.GetAllAddressResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.yingxs.shunfengkuaidi.Address> getAllAddress();
}
