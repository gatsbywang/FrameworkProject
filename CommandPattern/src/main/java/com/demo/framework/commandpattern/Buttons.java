package com.demo.framework.commandpattern;

/**
 * Created by 花歹 on 2019/5/18.
 * Email:   gatsbywang@126.com
 * Description:
 * Thought:
 */
public class Buttons {

    LeftCommand leftCommand;
    RightCommand rightCommand;

    public void setLeftCommand(LeftCommand leftCommand) {
        this.leftCommand = leftCommand;
    }

    public void setRightCommand(RightCommand rightCommand) {
        this.rightCommand = rightCommand;
    }

    public void toLeft(){
        leftCommand.excute();
    }

    public void toRight(){
        rightCommand.excute();
    }
}
