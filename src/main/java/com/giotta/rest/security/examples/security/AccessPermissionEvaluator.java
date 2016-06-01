package com.giotta.rest.security.examples.security;

import com.giotta.rest.security.examples.model.AccessStatus;
import com.giotta.rest.security.examples.model.PublishableEntity;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Serializable;

/**
 * @author John D Giotta
 * @since 6/1/16
 */
public class AccessPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object entity, Object o1) {
        boolean hasPermission = false;
        if (((PublishableEntity)entity).getStatus().equals(AccessStatus.PUBLISHED) || hasRole("ROLE_ADMIN")) {
            hasPermission = true;
        }
        return hasPermission;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }

    protected boolean hasRole(String role) {
        // get security context from thread local
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null)
            return false;

        Authentication authentication = context.getAuthentication();
        if (authentication == null)
            return false;

        for (GrantedAuthority auth : authentication.getAuthorities()) {
            if (role.equals(auth.getAuthority()))
                return true;
        }

        return false;
    }
}