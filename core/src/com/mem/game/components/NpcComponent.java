package com.mem.game.components;

import com.badlogic.ashley.core.Component;
import com.mem.game.input.NpcInputProcessor;
import com.mem.game.utils.NpcDialog;

public class NpcComponent implements Component {
	public String name;
	public NpcDialog dialog;
	public NpcState state = NpcState.DISABLED;
	public NpcInputProcessor input;
	
	public enum NpcState{ SILENT, TALKING, DISABLED };
}
