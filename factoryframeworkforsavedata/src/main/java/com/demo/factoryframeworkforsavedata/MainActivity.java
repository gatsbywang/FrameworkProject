package com.demo.factoryframeworkforsavedata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        IOHandler ioHandler = IOHandlerFactory.createIOHandler(IOHandlerFactory.IOType.MEMORY);

//        IOFactory ioFactory = new MemoryIOFactory();
//        IOHandler ioHandler = ioFactory.createIOHandler();

//        IOHandler ioHandler = IOHandlerFactory.getDefaultIOHandler();
    }
}
