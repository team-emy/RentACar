package org.codexio.rentacar.domain.entities;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {
    
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    
    private List<Rent> mySale;
    private List<Rent>myPurchase;
    
    private List<Car> myCars;

    private boolean isAccountNonLocked;
    private boolean isAccountNonExpired;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private Set<Role>authorities;
    

    public User() {
        this.mySale = new ArrayList<>();
        this.myCars = new ArrayList<>();
        this.myPurchase = new ArrayList<>();
    }

    @Override
    @Column(name = "username", nullable = false, unique = true, updatable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(targetEntity = Rent.class, mappedBy = "seller")
    public List<Rent> getMySale() {
        return mySale;
    }

    public void setMySale(List<Rent> mySale) {
        this.mySale = mySale;
    }

    @OneToMany(targetEntity = Rent.class, mappedBy = "buyer")
    public List<Rent> getMyPurchase() {
        return myPurchase;
    }

    public void setMyPurchase(List<Rent> myPurchase) {
        this.myPurchase = myPurchase;
    }

    @OneToMany(targetEntity = Car.class, mappedBy = "owner")
    public List<Car> getMyCars() {
        return myCars;
    }

    public void setMyCars(List<Car> myCars) {
        this.myCars = myCars;
    }
    

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }
}
