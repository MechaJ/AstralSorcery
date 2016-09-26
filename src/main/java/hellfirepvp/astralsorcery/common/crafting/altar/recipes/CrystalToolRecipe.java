package hellfirepvp.astralsorcery.common.crafting.altar.recipes;

import hellfirepvp.astralsorcery.common.crafting.helper.AbstractCacheableRecipe;
import hellfirepvp.astralsorcery.common.crafting.helper.ShapeMap;
import hellfirepvp.astralsorcery.common.crafting.helper.ShapedRecipeSlot;
import hellfirepvp.astralsorcery.common.item.crystal.CrystalProperties;
import hellfirepvp.astralsorcery.common.item.crystal.ToolCrystalProperties;
import hellfirepvp.astralsorcery.common.item.tool.ItemCrystalToolBase;
import net.minecraft.item.ItemStack;

import java.util.LinkedList;
import java.util.List;

/**
 * This class is part of the Astral Sorcery Mod
 * The complete source code for this mod can be found on github.
 * Class: CrystalToolRecipe
 * Created by HellFirePvP
 * Date: 26.09.2016 / 01:44
 */
public class CrystalToolRecipe extends DiscoveryRecipe {

    private final ShapedRecipeSlot[] positions;

    public CrystalToolRecipe(AbstractCacheableRecipe recipe, ShapedRecipeSlot... crystalPositions) {
        super(recipe);
        this.positions = crystalPositions;
    }

    @Override
    public int craftingTickTime() {
        return super.craftingTickTime() * 3;
    }

    @Override
    public ItemStack getOutput(ShapeMap centralGridMap) {
        ItemStack toolOut = super.getOutput(centralGridMap);
        List<CrystalProperties> prop = new LinkedList<>();
        for (ShapedRecipeSlot slot : positions) {
            ItemStack stack = centralGridMap.get(slot);
            if(stack == null) continue;
            CrystalProperties c = CrystalProperties.getCrystalProperties(stack);
            if(c == null) continue;
            prop.add(c);
        }
        ItemCrystalToolBase.setToolProperties(toolOut, ToolCrystalProperties.merge(prop));
        return toolOut;
    }
}
