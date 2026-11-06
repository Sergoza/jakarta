package horseclub;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@ControllerAdvice
public class XmlStylesheetAdvice implements ResponseBodyAdvice<Object> {

    private final XmlMapper xmlMapper = new XmlMapper();

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {

        if (selectedContentType.isCompatibleWith(MediaType.APPLICATION_XML)) {
            try {
                String xml = xmlMapper.writeValueAsString(body);
                String xmlWithXsl = "<?xml-stylesheet type=\"text/xsl\" href=\"/style.xsl\"?>\n" + xml;

                OutputStream os = response.getBody();
                os.write(xmlWithXsl.getBytes(StandardCharsets.UTF_8));
                os.flush();
                return null;
            } catch (Exception e) {
                return body;
            }
        }
        return body;
    }
}
