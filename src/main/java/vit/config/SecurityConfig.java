package vit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import lombok.RequiredArgsConstructor;
import vit.Security.CommonOAuth2UserService;
import vit.Security.MyUserDetailsService;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Lazy
	@Autowired
	CommonOAuth2UserService commonOAuth2UserService; 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/log/**","/help/notice/**", "/main").permitAll()
			.antMatchers("/user/**").hasRole("USER")
			.antMatchers("/admin/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/log/page") //로그인페이지
			.loginProcessingUrl("/log/member") //로그인요청주소
			.usernameParameter("email")
			.defaultSuccessUrl("/main")   
			.failureUrl("/log/page?error")
			.and()
			.logout()
			.logoutUrl("/log/logout")
			.logoutSuccessUrl("/")
			;
		http.oauth2Login().userInfoEndpoint().userService(commonOAuth2UserService);
		http.csrf().disable();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("/css/**", "/img/**", "/favicon.ico", "/error", "/js/**")
		;
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
    public HiddenHttpMethodFilter httpMethodFilter() {
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        return hiddenHttpMethodFilter;
    }

}
