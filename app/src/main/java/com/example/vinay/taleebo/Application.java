package com.example.vinay.taleebo;

/**
 * Created by shubham on 2/9/16.
 */
public final class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FontsOverride.setDefaultFont(this, "DEFAULT", "RobotoCondensed-Regular.ttf");
    }
}