package com.myooo.designPatterns.strategy;

import com.myooo.designPatterns.strategy.context.Context;
import org.springframework.beans.factory.annotation.Autowired;

public class StrategyController {

    @Autowired
    private Context context;


    public void deal(int type) throws Exception {

        HandlerStrategyTemplate handler = context.getHandler(type);
        int calculate = handler.calculate(1);

    }


}
