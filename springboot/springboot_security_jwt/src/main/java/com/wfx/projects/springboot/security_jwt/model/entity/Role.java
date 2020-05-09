package com.wfx.projects.springboot.security_jwt.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Gwei
 */
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
