package com.mpolicy.dbfile.utils;

import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.rtf.RtfWriter2;
import com.mpolicy.dbfile.config.ExportConstants;
import com.mpolicy.dbfile.modules.system.entity.TableFileds;
import com.mpolicy.dbfile.modules.system.entity.Tables;
import com.mpolicy.dbfile.modules.system.mapper.TableMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * <p> 创建word文档 </p>
 *
 * @author : chenyu
 * @description : 步骤:
 * 1、建立文档
 * 2、创建一个书写器
 * 3、打开文档
 * 4、向文档中写入数据
 * 5、关闭文档
 */
@Service
@Slf4j
public class TableToWordUtil {

    @Autowired
    TableMapper tableMapper;

    /**
     * 生成word文档
     *
     * @param tables：该数据库下所有表信息
     * @param fileName：生成文件地址
     * @param title:文件内容标题
     * @return: void
     */
    public void toWord(List<Tables> tables, String fileName, String title) {
        Document document = new Document(PageSize.A4);
        try {
            // 创建文件夹
            File dir = new File(ExportConstants.FILE_PATH);
            dir.mkdirs();

            // 创建文件
            File file = new File(fileName);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            file.createNewFile();

            // 写入文件信息
            RtfWriter2.getInstance(document, new FileOutputStream(fileName));
            document.open();
            Paragraph ph = new Paragraph();
            Font f = new Font();
            Paragraph p = new Paragraph(title, new Font(Font.NORMAL, 24, Font.BOLDITALIC, new Color(0, 0, 0)));
            p.setAlignment(1);
            document.add(p);
            ph.setFont(f);
            for (int i = 0; i < tables.size(); i++) {
                String table_name = tables.get(i).getName();
                String table_comment = tables.get(i).getComments();
                List<TableFileds> fileds = tableMapper.getTableInfo(tables.get(i).getName());
                if (table_comment == null) {
                    table_comment=table_name;
                }
                String all = "" + (i+1) + " 、"+table_comment+"\n 表名称:" + table_name;
                Table table = new Table(4);

                document.add(new Paragraph(""));

                table.setBorderWidth(1);
                table.setPadding(0);
                table.setSpacing(0);

                //添加表头的元素，并设置表头背景的颜色
                Color chade = new Color(176, 196, 222);

                Cell cell = new Cell("编号");
                addCell(table, cell, chade);
                cell = new Cell("字段名");
                addCell(table, cell, chade);
                cell = new Cell("字段属性");
                addCell(table, cell, chade);
                cell = new Cell("说明");
                addCell(table, cell, chade);

                table.endHeaders();

                // 表格的主体
                for (int k = 0; k < fileds.size(); k++) {
                    addContent(table, cell, (k + 1) + "");
                    addContent(table, cell, fileds.get(k).getField());
                    addContent(table, cell, fileds.get(k).getType()+"("+fileds.get(k).getLength()+")");
                    addContent(table, cell, fileds.get(k).getComments());

                }
                Paragraph pheae = new Paragraph(all);
                //写入表说明
                document.add(pheae);
                //生成表格
                document.add(table);
                log.info("正在写入表名为:"+table_name);
            }
            document.close();
            log.info("导出结束,关闭写入");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加表头到表格
     *
     * @param table
     * @param cell
     * @param chade
     */
    private void addCell(Table table, Cell cell, Color chade) {
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(chade);
        table.addCell(cell);
    }

    /**
     * 添加内容到表格
     *
     * @param table
     * @param content
     */
    private void addContent(Table table, Cell cell, String content) {
        cell = new Cell(content);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
    }

}
