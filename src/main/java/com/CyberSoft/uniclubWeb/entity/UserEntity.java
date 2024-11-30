package com.CyberSoft.uniclubWeb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name="full_name")
    private String fullname;

    @ManyToOne      // TODO note: Dựa vào "ManyToOne" hay "OneToMany" Xem chữ sau cùng để chọn một đối tượng private hay một List đối tượng.
    @JoinColumn(name = "id_roles")       // TODO note: Tên cột trong dâatabase dùng để liên kết dữ liệu
    private RoleEntity roles;    // TODO note: Dựa vào "ManyToOne" hay "OneToMany" Xem chữ sau cùng để chọn một đối tượng private hay một List đối tượng.
}
