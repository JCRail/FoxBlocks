package com.bidahochi.BlockMod.core.handler;

import com.bidahochi.BlockMod.FoxBlocks;
import com.bidahochi.BlockMod.items.*;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemHandler {

    public static void initItemRegister(){

        //FoxBlocks.blockLogger.info("ItemRegister Pre Init at com.bidahochi.BlockMod.core.handler.itemHandler");

        ItemIDs.test.item = new test();
        ItemIDs.jarate.item = new jarate();
        ItemIDs.gypsumDust.item = new gypsumDust();
        ItemIDs.enrichedClay.item = new enrichedClay();
        ItemIDs.ceramic.item = new ceramic();
        ItemIDs.cobaltIngot.item = new cobaltIngot();
        ItemIDs.lowDensityCompound.item = new lowDensityCompound();
        ItemIDs.rust.item = new rust();
        ItemIDs.aragoniteClump.item = new aragoniteClump();
        ItemIDs.ironRod.item = new IronRod();
        ItemIDs.ironSlice.item = new IronSlice();
        ItemIDs.computerizedCircuit.item = new computerizedCircuit();
        ItemIDs.woodSealant.item = new woodSealant();
        ItemIDs.taconiteCrushed.item = new taconiteCrushed();
        ItemIDs.taconitePellets.item = new taconitePellets();
        ItemIDs.quicklime.item = new quicklime();
        ItemIDs.roadTar.item=new roadTar();
        ItemIDs.bulb.item=new bulb();
        ItemIDs.bulbLong.item=new bulbLong();

        ItemIDs.doorA.item = new itemDoor().setUnlocalizedName("doorA").setTextureName(FoxBlocks.MODID + ":doorA_icon");
        ItemIDs.doorB.item = new itemDoor().setUnlocalizedName("doorB").setTextureName(FoxBlocks.MODID + ":doorB_icon");
        ItemIDs.doorC.item = new itemDoor().setUnlocalizedName("doorC").setTextureName(FoxBlocks.MODID + ":doorC_icon");
        ItemIDs.doorD.item = new itemDoor().setUnlocalizedName("doorD").setTextureName(FoxBlocks.MODID + ":doorD_icon");

        ItemIDs.record_piss2.item = new record_piss2("record_piss");
        ItemIDs.record_rodney.item = new record_rodney("record_rodney");

        for (ItemIDs items : ItemIDs.values()) {
            items.item.setCreativeTab(FoxBlocks.foxBlocksCreativeTabItems);

            items.item.setUnlocalizedName(FoxBlocks.MODID + ":" + items.itemName);
            GameRegistry.registerItem(items.item, items.name());

        }
    }
}
