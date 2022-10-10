package com.petmatches.users.model;

import com.petmatches.users.enums.RolName;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name="ROLES")
public class RoleModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private RolName rolName;

    public RoleModel() {
    }

    public RoleModel(RolName rolName) {
        this.rolName = rolName;
    }
}
