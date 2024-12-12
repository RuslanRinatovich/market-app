package ru.zelmex.marketapp.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "roles", schema = "public")
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    @Column(name = "title", nullable = false, length = 200)
    private String title;

    public Role() {
    }

    public Role(Long categoryId, String title) {
        this.roleId = categoryId;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role role)) return false;
        return Objects.equals(roleId, role.roleId) && Objects.equals(title, role.title);
    }

    @Override
    public int hashCode() {
        final int hashCode = 17 * roleId.hashCode() + 31 * title.hashCode();
        return hashCode;
    }


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long categoryId) {
        this.roleId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

}