package cn.db101.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "xxl.job")
public class XxlJobConfig {

    private Admin admin;

    private Executor executor;

    private String accessToken;

    @Data
    public static class Admin {
        private String addresses;
    }

    @Data
    public static class Executor {

        private String appName = "xxl-job-executor-sample";

        private String ip;

        private String address;

        private int port = 9999;

        private String logPath = "/data/applogs/xxl-job/jobhandler";

        private int logRetentionDays = 30;

    }

}
