package game;

import game.renderer.Animation;
import physics.BoxColider;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Sphere extends GameObject {
    BoxColider boxColider;

    public Sphere(){
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/sphere/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/sphere/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/sphere/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/sphere/3.png"));
        this.boxColider = new BoxColider(this, 16,16);
        this.renderer = new Animation(images);
    }

    @Override
    public void run() {
        super.run();
        this.fire();
    }


    int count; // TODO: continue editing
    private void fire() {
        this.count++;
        if(this.count > 20) {
            SphereBullet bullet = GameObject.recycle(SphereBullet.class);
            bullet.position.set(this.position);
            this.count = 0;
        }
    }
    public BoxColider getBoxColider(){
        return this.boxColider;
    }
}
