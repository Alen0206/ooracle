package com.example.ooracle.pojo;

import javax.persistence.*;

@Table(name = "T_GOODS")
public class TGoods {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "STANDARD")
    private String standard;

    @Column(name = "IMAGE")
    private String image;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return PRICE
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return STANDARD
     */
    public String getStandard() {
        return standard;
    }

    /**
     * @param standard
     */
    public void setStandard(String standard) {
        this.standard = standard;
    }

    /**
     * @return IMAGE
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "TGoods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", standard='" + standard + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}