package com.example.login.service;

public interface WarnService {

    /**
     * 待处理的警报
     *
     * @return
     */
    String toBeProcessed();

    /**
     * 已处理的警报
     *
     * @return
     */
    String processed();

    /**
     * 自动处理的警报
     *
     * @return
     */
    String automaticProcessing();

    /**
     * 处理警报
     * @param id
     * @param comId
     * @return
     */
    String handle(String id , String comId);
}
