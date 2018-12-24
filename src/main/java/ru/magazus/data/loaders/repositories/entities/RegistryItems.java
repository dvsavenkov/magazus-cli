package ru.magazus.data.loaders.repositories.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity(name = "registry_items")
public class RegistryItems {

    @EmbeddedId
    private RegistryItemsPK registryItemsPK;

    @ManyToOne
    @JoinColumn(name = "sourceid", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private Source source;

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public RegistryItemsPK getRegistryItemsPK() {
        return registryItemsPK;
    }

    public void setRegistryItemsPK(RegistryItemsPK registryItemsPK) {
        this.registryItemsPK = registryItemsPK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegistryItems)) return false;
        RegistryItems that = (RegistryItems) o;
        return Objects.equals(getRegistryItemsPK(), that.getRegistryItemsPK()) &&
                Objects.equals(getSource(), that.getSource());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegistryItemsPK(), getSource());
    }

    @Override
    public String toString() {
        return "RegistryItems{" +
                "registryItemsPK=" + registryItemsPK +
                ", source=" + source +
                '}';
    }
}
