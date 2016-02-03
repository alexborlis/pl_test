package net.smartrss.admin.view.app;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Alexander on 03.02.2016.
 */
@SuppressWarnings("serial")
public class UserAuthenticatedWebSession extends AuthenticatedWebSession {

    public UserAuthenticatedWebSession(Request request) {
        super(request);
    }

    @Override
    public boolean authenticate(String username, String password) {
        throw new UnsupportedOperationException("You are supposed to use Spring-Security!");
    }
    @Override
    public Roles getRoles() {
        Roles roles = new Roles();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            roles.add(authority.getAuthority());
        }
        return roles;
    }
}
