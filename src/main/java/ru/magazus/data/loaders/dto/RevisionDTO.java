package ru.magazus.data.loaders.dto;

import java.util.Objects;

public class RevisionDTO extends DTO {

    private String modelName;

    private String modelCode;

    private String url;

    private String shopName;

    private float shopPrice;

    private String date;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public float getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(float shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RevisionDTO that = (RevisionDTO) o;
        return Float.compare(that.shopPrice, shopPrice) == 0 &&
                modelName.equals(that.modelName) &&
                modelCode.equals(that.modelCode) &&
                url.equals(that.url) &&
                shopName.equals(that.shopName) &&
                date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelName, modelCode, url, shopName, shopPrice, date);
    }

    @Override
    public String toString() {
        return "RevisionDTO{" +
                "modelName='" + modelName + '\'' +
                ", modelCode='" + modelCode + '\'' +
                ", url='" + url + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopPrice=" + shopPrice +
                ", date='" + date + '\'' +
                '}';
    }
}
