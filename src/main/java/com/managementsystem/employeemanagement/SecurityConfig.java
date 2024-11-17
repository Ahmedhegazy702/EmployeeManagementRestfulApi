package com.managementsystem.employeemanagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // تعطيل CSRF إذا لم يكن مطلوبًا
        http.csrf().disable() // تعطيل CSRF

                // استخدام authorizeHttpRequests بدلاً من authorizeRequests
                .authorizeHttpRequests()
                .anyRequest().permitAll() // السماح لجميع الطلبات

                // تعطيل المصادقة الأساسية و صفحة تسجيل الدخول
                .and()
                .formLogin().disable()  // تعطيل صفحة تسجيل الدخول
                .httpBasic().disable(); // تعطيل المصادقة الأساسية

        return http.build();
    }
}

