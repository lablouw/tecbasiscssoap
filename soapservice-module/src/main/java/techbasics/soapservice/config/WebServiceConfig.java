package techbasics.soapservice.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import techbasics.common.aspect.UncaughtSoapExceptionHandlerAspect;
import techbasics.common.manager.PersonManager;
import techbasics.common.manager.PersonManagerImpl;
import techbasics.soapservice.aspect.SoapBoundaryLoggerAspect;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public SoapBoundaryLoggerAspect soapBoundaryLoggerAspect() {
        return new SoapBoundaryLoggerAspect();
    }

    @Bean
    public UncaughtSoapExceptionHandlerAspect uncaughtSoapExceptionHandlerAspect() {
        return new UncaughtSoapExceptionHandlerAspect();
    }

    @Bean
    public PersonManager personManager() {
        return new PersonManagerImpl();
    }

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/soapservice/*");
    }

    /////////////////////////////////////////////
    // Configuration for different endpoints based on the schemas generated by the jaxb2-maven-plugin plugin in the module pom.
    /////////////////////////////////////////////

    //SoapServiceV1
    //WSDL: http://localhost:8080/soapService/v1.wsdl
    @Bean(name = "soapServiceV1")
    public DefaultWsdl11Definition soapServiceV1Wsdl11Definition(XsdSchema soapServiceV1Schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("SoapServiceV1Port");
        wsdl11Definition.setLocationUri("/soapservice/v1");
        wsdl11Definition.setTargetNamespace(techbasics.soapservice.api.v1.service.SoapService.NAMESPACE_URI_V1);
        wsdl11Definition.setSchema(soapServiceV1Schema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema soapServiceV1Schema() {
        final String classPath = System.getProperty("java.class.path", ".");
        final String[] classPathElements = classPath.split(System.getProperty("path.separator"));
        for (final String element : classPathElements) {
            System.out.println(element);
        }

        return new SimpleXsdSchema(new ClassPathResource("schema1.xsd"));
    }


    //SoapServiceV2
    //WSDL: http://localhost:8080/soapService/v2.wsdl
    @Bean(name = "soapServiceV2")
    public DefaultWsdl11Definition soapServiceV2Wsdl11Definition(XsdSchema soapServiceV2Schema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("SoapServiceV2Port");
        wsdl11Definition.setLocationUri("/soapservice/v2");
        wsdl11Definition.setTargetNamespace(techbasics.soapservice.api.v2.service.SoapService.NAMESPACE_URI_V2);
        wsdl11Definition.setSchema(soapServiceV2Schema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema soapServiceV2Schema() {
        return new SimpleXsdSchema(new ClassPathResource("schema2.xsd"));
    }

}
