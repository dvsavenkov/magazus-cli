package ru.magazus.data.loaders.repositories.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Objects;

@Entity(name = "items_relation")
public class ItemsRelation {

    @EmbeddedId
    private ItemsRelationPK itemsRelationPK;

    @Column(name = "url")
    private String url;

    @Column(name = "relurl")
    private String relUrl;

    @Column(name = "insdate")
    private Date insDate;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRelUrl() {
        return relUrl;
    }

    public void setRelUrl(String relUrl) {
        this.relUrl = relUrl;
    }

    public Date getInsDate() {
        return insDate;
    }

    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }

    public ItemsRelationPK getItemsRelationPK() {
        return itemsRelationPK;
    }

    public void setItemsRelationPK(ItemsRelationPK itemsRelationPK) {
        this.itemsRelationPK = itemsRelationPK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemsRelation)) return false;
        ItemsRelation that = (ItemsRelation) o;
        return Objects.equals(getItemsRelationPK(), that.getItemsRelationPK()) &&
                Objects.equals(getUrl(), that.getUrl()) &&
                Objects.equals(getRelUrl(), that.getRelUrl()) &&
                Objects.equals(getInsDate(), that.getInsDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemsRelationPK(), getUrl(), getRelUrl(), getInsDate());
    }
}
