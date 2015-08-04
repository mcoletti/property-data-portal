package com.codeitek.pdp.model;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/20/13
 * Time: 5:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerDataSource {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String custUuid;

    public String getCustUuid() {
        return custUuid;
    }

    public void setCustUuid(String custUuid) {
        this.custUuid = custUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerDataSource that = (CustomerDataSource) o;

        if (id != that.id) return false;
        if (custUuid != null ? !custUuid.equals(that.custUuid) : that.custUuid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (custUuid != null ? custUuid.hashCode() : 0);
        return result;
    }
}
