package UI;

import java.util.List;
import javax.swing.*;
import Entidades.*;
import Service.EnlistarException;
import Service.MedicoService;

public class TablaMedicosPanel extends TablaPanel{
	
	private JTable tablaMedicos;
	private ModeloTablaMedicos modelo;
	private JScrollPane scrollPane;
	private List<Medico> listaMedicos;
	
	public TablaMedicosPanel(UIManager manager) {
		super(manager);
	}
	
	public void crearTablaPanel() {
		
		modelo = new ModeloTablaMedicos();
		tablaMedicos = new JTable(modelo);
		scrollPane = new JScrollPane(tablaMedicos);
		this.add(scrollPane);
		
		try {
			MedicoService service = new MedicoService();
			listaMedicos = service.enlistarMedico();
			modelo.setMedicos(listaMedicos); 
			modelo.fireTableDataChanged();
		}catch(EnlistarException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		modelo.filtrarTabla("");
		
	}

	public JTable getTablaMedicos() {
		return tablaMedicos;
	}

	public void setTablaMedicos(JTable tablaMedicos) {
		this.tablaMedicos = tablaMedicos;
	}

	public ModeloTablaMedicos getModelo() {
		return modelo;
	}

	public void setModelo(ModeloTablaMedicos modelo) {
		this.modelo = modelo;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public List<Medico> getListaMedicos() {
		return listaMedicos;
	}

	public void setListaMedicos(List<Medico> listaMedicos) {
		this.listaMedicos = listaMedicos;
	}	
	
}
