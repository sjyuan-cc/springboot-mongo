package cc.sjyuan.mongo.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "plan")
public class Plan {
    private static final Logger logger = LoggerFactory.getLogger(Plan.class);

    @Id
    private String id;

    private String subject;

    private Status status = Status.IDLE;

    public enum Status {
        IDLE,
        REHEARSING,
        BROADCASTING,
        SUSPENDED,
        PAUSED,
        FINISHED,
    }

    public enum StreamStatus {
        STOPPED,
        PUSHING,
        PAUSED
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
