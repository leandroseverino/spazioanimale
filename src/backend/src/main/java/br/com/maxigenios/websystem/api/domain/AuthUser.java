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
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <p>User Entity</p>
 * 
 * @author Leandro Severino - lseverino@gmail.com
 * @since 1.0
 * @version 1.0 
 */
@Entity
@Table(name = "auth_user")
@SequenceGenerator(name = "seq_auth_user", sequenceName = "auth_user_id_seq", allocationSize = 1, initialValue = 1)
public class AuthUser implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "seq_auth_user", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "password", nullable = false, length = 128)
    private String password;
    
    @Column(name = "last_login", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    
    @Column(name = "is_superuser", nullable = false)
    private boolean isSuperuser;
    
    @Column(name = "username", nullable = false, length = 30)
    private String username;
    
    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;
    
    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;
    
    @Column(name = "email", nullable = false, length = 254)
    private String email;
    
    @Column(name = "is_staff", nullable = false)
    private boolean isStaff;
    
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    
    @Column(name = "date_joined", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateJoined;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId", fetch = FetchType.LAZY)
    private List<Loggy> loggyList;
    
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresaId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<AuthUserGroups> authUserGroupsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<AuthUserUserPermissions> authUserUserPermissionsList;

    public AuthUser() {
    }

    public AuthUser(Integer id) {
        this.id = id;
    }

    public AuthUser(Integer id, String password, boolean isSuperuser, String username, String firstName, String lastName, String email, boolean isStaff, boolean isActive, Date dateJoined) {
        this.id = id;
        this.password = password;
        this.isSuperuser = isSuperuser;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isStaff = isStaff;
        this.isActive = isActive;
        this.dateJoined = dateJoined;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean getIsSuperuser() {
        return isSuperuser;
    }

    public void setIsSuperuser(boolean isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(boolean isStaff) {
        this.isStaff = isStaff;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public List<Loggy> getLoggyList() {
        return loggyList;
    }

    public void setLoggyList(List<Loggy> loggyList) {
        this.loggyList = loggyList;
    }

    public Empresa getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Empresa empresaId) {
        this.empresaId = empresaId;
    }

    public List<AuthUserGroups> getAuthUserGroupsList() {
        return authUserGroupsList;
    }

    public void setAuthUserGroupsList(List<AuthUserGroups> authUserGroupsList) {
        this.authUserGroupsList = authUserGroupsList;
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
        if (!(object instanceof AuthUser)) {
            return false;
        }
        AuthUser other = (AuthUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AuthUser {" + "id=" + id + ", password=" + password + ", lastLogin=" + lastLogin + ", isSuperuser=" + isSuperuser + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", isStaff=" + isStaff + ", isActive=" + isActive + ", dateJoined=" + dateJoined + ", empresaId=" + empresaId + '}';
    }
    
}
