package edu.uta.sis.app1.domain;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by Hannu Lohtander on 9.4.2016.
 */
@Table(name = "testentity")
@Entity
public class TestEntity {

    @Id
    @GeneratedValue
    Integer id;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    DateTime created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DateTime getCreated() {
        return created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }
}
