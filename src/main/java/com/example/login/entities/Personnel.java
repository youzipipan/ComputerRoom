package com.example.login.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.util.Objects;

@Entity
@Data
public class Personnel {
    private String id;
    private String username;
    private String password;
    private String flag;
    private String valid;

    @Id
    @Column(name = "ID", nullable = false, length = 40)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USERNAME", nullable = true, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = true, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "FLAG", nullable = true, length = 1)
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "VALID", nullable = true, length = 1)
    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personnel personnel = (Personnel) o;
        return Objects.equals(id, personnel.id) &&
                Objects.equals(username, personnel.username) &&
                Objects.equals(password, personnel.password) &&
                Objects.equals(flag, personnel.flag) &&
                Objects.equals(valid, personnel.valid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password, flag, valid);
    }
}
