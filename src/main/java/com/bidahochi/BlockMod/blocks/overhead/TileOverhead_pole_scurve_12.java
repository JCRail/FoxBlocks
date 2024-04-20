package com.bidahochi.BlockMod.blocks.overhead;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileOverhead_pole_scurve_12 extends TileEntity {
    public int dir=0;

    public TileOverhead_pole_scurve_12(int dir) {
        super();
        this.dir = dir;
    }

    public TileOverhead_pole_scurve_12() {}

    @Override
    public boolean shouldRenderInPass(int pass){ return pass==0; }


    @Override
    public S35PacketUpdateTileEntity getDescriptionPacket() {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        writeToNBT(nbttagcompound);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 0, nbttagcompound);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        if(pkt ==null){return;}
        readFromNBT(pkt.func_148857_g());
        markDirty();
    }

    @Override
    public void writeToNBT(NBTTagCompound tag){
        super.writeToNBT(tag);
        tag.setInteger("direction", dir);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag){
        super.readFromNBT(tag);
        dir = tag.getInteger("direction");
        if(worldObj!=null && worldObj.isRemote) {
            markDirty();
        }
    }

    public TileOverhead_pole_scurve_12 setFacing(int direction){
        dir=(byte) direction;
        this.markDirty();
        return this;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        //z is n/s, x is e/w
        if (dir==0){// north
            return AxisAlignedBB.getBoundingBox(xCoord-2, yCoord, zCoord-12, xCoord + 3, yCoord + 5, zCoord+1);
        }else if(dir==1){//east
            return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord-1, xCoord+12, yCoord + 5, zCoord + 3);
        }else if(dir==2){//south
            return AxisAlignedBB.getBoundingBox(xCoord-3, yCoord, zCoord, xCoord + 2, yCoord + 5, zCoord + 12);
        }else{//west
            return AxisAlignedBB.getBoundingBox(xCoord-12, yCoord, zCoord-3, xCoord+1, yCoord + 5, zCoord + 2);
        }

    }
    /*@Override //supposedly this would be faster, if it worked
    public AxisAlignedBB getRenderBoundingBox()
    {
        //z is n/s, x is e/w
        switch(dir) {
            case 1:// north
                return AxisAlignedBB.getBoundingBox(xCoord - 1, yCoord, zCoord - 12, xCoord + 3, yCoord + 5, zCoord);
            case 2://east
                return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord - 1, xCoord + 12, yCoord + 5, zCoord + 3);
            case 3://south
                return AxisAlignedBB.getBoundingBox(xCoord - 3, yCoord, zCoord, xCoord + 1, yCoord + 5, zCoord + 12);
            default://west
                return AxisAlignedBB.getBoundingBox(xCoord - 12, yCoord, zCoord - 3, xCoord, yCoord + 5, zCoord + 1);
        }
    }*/
}
