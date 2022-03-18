package com.myooo.myooo.practice.designPatterns.strategyPattern;

import com.myooo.myooo.practice.designPatterns.strategyPattern.context.Context;
import org.springframework.beans.factory.annotation.Autowired;

public class StrategyController {

    @Autowired
    private Context context;


    public void deal(int type) throws Exception {

        HandlerStrategyTemplate handler = context.getHandler(type);
        int calculate = handler.calculate(1);

    }


}
