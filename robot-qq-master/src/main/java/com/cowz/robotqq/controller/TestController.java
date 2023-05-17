package com.cowz.robotqq.controller;

import com.cowz.robotqq.service.SendMessageService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/robot")
@EnableScheduling
public class TestController {

    @Resource
    SendMessageService sendMessageService;

    /**
     * 关键词回复
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void reply() {
        System.out.println("开始检测关键词");
        List<HashMap> messages = sendMessageService.fetchMessage();
        messages.forEach(message -> {
            if (((String)message.get("content")).contains("关键词")) {
                System.out.println("检测到了关键词");
                sendMessageService.pushInfoToOne("命中了关键词，这是回复", (Long) message.get("id"));
            }
        });
    }
    /**
     * 定时推送
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void pushTask() {
        System.out.println("开始推送");
        sendMessageService.pushInfoToOne("推送测试", 230253928L);
    }

    /**
     * 指定条件下触发
     * @return
     */
    @GetMapping
    public String condition() {
        System.out.println("新商品上架，触发推送");
        sendMessageService.pushInfoToOne("有新商品上架了", 230253928L);
        return "success";
    }


}
