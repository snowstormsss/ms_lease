package domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author  xieyucheng
 * @create  2018/2/7 15:15
 * @desc  用户实体类
 **/

public class User implements Serializable{
    //用户Id
    private String userid;
    //用户名
    private String username;
    //用户密码
    private String password;
    //注册时间
    private LocalDateTime reg_time;
    //当前在线状态
    private Integer status;
    //账号当前状态
    private Integer locked;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getReg_time() {
        return reg_time;
    }

    public void setReg_time(LocalDateTime reg_time) {
        this.reg_time = reg_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", reg_time=" + reg_time +
                ", status=" + status +
                ", locked=" + locked +
                '}';
    }
}
