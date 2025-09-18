package net.modcito;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.modcito.datagen.ModcitoItemTagProvider;

public class ModcitoDataGenerator implements DataGeneratorEntrypoint {

    @Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModcitoItemTagProvider::new);
	}
}
