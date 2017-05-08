package cc.sjyuan.mongo.service.impl;

import org.springframework.data.mongodb.core.mapping.Field;

public class StatusStatisticsVO {
    private String status;
    private long value;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "StatusStatisticsVO{" +
                "status='" + status + '\'' +
                ", value=" + value +
                '}';
    }
}
