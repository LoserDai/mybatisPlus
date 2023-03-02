package com.mpolicy.dbfile.modules.system.service;


import com.mpolicy.dbfile.modules.common.dto.output.ApiResult;
import org.springframework.stereotype.Service;

/**
 * <p> 数据表管理 服务类 </p>
 *
 * @author : chenyu
 * @description :
 */
@Service
public interface ITableService {
    /**
     * 获取数据库表格数据
     *
     * @return
     */
    ApiResult getTableInfo(String tableName);
}
