package io.bramcode.movie.moviecategoryservices.auth;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity(name = "UserRole")
@Table(name = "userrole")
public class UserRole {

    @Id
    @SequenceGenerator(
            name = "userrole_sequence",
            sequenceName = "userrole_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userrole_sequence"
    )
    @Column(
            name = "role_id",
            updatable = false
    )
    private Long roleId;

    @Column(name = "role_name", length = 50, nullable = false)
    private String roleName;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "isRole_Enabled", nullable = false)
    private boolean isRoleEnabled;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_name")
    private UserPermission permissionSet;


    public UserRole() {
    }

    public UserRole(Long roleId, String roleName, boolean isRoleEnabled, UserPermission permissionSet) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.isRoleEnabled = isRoleEnabled;
        this.permissionSet = permissionSet;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isRoleEnabled() {
        return isRoleEnabled;
    }

    public void setRoleEnabled(boolean roleEnabled) {
        isRoleEnabled = roleEnabled;
    }

    public UserPermission getPermissionSet() {
        return permissionSet;
    }

    public void setPermissionSet(UserPermission permissionSet) {
        this.permissionSet = permissionSet;
    }

}
