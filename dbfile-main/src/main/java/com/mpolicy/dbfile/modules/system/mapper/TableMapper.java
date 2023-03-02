package com.mpolicy.dbfile.modules.system.mapper;


import com.mpolicy.dbfile.modules.system.entity.TableFileds;
import com.mpolicy.dbfile.modules.system.entity.Tables;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p> 查询表数据信息 </p>
 *R
 * @author : chenyu
 * @description :
 */
@Mapper
public interface TableMapper {

    /**
     * 获取指定数据库下所有表名和注释
     *
     * @param dbName:数据库名
     * @return: java.util.List<com.mpolicy.dbfile.modules.system.entity.Tables>
     */

//    @Select("<script> select table_name as name,table_comment as comment from information_schema.tables where table_schema =#{dbName} <if test=\"tableName != null and tableName != '' and tableName != 'null'\"> and table_name = #{tableName}</if> order by table_name </script>")
//    List<Tables> getAllTables(@Param("dbName") String dbName, @Param("tableName") String tableName);
    @Select("<script> select COMMENTS.TABLE_NAME as name ,COMMENTS.COMMENTS  from all_tables tables left join USER_TAB_COMMENTS comments on tables.TABLE_NAME = COMMENTS.TABLE_NAME where OWNER = 'CITINBMS'</script>")
    List<Tables> getAllTables(@Param("dbName") String dbName, @Param("tableName") String tableName);

    /**
     * 获取指定表信息
     *
     * @param tableName:表
     * @return: java.util.List<com.mpolicy.dbfile.modules.system.entity.TableFileds>
     */
//    @Select("SHOW FULL FIELDS FROM ${tableName}")
//    List<TableFileds> getTableInfo(@Param("tableName") String tableName);
    @Select("SELECT\n" +
            " atc.COLUMN_NAME AS field,\n" +
            " atc.DATA_TYPE AS type,\n" +
            " atc.data_length AS length,\n" +
            " acc.COMMENTS AS comments\n" +
            "FROM\n" +
            " ALL_TAB_COLUMNS atc\n" +
            "LEFT JOIN ALL_COL_COMMENTS acc ON\n" +
            " (atc.TABLE_NAME = acc.TABLE_NAME\n" +
            "  AND atc.OWNER = acc.OWNER\n" +
            "  AND atc.COLUMN_NAME = acc.COLUMN_NAME)\n" +
            "WHERE\n" +
            " atc. TABLE_NAME = #{tableName}\n" +
            " AND atc.OWNER = 'CITINBMS'\n" +
            " ORDER BY atc.column_ID ")
    List<TableFileds> getTableInfo(@Param("tableName") String tableName);

}
