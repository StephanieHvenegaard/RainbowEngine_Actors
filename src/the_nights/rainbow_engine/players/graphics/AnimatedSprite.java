/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.players.graphics;

import the_nights.rainbow_engine.players.graphics.Sprite;
import the_nights.rainbow_engine.core.Engine;
import the_nights.rainbow_engine.core.ICoreObject;

/**
 *
 * @author Stephanie
 */
public class AnimatedSprite extends Sprite {//implements ICoreObject{

    Sprite[] sprites;
    int frameID;
    int counter;
    int speed;
    //boolean playing;

    public AnimatedSprite(Sprite[] sprites, int speed) {
        this.sprites = sprites;
        //this.playing = false;
        this.frameID = 0;
        this.counter = 0;
        this.speed = speed;
    }

    @Override
    public int getWidth() {
        if (sprites != null && sprites.length > 0) {
            return this.sprites[0].getWidth();
        } else {
            return -1;
        }
    }

    @Override
    public int getHeight() {
        if (sprites != null && sprites.length > 0) {
            return this.sprites[0].getHeight();
        } else {
            return -1;
        }
    }

    @Override
    public int[] getPixels() {
        return sprites[frameID].getPixels();
    }

    public Sprite getCurrentSprite() {
        return sprites[frameID];
    }

    public Sprite[] getSprites() {
        return sprites;
    }

    public int getFrameID() {
        return frameID;
    }

//    public boolean isPlaying() {
//        return playing;
//    }

    public void setFrameID(int frameID) {
        if (sprites != null && frameID < sprites.length) {
            this.frameID = frameID;
        }
    }

    private void incrementFrame() {
        if (sprites != null ){//&& playing) {
            this.frameID = (1 + frameID) % sprites.length;
        }
    }
//
//    public void setPlaying(boolean playing) {
//        this.playing = playing;
//    }

    public void update() {
        counter++;
        if (counter >= speed) {
            counter = 0;
            incrementFrame();
        }
    }

    public void reset() {
        counter =0;
        frameID = 0;
    }
}
