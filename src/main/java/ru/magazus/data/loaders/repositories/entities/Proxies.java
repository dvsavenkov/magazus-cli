package ru.magazus.data.loaders.repositories.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

@Entity(name = "proxies")
public class Proxies {

    @Column(name = "protocol")
    String protocol;
    @Column(name = "blacklisted")
    Integer blacklisted;
    @Column(name = "user")
    String user;
    @Column(name = "pass")
    String password;
    @Column(name = "ver")
    Integer ver;
    @EmbeddedId
    private ProxiesPK proxiesPK;

    @Override
    public String toString() {
        return "Proxies{" +
                "proxiesPK=" + proxiesPK +
                ", protocol='" + protocol + '\'' +
                ", blacklisted=" + blacklisted +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", ver=" + ver +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proxies proxies = (Proxies) o;
        return Objects.equals(proxiesPK, proxies.proxiesPK) &&
                Objects.equals(protocol, proxies.protocol) &&
                Objects.equals(blacklisted, proxies.blacklisted) &&
                Objects.equals(user, proxies.user) &&
                Objects.equals(password, proxies.password) &&
                Objects.equals(ver, proxies.ver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proxiesPK, protocol, blacklisted, user, password, ver);
    }

    public ProxiesPK getProxiesPK() {
        return proxiesPK;
    }

    public void setProxiesPK(ProxiesPK proxiesPK) {
        this.proxiesPK = proxiesPK;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Integer getBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(Integer blacklisted) {
        this.blacklisted = blacklisted;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }
}
