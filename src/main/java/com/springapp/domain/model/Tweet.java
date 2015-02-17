package com.springapp.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "tweet")
public class Tweet {
	
	private static final String textFormat = "dd/MM/yyyy HH:mm:ss";
	private static final String dbFormat = "yyyyMMddHHmmss";

    @Id
    @Column(name = "id", length = 36)
	private Double id;
    
	private User user;
    
    private String userID;
    
	private Date date = new Date();
    
	private String content;

    public Tweet() {
    }

    public Tweet(User user, String content) {
        this.user = user;
        this.content = content;
    }

    public String getDateText(){
		return new SimpleDateFormat(textFormat).format(date);
	}

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
