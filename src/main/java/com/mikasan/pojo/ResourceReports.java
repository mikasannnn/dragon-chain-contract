package com.mikasan.pojo;

import lombok.Getter;
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
    @Getter
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

    @Property
    Timestamp reportTime;

}
