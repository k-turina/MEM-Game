package com.mem.game.systems;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.mem.game.components.CollisionComponent;
import com.mem.game.components.PlayerComponent;
import com.mem.game.components.TypeComponent;

public class CollisionSystem  extends IteratingSystem {
    ComponentMapper<CollisionComponent> cm;
    ComponentMapper<PlayerComponent> pm;

    @SuppressWarnings("unchecked")
    public CollisionSystem() {
        // only need to worry about player collisions
        super(Family.all(CollisionComponent.class,PlayerComponent.class).get());

        cm = ComponentMapper.getFor(CollisionComponent.class);
        pm = ComponentMapper.getFor(PlayerComponent.class);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        // get player collision component
        CollisionComponent cc = cm.get(entity);

        Entity collidedEntity = cc.collisionEntity;
        if(collidedEntity != null){
            TypeComponent type = collidedEntity.getComponent(TypeComponent.class);
            if(type != null){
                switch(type.type){
                    case TypeComponent.TREE: {
                        System.out.println("player hit tree");

                        break;
                    }
                    case TypeComponent.OTHER:
                        //do player hit other thing
                        System.out.println("player hit other");
                        break; //technically this isn't needed
                }
                cc.collisionEntity = null; // collision handled reset component
            }
        }

    }

}