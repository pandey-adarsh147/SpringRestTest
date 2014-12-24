package com.augylabs.facade.controller;

import com.augylabs.core.domain.ChatLogs;
import com.augylabs.core.repository.ChatLogRepository;
import com.augylabs.facade.Versions;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by adarshpandey on 12/6/14.
 *
 *
 * curl -X POST -H "Content-Type: application/json" -d '{"message":"xyz","timestamp":12345}' http://localhost:8080/chatlogs/adarsh
 *
 * curl -X GET http://localhost:8080/chatlogs/adarsh?limit=10&messageId=1
 *
 */
@RestController("Chat log related operations")
public class ChatLogsRestController {

    @Autowired
    private ChatLogRepository chatLogRepository;

    @RequestMapping(value = "/chatlogs/{userName}",
            method = RequestMethod.POST,
            produces = {Versions.APPLICATION_JSON},
            consumes = {Versions.APPLICATION_JSON})
    public Map<String, Object> addChatLog(@PathVariable String userName, @RequestBody Map<String, String> message) {

        ChatLogs chatLogs = new ChatLogs();
        chatLogs.setMessage(message.get("message"));
        chatLogs.setTimestamp(Long.valueOf(message.get("timestamp")));

        chatLogRepository.save(chatLogs);

        Map<String, Object> chatResponse = Maps.newHashMap();

        chatResponse.put("status", true);

        return chatResponse;
    }


    @RequestMapping(value = "/chatlogs/{userName}",
            method = RequestMethod.GET,
            produces = {Versions.APPLICATION_JSON})
    public Map<String, Object> getChatLogs(@PathVariable String userName, @RequestParam("limit") int limit, @RequestParam("messageId") int messageId) {

        Map<String, Object> responseMap = Maps.newHashMap();


        PageRequest pageRequest = new PageRequest(0, limit);
        List<ChatLogs> logs = chatLogRepository.findAll(userName, messageId, pageRequest);

        responseMap.put("response", logs);

        return responseMap;
    }
}
