package com.myooo.designPatterns.strategy.context;

import com.myooo.designPatterns.strategy.HandlerStrategyTemplate;
import com.myooo.designPatterns.strategy.handler.DownHandler;
import com.myooo.designPatterns.strategy.handler.MortgageHandler;
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
