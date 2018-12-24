package ru.magazus.data.loaders.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemsRelationPK implements Serializable {

    @Column(name = "sourceid")
    private Integer sourceId;

    @Column(name = "itemid")
    private String itemid;

    @Column(name = "regionid")
    private Integer regionId;

    @Column(name = "relsourceid")
    private Integer relSourceId;

    @Column(name = "relitemid")
    private String relItemId;


    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getRelSourceId() {
        return relSourceId;
    }

    public void setRelSourceId(Integer relSourceId) {
        this.relSourceId = relSourceId;
    }

    public String getRelItemId() {
        return relItemId;
    }

    public void setRelItemId(String relItemId) {
        this.relItemId = relItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemsRelationPK)) return false;
        ItemsRelationPK that = (ItemsRelationPK) o;
        return Objects.equals(getSourceId(), that.getSourceId()) &&
                Objects.equals(getItemid(), that.getItemid()) &&
                Objects.equals(getRegionId(), that.getRegionId()) &&
                Objects.equals(getRelSourceId(), that.getRelSourceId()) &&
                Objects.equals(getRelItemId(), that.getRelItemId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSourceId(), getItemid(), getRegionId(), getRelSourceId(), getRelItemId());
    }
}
