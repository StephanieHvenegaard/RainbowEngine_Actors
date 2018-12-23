/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.players.graphics;

import the_nights.rainbow_engine.players.graphics.Sprite;
import java.awt.image.BufferedImage;

/**
 *
 * @author Stephanie
 */
public class SpriteSheet {

    private int[] pixels;
    private BufferedImage sheet;
    public final int WIDTH;
    public final int HEIGHT;
    public final int SPRITE_SIZE;
    private Sprite[] sprites;

    public SpriteSheet(BufferedImage sheet, int spriteSize) {
        this.sheet = sheet;
        this.HEIGHT = sheet.getHeight();
        this.WIDTH = sheet.getWidth();
        this.SPRITE_SIZE = spriteSize;
        this.pixels = new int[HEIGHT * WIDTH];
        this.sprites = new Sprite[(HEIGHT / spriteSize) * (WIDTH / spriteSize)];
        sheet.getRGB(0, 0, WIDTH, HEIGHT, pixels, 0, 0);

        int spriteID = 0;
        for (int y = 0; y < HEIGHT; y += spriteSize) {
            for (int x = 0; x < WIDTH; x += spriteSize) {
                int[] spritePix = new int[spriteSize * spriteSize];
                int spriteWidth = spriteSize;
                int spriteHeight = spriteSize;
                spritePix = sheet.getRGB(x, y, spriteWidth, spriteHeight, spritePix, 0, spriteWidth);
                Sprite s = new Sprite(spriteSize, spritePix);
                sprites[spriteID] = s;
                spriteID++;
            }
        }
    }

    public int[] getPixels() {
        return pixels;
    }

    public BufferedImage getSheet() {
        return sheet;
    }

    public Sprite getSprite(int id) {
        if (id < sprites.length) {
            return sprites[id];
        } else {
            System.out.println("ID " + id+ " is out of range for this sprite sheet.  Only "+sprites.length+" sprites loaded");
            return null;
        }
    }

    public Sprite getSprite(int x, int y) {
        int width = (WIDTH/SPRITE_SIZE);
        int id = x + (y*width);
        //System.out.println("fetching sprite x:"+x +" y:"+y+ " with id:"+id);
        return getSprite(id);
    }
    public Sprite[] getSprites(int row)
    {
        Sprite[] returnedSprites = new Sprite[(WIDTH / SPRITE_SIZE)];        
        for(int i =0; i < returnedSprites.length; i++)
        {
            returnedSprites[i] = getSprite(i,row);
        }
        return returnedSprites;
    }
}
