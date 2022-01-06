package com.jcheng.plan.rabbitmq.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jcheng.common.utils.WeChatUtils;
import com.jcheng.plan.model.PmUser;
import com.jcheng.plan.model.Task;
import com.jcheng.plan.rabbitmq.MqConstants;
import com.jcheng.plan.service.TaskService;
import com.jcheng.plan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

@Component
@RabbitListener(queues = MqConstants.REMIND_QUEUE)
@Slf4j
public class RemindQueueHandler {
    @Autowired
    TaskService taskService;
    @Autowired
    UserService userService;

    @RabbitHandler
    public void process(Task task) throws IOException {
        Task task1 = taskService.getById(task.getTaskId());
//        确保当初的提醒时间没有发生改变
        String taskRemindTime = task.getRemindTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        String task1RemindTime = task1.getRemindTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        log.info(task1RemindTime + ";" + taskRemindTime);
        if (task1RemindTime.equals(taskRemindTime)) {
            String accessToken = WeChatUtils.getAccessToken();
            PmUser user = userService.getOne(Wrappers.<PmUser>lambdaQuery().eq(PmUser::getSysUserId, task.getUserId()));
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("touser", user.getOpenId());
            jsonObject.put("template_id", "qTYSkdd92d38CqXXt54yr3kz4wb0rZRuHXkEho73ato");
            //language=JSON
            String data = "{\"thing1\":{\"value\": \"{0}\"},\"time2\": {\"value\": \"{1}\"},\"thing4\": {\"value\": \"{2}\"},\"time10\": {\"value\": \"{3}\"}}";
            data = data
                    .replace("{1}", task1.getRemindTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                    .replace("{2}", "您的计划提醒日期到了");
            if (task1.getDeadline() != null) {
                data = data.replace("{3}", task1.getDeadline().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            } else {
                data = data.replace("{3}", task1RemindTime);
            }
            if (task1.getTitle().length() > 20) {
                data = data.replace("{0}", task1.getTitle().substring(0, 20));
            } else {
                data = data.replace("{0}", task1.getTitle());
            }
            JSONObject jsonData = JSON.parseObject(data);
            jsonObject.put("data", jsonData);
            System.out.println(jsonObject.toJSONString());
            Connection.Response execute = Jsoup.connect("https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=" + accessToken)
                    .requestBody(jsonObject.toString())
                    .header("Content-Type", "application/json;charset=UTF-8").ignoreContentType(true).method(Connection.Method.POST).execute();
            log.info(execute.body());
        }
    }
}
