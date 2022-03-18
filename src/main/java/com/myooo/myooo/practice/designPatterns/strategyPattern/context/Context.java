package com.myooo.myooo.practice.designPatterns.strategyPattern.context;

import com.myooo.myooo.practice.designPatterns.strategyPattern.HandlerStrategyTemplate;
import com.myooo.myooo.practice.designPatterns.strategyPattern.handler.DownHandler;
import com.myooo.myooo.practice.designPatterns.strategyPattern.handler.MortgageHandler;
import org.springframework.stereotype.Service;

@Service
public class Context {

    public HandlerStrategyTemplate getHandler(int type) throws Exception {
        switch (type) {
            case 0:
                return new DownHandler();
            case 1:
                return new MortgageHandler();
            default:
                throw new Exception("不支持的类型");
        }
    }

}
