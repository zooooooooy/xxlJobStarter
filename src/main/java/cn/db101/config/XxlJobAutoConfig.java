package cn.db101.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {XxlJobConfig.class})
public class XxlJobAutoConfig {

    @Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobSpringExecutor xxlJobExecutor(XxlJobConfig xxlJobConfig) {

        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(xxlJobConfig.getAdmin().getAddresses());
        xxlJobSpringExecutor.setAppName(xxlJobConfig.getExecutor().getAppName());
        xxlJobSpringExecutor.setIp(xxlJobConfig.getExecutor().getIp());
        xxlJobSpringExecutor.setPort(xxlJobConfig.getExecutor().getPort());
        xxlJobSpringExecutor.setAccessToken(xxlJobConfig.getAccessToken());
        xxlJobSpringExecutor.setLogPath(xxlJobConfig.getExecutor().getLogPath());
        xxlJobSpringExecutor.setLogRetentionDays(xxlJobConfig.getExecutor().getLogRetentionDays());

        return xxlJobSpringExecutor;
    }
}
