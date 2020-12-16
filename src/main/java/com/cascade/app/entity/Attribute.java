package com.cascade.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "ATTRIBUTE_TBL")
public class Attribute
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int attributeId;

   @Column(name = "attribute_name")
   private String name;

    public Attribute() {
    }

    public Attribute(int attributeId, String name) {
        this.attributeId = attributeId;
        this.name = name;
    }

    public int getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(int attributeId) {
        this.attributeId = attributeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "attributeId=" + attributeId +
                ", name='" + name + '\'' +
                '}';
    }
}
