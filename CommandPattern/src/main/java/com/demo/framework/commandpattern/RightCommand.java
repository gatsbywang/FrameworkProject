package com.demo.framework.commandpattern;

/**
 * Created by 花歹 on 2019/5/18.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class RightCommand implements Command {


    private final TetrisMachine machine;

    public RightCommand(TetrisMachine machine){
        this.machine = machine;
    }

    @Override
    public void excute() {

    }
}
