package com.mikasan.pojo;

import org.hyperledger.fabric.contract.annotation.Property;

import java.security.Timestamp;
import java.util.Map;

/**
 * ResourceReports
 *
 * @author MiKaSan
 * @since 2025/8/20 16:36
 *  流量安全威胁报告
 */
public class ResourceReports {
    @Property
    String id;

    @Property
    String reportName;

    @Property
    String gatewayName;

    @Property
    String content;

    @Property
    Map<String,String> details;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }

    public Timestamp getReportTime() {
        return reportTime;
    }

    public void setReportTime(Timestamp reportTime) {
        this.reportTime = reportTime;
    }

    @Property
    Timestamp reportTime;

}
