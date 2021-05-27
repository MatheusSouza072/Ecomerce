package com.ecomerce.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long Id;

    @Column(name = "PASSWORD", nullable = false, length = 100)
    private String password;

    @Deprecated
    public User(){
    }

    private User(@NotNull String description) {
        this.password = Objects.requireNonNull(description, "password must not be null");
    }

    public static User of(@NotNull String description) {
        return new User(description);
    }

    public Long getId() {
        return Id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }


}
