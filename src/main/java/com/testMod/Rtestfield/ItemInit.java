package com.testMod.Rtestfield;

import com.Dudu.rtestfield.item.custom.DavaAxe;
import com.Dudu.rtestfield.item.custom.UltraPickaxe;
import com.PG.rtestfield.item.custom.TestSword;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "rtestfield");
    public static final RegistryObject<Item> TEST_SWORD = ITEMS.register("test_sword", () -> new TestSword());
    public static final RegistryObject<Item> ULTRA_PICKAXE = ITEMS.register("ultra_pickaxe", () -> new UltraPickaxe());
    public static final RegistryObject<Item> DAVA_AXE= ITEMS.register("dava_axe", () -> new DavaAxe());

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "rtestfield");
    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> TEST_SWORD.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(TEST_SWORD.get());
                output.accept(ULTRA_PICKAXE.get());
                output.accept(DAVA_AXE.get());
            }).build());


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
