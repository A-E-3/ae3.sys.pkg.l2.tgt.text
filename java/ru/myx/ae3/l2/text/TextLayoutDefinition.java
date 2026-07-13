package ru.myx.ae3.l2.text;

import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.l2.LayoutDefinitionAbstract;

abstract class TextLayoutDefinition implements LayoutDefinitionAbstract<TextTargetContext>, TextContextHandler {
	
	@Override
	public BaseObject onEnter(final TextTargetContext target, final BaseObject layout) {
		
		target.dump(this.getClass().getName() + ", onEnter, layout=" + layout.baseGet("layout", BaseObject.UNDEFINED));
		return target.onEnter(target, layout);
	}

	@Override
	public abstract BaseObject onExecute(final TextTargetContext context, final BaseObject layout);

	@Override
	public void onLeave(final TextTargetContext target) {
		
		target.dump(this.getClass().getName() + ", onLeave");
		target.onLeave(target);
	}

	@Override
	public BaseObject onNest(final TextTargetContext target, final BaseObject layout) {
		
		target.dump(this.getClass().getName() + ", onNest, layout=" + layout.baseGet("layout", BaseObject.UNDEFINED));
		return target.onNest(target, layout);
	}
}
