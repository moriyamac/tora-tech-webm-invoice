package invoice.dao;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/**
 * The Class InvoiceByInvoiceNoConverter.
 */
@Configuration
@EnableWebMvc
public class InvoiceByInvoiceNoConverter implements WebMvcConfigurer {

    /**
     * Mapping jackson 2 http message converter.
     * RestControllerで返却するJSONフォーマットを設定.
     *
     */
    @Override
    public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder //
                .json()
                .indentOutput(true)
                .propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                .build();

        converters.add(new MappingJackson2HttpMessageConverter(objectMapper));

        converters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
    }

}