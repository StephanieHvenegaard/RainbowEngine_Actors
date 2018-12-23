/*
* MIT License
* 
* Copyright (c) 2018 Stephanie Hvenegaard
* 
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
* 
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software, as well as credit to the 
* original author: Stephanie Hvenegaard.
* 
* 
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
*/
package the_nights.players.graphics;

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
