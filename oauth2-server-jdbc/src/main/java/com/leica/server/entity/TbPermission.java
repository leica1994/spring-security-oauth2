package com.leica.server.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_permission")
@Getter
@Setter
public class TbPermission implements Serializable {
    /**
     *
     */
    @Id
    private Long id;

    /**
     * 父权限
     */
    private Long parentId;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限英文名称
     */
    private String enname;

    /**
     * 授权路径
     */
    private String url;

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

    @ManyToMany(targetEntity = TbRole.class, mappedBy = "tbPermissions")
    private Set<TbRole> tbRoles;
}

