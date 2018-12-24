package ru.magazus.data.loaders.repositories.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RegistryItemsAttributesPK implements Serializable {

    private Integer sourceid;

    private String itemid;

    private String attribute;

    public Integer getSourceid() {
        return sourceid;
    }

    public void setSourceid(Integer sourceid) {
        this.sourceid = sourceid;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegistryItemsAttributesPK)) return false;
        RegistryItemsAttributesPK that = (RegistryItemsAttributesPK) o;
        return Objects.equals(getSourceid(), that.getSourceid()) &&
                Objects.equals(getItemid(), that.getItemid()) &&
                Objects.equals(getAttribute(), that.getAttribute());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSourceid(), getItemid(), getAttribute());
    }
}
