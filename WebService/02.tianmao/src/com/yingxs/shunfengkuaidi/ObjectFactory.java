
package com.yingxs.shunfengkuaidi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.yingxs.shunfengkuaidi package. 
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

    private final static QName _GetAdressInfoByUserId_QNAME = new QName("http://shunfengkuaidi.yingxs.com/", "getAdressInfoByUserId");
    private final static QName _GetAdressInfoByUserIdResponse_QNAME = new QName("http://shunfengkuaidi.yingxs.com/", "getAdressInfoByUserIdResponse");
    private final static QName _GetAllAddress_QNAME = new QName("http://shunfengkuaidi.yingxs.com/", "getAllAddress");
    private final static QName _GetAllAddressResponse_QNAME = new QName("http://shunfengkuaidi.yingxs.com/", "getAllAddressResponse");
    private final static QName _GetAllArea_QNAME = new QName("http://shunfengkuaidi.yingxs.com/", "getAllArea");
    private final static QName _GetAllAreaResponse_QNAME = new QName("http://shunfengkuaidi.yingxs.com/", "getAllAreaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.yingxs.shunfengkuaidi
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllAreaResponse }
     * 
     */
    public GetAllAreaResponse createGetAllAreaResponse() {
        return new GetAllAreaResponse();
    }

    /**
     * Create an instance of {@link GetAllAreaResponse.Return }
     * 
     */
    public GetAllAreaResponse.Return createGetAllAreaResponseReturn() {
        return new GetAllAreaResponse.Return();
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
     * Create an instance of {@link GetAllAddress }
     * 
     */
    public GetAllAddress createGetAllAddress() {
        return new GetAllAddress();
    }

    /**
     * Create an instance of {@link GetAllAddressResponse }
     * 
     */
    public GetAllAddressResponse createGetAllAddressResponse() {
        return new GetAllAddressResponse();
    }

    /**
     * Create an instance of {@link GetAllArea }
     * 
     */
    public GetAllArea createGetAllArea() {
        return new GetAllArea();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link GetAllAreaResponse.Return.Entry }
     * 
     */
    public GetAllAreaResponse.Return.Entry createGetAllAreaResponseReturnEntry() {
        return new GetAllAreaResponse.Return.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAdressInfoByUserId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shunfengkuaidi.yingxs.com/", name = "getAdressInfoByUserId")
    public JAXBElement<GetAdressInfoByUserId> createGetAdressInfoByUserId(GetAdressInfoByUserId value) {
        return new JAXBElement<GetAdressInfoByUserId>(_GetAdressInfoByUserId_QNAME, GetAdressInfoByUserId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAdressInfoByUserIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shunfengkuaidi.yingxs.com/", name = "getAdressInfoByUserIdResponse")
    public JAXBElement<GetAdressInfoByUserIdResponse> createGetAdressInfoByUserIdResponse(GetAdressInfoByUserIdResponse value) {
        return new JAXBElement<GetAdressInfoByUserIdResponse>(_GetAdressInfoByUserIdResponse_QNAME, GetAdressInfoByUserIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shunfengkuaidi.yingxs.com/", name = "getAllAddress")
    public JAXBElement<GetAllAddress> createGetAllAddress(GetAllAddress value) {
        return new JAXBElement<GetAllAddress>(_GetAllAddress_QNAME, GetAllAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllAddressResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shunfengkuaidi.yingxs.com/", name = "getAllAddressResponse")
    public JAXBElement<GetAllAddressResponse> createGetAllAddressResponse(GetAllAddressResponse value) {
        return new JAXBElement<GetAllAddressResponse>(_GetAllAddressResponse_QNAME, GetAllAddressResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllArea }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shunfengkuaidi.yingxs.com/", name = "getAllArea")
    public JAXBElement<GetAllArea> createGetAllArea(GetAllArea value) {
        return new JAXBElement<GetAllArea>(_GetAllArea_QNAME, GetAllArea.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllAreaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shunfengkuaidi.yingxs.com/", name = "getAllAreaResponse")
    public JAXBElement<GetAllAreaResponse> createGetAllAreaResponse(GetAllAreaResponse value) {
        return new JAXBElement<GetAllAreaResponse>(_GetAllAreaResponse_QNAME, GetAllAreaResponse.class, null, value);
    }

}
