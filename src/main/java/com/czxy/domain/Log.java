package com.czxy.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * CREATE TABLE `tab_log` (
 *   `id` INT(11) NOT NULL AUTO_INCREMENT,
 *   `uid` INT(11) DEFAULT NULL,
 *   `username` VARCHAR(20) DEFAULT NULL,
 *   `operat` VARCHAR(20) DEFAULT NULL,
 *   `time` DATETIME DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=INNODB DEFAULT CHARSET=utf8;
 */
@Table(name = "tab_log")
@Entity
public class Log {
    @Id
    private Integer id;
    private Integer uid;
    private String username;
    private String operat;
    private Date time;

    public Log() {
    }

    public Log(Integer id, Integer uid, String username, String operat, Date time) {
        this.id = id;
        this.uid = uid;
        this.username = username;
        this.operat = operat;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", operat='" + operat + '\'' +
                ", time=" + time +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperat() {
        return operat;
    }

    public void setOperat(String operat) {
        this.operat = operat;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
