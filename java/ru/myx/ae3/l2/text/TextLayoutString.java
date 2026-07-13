package ru.myx.ae3.l2.text;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseObject;

class TextLayoutString extends TextLayoutDefinition {

	public static final TextLayoutString INSTANCE = new TextLayoutString();

	private TextLayoutString() {
		
		//
	}

	@Override
	public BaseObject onExecute(final TextTargetContext context, final BaseObject layout) {
		
		final String string = Base.getString(layout, "value", " no data ");
		final int length = string.length();
		if (length > 0) {
			switch (string.charAt(0)) {
				case '\t' : {
					final StringBuilder builder = new StringBuilder(length + 32);
					int i = 0;
					for (; i < length && string.charAt(i) == '\t'; ++i) {
						/** unicode spaces */
						builder.append((char) 8194);
						builder.append((char) 8195);
					}
					if (i < length) {
						builder.append(string.substring(i));
					}
					return context.setString(builder.toString());
				}
				case ' ' : {
					final StringBuilder builder = new StringBuilder(length + 32);
					int i = 0;
					for (; i < length && string.charAt(i) == ' '; ++i) {
						/** unicode space */
						builder.append((char) 8194);
					}
					if (i < length) {
						builder.append(string.substring(i));
					}
					return context.setString(builder.toString());
				}
				default :
			}
		}
		return context.setString(string);
	}
}
