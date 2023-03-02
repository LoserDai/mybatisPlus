package com.mpolicy.dbfile.modules.system.service.impl;

import com.mpolicy.dbfile.config.ExportConstants;
import com.mpolicy.dbfile.modules.common.dto.output.ApiResult;
import com.mpolicy.dbfile.modules.system.entity.Tables;
import com.mpolicy.dbfile.modules.system.mapper.TableMapper;
import com.mpolicy.dbfile.modules.system.service.ITableService;
import com.mpolicy.dbfile.utils.DateTimeUtils;
import com.mpolicy.dbfile.utils.TableToWordUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * <p> 实现类 </p>
 *
 * @author : chenyu
 * @description :
 */
@Slf4j
@Service
public class TableService implements ITableService {

    @Autowired
    private TableMapper tableMapper;
    @Autowired
    private TableToWordUtil tableToWordUtil;

    @Override
    public ApiResult getTableInfo(String tableName) {
        List<Tables> tables = null;
        // 1、获取数据库所有表信息(若param传入表名则导出单个表信息)
        tables = tableMapper.getAllTables(ExportConstants.DATABASE, tableName);
        if (CollectionUtils.isEmpty(tables)) {
            return ApiResult.fail("数据库或表信息不存在");
        }
        // 2、生成文件名信息 - 年月日时分秒
        String date = null;
        try {
            date = DateTimeUtils.dateFormat(new Date(), DateTimeUtils.PARSE_PATTERNS[12]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String docFileName = ExportConstants.FILE_PATH + "\\" + ExportConstants.FILE_NAME + "-" + date + ".doc";

        // 3、调用工具类生成文件
        tableToWordUtil.toWord(tables, docFileName, ExportConstants.FILE_NAME);

        // 4、返回文件地址
        String filePath = docFileName.replaceAll("\\\\", "/");
        return ApiResult.ok("导出数据库表信息生成Word成功", filePath);
    }
}

