package com.mikasan;

import com.google.gson.Gson;
import lombok.extern.java.Log;
import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Transaction;

/**
 * DragonChainContract
 *
 * @author MiKaSan
 * @Description : 智能合约
 * @since 2025/8/20 16:39
 */

@Contract(name = "DragonChainContract")  //指定合约名
@Default//默认是智能合约
@Log
public class DragonChainContract implements ContractInterface {

    //gson 用于JSON序列化和反序列化
    private final Gson gson = new Gson();
    
    // 添加报告
    @Transaction
    public void addResourceReport(Context ctx, String json) {
        log.info("添加报告信息: " + json);
        ContractMethod.addResourceReport(ctx, json);
    }

    // 获取单个报告
    @Transaction
    public String getResourceReport(Context ctx, String id) {
        log.info("获取报告: " + id);
        return ContractMethod.getResourceReport(ctx, id);
    }

    // 获取所有报告
    @Transaction
    public String getAllResourceReport(Context ctx) {
        log.info("获取所有报告" );
        return ContractMethod.getAllResourceReport(ctx);
    }
    
    // 添加流量报告
    @Transaction
    public void addTrafficReport(Context ctx, String  json) {
        ContractMethod.addTrafficReport(ctx, json);
    }

    // 获取单个流量报告
    @Transaction
    public String getTrafficReport(Context ctx, String id) {
        return ContractMethod.getTrafficReport(ctx, id);
    }

    // 获取所有流量报告
    @Transaction
    public String getAllTrafficReports(Context ctx) {
        return ContractMethod.getAllTrafficReports(ctx);
    }
}