package com.giotta.rest.security.examples.config;

import com.giotta.rest.security.examples.security.AccessPermissionEvaluator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;

/**
 * @author John D Giotta
 * @since 6/1/16
 */
@Configuration
public class PermissionConfig {
    @Bean
    public PermissionEvaluator permissionEvaluator() {
        return new AccessPermissionEvaluator();
    }

}
