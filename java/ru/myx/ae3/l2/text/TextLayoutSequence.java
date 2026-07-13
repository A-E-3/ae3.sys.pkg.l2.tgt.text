package ru.myx.ae3.l2.text;

import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseObject;

class TextLayoutSequence extends TextLayoutDefinition {
	
	public static final TextLayoutSequence	INSTANCE	= new TextLayoutSequence();
	
	private TextLayoutSequence() {
		//
	}
	
	@Override
	public BaseObject onExecute(final TextTargetContext context, final BaseObject layout) {
		final BaseArray array = layout.baseGet( "elements", BaseObject.UNDEFINED ).baseArray();
		if (array == null) {
			return null;
		}
		context.dump( "setSequence: " + array.length() );
		return context.enterSequence( context, array );
	}
}
