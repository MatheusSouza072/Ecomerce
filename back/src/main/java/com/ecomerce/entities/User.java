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

    @Column(name = "DESCRIPTION", nullable = false, length = 100)
    private String description;

    @Deprecated
    public User(){
    }

    private User(@NotNull String description) {
        this.description = Objects.requireNonNull(description, "description must not be null");
    }

    public static User of(@NotNull String description) {
        return new User(description);
    }

    public Long getId() {
        return Id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(description, user.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }


}
