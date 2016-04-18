package edu.uta.sis.cnfg.domain.entities;


import javax.persistence.*;

/**
 * Created by Hannu Lohtander on 4.4.2016.
 */
@Table( name = "filematadata")
@Entity
public class FileMetaData {

    @Id
    @GeneratedValue
    Integer id;
    @Column(length = 1000)
    String originalName;
    @Column(length = 1000)
    String newName;
    long size;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
