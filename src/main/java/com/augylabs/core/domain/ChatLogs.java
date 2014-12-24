package com.augylabs.core.domain;

import javax.persistence.*;

/**
 * Created by adarshpandey on 12/5/14.
 */

@Entity
@Table(name = "chat_logs")
public class ChatLogs {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;


    @Column(name = "message")
    private String message;

    @Column(name = "timestamp")
    private Long timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
