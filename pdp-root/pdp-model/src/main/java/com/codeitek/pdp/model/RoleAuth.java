package com.codeitek.pdp.model;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/9/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public class RoleAuth {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleAuth roleAuth = (RoleAuth) o;

        if (enabled != roleAuth.enabled) return false;
        if (id != roleAuth.id) return false;
        if (role != null ? !role.equals(roleAuth.role) : roleAuth.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        return result;
    }
}
