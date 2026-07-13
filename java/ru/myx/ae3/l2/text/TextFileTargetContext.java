package ru.myx.ae3.l2.text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import ru.myx.ae3.binary.Transfer;

/**
 *
 * @author myx
 *
 */
public class TextFileTargetContext extends TextTargetContext {
	
	private final File output;

	/**
	 * @param output
	 * @throws IOException
	 */
	public TextFileTargetContext(final File output) throws IOException {
		super(null);
		this.output = output;
	}

	@Override
	public void doFinish() {
		
		this.document.close();
		try {
			final FileOutputStream output = new FileOutputStream(this.output);
			Transfer.toStream(this.document.toBuffer(), output, true);
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}
}
