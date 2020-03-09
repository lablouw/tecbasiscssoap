package techbasics.config;

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
import techbasics.api.soapservice.v1.service.SoapService;
import techbasics.aspect.RestBoundaryLoggerAspect;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public RestBoundaryLoggerAspect restBoundaryLoggerAspect() {
        return new RestBoundaryLoggerAspect();
    }

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/soapService/*");
    }

    //WSDL: http://localhost:8080/soapService/v1.wsdl
    @Bean(name = "v1")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema soapServiceSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("SoapServicePort");
        wsdl11Definition.setLocationUri("/soapService");
        wsdl11Definition.setTargetNamespace(SoapService.NAMESPACE_URI);
        wsdl11Definition.setSchema(soapServiceSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema soapServiceSchema() {
        return new SimpleXsdSchema(new ClassPathResource("schema1.xsd"));
    }

}
