package ru.myx.ae3.l2.text;

import java.io.File;
import java.io.FileInputStream;

import ru.myx.ae3.Engine;
import ru.myx.ae3.base.BaseObject;
import ru.myx.ae3.l2.LayoutEngine;

/**
 * @author myx
 * 
 */
public class TestText {
	/**
	 * @param args
	 * @throws Throwable
	 */
	public static void main(final String[] args) throws Throwable {
		Engine.createGuid();
		
		final File output = File.createTempFile( "test", ".txt" );
		System.out.println( "LayoutEngine2 TEXT renderer test, output to: " + output.getAbsolutePath() );
		
		final BaseObject text = args == null || args.length == 0
				? LayoutEngine.getDocumentation() // context.getLayoutAbout()
				: args.length > 1
						? LayoutEngine.getDocumentation()
						: LayoutEngine.parseJSLD( new FileInputStream( args[0] ) );
		new TextFileTargetContext( output ).transform( text ).baseValue();
		
		Engine.createProcess( output.getName(), null, output.getParentFile() );
	}
}
