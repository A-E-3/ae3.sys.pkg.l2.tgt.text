package ru.myx.ae3.l2.text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

import ru.myx.ae3.base.Base;
import ru.myx.ae3.base.BaseArray;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.binary.Transfer;
import ru.myx.ae3.binary.TransferCollector;
import ru.myx.ae3.i3.TargetInterface;
import ru.myx.ae3.l2.ContextHandler;
import ru.myx.ae3.l2.LayoutDefinition;
import ru.myx.ae3.l2.TargetContextAbstract;
import ru.myx.ae3.report.Report;

/**
 *
 * @author myx
 *
 */
public abstract class TextTargetContext extends TargetContextAbstract<TextTargetContext> {

	private final static Map<String, TextLayoutDefinition> LAYOUTS;

	static {
		LAYOUTS = new TreeMap<>();
		TextTargetContext.LAYOUTS.put("sequence", TextLayoutSequence.INSTANCE);
		TextTargetContext.LAYOUTS.put("string", TextLayoutString.INSTANCE);
	}

	/**
	 *
	 */
	protected final TransferCollector document;

	/**
	 * @param iface
	 */
	protected TextTargetContext(final TargetInterface iface) {
		super(iface);
		this.document = Transfer.createCollector();
	}

	@Override
	public abstract void doFinish();

	/**
	 * to make visible locally
	 */
	@Override
	protected BaseObject enterSequence(final ContextHandler<TextTargetContext, BaseObject> handler, final BaseArray array) {
		
		return super.enterSequence(handler, array);
	}

	@Override
	protected LayoutDefinition<TextTargetContext> getLayoutForContext(final String name) {
		
		return TextTargetContext.LAYOUTS.get(name);
	}

	@Override
	public BaseObject onNest(final TextTargetContext target, final BaseObject object) {
		
		final String layout = Base.getString(object, "layout", "string");
		if (Report.MODE_DEBUG) {
			System.out.println(">>>>>> layout=" + layout);
		}
		if ("string".equals(layout)) {
			try {
				this.document.getOutputStream().write(Base.getString(object, "value", " no data ").getBytes(StandardCharsets.UTF_8));
				this.document.getOutputStream().write('\r');
				this.document.getOutputStream().write('\n');
			} catch (final IOException e) {
				throw new RuntimeException(e);
			}
			return null;
		}
		return object;
	}

	BaseObject setString(final String s) {
		
		if (Report.MODE_DEBUG) {
			this.dump("setString: " + s);
		}
		try {
			this.document.getOutputStream().write(s.getBytes(StandardCharsets.UTF_8));
			this.document.getOutputStream().write('\r');
			this.document.getOutputStream().write('\n');
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}

		return null;
	}
}
