package com.cowz.robotqq.service;

import java.util.HashMap;
import java.util.List;

/**
 * @author WZ
 */
public interface SendMessageService {
    void pushInfo(String msg, Long target);

    void pushInfoToOne(String msg, Long target);

    List<Long> getAllGroup();

    List<HashMap> fetchMessage();
}
