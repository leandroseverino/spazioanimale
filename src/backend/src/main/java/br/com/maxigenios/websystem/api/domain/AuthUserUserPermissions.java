/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.maxigenios.websystem.api.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <p>User x Permissions Entity</p>
 * 
 * @author Leandro Severino - lseverino@gmail.com
 * @since 1.0
 * @version 1.0 
 */
@Entity
@Table(name = "auth_user_user_permissions")
@SequenceGenerator(name = "seq_auth_user_user_permissions", sequenceName = "auth_user_user_permissions_id_seq", allocationSize = 1, initialValue = 1)
public class AuthUserUserPermissions implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "seq_auth_user_user_permissions", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @JoinColumn(name = "permission_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AuthPermission permissionId;
    
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AuthUser userId;
    
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresaId;

    public AuthUserUserPermissions() {
    }

    public AuthUserUserPermissions(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AuthPermission getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(AuthPermission permissionId) {
        this.permissionId = permissionId;
    }

    public AuthUser getUserId() {
        return userId;
    }

    public void setUserId(AuthUser userId) {
        this.userId = userId;
    }

    public Empresa getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Empresa empresaId) {
        this.empresaId = empresaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AuthUserUserPermissions)) {
            return false;
        }
        AuthUserUserPermissions other = (AuthUserUserPermissions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AuthUserUserPermissions {" + "id=" + id + ", permissionId=" + permissionId + ", userId=" + userId + ", empresaId=" + empresaId + '}';
    }
    
}
