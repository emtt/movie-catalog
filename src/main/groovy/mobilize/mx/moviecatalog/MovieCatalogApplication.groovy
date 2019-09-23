package mobilize.mx.moviecatalog

import mobilize.mx.moviecatalog.config.JwtFilter
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean

@SpringBootApplication
class MovieCatalogApplication {

	@Bean
	FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter())
		registrationBean.addUrlPatterns("/secure/*")
		registrationBean.addUrlPatterns("/genre/*")
		registrationBean.addUrlPatterns("/movie/*")


		return registrationBean
	}

	static void main(String[] args) {
		SpringApplication.run(MovieCatalogApplication, args)
	}

}
