package demo.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import demo.service.EmployeeService;
 
@Configuration
public class EmployeeConfig {
 
    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
 
}
