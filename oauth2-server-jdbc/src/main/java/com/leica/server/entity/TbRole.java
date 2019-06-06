package com.leica.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tb_role")
@Getter
@Setter
public class TbRole implements Serializable {
    /**
     *
     */
    @Id
    private Long id;

    /**
     * 父角色
     */
    private Long parentId;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色英文名称
     */
    private String enname;

    /**
     * 备注
     */
    private String description;

    /**
     *
     */
    private Date created;

    /**
     *
     */
    private LocalDateTime updated;

    private static final long serialVersionUID = 1L;

    @ManyToMany(targetEntity = TbUser.class,mappedBy = "tbRoles")
    private Set<TbUser> tbUsers;

    @ManyToMany(targetEntity = TbPermission.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "tb_role_permission",joinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")},inverseJoinColumns = {@JoinColumn(name = "permission_id",referencedColumnName = "id")})
    private Set<TbPermission> tbPermissions;
}

