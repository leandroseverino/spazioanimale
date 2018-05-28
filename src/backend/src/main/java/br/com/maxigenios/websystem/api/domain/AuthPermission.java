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
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <p>Permission Entity</p>
 * 
 * @author Leandro Severino - lseverino@gmail.com
 * @since 1.0
 * @version 1.0 
 */
@Entity
@Table(name = "auth_permission")
@SequenceGenerator(name = "seq_auth_permission", sequenceName = "auth_permission_id_seq", allocationSize = 1, initialValue = 1)
public class AuthPermission implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "seq_auth_permission", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    
    @Column(name = "content_type_id", nullable = false)
    private int contentTypeId;
    
    @Column(name = "codename", nullable = false, length = 100)
    private String codename;
    
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresaId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permissionId", fetch = FetchType.LAZY)
    private List<AuthGroupPermissions> authGroupPermissionsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permissionId", fetch = FetchType.LAZY)
    private List<AuthUserUserPermissions> authUserUserPermissionsList;

    public AuthPermission() {
    }

    public AuthPermission(Integer id) {
        this.id = id;
    }

    public AuthPermission(Integer id, String name, int contentTypeId, String codename) {
        this.id = id;
        this.name = name;
        this.contentTypeId = contentTypeId;
        this.codename = codename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContentTypeId() {
        return contentTypeId;
    }

    public void setContentTypeId(int contentTypeId) {
        this.contentTypeId = contentTypeId;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public Empresa getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Empresa empresaId) {
        this.empresaId = empresaId;
    }

    public List<AuthGroupPermissions> getAuthGroupPermissionsList() {
        return authGroupPermissionsList;
    }

    public void setAuthGroupPermissionsList(List<AuthGroupPermissions> authGroupPermissionsList) {
        this.authGroupPermissionsList = authGroupPermissionsList;
    }

    public List<AuthUserUserPermissions> getAuthUserUserPermissionsList() {
        return authUserUserPermissionsList;
    }

    public void setAuthUserUserPermissionsList(List<AuthUserUserPermissions> authUserUserPermissionsList) {
        this.authUserUserPermissionsList = authUserUserPermissionsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AuthPermission)) {
            return false;
        }
        AuthPermission other = (AuthPermission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AuthPermission {" + "id=" + id + ", name=" + name + ", contentTypeId=" + contentTypeId + ", codename=" + codename + ", empresaId=" + empresaId + '}';
    }
    
}
