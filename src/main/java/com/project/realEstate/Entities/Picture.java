package com.project.realEstate.Entities;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mime;
    @Lob @Basic(fetch = FetchType.LAZY)
    private byte[] content;

    public Picture() {
    }

    public Picture(String name, String mime, byte[] content) {
        this.name = name;
        this.mime = mime;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mime='" + mime + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
