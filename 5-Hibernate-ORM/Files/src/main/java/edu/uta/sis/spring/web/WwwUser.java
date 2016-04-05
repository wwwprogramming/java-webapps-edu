package edu.uta.sis.spring.web;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Hannu Lohtander on 2.4.2016.
 */
public class WwwUser implements UserDetails{

    private Long id;
    private String username;
    protected String password;

    protected boolean enabled;
    protected HashSet<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();

    protected boolean isAccountNonExpired=true;
    protected boolean isAccountNonLocked=true;
    protected boolean isCredentialsNonExpired=true;

    protected String email;

    public WwwUser() {
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ANONYMOUS"));
    }

    public WwwUser(Long id, String username, String password) {
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ANONYMOUS"));
        setUsername(username);
        setPassword(password);
        setId(id);
        setEmail("no-email@example.org");
        enabled = true;
    }

    public WwwUser(Long id, String username, String password, String email, String role) {
        grantedAuthorities.add(new SimpleGrantedAuthority(role));
        setUsername(username);
        setPassword(password);
        setId(id);
        setEmail(email);
        enabled = true;
    }

    public String getRole() {
        Iterator<GrantedAuthority> i = grantedAuthorities.iterator();
        while (i.hasNext()) {
            GrantedAuthority auth = (SimpleGrantedAuthority)i.next();
            return auth.getAuthority();
        }
        return null;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "WwwUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", grantedAuthorities=" + grantedAuthorities +
                ", isAccountNonExpired=" + isAccountNonExpired +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isCredentialsNonExpired=" + isCredentialsNonExpired +
                ", email='" + email + '\'' +
                '}';
    }
}
