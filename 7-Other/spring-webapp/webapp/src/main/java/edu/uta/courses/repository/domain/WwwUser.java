package edu.uta.courses.repository.domain;

import org.joda.time.DateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;

/**
 * Created by me on 10.2.2015.
 */
public class WwwUser  implements UserDetails {

    private Long id;
    private String username;
    protected String passwordHash;

    protected boolean enabled;
    protected HashSet<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
    protected boolean isFakedAccount = false;
    protected boolean isAccountNonExpired=true;
    protected boolean isAccountNonLocked=true;
    protected boolean isCredentialsNonExpired=true;

    protected String address;
    protected DateTime archivedOn;
    protected DateTime createdOn;
    protected DateTime dateOfBirth;
    protected String email;
    protected String firstName;
    protected String lastName;
    protected DateTime modifiedOn;


    public WwwUser() {
        this.enabled = false;
        this.username = "anonymous";
    }

    public WwwUser(User user) {
        this.id = user.getId();

        // @TODO for each tokenized roles, add authorities
        HashSet<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
        auths.add(new SimpleGrantedAuthority(user.getSecurityRoles()));
        setAuthorities(auths);
        // @TODO bind other values too


        // authenticationuserdetails
        this.username = user.getUserName();
        this.passwordHash = user.getPassword();
        this.enabled = user.getArchivedOn() == null;
        this.grantedAuthorities.addAll(auths);

        bindUser(user);
    }

    private void bindUser(User u) {
        this.address = u.getAddress();
        this.archivedOn = u.getArchivedOn();

        this.createdOn = u.getCreatedOn();

        this.dateOfBirth = u.getDateOfBirth();
        this.email = u.getEmail();
        this.firstName  = u.getFirstName();
        this.lastName = u.getLastName();

        this.modifiedOn = u.getModifiedOn();

        this.enabled = u.getEnabled() != null ? u.getEnabled(): true;
        this.isAccountNonExpired = u.getAccountNonExpired() != null ? u.getAccountNonExpired(): true;
        this.isAccountNonLocked = u.getAccountNonLocked() != null ? u.getAccountNonLocked(): true;
        this.isCredentialsNonExpired = u.getCredentialsNonExpired() != null ? u.getCredentialsNonExpired(): true;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return passwordHash;
    }

    public void setPassword(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public HashSet<GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    public void setAuthorities(HashSet<GrantedAuthority> authorities) {
        this.grantedAuthorities = authorities;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DateTime getArchivedOn() {
        return archivedOn;
    }

    public void setArchivedOn(DateTime archivedOn) {
        this.archivedOn = archivedOn;
    }


    public DateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(DateTime createdOn) {
        this.createdOn = createdOn;
    }


    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public DateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(DateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }


    public void addRole(String role) {
        if (!grantedAuthorities.contains(role))
            this.grantedAuthorities.add(new SimpleGrantedAuthority(role));
    }

    public boolean isSuperuser() {
        if (grantedAuthorities.contains(new SimpleGrantedAuthority(Constants.ROLE_SUPERUSER))) return true;
        return false;
    }

    public boolean isModerator() {
        if (grantedAuthorities.contains(new SimpleGrantedAuthority(Constants.ROLE_MODERATOR))) return true;
        return false;
    }

    public boolean isUser() {
        if (grantedAuthorities.contains(new SimpleGrantedAuthority(Constants.ROLE_USER))) return true;
        return false;
    }

    public void setFakedAccount(boolean isItReally) {
        this.isFakedAccount = isItReally;
    }

    public boolean isFakedAccount() {
        return isFakedAccount;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

}
