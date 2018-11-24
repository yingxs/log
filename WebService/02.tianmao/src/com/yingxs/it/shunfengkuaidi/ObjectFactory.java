
package com.yingxs.it.shunfengkuaidi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.yingxs.it.shunfengkuaidi package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAdressInfoByUserId_QNAME = new QName("http://shunFengKuaiDi.it.yingxs.com/", "getAdressInfoByUserId");
    private final static QName _GetAdressInfoByUserIdResponse_QNAME = new QName("http://shunFengKuaiDi.it.yingxs.com/", "getAdressInfoByUserIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.yingxs.it.shunfengkuaidi
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAdressInfoByUserId }
     * 
     */
    public GetAdressInfoByUserId createGetAdressInfoByUserId() {
        return new GetAdressInfoByUserId();
    }

    /**
     * Create an instance of {@link GetAdressInfoByUserIdResponse }
     * 
     */
    public GetAdressInfoByUserIdResponse createGetAdressInfoByUserIdResponse() {
        return new GetAdressInfoByUserIdResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAdressInfoByUserId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shunFengKuaiDi.it.yingxs.com/", name = "getAdressInfoByUserId")
    public JAXBElement<GetAdressInfoByUserId> createGetAdressInfoByUserId(GetAdressInfoByUserId value) {
        return new JAXBElement<GetAdressInfoByUserId>(_GetAdressInfoByUserId_QNAME, GetAdressInfoByUserId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAdressInfoByUserIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shunFengKuaiDi.it.yingxs.com/", name = "getAdressInfoByUserIdResponse")
    public JAXBElement<GetAdressInfoByUserIdResponse> createGetAdressInfoByUserIdResponse(GetAdressInfoByUserIdResponse value) {
        return new JAXBElement<GetAdressInfoByUserIdResponse>(_GetAdressInfoByUserIdResponse_QNAME, GetAdressInfoByUserIdResponse.class, null, value);
    }

}
