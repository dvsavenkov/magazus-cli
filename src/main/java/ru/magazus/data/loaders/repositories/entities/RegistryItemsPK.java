package ru.magazus.data.loaders.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RegistryItemsPK implements Serializable {

    @Column(name = "itemid")
    private String itemid;

    @Column(name = "sourceid")
    private Integer sourceid;


    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public Integer getSourceid() {
        return sourceid;
    }

    public void setSourceid(Integer sourceid) {
        this.sourceid = sourceid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistryItemsPK that = (RegistryItemsPK) o;
        return Objects.equals(getItemid(), that.getItemid()) &&
                Objects.equals(getSourceid(), that.getSourceid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemid(), getSourceid());
    }

    @Override
    public String toString() {
        return "RegistryItemsPK{" +
                "itemid='" + itemid + '\'' +
                ", sourceid=" + sourceid +
                '}';
    }
}
