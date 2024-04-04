package com.CyberSoft.uniclubWeb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SercurityConfig {
    @Autowired
    private com.CyberSoft.uniclubWeb.filter.CustomJwtFilter customJwtFilter;
    ;
/*
    Spring Security 6~
* Thay doi thong tin cau hinh cua Security: Phan quyen, chung thuc,...
* */
//    Khởi tạo chuẩn mã hoá sử dụng và lưu trên IOC
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // Tạo danh sách user luu tạm trên RAM.
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
//        UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("123")).roles("ADMIN").build();
//        UserDetails user = User.withUsername("user").password(passwordEncoder().encode("123456")).roles("USER").build();
//        return new InMemoryUserDetailsManager(admin,user);
////    }
//    @Bean
//    public SecurityFilterChain securityFilterChain4(HttpSecurity httpSecurity) throws Exception{
//        return httpSecurity.csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Huỷ sử dụng session, khong luu trang thai
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers(HttpMethod.GET,"/admin").permitAll()
//                .requestMatchers(HttpMethod.POST,"/admin").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.GET,"/admin").permitAll()
//                .requestMatchers(HttpMethod.POST,"/login/**").permitAll()
//                .requestMatchers(HttpMethod.PUT,"/admin").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.DELETE,"/admin").hasAnyRole("ADMIN","USER")
//                .anyRequest().authenticated()                   // con cac link con lai phai chung thuc
//                .and()
//                .addFilterBefore(customJwtFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
////        return httpSecurity.csrf().disable()  // csrf: ngăn không cho
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and()
////                .authorizeHttpRequests()
////                .requestMatchers("/role").permitAll() // permitAll: cho phép ai đi vào cũng được
//////                .requestMatchers("/role/**").hasRole("ADMIN")
////                .requestMatchers(HttpMethod.GET,"/role/admin").permitAll()
//////                .requestMatchers(HttpMethod.POST,"/role/admin").hasRole("USER")
////                .requestMatchers("/login").permitAll()
////                .requestMatchers(HttpMethod.PUT,"/role/admin").hasRole("ADMIN")
////                .requestMatchers(HttpMethod.DELETE,"/role/admin").hasAnyRole("ADMIN", "USER")
////                .anyRequest().authenticated() // tất cả request còn lại phải chức thực
////                .and()
////                .addFilterBefore(customJwtFilter, UsernamePasswordAuthenticationFilter.class)
////                .build();
//
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        Cách cũ.
//        return http.csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Huỷ sử dụng session, khong luu trang thai
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers("/login/**", "/file/**").permitAll()
//                .requestMatchers(HttpMethod.GET,"/product").permitAll()
////                .requestMatchers(HttpMethod.DELETE,"/admin").hasAnyRole("ADMIN","USER")
//                .anyRequest().authenticated()                   // con cac link con lai phai chung thuc
//                .and()
//                .addFilterBefore(customJwtFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//       Cách Mới:
//        http.csrf(c -> c.disable())
//                .authorizeHttpRequests(a ->{
//                        a.requestMatchers("/role","/role/**").permitAll();         // Cho phép chạy
//                        a.anyRequest().authenticated();                 // Yeu cau chung thuc.
//                }
//                );
//        return http.build();

        return http.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(author -> {
                    author.requestMatchers("/login/**", "/file/**","/test/**").permitAll();
                    author.requestMatchers(HttpMethod.GET, "/product").permitAll();
                    author.anyRequest().authenticated();
                })
                .addFilterBefore(customJwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
