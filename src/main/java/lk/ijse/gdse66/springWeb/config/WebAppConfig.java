package lk.ijse.gdse66.springWeb.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"lk.ijse.gdse66.springWeb.api","lk.ijse.gdse66.springWeb.advice"})
@EnableWebMvc
public class WebAppConfig {
}
