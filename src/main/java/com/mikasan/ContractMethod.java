package com.mikasan;


import com.google.gson.Gson;
import com.mikasan.pojo.ResourceReports;
import com.mikasan.pojo.TrafficReports;
import lombok.extern.java.Log;
import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.annotation.Transaction;
import org.hyperledger.fabric.shim.ChaincodeStub;
import org.hyperledger.fabric.shim.ledger.QueryResultsIterator;
import org.hyperledger.fabric.shim.ledger.KeyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * ContractMethod
 *
 * @author MiKaSan
 * @Description : 合约方法实现
 * @since 2025/8/20 16:39
 */
@Log
public class ContractMethod {

    //gson 用于JSON序列化和反序列化
    private static final Gson gson = new Gson();

    //添加
    @Transaction
    public static void addResourceReport(Context ctx, String json) {
        ResourceReports reports = gson.fromJson(json, ResourceReports.class);
        ChaincodeStub stub = ctx.getStub();
        stub.putStringState(reports.getId(), gson.toJson(reports));
        log.info(reports.getId() + "\n添加成功");
    }

    //获取单个
    @Transaction
    public static String getResourceReport(Context ctx, String id) {
        ChaincodeStub stub = ctx.getStub();
        String reportJson = stub.getStringState(id);

        if (reportJson == null || reportJson.isEmpty()) {
            log.warning("ID: " + id + " 未查询到数据");
            return "{ }";
        }

        log.info("查询成功: " + id);
        return reportJson;
    }

    //获取所有
    @Transaction
    public static String getAllResourceReport(Context ctx) {
        ChaincodeStub stub = ctx.getStub();
        List<ResourceReports> reportsList = new ArrayList<>();

        // 遍历所有状态
        QueryResultsIterator<KeyValue> results = stub.getStateByRange("", "");
        for (KeyValue kv : results) {
            String json = kv.getStringValue();
            reportsList.add(gson.fromJson(json, ResourceReports.class));
        }

        log.info("查询所有数据成功，共 " + reportsList.size() + " 条");
        return gson.toJson(reportsList);
    }
    
    // 添加流量报告
    @Transaction
    public static void addTrafficReport(Context ctx, String json ){
        TrafficReports reports = gson.fromJson(json, TrafficReports.class);
        ChaincodeStub stub = ctx.getStub();
        stub.putStringState(reports.getId(), gson.toJson(reports));
        log.info(reports.getId() + "\n添加成功");
    }

    // 获取单个流量报告
    @Transaction
    public static String getTrafficReport(Context ctx, String id) {
        ChaincodeStub stub = ctx.getStub();
        String reportJson = stub.getStringState(id);

        if (reportJson == null || reportJson.isEmpty()) {
            log.warning("ID: " + id + " 未查询到数据");
            return "{}";
        }

        log.info("查询成功: " + id);
        return reportJson;
    }

    // 获取所有流量报告
    @Transaction
    public static String getAllTrafficReports(Context ctx) {
        ChaincodeStub stub = ctx.getStub();
        List<TrafficReports> reportsList = new ArrayList<>();

        // 遍历所有状态
        QueryResultsIterator<KeyValue> results = stub.getStateByRange("", "");
        for (KeyValue kv : results) {
            String json = kv.getStringValue();
            TrafficReports report = gson.fromJson(json, TrafficReports.class);
            reportsList.add(report);
        }

        log.info("查询所有数据成功，共 " + reportsList.size() + " 条");
        return gson.toJson(reportsList);
    }
}