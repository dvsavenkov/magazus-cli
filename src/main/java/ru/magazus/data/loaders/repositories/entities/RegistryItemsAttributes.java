package ru.magazus.data.loaders.repositories.entities;

import javax.persistence.*;

@IdClass(RegistryItemsAttributesPK.class)
@Entity(name = "registry_items_attributes")
public class RegistryItemsAttributes {

    @Id
    @AttributeOverrides({
            @AttributeOverride(name = "itemid", column = @Column(name = "itemid")),
            @AttributeOverride(name = "sourceid", column = @Column(name = "sourceid")),
            @AttributeOverride(name = "attribute", column = @Column(name = "attribute"))
    })
    private Integer sourceid;
    private String itemid;
    private String attribute;

    @Column
    private String value;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
