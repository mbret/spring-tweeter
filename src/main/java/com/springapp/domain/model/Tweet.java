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
	private String id;
    
	private User user;
    
    private Double userID;
    
	private Date date = new Date();
    
	private String content;

    public Tweet() {
    }

    public Tweet(String content) {
        this.content = content;
    }

    public String getDateText(){
		return new SimpleDateFormat(textFormat).format(date);
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getUserID() {
        return userID;
    }

    public void setUserID(Double userID) {
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
