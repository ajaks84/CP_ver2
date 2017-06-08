package com.adc.deshand.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.httpBasic().and()
			.authorizeRequests()
				.antMatchers("/index.html", "/", "/login", "/message", "/home").permitAll()
				.anyRequest().authenticated()
				.and()
			.csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		// @formatter:on
	}

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
//		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("superadmin").password("superadmin").roles("SUPERADMIN");
//	
//	}
	
//	@Autowired
//	DataSource dataSource;
//
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//
//	  auth.jdbcAuthentication().dataSource(dataSource)
//		.usersByUsernameQuery(
//			"select username,password, enabled from users where username=?")
//		.authoritiesByUsernameQuery(
//			"select username, role from user_roles where username=?");
//	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// @formatter:off
//		http
//			.httpBasic().and()
//			.authorizeRequests()
//				.antMatchers("/css/**", "/src/**", "/bower_components/**", "/**").permitAll()
//				.anyRequest().authenticated();
////				.and()
////			.csrf()
////				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//		// @formatter:on
//	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//	  http.authorizeRequests()
//		.antMatchers("/countries").access("hasRole('ROLE_USER')");
//		.and()
//		  .formLogin().loginPage("/login").failureUrl("/login?error")
//		  .usernameParameter("username").passwordParameter("password")
//		.and()
//		  .logout().logoutSuccessUrl("/login?logout")
//		.and()
//		  .exceptionHandling().accessDeniedPage("/403")
//		.and()
//		  .csrf();
//	}
	
	
	
//	protected void configure(HttpSecurity http) throws Exception {
//	    http.authorizeRequests()
//	      .anyRequest().authenticated()
//	      .and().formLogin()
//	      .loginPage("/login").permitAll();
//	}

//	 @Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests().antMatchers("/**").access("hasRole('ROLE_ADMIN')")
////				.antMatchers("/confidential/**").access("hasRole('ROLE_SUPERADMIN')")//.antMatchers("/login").permitAll();
//				.and().formLogin().defaultSuccessUrl("/", false);
//
//	}
	 
	 
	 
	 // This is working if you want a Sprint Default Login Page
//	 @Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/factories/**").access("hasRole('ROLE_ADMIN')")
//				.and().formLogin().defaultSuccessUrl("/", false);
//
//	}
}
