/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.players.graphics;

import the_nights.rainbow_engine.players.graphics.AnimatedSprite;

/**
 *
 * @author Stephanie
 */
public class ActorAnimationTree {
    public final int SIZE = 8;
    public final int RUN_LEFT = 0;
    public final int ATTACK_LEFT = 1;
    public final int RUN_UP = 2;
    public final int RUN_RIGHT = 3;
    public final int ATTACK_RIGHT = 4;
    public final int RUN_DOWN = 5;
    public final int SPAWN = 6;
    public final int DIE = 7;
    AnimatedSprite[] animTree;
    public ActorAnimationTree()
    {
        animTree=new AnimatedSprite[SIZE];
    }
    public ActorAnimationTree(AnimatedSprite[] animtree)
    {
        this();
        for(int i=0;i<animtree.length;i++)
        {
            if(i>=this.animTree.length)break;
            this.animTree[i] = animtree[i];
        }
    }
    public void addAnimSprite(int id, AnimatedSprite as)
    {
        if(id>=this.animTree.length)return;
        this.animTree[id] =as;
    }
    public AnimatedSprite getAnim(int id)
    {
        if(id>=this.animTree.length)return null;
        return this.animTree[id];
    }            
}
