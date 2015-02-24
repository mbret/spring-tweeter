package com.springapp.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User{

    @Id
    @Column(name = "id", length = 36)
    private String id;
    
    @Column(name = "mail", unique = true)
    private String mail;
    
    @Column(name = "name")
    private String name;

    @Column(name = "firstname")
    private String firstName;
    
    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinTable(
//            name = "subscription",
//            joinColumns =
//    )
    private List<User> subscriptions;
    
    public User() {
    }

    public User(String firstName, String name, String mail, String password) {
        this.firstName = firstName;
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public boolean isValid(){
        return true;
    }

	public String getPassword() {
		return password;
	}
    /*
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    
    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return this.getMail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
    */
}
