/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.players.graphics;

import java.awt.image.BufferedImage;

/**
 *
 * @author Stephanie
 */
public class Sprite{
    private final  int width;
    private final int height;
    private int[] pixels;
    
    public Sprite(SpriteSheet sheet,int startX,int startY,int width,int height)
    {
        this.height = height;
        this.width = width;
        this.pixels = new int[height*width];
        sheet.getSheet().getRGB(startX, startY, width, height, pixels, 0,width);
    }
    public Sprite(int size, int[] pixels)
    {
        this.height =size;
        this.width =size;
        this.pixels = pixels;
    }
    public Sprite(BufferedImage sprite)
    {
        width = sprite.getWidth();
        height = sprite.getHeight();
        this.pixels = new int[width*height];
        sprite.getRGB(0,0,width,height,pixels,0,width);
    }
    public Sprite()
    {
        this.height = -1;
        this.width =-1;
        this.pixels = null;
    }
    public int[] getPixels() {
        return pixels;
    } 

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
}
