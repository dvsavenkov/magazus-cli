package ru.magazus.data.loaders.repositories.entities;


import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProxiesPK implements Serializable {

    private String ip;
    private String port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProxiesPK proxiesPK = (ProxiesPK) o;
        return Objects.equals(ip, proxiesPK.ip) &&
                Objects.equals(port, proxiesPK.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port);
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

}
