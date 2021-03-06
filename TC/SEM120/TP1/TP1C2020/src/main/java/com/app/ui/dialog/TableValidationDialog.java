package com.app.ui.dialog;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.app.ui.view.adaptation.CommonTableCellRenderer;
import com.app.ui.view.adaptation.CustomTableModel;

public class TableValidationDialog extends CustomDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int _realframeW = 500;
	private int _realframeH = 400;
	
	private int _frameW = this._realframeW + this._xOsDifference;
	private int _frameH = this._realframeH + this._yOsDifference;
	
	private JPanel _contentPanel;
	
	public static String[] TABLE_TITLE = new String[] { "Pila", "Entrada", "Producción" };
	private JScrollPane _spValidation;
	private DefaultTableModel _dtmValidation;
	private JTable _tblValidation;
	
	private JButton _btnClose;
	
	public TableValidationDialog( JFrame parent ) {
		super( parent );
		this.setTitle( ".: Tabla de validación :." );
		this.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
		this.setBounds( 0
				, 0
				, _frameW
				, _frameH );
		this._contentPanel = new JPanel();
		this._contentPanel.setBorder( new EmptyBorder( 0, 0, 0, 0 ) );
		this._contentPanel.setLayout( null );
		this.setContentPane( this._contentPanel );
		this.setLocationRelativeTo( null );
		
		this.setModalityType( DEFAULT_MODALITY_TYPE );
		
		this._spValidation = new JScrollPane();
		this._spValidation.setBounds( this.spX
				, this.spY
				, this._realframeW - this.spX
				, this._realframeH - 3 * this.spY - this.fldH );
		this._contentPanel.add( this._spValidation );
		
		this._dtmValidation = new CustomTableModel( null, TABLE_TITLE );
		this._tblValidation = new JTable( this._dtmValidation );
		this._tblValidation.setDefaultRenderer( String.class, new CommonTableCellRenderer() );
		this._spValidation.setViewportView( this._tblValidation );
		
		this._btnClose = new JButton( "Cerrar" );
		this._btnClose.setBounds( this._realframeW - 100
				, this._spValidation.getY() + this._spValidation.getHeight() + this.spY
				, 100
				, this.fldH );
		this._contentPanel.add( this._btnClose );
	}
	
	public JScrollPane getSpValidation() {
		return this._spValidation;
	}
	
	public DefaultTableModel getDtmValidation() {
		return this._dtmValidation;
	}
	
	public JTable getTblValidation() {
		return this._tblValidation;
	}
	
	public JButton getBtnClose() {
		return this._btnClose;
	}
}