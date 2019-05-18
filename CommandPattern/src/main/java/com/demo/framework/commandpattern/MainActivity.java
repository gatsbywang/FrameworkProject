package com.demo.framework.commandpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1、命令角色 2、命令的接收者（执行者）3、命令的发送者
        TetrisMachine machine = new TetrisMachine();
        LeftCommand leftCommand = new LeftCommand(machine);
        RightCommand rightCommand = new RightCommand( machine);

        Buttons buttons = new Buttons();
        buttons.setLeftCommand(leftCommand);
        buttons.setRightCommand(rightCommand);
        buttons.toRight();
        buttons.toLeft();


        //简单版
//        TetrisMachine machine = new TetrisMachine();
//        machine.toLeft();
//        machine.toRight();
    }
}
