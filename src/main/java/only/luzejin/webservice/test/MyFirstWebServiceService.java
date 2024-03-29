
package only.luzejin.webservice.test;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MyFirstWebServiceService", targetNamespace = "http://webservice.luzejin.only/", wsdlLocation = "file:/E:/workSpace/testProject/src/main/java/only/luzejin/webservice/test/myFirstService.wsdl")
public class MyFirstWebServiceService
    extends Service
{

    private final static URL MYFIRSTWEBSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException MYFIRSTWEBSERVICESERVICE_EXCEPTION;
    private final static QName MYFIRSTWEBSERVICESERVICE_QNAME = new QName("http://webservice.luzejin.only/", "MyFirstWebServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/E:/workSpace/testProject/src/main/java/only/luzejin/webservice/test/myFirstService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MYFIRSTWEBSERVICESERVICE_WSDL_LOCATION = url;
        MYFIRSTWEBSERVICESERVICE_EXCEPTION = e;
    }

    public MyFirstWebServiceService() {
        super(__getWsdlLocation(), MYFIRSTWEBSERVICESERVICE_QNAME);
    }

    public MyFirstWebServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MYFIRSTWEBSERVICESERVICE_QNAME, features);
    }

    public MyFirstWebServiceService(URL wsdlLocation) {
        super(wsdlLocation, MYFIRSTWEBSERVICESERVICE_QNAME);
    }

    public MyFirstWebServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MYFIRSTWEBSERVICESERVICE_QNAME, features);
    }

    public MyFirstWebServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MyFirstWebServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MyFirstWebService
     */
    @WebEndpoint(name = "MyFirstWebServicePort")
    public MyFirstWebService getMyFirstWebServicePort() {
        return super.getPort(new QName("http://webservice.luzejin.only/", "MyFirstWebServicePort"), MyFirstWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MyFirstWebService
     */
    @WebEndpoint(name = "MyFirstWebServicePort")
    public MyFirstWebService getMyFirstWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservice.luzejin.only/", "MyFirstWebServicePort"), MyFirstWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MYFIRSTWEBSERVICESERVICE_EXCEPTION!= null) {
            throw MYFIRSTWEBSERVICESERVICE_EXCEPTION;
        }
        return MYFIRSTWEBSERVICESERVICE_WSDL_LOCATION;
    }

}
