package com.mikasan.pojo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

import java.util.Map;

/**
 * ResourceReports
 *
 * @author MiKaSan
 * @since 2025/8/20 16:36
 *  流量安全威胁报告
 */
@Data
@DataType
@Accessors(chain = true)
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

    @Property
    long reportTime;

}
