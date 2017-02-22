//package security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//				.anyRequest().authenticated()
//				.and()
//			.formLogin()
//				.loginPage("/")
//				.permitAll();
//	}
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////    	http
////		.authorizeRequests()
////			.antMatchers("/","/home/**","/login","/signup","/home","/logout").permitAll()
////			.antMatchers("/admin/**").hasRole("ADMIN")
////			.anyRequest().authenticated()
////			.and()
////		.formLogin();
////			//.loginPage("/admin")
////			//.and()
////		//.httpBasic();
////    	http.csrf().disable();
//////    	http
//////    		.authorizeRequests()
//////    			.antMatchers("/","/*admin*/**").access("hasRole('ADMIN')")
//////    			//.anyRequest().authenticated()
//////    			.and()
//////    		.formLogin();
////    			//.loginPage("/login")
////    			//.permitAll();
////    	//http.csrf().disable();
////    			//.and
////    			//.antMatchers("/admin/*").access("hasRole('ADMIN')");
//////        http.authorizeRequests().antMatchers("/admin").permitAll()
//////                .antMatchers("/home").access("hasRole('USER')")
//////                .antMatchers("/home/*").access("hasRole('USER')")
//////                .and()
//////                .formLogin().loginPage("/")
//////                .and()
//////                .csrf().disable();
////    }
//    
//    @Autowired
//    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.inMemoryAuthentication().withUser("mitul").password("yyyyyy")
//                .roles("ADMIN");
//    }
//}