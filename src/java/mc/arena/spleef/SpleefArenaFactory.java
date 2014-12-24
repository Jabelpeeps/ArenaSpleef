package mc.arena.spleef;

import mc.alk.arena.objects.arenas.Arena;
import mc.alk.arena.objects.arenas.ArenaFactory;
import org.bukkit.plugin.Plugin;

/**
 * 
 * 
 * @author Nikolai
 */
public class SpleefArenaFactory implements ArenaFactory {
    
    Plugin plugin;
    
    public SpleefArenaFactory(Plugin reference) {
        this.plugin = reference;
    }

    public Arena newArena() {
        return new SpleefArena(plugin);
    }
    
}
