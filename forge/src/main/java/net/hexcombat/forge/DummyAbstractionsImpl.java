package net.hexcombat.forge;

import net.hexcombat.DummyAbstractions;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraftforge.common.IForgeShearable;
import net.minecraftforge.fml.loading.FMLPaths;
import java.nio.file.Path;

public class DummyAbstractionsImpl {
    /**
     * This is the actual implementation of {@link DummyAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
