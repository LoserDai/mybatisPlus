package com.mpolicy.dbfile.modules.common.api;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> 基类 </p>
 *
 * @description:
 * @author: zhaoqiuyue
 * @date: 2019/8/17 0017 19:53
 */
@RestController
@Slf4j
public class BaseController {

    public Logger logger = LoggerFactory.getLogger(getClass());

}