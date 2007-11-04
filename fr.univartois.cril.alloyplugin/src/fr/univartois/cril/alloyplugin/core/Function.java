package fr.univartois.cril.alloyplugin.core;

import org.eclipse.swt.graphics.Image;

import edu.mit.csail.sdg.alloy4compiler.ast.Func;
import fr.univartois.cril.alloyplugin.AlloyPlugin;
import fr.univartois.cril.alloyplugin.core.ui.IALSFunction;

public class Function implements IALSFunction {
	
	public static final Image icon =AlloyPlugin.getDefault().getImage(AlloyPlugin.FUNCTION_ICON_ID);

	private Func func;

	public Function(Func func) {
		this.func=func;
	}

	public String toString(){
		return func.toString();
	}

	public Image getIcon() {
		return icon;
	}

	public int getBeginLine() {
		return func.pos.y;
	}
    public int getEndLine() {
        return func.pos.y2+func.getBody().closingBracket.y2;
    }
}
