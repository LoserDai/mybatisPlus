package com.cowz.robotqq.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.cowz.robotqq.service.SendMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author WZ
 */
@Slf4j
@Service
public class SendMessageServiceImpl implements SendMessageService {

        @Value("${mirai.verifyKey}")
        private String verifyKey;
        @Value("${mirai.account}")
        private String account;
        @Resource
        private RestTemplate restTemplate;
        private String sessionKey;

        private static String mainInterface = "http://127.0.0.1:8080";
        private String verify = "/verify";
        private String bind = "/bind";
        private String release = "/release";
        private String sendGroupMessage = "/sendGroupMessage";
        private String groupList = "/groupList";
        private String friendMessage = "/sendFriendMessage";
        private String fetchMessage = "/fetchMessage";


        @PostConstruct
        public void init(){
            String url = mainInterface + verify;
            JSONObject jsonObject = new JSONObject();
            jsonObject.set("verifyKey", verifyKey);
            // 获取sessionKey
            ResponseEntity<HashMap> responseEntity = restTemplate.postForEntity(url, jsonObject, HashMap.class);
            HashMap bodyMap = responseEntity.getBody();
            sessionKey = (String) bodyMap.get("session");
            log.info("sessionKey:" + sessionKey);

            if (StrUtil.isNotBlank(sessionKey)) {
                String bindUrl = mainInterface + bind;
                JSONObject bindJson = new JSONObject();
                bindJson.set("sessionKey", sessionKey);
                bindJson.set("qq", Long.valueOf(account));
                restTemplate.postForEntity(bindUrl, bindJson, HashMap.class);
                log.info("bind success");
            }else {
                log.error("sessionKey exception");
            }

        }

        @Override
        public void pushInfo(String msg, Long target){

            String url = mainInterface + sendGroupMessage;

            // 拼装请求参数
            JSONObject infoJson = new JSONObject();
            infoJson.set("sessionKey", sessionKey);
            infoJson.set("target", target);
            ArrayList<HashMap<String, String>> messageChain = new ArrayList<>();
            HashMap<String, String> message = new HashMap<>();
            message.put("type", "Plain");
            message.put("text", msg);
            messageChain.add(message);
            infoJson.set("messageChain", messageChain);

            restTemplate.postForEntity(url, infoJson, Object.class);
        }

        @Override
        public void pushInfoToOne(String msg, Long target){

            String url = mainInterface + friendMessage;

            // 拼装请求参数
            JSONObject infoJson = new JSONObject();
            infoJson.set("sessionKey", sessionKey);
            infoJson.set("target", target);
            ArrayList<HashMap<String, String>> messageChain = new ArrayList<>();
            HashMap<String, String> message = new HashMap<>();
            message.put("type", "Plain");
            message.put("text", msg);
            messageChain.add(message);
            infoJson.set("messageChain", messageChain);

            restTemplate.postForEntity(url, infoJson, Object.class);
        }

        /**
         * 获取所有需要发送消息的群聊id
         */
        @Override
        public List<Long> getAllGroup(){
            String groupUrl = mainInterface + groupList + "?sessionKey=" + sessionKey;

            HashMap groupBody = restTemplate.getForEntity(groupUrl, HashMap.class).getBody();
            ArrayList<HashMap<String, Object>> groups = (ArrayList<HashMap<String, Object>>) groupBody.get("data");
            return groups
                    .stream()
                    .filter(group -> {
                        return ((String) group.get("permission")).equalsIgnoreCase("ADMINISTRATOR");
                    })
                    .map(group -> Long.valueOf(String.valueOf((int) group.get("id"))))
                    .collect(Collectors.toList());
        }

        @Override
        public List<HashMap> fetchMessage() {
            String messageUrl = mainInterface + fetchMessage + "?sessionKey=" + sessionKey + "&count=10";

            List<HashMap> result = new ArrayList<>();
            HashMap body = restTemplate.getForEntity(messageUrl, HashMap.class).getBody();
            if (((Integer)body.get("code"))==0) {
                List<HashMap> dataList = (List<HashMap>) body.get("data");
                for (HashMap data : dataList) {
                    if (((String)data.get("type")).equals("FriendMessage")) {
                        List<HashMap> messageChain = (List<HashMap>)data.get("messageChain");
                        HashMap sender = (HashMap)data.get("sender");
                        if (sender != null && messageChain != null) {
                            Long id = Long.valueOf((Integer)sender.get("id"));
                            HashMap plain = messageChain.get(1);
                            String content = (String) plain.get("text");
                            if (content != null && id != null) {
                                HashMap<String, Object> res = new HashMap<>();
                                res.put("id", id);
                                res.put("content", content);
                                result.add(res);
                            }
                        }

                    }
                }
            }

            return result;

        }


}
