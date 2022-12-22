package io.github.pumpkinxd.favspamsilencer.mixins.workarounds;

import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.SimpleChannelInboundHandler;

import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;

import net.minecraft.network.play.server.S01PacketJoinGame;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.network.handshake.NetworkDispatcher;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@SuppressWarnings("unused")



//still not working rn
@Mixin(NetworkDispatcher.class)
public abstract class mixinNetworkDispatcher_mutePacketInfoSpammer extends NetworkDispatcher{
    public mixinNetworkDispatcher_mutePacketInfoSpammer(NetworkManager manager) {
        super(manager);
    }
    public mixinNetworkDispatcher_mutePacketInfoSpammer(NetworkManager manager, ServerConfigurationManager scm) {
        super(manager, scm);
    }



    @Inject(
            method="handleVanilla",
            at=@At(
                    value = "INVOKE",
                    target = "info",
                    shift = At.Shift.AFTER,
                    ordinal = 0
            ),
            remap = false

    )
    private void theSilencer(){
        //return;//do nothing
    }
}
