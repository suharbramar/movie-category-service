package io.bramcode.movie.moviecategoryservices.auth;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "UserPermission")
@Table(name = "userpermission")
public class UserPermission {

    @Id
    @Column(name = "permission_name", length = 100, nullable = false)
    private String permissionName;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "isPermission_Enabled", nullable = false)
    private boolean isPermissionEnabled;

    public UserPermission() {
    }

    public UserPermission(String permissionName, boolean isPermissionEnabled) {
        this.permissionName = permissionName;
        this.isPermissionEnabled = isPermissionEnabled;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public boolean isPermissionEnabled() {
        return isPermissionEnabled;
    }

    public void setPermissionEnabled(boolean permissionEnabled) {
        isPermissionEnabled = permissionEnabled;
    }
}
