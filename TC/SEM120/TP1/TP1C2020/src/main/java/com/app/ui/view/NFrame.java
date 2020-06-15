package com.app.ui.view;

import javax.swing.JFrame;

public abstract class NFrame extends JFrame {

	protected int _xOsDifference;
	protected int _yOsDifference;
	
	protected int spX = 7;
	protected int spY = 5;
	protected int fldH = 27;
	
	public NFrame() {
		String str = System.getProperty("os.name").toString().toUpperCase();
		
		if ( str.contains("WINDOWS")/*( "Windows 10" )*/ ) {
			this._xOsDifference = 22;
			this._yOsDifference = 45;
		} else {
			this._xOsDifference = 8;
			this._yOsDifference = 45;
		}
	}
}