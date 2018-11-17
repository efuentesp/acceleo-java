package com.softtek.acceleo.demo.security;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.Privilege;

/**
 * Created by stephan on 20.03.16.
 */
public class JwtUser implements UserDetails {

    private final Long id;
    private final String username;
    private final String firstname;
    private final String lastname;
    private final String password;
    private final String email;
    private final boolean enabled;
    private final Date lastPasswordResetDate;    
    private final InfoUser user;
    private final Collection<? extends GrantedAuthority> authorities;
    private final List<JwtPermission> permissions;

	public JwtUser(
          Long id,
          String username,
          String firstname,
          String lastname,
          String email,
          String password,
          boolean enabled,
          Date lastPasswordResetDate, 
          InfoUser user,
          Collection<? extends GrantedAuthority> authorities,
          List<JwtPermission> permissions
    ) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.user = user;
        this.authorities = authorities;
        this.permissions = permissions;
    }
    
    /**
     * Se carga informacion de los authority.
     * @return
     */
    private Collection<? extends Privilege> loadPrivilege(){
    	
    	
    	return null;
    }
    

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    public String getFirstname() {
        return firstname;
    }

    @JsonIgnore
    public String getLastname() {
        return lastname;
    }

    @JsonIgnore
    public String getEmail() {
        return email;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
    
    public InfoUser getUser() {
		return user;
	}
	
    public List<JwtPermission> getPermissions() {
		return permissions;
	}
	
    
}

class InfoUser {
    private String username = null;
	private String display_name = null;
    private String email = null;
    private Boolean user_enabled = Boolean.FALSE;
    private String role = null;
    private Boolean role_enabled = Boolean.FALSE;    
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getUser_enabled() {
		return user_enabled;
	}
	public void setUser_enabled(Boolean user_enabled) {
		this.user_enabled = user_enabled;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Boolean getRole_enabled() {
		return role_enabled;
	}
	public void setRole_enabled(Boolean role_enabled) {
		this.role_enabled = role_enabled;
	}
}