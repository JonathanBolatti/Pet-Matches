package com.petmatches.users.model;


import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USERS")
@SQLDelete(sql = "UPDATE USERS SET DELETED = true WHERE id=?")
@Where(clause = "DELETED=false")
public class UserModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "FIRST_NAME", nullable = true)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = true)
    private String lastName;

    @Column(name = "BIRTH_DATE", nullable = true)
    private String birthDate;

    @Column(name = "NATIONALITY", nullable = true)
    private String userNationality;

    @Column(name = "CODE_NATIONALITY", nullable = true)
    private String codeNationality;

    @OneToOne
    @JoinColumn(name = "PHONE_ID")
    private PhoneNumberModel phoneNumber;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USUARIO_ROLES", joinColumns = {@JoinColumn(name = "USER_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID")})
    private Set<RoleModel> roles;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "STATUS", nullable = true)
//    private StatusUserModel status;

//    @OneToOne
//    @JoinColumn(name = "ADDRESS_ID")
//    private AddressModel addressModel;

    @Column(name = "DELETED", nullable = true)
    private boolean deleted = Boolean.FALSE;




}
