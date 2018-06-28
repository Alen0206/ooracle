package com.example.ooracle.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_ORDER")
public class TOrder {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "GOODS_ID")
    private Integer goodsId;

    @Column(name = "NUM")
    private Integer num;

    @Column(name = "USER_ID")
    private Integer userId;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @Column(name = "CRETIME")
    private Date cretime;

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
     * @return GOODS_ID
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return NUM
     */
    public Integer getNum() {
        return num;
    }

    /**
     * @param num
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * @return USER_ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return CRETIME
     */
    public Date getCretime() {
        return cretime;
    }

    /**
     * @param cretime
     */
    public void setCretime(Date cretime) {
        this.cretime = cretime;
    }

    @Override
    public String toString() {
        return "TOrder{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", num=" + num +
                ", userId=" + userId +
                ", cretime=" + cretime +
                '}';
    }
}