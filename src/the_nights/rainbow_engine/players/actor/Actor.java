/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.actor;

import the_nights.rainbow_engine.graphics.AnimatedSprite;
import the_nights.rainbow_engine.graphics.Rectangle;
import the_nights.rainbow_engine.graphics.Sprite;
import the_nights.rainbow_engine.collision.IHasCollision;
import depreched.EngineColors;
import the_nights.rainbow_engine.core.IMoveable;
import the_nights.rainbow_engine.core.IPlacable;
import the_nights.rainbow_engine.core.ICoreObject;

/**
 *
 * @author Stephanie
 */
public abstract class Actor implements ICoreObject, IPlacable, IMoveable, IHasCollision {

    protected final AnimatedSprite[] animTree;
    protected Sprite sprite;
    protected Rectangle rPlacement;
    protected Rectangle rCollisionBox;
    protected int activeAnimTree = 0;
    protected int speed;
    protected int health;

    public Actor(AnimatedSprite[] animTree, int speed) {
        this.animTree = animTree;
        this.sprite = animTree[0].getCurrentSprite();
        this.rPlacement = new Rectangle(0, 0, sprite.getWidth(), sprite.getHeight());
        this.speed = speed;
    }

    public Actor(Sprite sprite, int speed) {
        this.animTree = null;
        this.sprite = sprite;
        this.rPlacement = new Rectangle(0, 0, sprite.getWidth(), sprite.getHeight());
        this.speed = speed;
    }

    public Actor(Rectangle playerRec, int speed) {
        this.animTree = null;
        this.sprite = null;
        this.rPlacement = playerRec;
    }

    @Override
    public int getX() {
        return rPlacement.getX();
    }

    @Override
    public int getY() {
        return rPlacement.getY();
    }

    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public void setX(int x) {
        this.rPlacement.setX(x);
        this.rCollisionBox.setX(x);
    }

    @Override
    public void setY(int y) {
        this.rPlacement.setY(y);
        this.rCollisionBox.setY(y);
    }

    @Override
    public void moveX(int x) {
        int dxp = rPlacement.getX() + x;
        int dxc = rCollisionBox.getX() + x;
        this.rPlacement.setX(dxp);
        this.rCollisionBox.setX(dxc);
    }

    @Override
    public void moveY(int y) {
        int dyp = rPlacement.getY() + y;
        int dyc = rCollisionBox.getY() + y;
        this.rPlacement.setY(dyp);
        this.rCollisionBox.setY(dyc);
    }

    @Override
    public boolean collidable() {
        return (rCollisionBox != null);
    }

    @Override
    public boolean checkCollision(Rectangle rec) {
    return this.rCollisionBox.Overlap(rec);
    }

    @Override
    public void setCollisionBox(Rectangle rec) {
        this.rCollisionBox = rec;
        this.rCollisionBox.generateBorderGrafics(EngineColors.Red);
    }

    @Override
    public void setCollisionBox(int width, int height) {
        Rectangle rec = new Rectangle(rPlacement.getX(), rPlacement.getY(), width, height);
        setCollisionBox(rec);
    }
}
