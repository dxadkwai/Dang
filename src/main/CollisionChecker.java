package main;

import entity.Entity;

// Handles collision detection between entities and game world tiles
public class CollisionChecker {
    
    GamePanel gp;

    // Constructor: Initialize collision checker with game panel reference
    public CollisionChecker(GamePanel gp) {
        this.gp = gp;

    }

    // Check if entity collides with tiles based on movement direction
    public void checkTile(Entity entity) {

        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1;
        int tileNum2;

        switch (entity.direction) {
        case"up":
            entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2=gp.tileM.mapTileNum[entityRightCol][entityTopRow];
            if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                entity.collisionOn =true;
            }
            break;
        case"down":
            entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
            tileNum2=gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
            if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                entity.collisionOn =true;
            }
            break;
        case"left":
            entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2=gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
            if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                entity.collisionOn =true;
            }
            break;
        case"right":
            entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
            tileNum2=gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
            if(gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                entity.collisionOn =true;
            }
            break;

        }
    }
}
