package com.cascade.app.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "GEOMETRY_TBL")
public class Geometry
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int geometryId;

   @Column(name = "geometry_name")
   private String name;

   @OneToMany(targetEntity = Attribute.class, cascade = CascadeType.ALL)
   @JoinColumn(name = "ga_fk", referencedColumnName = "geometryId")
   private List<Attribute> attributes;

    public Geometry() {
    }

    public Geometry(int geometryId, String name, List<Attribute> attributes) {
        this.geometryId = geometryId;
        this.name = name;
        this.attributes = attributes;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public int getGeometryId() {
        return geometryId;
    }

    public void setGeometryId(int geometryId) {
        this.geometryId = geometryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Geometry{" +
                "geometryId=" + geometryId +
                ", name='" + name + '\'' +
                '}';
    }
}
